package cn.ccf.service;

import cn.ccf.mapper.SensorMapper;
import cn.ccf.pojo.Sensor;
import cn.ccf.pojo.SensorExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SensorService {

    @Autowired
    private SensorMapper sensorMapper;


    public List<Sensor> queryByType(String type) {
        SensorExample example = new SensorExample();
        example.createCriteria().andTypeEqualTo(type);
        return sensorMapper.selectByExample(example);
    }

    public Sensor queryBySensorNumber(String sensorNumber) {
        SensorExample example = new SensorExample();
        example.createCriteria().andSensorNumberEqualTo(sensorNumber);
        List<Sensor> sensors = sensorMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(sensors)) {
            return null;
        }
        return sensors.get(0);
    }

    public void insert(Sensor sensor) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        sensor.setId(uuid);
        sensorMapper.insert(sensor);
    }

    public int deleteSensor(String id) {
        return sensorMapper.deleteByPrimaryKey(id);
    }

    public Sensor queryById(String id) {
        return sensorMapper.selectByPrimaryKey(id);
    }

    public void updateSelective(Sensor sensor) {
        sensorMapper.updateByPrimaryKeySelective(sensor);
    }
}
