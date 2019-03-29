package cn.ccf.service;

import cn.ccf.mapper.HumidityHistoryMapper;
import cn.ccf.pojo.HumidityHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HumidityHistoryService {
    @Resource
    private HumidityHistoryMapper humidityHistoryMapper;


    public void saveHumidity(List<HumidityHistory> list) {
        humidityHistoryMapper.batchInsert(list);
    }
}
