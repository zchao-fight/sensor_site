package cn.ccf.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class NumInWorkshop {
    private String id;

    private String workshopId;

    private BigDecimal num;

    private Date createTime;

}