package cn.ccf.quartz;

/**
 * @author charles
 * @date 2019/8/25 18:59
 */
public enum SensorStatus {
    Normal("正常", "1"), Damage("损坏", "0");

    private String status;
    private String flag;
    SensorStatus(String status, String flag) {
        this.flag = flag;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
