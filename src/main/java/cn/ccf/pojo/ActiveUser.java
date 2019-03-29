package cn.ccf.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ActiveUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;// 用户id

    private String username;

    private String realname;

    private List<SysResource> menus;// 菜单

    private List<SysResource> permissions;// 权限



}
