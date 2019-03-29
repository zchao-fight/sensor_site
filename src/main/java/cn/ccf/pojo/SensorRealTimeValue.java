package cn.ccf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SensorRealTimeValue {
    private String id;

    private String sensorId;

    private String sensorType;

    private String num;

    private String unit;

    private Date updateTime;

}