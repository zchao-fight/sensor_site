package cn.ccf.service;

import cn.ccf.mapper.SensorRealTimeValueMapper;
import cn.ccf.pojo.SensorRealTimeValue;
import cn.ccf.pojo.SensorRealTimeValueExample;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class RealTimeSensorDataService {

    @Resource
    private SensorRealTimeValueMapper sensorRealTimeValueMapper;

    @Transactional()
    public int insertSensorRealTimeData(SensorRealTimeValue currentValue) {

        SensorRealTimeValueExample example = new SensorRealTimeValueExample();
        example.createCriteria().andSensorIdEqualTo(currentValue.getSensorId());
        List<SensorRealTimeValue> list = sensorRealTimeValueMapper.selectByExample(example);
        if (null != list && list.size() != 0) {
            SensorRealTimeValue sensorRealTimeValue = list.get(0);
            sensorRealTimeValue.setNum(currentValue.getNum());
            sensorRealTimeValue.setUpdateTime(new Date());
            return sensorRealTimeValueMapper.updateByPrimaryKeySelective(sensorRealTimeValue);
        }
        currentValue.setId(UUID.randomUUID().toString().replace("-", ""));
        currentValue.setUpdateTime(new Date());
        return sensorRealTimeValueMapper.insert(currentValue);

    }

    public SensorRealTimeValue queryBySensorId(String sensorId) {
        SensorRealTimeValueExample example = new SensorRealTimeValueExample();
        example.createCriteria().andSensorIdEqualTo(sensorId);
        List<SensorRealTimeValue> list = sensorRealTimeValueMapper.selectByExample(example);
        if (list != null && list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    public List<SensorRealTimeValue> queryBySensorType(String type) {
        SensorRealTimeValueExample example = new SensorRealTimeValueExample();
        example.createCriteria().andSensorTypeEqualTo(type);
        List<SensorRealTimeValue> list = sensorRealTimeValueMapper.selectByExample(example);
        if (list != null && list.size() != 0) {
            return list;
        }
        return null;
    }
}
