package cn.ccf.service;

import cn.ccf.mapper.SysRoleMapper;
import cn.ccf.pojo.SysRole;
import cn.ccf.pojo.SysRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    public List<SysRole> findAllRole() {

        return sysRoleMapper.selectByExample(new SysRoleExample());
    }


}
