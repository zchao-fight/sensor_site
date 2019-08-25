package cn.ccf.pojo;

import java.util.Date;

public class ProximityHistory {
    private String id;

    private String sensorNum;

    private String num;

    private String unit;

    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSensorNum() {
        return sensorNum;
    }

    public void setSensorNum(String sensorNum) {
        this.sensorNum = sensorNum == null ? null : sensorNum.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}