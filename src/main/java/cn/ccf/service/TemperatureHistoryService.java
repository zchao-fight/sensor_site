package cn.ccf.service;

import cn.ccf.mapper.TemperatureHistoryMapper;
import cn.ccf.pojo.TemperatureHistory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemperatureHistoryService {
    @Resource
    private TemperatureHistoryMapper temperatureHistoryMapper;


    public void saveTemperature(List<TemperatureHistory> list) {
        temperatureHistoryMapper.batchInsert(list);
    }
}
