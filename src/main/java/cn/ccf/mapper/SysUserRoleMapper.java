package cn.ccf.mapper;

import cn.ccf.pojo.SysUserRoleExample;
import cn.ccf.pojo.SysUserRoleKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserRoleMapper {
    int countByExample(SysUserRoleExample example);

    int deleteByExample(SysUserRoleExample example);

    int deleteByPrimaryKey(SysUserRoleKey key);

    int insert(SysUserRoleKey record);

    int insertSelective(SysUserRoleKey record);

    List<SysUserRoleKey> selectByExample(SysUserRoleExample example);

    int updateByExampleSelective(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);

    int updateByExample(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);

    String selectRoleByUserId(Integer userId);

    int deleteUserRoleByUserId(Integer id);

    List<SysUserRoleKey> selectUserRoleByRoleId(Integer roleId);
}