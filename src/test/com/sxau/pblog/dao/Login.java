package com.sxau.pblog.dao;

import com.sxau.pblog.base.SpringTestCase;
import com.sxau.pblog.mapper.AdminMapper;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/24.
 */
public class Login extends SpringTestCase {
    @Resource
    private AdminMapper adminMapper;

    @Test
    public void selectSessionIdBySessionId() {
        System.out.print(adminMapper.selectSessionIdBySessionId("9DB69520F0491162E67B79AB67E24197"));
    }
}
