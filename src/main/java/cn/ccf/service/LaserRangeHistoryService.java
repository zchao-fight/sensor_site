package cn.ccf.service;

import cn.ccf.mapper.LaserRangeHistoryMapper;
import cn.ccf.pojo.LaserRangeHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LaserRangeHistoryService {

    @Resource
    private LaserRangeHistoryMapper laserRangeHistoryMapper;


    public void saveLaserRange(List<LaserRangeHistory> list) {
        laserRangeHistoryMapper.batchInsert(list);
    }
}
