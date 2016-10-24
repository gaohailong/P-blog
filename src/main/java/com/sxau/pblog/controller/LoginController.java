package com.sxau.pblog.controller;

import com.sxau.pblog.service.IService.LoginService;
import com.sxau.pblog.utils.ConstantUtil;
import com.sxau.pblog.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by gaohailong on 2016/10/8.
 */
@SessionAttributes(value = {ConstantUtil.LOGIN_SESSION, ConstantUtil.LOGIN_ERROR}, types = {String.class, String.class})
@Controller
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

    /**
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, Map<String, String> map) {
        session.invalidate();
        map.put(ConstantUtil.LOGIN_SESSION, SessionUtil.generateSessionId());
        return "/login";
    }

    @RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
    public String verifyUser(@RequestParam(value = "username", required = true) String username,
                             @RequestParam(value = "password", required = true) String password, Map<String, String> map,
                             HttpSession session) {
        boolean isOk = loginService.vertifyUser(username, password);
        if (isOk) {
            String sessionId = (String) session.getAttribute(ConstantUtil.LOGIN_SESSION);
            int result = loginService.updateSessionByAdmin(sessionId, username, password);
            if (result > 0) {
                return "/manager";
            }
            return "/login";
        } else {
            map.put(ConstantUtil.LOGIN_ERROR, "用户名或密码错误");
            return "/login";
        }
    }
}
