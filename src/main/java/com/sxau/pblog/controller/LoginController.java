package com.sxau.pblog.controller;

import com.sxau.pblog.service.IService.LoginService;
import com.sxau.pblog.utils.ConstantUtil;
import com.sxau.pblog.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by gaohailong on 2016/10/8.
 */
@SessionAttributes(value = {ConstantUtil.LOGIN_SESSION, ConstantUtil.LOGIN_ERROR}, types = {String.class, String.class})
@Controller
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
    public String verifyUser(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password, Map<String, String> map) {
        System.out.print(username + password);
        boolean isOk = loginService.vertifyUser(username, password);
        if (isOk) {
            map.put(ConstantUtil.LOGIN_SESSION, SessionUtil.generateSessionId());
            return "/manager";
        } else {
            map.put(ConstantUtil.LOGIN_ERROR, "用户名或密码错误");
            return "redirect:/index.jsp";
        }
    }
}
