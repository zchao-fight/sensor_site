package cn.ccf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OperateLog {
    private Integer id;

    private String username;

    private String module;

    private String methods;

    private String actionTime;

    private String userIP;

    private Date operTime;

    private String description;

}