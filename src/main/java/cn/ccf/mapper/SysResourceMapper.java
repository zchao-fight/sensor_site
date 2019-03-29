package cn.ccf.mapper;

import cn.ccf.pojo.SysResource;
import cn.ccf.pojo.TreeObjectVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysResourceMapper {

    //根据用户id查询菜单
    List<SysResource> findMenuListByUserId(int userId);

    //根据用户id查询权限url
    List<SysResource> findPermissionListByUserId(int userId);

    // 根据roleId查询权限
    List<SysResource> findResourceByRoleId(String roleId);

    // 查询所有权限数据
    List<TreeObjectVO> findAllPermissions();
}
