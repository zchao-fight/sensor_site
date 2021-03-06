package cn.ccf.controller;

import cn.ccf.common.ResponseCodeConst;
import cn.ccf.common.ResponseDTO;
import cn.ccf.pojo.SensorRealTimeValue;
import cn.ccf.service.RealTimeSensorDataService;
import cn.ccf.service.SensorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class RealTimeSensorDataController {

    @Resource
    private RealTimeSensorDataService realTimeSensorDataService;


    @RequestMapping(value = "saveLaser", method = RequestMethod.POST)
    public ResponseDTO<Void> saveLaser(SensorRealTimeValue sensorRealTimeValue) {
        return saveSensorRealTimeData(sensorRealTimeValue);
    }

    @RequestMapping(value = "saveGas", method = RequestMethod.POST)
    public ResponseDTO<Void> saveGas(SensorRealTimeValue sensorRealTimeValue) {
        return saveSensorRealTimeData(sensorRealTimeValue);
    }

    @RequestMapping(value = "saveProximity", method = RequestMethod.POST)
    public ResponseDTO<Void> saveProximity(SensorRealTimeValue sensorRealTimeValue) {
        return saveProximityRealTimeData(sensorRealTimeValue);
    }

    private ResponseDTO<Void> saveProximityRealTimeData(SensorRealTimeValue sensorRealTimeValue) {
        String[] sensorIds = sensorRealTimeValue.getSensorId().split(",");
        String[] units = sensorRealTimeValue.getUnit().split(",");
        String[] nums = sensorRealTimeValue.getNum().split(",");


        for (int i = 0; i < sensorIds.length; i++) {

            SensorRealTimeValue temp = new SensorRealTimeValue();
            temp.setUnit(units[i]);
            temp.setSensorType("proximity");
            temp.setSensorId(sensorIds[i]);
            temp.setNum(nums[i]);
            saveSensorRealTimeData(temp);
        }



        return ResponseDTO.succ();
    }

    @RequestMapping(value = "saveDust", method = RequestMethod.POST)
    public ResponseDTO<Void> saveDust(SensorRealTimeValue sensorRealTimeValue) {
        return saveSensorRealTimeData(sensorRealTimeValue);
    }

    @RequestMapping(value = "saveResistance", method = RequestMethod.POST)
    public ResponseDTO<Void> saveResistance(SensorRealTimeValue sensorRealTimeValue) {
        return saveSensorRealTimeData(sensorRealTimeValue);
    }

    @RequestMapping(value = "saveHumiture", method = RequestMethod.POST)
    public ResponseDTO<Void> saveHumiture(SensorRealTimeValue sensorRealTimeValue) {
        String sensorIds = sensorRealTimeValue.getSensorId();
        String value = sensorRealTimeValue.getNum();
        String[] ids = sensorIds.split(",");
        String[] nums = value.split(",");
        if (ids.length != nums.length) {
            return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
        }

        SensorRealTimeValue record = new SensorRealTimeValue();


        for (int i = 0; i < ids.length; i++) {
            if (i % 2 == 0) {
                // 保存温度
                record.setNum(nums[i]);
                record.setSensorId(ids[i]);
                record.setSensorType("temperature");
                record.setUnit("摄氏度");
                saveSensorRealTimeData(record);
            } else {
                // 保存湿度
                record.setNum(nums[i]);
                record.setSensorId(ids[i]);
                record.setSensorType("humidity");
                record.setUnit("%RH");
                saveSensorRealTimeData(record);
            }
        }
        return ResponseDTO.succ();
    }


    public ResponseDTO<Void> saveSensorRealTimeData(SensorRealTimeValue sensorRealTimeLaserData) {
        try {
            realTimeSensorDataService.insertSensorRealTimeData(sensorRealTimeLaserData);
        } catch (Exception e) {
            return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
        }
        return ResponseDTO.succ();
    }
}
