package com.sxau.pblog.service;

import com.sxau.pblog.mapper.AdminMapper;
import com.sxau.pblog.pojo.Admin;
import com.sxau.pblog.pojo.AdminExample;
import com.sxau.pblog.service.IService.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaohailong on 2016/10/17.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean vertifyUser(String username, String password) {
        Admin admin = new Admin();
        admin.setAdminname(username);
        admin.setAdminpass(password);

        int admins = adminMapper.countByExample(admin);
        if (admins == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int updateSessionByAdmin(String sessionid, String username, String password) {
        Admin admin = new Admin();
        admin.setAdminname(username);
        admin.setAdminpass(password);
        admin.setSessionid(sessionid);
        int result = adminMapper.updateSessionByAdmin(admin);
        return result;
    }
}
