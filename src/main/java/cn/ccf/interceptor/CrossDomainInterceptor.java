package cn.ccf.interceptor;

import cn.ccf.pojo.UserInfo;
import cn.ccf.util.RequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author charles
 * @date 2019/5/6 8:39
 * <p>
 * 登录拦截器
 */
@Component
public class CrossDomainInterceptor extends HandlerInterceptorAdapter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Expose-Headers", "*");
        response.setHeader("Access-Control-Allow-Headers", "Authentication,Origin, X-Requested-With, Content-Type, " + "Accept, x-access-token");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");

        // 如果不注释，出现获取定员人数失败 todo

        /*if (handler instanceof HandlerMethod) {
            String contextPath = request.getContextPath();
            String uri = request.getRequestURI();
            String target = uri.replaceFirst(contextPath, "");
            if (target.contains("login") || target.contains("handleLogin")) {
                return true;
            }

            UserInfo userInfo = RequestUtil.getSessionEntity();
            if (null == userInfo) {
                request.getRequestDispatcher("/WEB-INF/jsp/system/user/login.jsp").forward(request, response);
                return false;
            }
        }*/
        return true;
    }

}
