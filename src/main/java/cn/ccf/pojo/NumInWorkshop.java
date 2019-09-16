package cn.ccf.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author charles
 */
@Data
public class NumInWorkshop {
    private String id;

    private String workshopId;

    private BigDecimal num;

    private String createTime;

}