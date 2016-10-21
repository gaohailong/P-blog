package com.sxau.pblog.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sxau.pblog.pojo.Admin;
import com.sxau.pblog.service.IService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gaohailong on 2016/10/8.
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

 /*   @RequestMapping(value = "/queryToken", method = RequestMethod.POST)
    public String loginPage(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) throws JsonProcessingException {
        System.out.print(username);
        System.out.print(password);
//        Admin admin = new Admin();
//        admin.setAdminname(username);
//        admin.setAdminpass(password);
//        System.out.print(admin.getAdminname()+"+ff+"+admin.getAdminpass());
//        if (loginService.vertifyUser(admin)) {
//            return "manager";
//        }
//        return responseStringToJson("登录失败");
        return "/manager";
    }
*/
    @RequestMapping(value = "/queryToken", method = RequestMethod.POST)
    public String vertifyUser(HttpServletRequest request,HttpServletResponse response) {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        System.out.print(username+password);
        return "redirect:/manager";
    }
}
