package cn.ccf.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Workshop {
    private String id;

    private String workshopNumber;

    private String name;

    private String location;

    private Date createtime;

    private String ip;

    private BigDecimal personnelQuota;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkshopNumber() {
        return workshopNumber;
    }

    public void setWorkshopNumber(String workshopNumber) {
        this.workshopNumber = workshopNumber == null ? null : workshopNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public BigDecimal getPersonnelQuota() {
        return personnelQuota;
    }

    public void setPersonnelQuota(BigDecimal personnelQuota) {
        this.personnelQuota = personnelQuota;
    }
}