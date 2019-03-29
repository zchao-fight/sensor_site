package cn.ccf.service;

import cn.ccf.mapper.LoginLogMapper;
import cn.ccf.mapper.SysResourceMapper;
import cn.ccf.mapper.SysUserMapper;
import cn.ccf.mapper.SysUserRoleMapper;
import cn.ccf.pojo.SysResource;
import cn.ccf.pojo.SysUser;
import cn.ccf.pojo.SysUserExample;
import cn.ccf.pojo.SysUserRoleKey;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private LoginLogMapper loginLogMapper;

    @Resource
    private SysResourceMapper sysResourceMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    public SysUser getByUsername(String username) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
        if (sysUsers != null && sysUsers.size() != 0) {
            return sysUsers.get(0);
        }
        return null;

    }

    @Override
    public List<SysResource> findMenuListByUserId(int userId) {
        return sysResourceMapper.findMenuListByUserId(userId);
    }

    @Override
    public List<SysResource> findPermissionListByUserId(int userId) {
        return sysResourceMapper.findPermissionListByUserId(userId);
    }

    @Override
    public void insertLoginLog(Map<String, Object> logForm) {
        loginLogMapper.insert(logForm);
    }

    @Override
    public List<SysUser> findAllSysUsers() {
        return sysUserMapper.findAllSysUsers();
    }

    @Override
    public Integer insertSysUserAndRole(SysUser sysUser, Integer roleId) {
        int result1 = sysUserMapper.insert(sysUser);
        SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
        sysUserRoleKey.setRoleId(roleId);
        sysUserRoleKey.setUserId(sysUser.getId());
        int result2 = sysUserRoleMapper.insert(sysUserRoleKey);

        return result1 == 1 && result2 ==1 ? 1 : 0;


    }

    @Override
    public SysUser selectUserById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public String selectRoleByUserId(Integer userId) {
        return sysUserRoleMapper.selectRoleByUserId(userId);
    }

    @Override
    public Integer deleteUser(Integer id) {
        int result1 = sysUserMapper.deleteByPrimaryKey(id);
        int result2 = sysUserRoleMapper.deleteUserRoleByUserId(id);
        return result1 == 1 && result2 == 1 ? 1 : 0;
    }
}
