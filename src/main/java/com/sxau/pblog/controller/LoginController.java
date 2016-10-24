package com.sxau.pblog.controller;

import com.sxau.pblog.service.IService.LoginService;
import com.sxau.pblog.utils.ConstantUtil;
import com.sxau.pblog.utils.SessionUtil;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by gaohailong on 2016/10/8.
 */
@Api(value = "login", description = "登陆", produces = MediaType.APPLICATION_JSON_VALUE)
@SessionAttributes(value = {ConstantUtil.LOGIN_SESSION, ConstantUtil.LOGIN_ERROR}, types = {String.class, String.class})
@Controller
public class LoginController extends BaseController {
    @Autowired
    private LoginService loginService;

    /**
     * 登陆
     *
     * @param session
     * @return
     */
    @ApiOperation(value = "获取token", httpMethod = "GET", response = String.class, notes = "获取token", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回token成功")})
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, Map<String, String> map) {
        session.invalidate();
        map.put(ConstantUtil.LOGIN_SESSION, SessionUtil.generateSessionId());
        return "/login";
    }

    /**
     * 验证用户
     *
     * @param username
     * @param password
     * @param map
     * @param session
     * @return
     */
    @ApiOperation(value = "验证用户", httpMethod = "POST", response = String.class, notes = "登陆验证", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "验证成功")})
    @RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
    public String verifyUser(@ApiParam(required = true, value = "用户名", name = "username")
                             @RequestParam(value = "username", required = true) String username,
                             @ApiParam(required = true, value = "密码", name = "password")
                             @RequestParam(value = "password", required = true) String password,
                             Map<String, String> map, HttpSession session) {
        session.removeAttribute(ConstantUtil.LOGIN_ERROR);
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

    /*//TODO 退出登陆
    @RequestMapping("/logout")
    public String logout(@RequestParam(value = "sessionid", required = true) String sessionid) {

        return "d";
    }*/
}
