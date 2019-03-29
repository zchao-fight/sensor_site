package cn.ccf.controller;

import cn.ccf.common.constants.SessionConst;
import cn.ccf.pojo.UserInfo;
import cn.ccf.service.UserInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private static final String salt = "zc";

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("addUserUI")
    public String addUserUI(HttpServletRequest request) {
        return "system/user/add";
    }

    @RequestMapping("modifyPasswordUI")
    public String modifyPasswordUI(HttpServletRequest request) {
        return "system/user/modifyPassword";
    }

    @RequestMapping("modifyPassword")
    @ResponseBody
    public ResponseEntity<Void> modifyPassword(HttpServletRequest request, String password) {
        try {
            UserInfo userInfo = (UserInfo) request.getSession().getAttribute(SessionConst.SESSION_NAME);
            userInfo.setPassword(new SimpleHash("MD5", password, salt, 1).toString());
            userInfoService.updateSelective(userInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @RequestMapping("editUserUI")
    public String editUserUI(HttpServletRequest request, String id) {
        UserInfo userInfo = userInfoService.queryUserById(id);
        request.setAttribute("userInfo", userInfo);
        return "system/user/edit";
    }

    @RequestMapping("editUser")
    public ResponseEntity<Void> editUser(UserInfo userInfo) {
        try {
            userInfo.setWorkId(String.valueOf(Long.parseLong(userInfo.getEchoWorkId())));
            userInfoService.updateSelective(userInfo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @RequestMapping(value = "deleteUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> deleteUser(Integer id) {
        Integer result = userInfoService.deleteUser(id);
        if (result == 1) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> addUser(UserInfo userInfo) {

        if (userInfo.getUsername() != null && userInfo.getEchoWorkId() != null) {
            boolean flag = userInfoService.queryUserInfoByUsernameAndEchoWorkId(userInfo.getUsername(), userInfo.getEchoWorkId());
            if (!flag) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        try {
            String password = new SimpleHash("MD5", userInfo.getPassword(), salt, 1).toString();
            String echoWorkId = userInfo.getEchoWorkId();
            if (echoWorkId != null) {
                userInfo.setWorkId(String.valueOf(Long.parseLong(echoWorkId)));
            }
            userInfo.setPassword(password);
            Integer result = userInfoService.inserUser(userInfo);
            if (result == 1) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        return "system/user/login";
    }

    @RequestMapping("handleLogin")
    public String login(HttpServletRequest request, String username, String password) {
        String passwordMd5 = new SimpleHash("MD5", password, salt, 1).toString();
        UserInfo userInfo = userInfoService.queryUserInfoByUsername(username);
        if (userInfo != null) {
            if (StringUtils.equals(passwordMd5, userInfo.getPassword())) {
                request.getSession().setAttribute(SessionConst.SESSION_NAME, userInfo);
                request.getSession().setMaxInactiveInterval(60 * 60);
                return "redirect:/index.action";
            }
        }

        request.setAttribute("error", "登录失败");

        return "system/user/login";
    }

    @RequestMapping("list")
    public String listUser(HttpServletRequest request) {
        List<UserInfo> userInfos = userInfoService.findAllUsers();
        request.setAttribute("userInfos", userInfos);
        return "system/user/list";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/user/login.action";
    }

    @RequestMapping("getVerificationCode")
    public String getVerificationCode() {
        return "system/user/validatecode";
    }
}
