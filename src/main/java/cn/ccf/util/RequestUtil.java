package cn.ccf.util;

import cn.ccf.common.constants.SessionConst;
import cn.ccf.pojo.UserInfo;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author charles
 * @date 2019/4/16
 */
public class RequestUtil {

    public static UserInfo getSessionEntity() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request != null) {
                return (UserInfo) request.getSession().getAttribute(SessionConst.SESSION_NAME);
            }
        }
        return null;
    }

    public static HttpSession getSession() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request != null) {
                return request.getSession();
            }
        }
        return null;
    }

    public static boolean invalidateSession() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request != null) {
                request.getSession().invalidate();
                return true;
            }
        }
        return false;
    }

    public static String getRemoteAddr() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request != null) {
                return request.getRemoteAddr();
            }
        }
        return null;
    }


    public static String getRequestUri() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request != null) {
                String uri = request.getRequestURI();
                String contextPath = request.getContextPath();
                return uri.replaceFirst(contextPath, "");
            }
        }
        return null;
    }

    /**
     * 获取页面传递的某一个参数值
     *
     * @param key
     * @return
     */
    public static String getPara(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getParameter(key);
    }

    public static String[] getParaValues(String key) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getParameterValues(key);
    }
}
