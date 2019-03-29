package cn.ccf.service;

import cn.ccf.common.ResponseCodeConst;
import cn.ccf.common.ResponseDTO;
import cn.ccf.mapper.CurrentInAndOutMapper;
import cn.ccf.mapper.InAndOutHistoryMapper;
import cn.ccf.mapper.NumInWorkshopMapper;
import cn.ccf.pojo.*;
import cn.ccf.vo.SwipeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SwipeCardService {

    @Resource
    private InAndOutHistoryMapper inAndOutHistoryMapper;

    @Resource
    private CurrentInAndOutMapper currentInAndOutMapper;

    @Resource
    private NumInWorkshopMapper numInWorkshopMapper;

    public NumInWorkshop queryNumInWorkshopByWorkshopId(String workshopId) {
        NumInWorkshopExample example = new NumInWorkshopExample();
        example.createCriteria().andWorkshopIdEqualTo(workshopId);
        List<NumInWorkshop> numInWorkshops = numInWorkshopMapper.selectByExample(example);
        if (numInWorkshops != null && numInWorkshops.size() != 0) {
            return numInWorkshops.get(0);
        }
        return null;

    }

    @Transactional
    public void insertSwipeInMsg(SwipeVO swipeVO) {

        String uuid = UUID.randomUUID().toString().replace("-", "");
        String workshopId = swipeVO.getWorkshopId();
        String workId = swipeVO.getWorkId();
        String name = swipeVO.getName();

        // 插入到历史进出记录
        InAndOutHistory historyIn = new InAndOutHistory();
        historyIn.setId(uuid);
        historyIn.setEntryTime(new Date());
        historyIn.setWorkshopId(workshopId);
        historyIn.setWorkId(workId);
        historyIn.setName(name);
        inAndOutHistoryMapper.insert(historyIn);

        // 插入到实时进出记录
        CurrentInAndOut currentIn = new CurrentInAndOut();
        currentIn.setId(uuid);
        currentIn.setEntryTime(historyIn.getEntryTime());
        currentIn.setName(name);
        currentIn.setWorkId(workId);
        currentIn.setWorkshopId(workshopId);
        currentInAndOutMapper.insert(currentIn);

        int num = swipeVO.getNum();

        // 更新进入到厂房人数
        NumInWorkshop numInWorkshop = this.queryNumInWorkshopByWorkshopId(workshopId);
        if (numInWorkshop == null) {
            numInWorkshop = new NumInWorkshop();
            numInWorkshop.setId(uuid);
            numInWorkshop.setWorkshopId(workshopId);
            numInWorkshop.setNum(new BigDecimal(num));
            numInWorkshop.setCreateTime(new Date());
            numInWorkshopMapper.insert(numInWorkshop);
        } else {
            numInWorkshop.setNum(new BigDecimal(num));
            numInWorkshop.setCreateTime(new Date());
            numInWorkshopMapper.updateByPrimaryKey(numInWorkshop);
        }
    }

    @Transactional
    public void insertSwipeOutMsg(SwipeVO swipeVO, String id) {
        String workId = swipeVO.getWorkId();
        // 删除实时进出记录
        CurrentInAndOutExample currentInAndOutExample = new CurrentInAndOutExample();
        currentInAndOutExample.createCriteria().andWorkIdEqualTo(workId);
        currentInAndOutMapper.deleteByExample(currentInAndOutExample);

        // 更新进出历史记录离开厂房时间
        InAndOutHistory outHistory = new InAndOutHistory();
        outHistory.setId(id); // 实时进出id 和 历史进出id 一致
        outHistory.setDepartureTime(new Date());
        inAndOutHistoryMapper.updateByPrimaryKeySelective(outHistory);

        // 更新离开之后厂房人数
        NumInWorkshop numInWorkshop = queryNumInWorkshopByWorkshopId(swipeVO.getWorkshopId());
        numInWorkshop.setNum(new BigDecimal(swipeVO.getNum()));
        numInWorkshop.setCreateTime(new Date());
        numInWorkshopMapper.updateByPrimaryKey(numInWorkshop);
    }
}
