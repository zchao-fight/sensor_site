package cn.ccf.quartz;

import cn.ccf.pojo.*;
import cn.ccf.service.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Component
public class ScanDatabase {

    @Resource
    private RealTimeSensorDataService realTimeSensorDataService;

    @Resource
    private LaserRangeHistoryService laserRangeHistoryService;

    @Resource
    private DustHistoryService dustHistoryService;

    @Resource
    private GasHistoryService gasHistoryService;

    @Resource
    private ResistanceHistoryService resistanceHistoryService;

    @Resource
    private TemperatureHistoryService temperatureHistoryService;

    @Resource
    private HumidityHistoryService humidityHistoryService;




    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveHumidityHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("humidity");


        if (sensorRealTimeValues != null) {
            List<HumidityHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                HumidityHistory humidityHistory = new HumidityHistory();
                humidityHistory.setCreateTime(new Date());
                humidityHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                humidityHistory.setSensorNum(e.getSensorId());
                humidityHistory.setUnit(e.getUnit());
                humidityHistory.setNum(e.getNum());
                list.add(humidityHistory);
            });

            humidityHistoryService.saveHumidity(list);
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveTemperatureHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("temperature");


        if (sensorRealTimeValues != null) {
            List<TemperatureHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                TemperatureHistory temperatureHistory = new TemperatureHistory();
                temperatureHistory.setCreateTime(new Date());
                temperatureHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                temperatureHistory.setSensorNum(e.getSensorId());
                temperatureHistory.setUnit(e.getUnit());
                temperatureHistory.setNum(e.getNum());
                list.add(temperatureHistory);
            });

            temperatureHistoryService.saveTemperature(list);
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveLaserHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("laser");


        if (sensorRealTimeValues != null) {
            List<LaserRangeHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                LaserRangeHistory laserRange = new LaserRangeHistory();
                laserRange.setCreateTime(new Date());
                laserRange.setId(UUID.randomUUID().toString().replace("-", ""));
                laserRange.setSensorNum(e.getSensorId());
                laserRange.setUnit(e.getUnit());
                laserRange.setNum(e.getNum());
                list.add(laserRange);
            });

            laserRangeHistoryService.saveLaserRange(list);
        }
    }


    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveDustHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("dust");

        if (sensorRealTimeValues != null) {
            List<DustHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                DustHistory dustHistory = new DustHistory();
                dustHistory.setCreateTime(new Date());
                dustHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                dustHistory.setSensorNum(e.getSensorId());
                dustHistory.setUnit(e.getUnit());
                dustHistory.setNum(e.getNum());
                list.add(dustHistory);
            });

            dustHistoryService.saveDust(list);
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveGasHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("dust");

        if (sensorRealTimeValues != null) {
            List<GasHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                GasHistory gasHistory = new GasHistory();
                gasHistory.setCreateTime(new Date());
                gasHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                gasHistory.setSensorNum(e.getSensorId());
                gasHistory.setUnit(e.getUnit());
                gasHistory.setNum(e.getNum());
                list.add(gasHistory);
            });

            gasHistoryService.saveGas(list);
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveResistanceHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("resistance");

        if (sensorRealTimeValues != null) {
            List<ResistanceHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                ResistanceHistory resistanceHistory = new ResistanceHistory();
                resistanceHistory.setCreateTime(new Date());
                resistanceHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                resistanceHistory.setSensorNum(e.getSensorId());
                resistanceHistory.setUnit(e.getUnit());
                resistanceHistory.setNum(e.getNum());
                list.add(resistanceHistory);
            });

            resistanceHistoryService.saveResistance(list);
        }
    }
}
