package cn.ccf.mapper;

import cn.ccf.pojo.SysRoleResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleResourceMapper {


    void batchSave(List<SysRoleResource> list);

    void deleteRolePermission(String roleId);

    // 删除角色 级联删除角色-资源表关联
    int deleteRoleByRoleId(Integer roleId);
}
