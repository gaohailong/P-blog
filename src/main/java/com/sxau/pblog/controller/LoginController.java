package com.sxau.pblog.controller;

import com.sxau.pblog.service.IService.LoginService;
import com.sxau.pblog.utils.ConstantUtil;
import com.sxau.pblog.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
     * TODO 思路
     * 1、点击登录后与数据库比较sessionid是否相同
     * 2、相同的话，转向正常页面
     * 3、不相同的话，转向登录页面
     * 4、登录成功后要将sessionid存储到数据库
     * 存储到数据库如何删除（时间到了以后）
     *5、登录session变化思路，
     * （1）禁止刷新
     * （2）将返回页面和控制器分开，让转到一个页面，再去返回页面
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session) {
        System.out.print("sds");
        String sessinId = (String) session.getAttribute(ConstantUtil.LOGIN_SESSION);
        //查询session返回的对象，对象为空的操作
        if (sessinId == null) {
            session.invalidate();
            return "/login";
        } else {
            //对象不为空的操作，并且正确
            return "/login";
        }
    }

    @RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
    public String verifyUser(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password, Map<String, String> map) {
        System.out.print(username + password);
        boolean isOk = loginService.vertifyUser(username, password);
        if (isOk) {
            map.put(ConstantUtil.LOGIN_SESSION, SessionUtil.generateSessionId());
            return "/manager";
        } else {
            map.put(ConstantUtil.LOGIN_ERROR, "用户名或密码错误");
            return "redirect:/login.jsp";
        }
    }
}
