package cn.ccf.quartz;

import cn.ccf.pojo.*;
import cn.ccf.service.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author charles
 * @date 2019/08/25
 */
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

    @Resource
    private ProximityHistoryService proximityHistoryService;

    @Resource
    private SensorService sensorService;

    /**
     * 状态好坏 0：坏 1：好
     */
    private Map<String, SensorStatus> statusMap = new HashMap<String, SensorStatus>() {{
        put("humidity", SensorStatus.Damage);
        put("temperature", SensorStatus.Damage);
        put("laser", SensorStatus.Damage);
        put("dust", SensorStatus.Damage);
        put("gas", SensorStatus.Damage);
        put("resistance", SensorStatus.Damage);
        put("proximity", SensorStatus.Damage);
    }};


    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveHumidityHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("humidity");

        if (sensorRealTimeValues != null) {
            List<HumidityHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                HumidityHistory humidityHistory = new HumidityHistory();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date nowDate = new Date();

                try {
                    Date originalDate = sdf.parse(e.getUpdateTime());
                    int interval = (int) ((nowDate.getTime() - originalDate.getTime()) / (1000 * 60));
                    if (interval < 10) {
                        humidityHistory.setCreateTime(sdf.format(nowDate));
                        humidityHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                        humidityHistory.setSensorNum(e.getSensorId());
                        humidityHistory.setUnit(e.getUnit());
                        humidityHistory.setNum(e.getNum());
                        list.add(humidityHistory);

//                            变量在数据库里面更改为正常
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Damage.getFlag())) {
                                sensor.setStatus(SensorStatus.Normal.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }

                    } else {
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Normal.getFlag())) {
                                sensor.setStatus(SensorStatus.Damage.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }

                    }
                } catch (Exception ex) {
                    System.out.println("湿度日期转换失败");
                }
            });

            if (!list.isEmpty()) {
                humidityHistoryService.saveHumidity(list);
            }
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveTemperatureHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("temperature");


        if (sensorRealTimeValues != null) {
            List<TemperatureHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                TemperatureHistory temperatureHistory = new TemperatureHistory();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date nowDate = new Date();

                try {
                    Date originalDate = sdf.parse(e.getUpdateTime());
                    int interval = (int) ((nowDate.getTime() - originalDate.getTime()) / (1000 * 60));
                    if (interval < 10) {
                        temperatureHistory.setCreateTime(sdf.format(nowDate));
                        temperatureHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                        temperatureHistory.setSensorNum(e.getSensorId());
                        temperatureHistory.setUnit(e.getUnit());
                        temperatureHistory.setNum(e.getNum());
                        list.add(temperatureHistory);

                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Damage.getFlag())) {
                                sensor.setStatus(SensorStatus.Normal.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    } else {
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Normal.getFlag())) {
                                sensor.setStatus(SensorStatus.Damage.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("温度日期转换失败");
                }
            });

            if (!list.isEmpty()) {
                temperatureHistoryService.saveTemperature(list);
            }
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveLaserHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("laser");


        if (sensorRealTimeValues != null) {
            List<LaserRangeHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                LaserRangeHistory laserRange = new LaserRangeHistory();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date nowDate = new Date();

                try {
                    Date originalDate = sdf.parse(e.getUpdateTime());
                    int interval = (int) ((nowDate.getTime() - originalDate.getTime()) / (1000 * 60));
                    if (interval < 10) {
                        laserRange.setCreateTime(sdf.format(nowDate));
                        laserRange.setId(UUID.randomUUID().toString().replace("-", ""));
                        laserRange.setSensorNum(e.getSensorId());
                        laserRange.setUnit(e.getUnit());
                        laserRange.setNum(e.getNum());
                        list.add(laserRange);
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Damage.getFlag())) {
                                sensor.setStatus(SensorStatus.Normal.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    } else {
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Normal.getFlag())) {
                                sensor.setStatus(SensorStatus.Damage.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("激光日期转换错误");
                }

            });

            if (!list.isEmpty()) {
                laserRangeHistoryService.saveLaserRange(list);
            }
        }
    }


    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveDustHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("dust");

        if (sensorRealTimeValues != null) {
            List<DustHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                DustHistory dustHistory = new DustHistory();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date nowDate = new Date();

                try {
                    Date originalDate = sdf.parse(e.getUpdateTime());
                    int interval = (int) ((nowDate.getTime() - originalDate.getTime()) / (1000 * 60));
                    if (interval < 10) {
                        dustHistory.setCreateTime(sdf.format(nowDate));
                        dustHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                        dustHistory.setSensorNum(e.getSensorId());
                        dustHistory.setUnit(e.getUnit());
                        dustHistory.setNum(e.getNum());
                        list.add(dustHistory);
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Damage.getFlag())) {
                                sensor.setStatus(SensorStatus.Normal.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    } else {
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Normal.getFlag())) {
                                sensor.setStatus(SensorStatus.Damage.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("粉尘日期转换错误");
                }

            });

            if (!list.isEmpty()) {
                dustHistoryService.saveDust(list);
            }
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveGasHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("gas");

        if (sensorRealTimeValues != null) {
            List<GasHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                GasHistory gasHistory = new GasHistory();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date nowDate = new Date();

                try {
                    Date originalDate = sdf.parse(e.getUpdateTime());
                    int interval = (int) ((nowDate.getTime() - originalDate.getTime()) / (1000 * 60));
                    if (interval < 10) {
                        gasHistory.setCreateTime(sdf.format(nowDate));
                        gasHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                        gasHistory.setSensorNum(e.getSensorId());
                        gasHistory.setUnit(e.getUnit());
                        gasHistory.setNum(e.getNum());
                        list.add(gasHistory);
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Damage.getFlag())) {
                                sensor.setStatus(SensorStatus.Normal.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    } else {
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Normal.getFlag())) {
                                sensor.setStatus(SensorStatus.Damage.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("可燃气体日期转换失败");
                }

            });

            if (CollectionUtils.isNotEmpty(list)) {
                gasHistoryService.saveGas(list);
            }
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveResistanceHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("resistance");

        if (sensorRealTimeValues != null) {
            List<ResistanceHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                ResistanceHistory resistanceHistory = new ResistanceHistory();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date nowDate = new Date();

                try {
                    Date originalDate = sdf.parse(e.getUpdateTime());
                    int interval = (int) ((nowDate.getTime() - originalDate.getTime()) / (1000 * 60));
                    if (interval < 10) {
                        resistanceHistory.setCreateTime(sdf.format(nowDate));
                        resistanceHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                        resistanceHistory.setSensorNum(e.getSensorId());
                        resistanceHistory.setUnit(e.getUnit());
                        resistanceHistory.setNum(e.getNum());
                        list.add(resistanceHistory);
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Damage.getFlag())) {
                                sensor.setStatus(SensorStatus.Normal.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    } else {
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Normal.getFlag())) {
                                sensor.setStatus(SensorStatus.Damage.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println("接地电阻日期转换失败");
                }

            });

            if (!list.isEmpty()) {
                resistanceHistoryService.saveResistance(list);
            }
        }
    }

    @Scheduled(cron = "0 0/1 * * * ? ")
    public void saveProximityHistory() {
        List<SensorRealTimeValue> sensorRealTimeValues = realTimeSensorDataService.queryBySensorType("proximity");

        if (sensorRealTimeValues != null) {
            List<ProximityHistory> list = new ArrayList<>();
            sensorRealTimeValues.forEach(e -> {
                ProximityHistory proximityHistory = new ProximityHistory();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date nowDate = new Date();
                try {
                    Date originalDate = sdf.parse(e.getUpdateTime());
                    int interval = (int) ((nowDate.getTime() - originalDate.getTime()) / (1000 * 60));
                    if (interval < 10) {
                        proximityHistory.setCreateTime(sdf.format(nowDate));
                        proximityHistory.setId(UUID.randomUUID().toString().replace("-", ""));
                        proximityHistory.setSensorNum(e.getSensorId());
                        proximityHistory.setUnit(e.getUnit());
                        proximityHistory.setNum(e.getNum());
                        list.add(proximityHistory);
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Damage.getFlag())) {
                                sensor.setStatus(SensorStatus.Normal.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    } else {
                        Sensor sensor = sensorService.queryBySensorNumber(e.getSensorId());
                        if (sensor != null) {
                            if (sensor.getStatus().equals(SensorStatus.Normal.getFlag())) {
                                sensor.setStatus(SensorStatus.Damage.getFlag());
                                sensorService.updateSelective(sensor);
                            }
                        }
                    }
                } catch (ParseException e1) {
                    System.out.println("接近传感器日期转换出错");
                }


            });

            if (!list.isEmpty()) {
                proximityHistoryService.saveProximity(list);
            }
        }
    }
}
