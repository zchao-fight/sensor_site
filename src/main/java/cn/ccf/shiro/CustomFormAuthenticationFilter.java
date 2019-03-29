package cn.ccf.shiro;

import cn.ccf.pojo.ActiveUser;
import cn.ccf.service.SysUserService;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    @Resource
    private SysUserService sysUserService;

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        // TODO 暂时注释掉验证码

        /**
        //在这里进行校验码校验 从session中取出正确校验码
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        String validateCode = (String) session.getAttribute("validateCode");

        //取出页面的校验码 验证输入的验证码和session中的验证码进行对比

        String randomcode = httpServletRequest.getParameter("randomcode");


        if (randomcode != null && validateCode != null && !randomcode.equalsIgnoreCase(validateCode)) {
            //校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
            httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
            //拒绝访问 不再校验账号和密码
            return true;
        }
         **/
        return super.onAccessDenied(request, response);
    }

    //返回subject是否已经登陆验证通过了，因为没有logout，所以返回true
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //针对一个浏览器只能登录一个账号的bug解决方法
        //是否是登录地址
        if (isLoginRequest(request, response)) {
            //是否是post提交
            if (isLoginSubmission(request, response)) {
                //继续身份验证
                return false;
            }
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }


    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

        // 获取已登录的用户信息
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        String loginIp = subject.getSession().getHost();

        // 获取session
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpSession session = httpServletRequest.getSession();

        // 用户信息保存到session
        session.setAttribute("activeUser", activeUser);


        Map<String, Object> logForm = new HashMap<>();
        logForm.put("username", activeUser.getUsername());
        logForm.put("loginIp", loginIp);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        logForm.put("loginTime", timestamp);
        logForm.put("description", "登录成功");
        sysUserService.insertLoginLog(logForm);
        return super.onLoginSuccess(token, subject, request, response);
    }
}
