package cn.ccf.controller;

import cn.ccf.common.ResponseCodeConst;
import cn.ccf.common.ResponseDTO;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
//            userInfo.setPassword(new SimpleHash("MD5", password, salt, 1).toString());
            userInfo.setPassword(password);
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


    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDTO<Boolean> deleteUser(@RequestParam("id") int id) {
        userInfoService.deleteUser(id);
        return ResponseDTO.succ(true);
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDTO<Boolean> addUser(@Valid UserInfo userInfo) {

        if (userInfo.getUsername() != null && userInfo.getEchoWorkId() != null) {
            boolean flag = userInfoService.queryUserInfoByUsernameAndEchoWorkId(userInfo.getUsername(), userInfo.getEchoWorkId());
            if (!flag) {
                return ResponseDTO.wrap(ResponseCodeConst.SYSTEM_ERROR);
            }
        }

        /** 暂时不加密
         String password = new SimpleHash("MD5", userInfo.getPassword(), salt, 1).toString();
         userInfo.setPassword(password);
         **/
        String echoWorkId = userInfo.getEchoWorkId();
        if (echoWorkId != null) {
            userInfo.setWorkId(String.valueOf(Long.parseLong(echoWorkId)));
        }
        Integer result = userInfoService.inserUser(userInfo);
        if (result == 1) {
            return ResponseDTO.succ(true);
        } else {
            return ResponseDTO.wrap(ResponseCodeConst.SYSTEM_ERROR);
        }
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request) {
        return "system/user/login";
    }

    @RequestMapping("handleLogin")
    public String login(HttpServletRequest request, String username, String password) {
//        String passwordMd5 = new SimpleHash("MD5", password, salt, 1).toString();
        UserInfo userInfo = userInfoService.queryUserInfoByUsername(username);
        if (userInfo != null) {
            if (StringUtils.equals(password, userInfo.getPassword())) {
                request.getSession().setAttribute(SessionConst.SESSION_NAME, userInfo);
                request.getSession().setMaxInactiveInterval(60 * 60 * 60);
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


    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/user/login.action";
    }

    @RequestMapping("getVerificationCode")
    public String getVerificationCode() {
        return "system/user/validatecode";
    }
}
