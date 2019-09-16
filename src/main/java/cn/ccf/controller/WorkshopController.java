package cn.ccf.controller;

import cn.ccf.common.ResponseCodeConst;
import cn.ccf.common.ResponseDTO;
import cn.ccf.common.TCPClient;
import cn.ccf.mapper.CurrentInAndOutMapper;
import cn.ccf.mapper.NumInWorkshopMapper;
import cn.ccf.mapper.WorkshopMapper;
import cn.ccf.pojo.*;
import cn.ccf.util.SmartBeanUtil;
import cn.ccf.vo.WorkshopVO;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("workshop")
public class WorkshopController {

    // 简化了Service层 因为太简单
    @Resource
    private WorkshopMapper workshopMapper;
    @Resource
    private CurrentInAndOutMapper currentInAndOutMapper;

    @Resource
    private NumInWorkshopMapper numInWorkshopMapper;

    @RequestMapping("addWorkshopUI")
    public String addWorkshopUI(HttpServletRequest request) {
        return "system/workshop/add";
    }

    @RequestMapping(value = "addWorkshop", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO<Boolean> addWorkshop(@Valid Workshop workshop) {
            workshop.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            workshop.setId(UUID.randomUUID().toString().replace("-", ""));
            Integer result = workshopMapper.insert(workshop);
            if (result == 1) {
                return ResponseDTO.succ(true);
            } else {
                return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
            }
    }


    @RequestMapping("editWorkshopUI")
    public String editUserUI(HttpServletRequest request, String id) {
        Workshop workshop = workshopMapper.selectByPrimaryKey(id);
        request.setAttribute("workshop", workshop);
        return "system/workshop/edit";
    }

    @RequestMapping("editWorkshop")
    public ResponseEntity<Void> editWorkshop(Workshop workshop) {
        try {
            workshopMapper.updateByPrimaryKey(workshop);
            String msg = "quota:" + workshop.getPersonnelQuota();
            TCPClient tcpClient = new TCPClient();
            tcpClient.startClient(workshop.getIp(), 7777, msg);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(value = "deleteWorkshop")
    @ResponseBody
    public ResponseDTO<Boolean> deleteWorkshop(String id) {
        Integer result = workshopMapper.deleteByPrimaryKey(id);
        if (result == 1) {
            return ResponseDTO.succ(true);
        }
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
    }

    @RequestMapping(value = "list")
    public String list(HttpServletRequest request) {
        WorkshopExample example = new WorkshopExample();
        List<Workshop> workshops = workshopMapper.selectByExample(example);

        List<WorkshopVO> workshopVOS = new ArrayList<>();

        workshops.forEach( workshop -> {
            CurrentInAndOutExample currentInAndOutExample = new CurrentInAndOutExample();
            currentInAndOutExample.createCriteria().andWorkshopIdEqualTo(workshop.getWorkshopNumber());
            List<CurrentInAndOut> currentInAndOuts = currentInAndOutMapper.selectByExample(currentInAndOutExample);

            WorkshopVO workshopVO = SmartBeanUtil.copy(workshop, WorkshopVO.class);
            workshopVO.setNumInWorkshop(CollectionUtils.isNotEmpty(currentInAndOuts) ? currentInAndOuts.size() : 0);
            workshopVOS.add(workshopVO);
        });


        request.setAttribute("workshops", workshopVOS);
        return "system/workshop/list";
    }

    @RequestMapping(value = "getQuota", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Integer> getQuota(String workshopNumber) {
        WorkshopExample example = new WorkshopExample();
        example.createCriteria().andWorkshopNumberEqualTo(workshopNumber);
        List<Workshop> workshops = workshopMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(workshops)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(workshops.get(0).getPersonnelQuota().intValue());
    }

    @RequestMapping(value = "clearCount")
    public ResponseEntity<Void> clearCount(String workshopNumber) {

        try {
            // 删除实时进出厂房计数
            CurrentInAndOutExample currentInAndOutExample = new CurrentInAndOutExample();
            currentInAndOutExample.createCriteria().andWorkshopIdEqualTo(workshopNumber);
            currentInAndOutMapper.deleteByExample(currentInAndOutExample);

            NumInWorkshopExample numInWorkshopExample = new NumInWorkshopExample();
            numInWorkshopExample.createCriteria().andWorkshopIdEqualTo(workshopNumber);
            List<NumInWorkshop> numInWorkshops = numInWorkshopMapper.selectByExample(numInWorkshopExample);
            if (CollectionUtils.isNotEmpty(numInWorkshops)) {
                numInWorkshops.get(0).setNum(new BigDecimal(0));
            }
            numInWorkshopMapper.updateByPrimaryKeySelective(numInWorkshops.get(0));


            //查询厂房
            WorkshopExample workshopExample = new WorkshopExample();
            workshopExample.createCriteria().andWorkshopNumberEqualTo(workshopNumber);
            List<Workshop> workshops = workshopMapper.selectByExample(workshopExample);
            // 删除历史进出厂房计数 todo 不应该删除 保留历史记录

            // tcp连接 发送清除计数指令
            try {
                Socket socket = new Socket(workshops.get(0).getIp(), 7777);
                if (socket.isConnected()) {
                    new Thread(() -> {
                        try {
                            OutputStream os = socket.getOutputStream();
                            os.write("clear".getBytes("utf-8"));
                            os.flush();
                            os.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
}
