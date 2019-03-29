package cn.ccf.controller;

import cn.ccf.common.ResponseCodeConst;
import cn.ccf.common.ResponseDTO;
import cn.ccf.common.SensorResponseCodeConst;
import cn.ccf.pojo.CurrentInAndOut;
import cn.ccf.pojo.InAndOutHistory;
import cn.ccf.pojo.NumInWorkshop;
import cn.ccf.pojo.UserInfo;
import cn.ccf.service.CurrentInAndOutService;
import cn.ccf.service.SwipeCardService;
import cn.ccf.service.UserInfoService;
import cn.ccf.vo.SwipeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class SensorHistoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SensorHistoryController.class);

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private CurrentInAndOutService currentInAndOutService;

    @Resource
    private SwipeCardService swipeCardService;

    @RequestMapping(value = "checkSwipeIn", method = RequestMethod.POST)
    public ResponseDTO<Void> checkWorkIdIn(SwipeVO swipeVO) {

        try {
            String workId = swipeVO.getWorkId();
            UserInfo userInfo = userInfoService.queryUserInfoByWorkId(workId);
            if (userInfo == null) {
                return ResponseDTO.wrap(SensorResponseCodeConst.USELESS_CARD_ID);
            }

            CurrentInAndOut currentInAndOut = currentInAndOutService.queryByWorkId(workId);
            if (currentInAndOut != null) {
                return ResponseDTO.wrap(SensorResponseCodeConst.HAVE_BEEN_IN_WORKSHOP);
            }

            swipeVO.setName(userInfo.getName());
            swipeCardService.insertSwipeInMsg(swipeVO);
            return ResponseDTO.succ();
        } catch (Exception e) {
            LOGGER.error("请求刷卡进入出错");
            return ResponseDTO.wrap(ResponseCodeConst.SYSTEM_ERROR);
        }
    }


    @RequestMapping(value = "checkSwipeOut", method = RequestMethod.POST)
    public ResponseDTO<Void> checkWorkIdOut(SwipeVO swipeVO) {
        try {
            String workId = swipeVO.getWorkId();

            UserInfo userInfo = userInfoService.queryUserInfoByWorkId(workId);
            if (userInfo == null) {
                return ResponseDTO.wrap(SensorResponseCodeConst.USELESS_CARD_ID);
            }

            CurrentInAndOut currentInAndOut = currentInAndOutService.queryByWorkId(workId);
            if (currentInAndOut == null) {
                return ResponseDTO.wrap(SensorResponseCodeConst.HAVE_BEEN_OUT_OF_WORKSHOP);
            }

            swipeVO.setName(userInfo.getName());
            swipeCardService.insertSwipeOutMsg(swipeVO, currentInAndOut.getId());

            return ResponseDTO.succ();
        } catch (Exception e) {
            LOGGER.error("刷卡出门出错");
            return ResponseDTO.wrap(ResponseCodeConst.SYSTEM_ERROR);
        }

    }



}
