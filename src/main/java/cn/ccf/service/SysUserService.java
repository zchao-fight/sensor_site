package cn.ccf.service;

import cn.ccf.pojo.SysResource;
import cn.ccf.pojo.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserService {

    List<SysResource> findMenuListByUserId(int id);

    List<SysResource> findPermissionListByUserId(int id);

    void insertLoginLog(Map<String, Object> logForm);

    List<SysUser> findAllSysUsers();

    Integer insertSysUserAndRole(SysUser sysUser, Integer roleId);

    SysUser selectUserById(Integer id);

    String selectRoleByUserId(Integer userId);

    Integer deleteUser(Integer id);

    SysUser getByUsername(String username);
}
