package cn.ccf.shiro;

import cn.ccf.pojo.ActiveUser;
import cn.ccf.pojo.SysResource;
import cn.ccf.pojo.SysUser;
import cn.ccf.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class CustomRealm extends AuthorizingRealm{

    @Resource
    private SysUserService sysUserService;



    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("CustomRealm");
    }

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //token是用户输入的
        //第一步：从token取出身份信息
        String username = (String) authenticationToken.getPrincipal();

        //第二步：根据用户输入的username从数据库查询
        SysUser sysUser = sysUserService.getByUsername(username);
        if (sysUser == null) {
            return null;
        }

        String password = sysUser.getPassword();
        String salt = sysUser.getSalt();//盐

        //如果查询到返回认证信息AuthenticationInfo
        //activeUser 用户信息
        ActiveUser activeUser = new ActiveUser();
        activeUser.setId(sysUser.getId());
        activeUser.setUsername(sysUser.getUsername());
        activeUser.setRealname(sysUser.getRealname());

        //根据 用户id 取出菜单
        List<SysResource> menuList = sysUserService.findMenuListByUserId(activeUser.getId());
        //将用户菜单设置到activeUser
        activeUser.setMenus(menuList);

        //将activeUser设置到simpleAuthenticationInfo
        return new SimpleAuthenticationInfo(activeUser, password, ByteSource.Util.bytes(salt), this.getName());
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //从principal获取主身份信息）
        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();

        List<SysResource> permissionList = sysUserService.findPermissionListByUserId(activeUser.getId());

        List<String> permissions = new ArrayList<>();

        if (permissionList != null) {
            permissionList.forEach(e -> permissions.add(e.getResKey()));
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将上面查询到的授权信息填充到simAuthorizationInfo中
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    //清除缓存  shiro中提供了对认证信息和授权信息的缓存。shiro默认是关闭认证信息缓存的，对于授权信息的缓存shiro默认开启的。主要研究授权信息缓存，因为授权的数据量大。
    //用户认证通过。 该 用户第一次授权：调用realm查询数据库     该 用户第二次授权：不调用realm查询数据库，直接从缓存中取出授权信息（权限标识符）。
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
