package cn.ccf.common;

public class SensorResponseCodeConst extends ResponseCodeConst {

    /**
     * 无效卡号 101
     */
    public static final SensorResponseCodeConst USELESS_CARD_ID = new
            SensorResponseCodeConst(101, "无效卡号！");

    /**
     * 人员已在工房 102
     */
    public static final SensorResponseCodeConst HAVE_BEEN_IN_WORKSHOP = new
                    SensorResponseCodeConst(102, "人员已在工房！");

    /**
     * 人员已离开工房 103
     */
    public static final SensorResponseCodeConst HAVE_BEEN_OUT_OF_WORKSHOP = new
            SensorResponseCodeConst(103, "人员已离开工房！");

    /**
     * 人员已离开工房 104
     */
    public static final SensorResponseCodeConst OUT_OF_LIMIT = new
            SensorResponseCodeConst(104, "人员超限！");


    public SensorResponseCodeConst(int code, String msg) {
        super(code, msg);
    }
}
