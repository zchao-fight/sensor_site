package cn.ccf.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class LoginLog {
    private Long id;

    private String username;

    private Date loginTime;

    private String loginIp;

    private String description;

}