package com.sxau.pblog.service;

import com.sxau.pblog.base.SpringTestCase;
import com.sxau.pblog.service.IService.LoginService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by gaohailong on 2016/10/22.
 */
public class TestLogin extends SpringTestCase{
    @Resource
    private LoginService loginService;

    @Test
    public void getAdminNum(){
        System.out.print(loginService.vertifyUser("gao","ao"));
    }
    @Test
    public void addSessionByAdmin(){
        System.out.print(loginService.updateSessionByAdmin("qwertqqyqq","gao","gao"));
    }
}
