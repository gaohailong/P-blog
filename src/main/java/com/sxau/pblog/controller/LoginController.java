package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Admin;
import com.sxau.pblog.service.IService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by gaohailong on 2016/10/8.
 */
@SessionAttributes(value = {"sessionId"}, types = {String.class})
@Controller
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
    public String verifyUser(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password, Map<String, String> map) {
        //1、确认信息是否正确
        //2、正确返回：将sessionID存储
        //3、错误返回错误，提示或者页面
        System.out.print(username + password);
        //TODO 验证成功生成id
//        map.put("sessionId",);
        return "/manager";
    }
}
