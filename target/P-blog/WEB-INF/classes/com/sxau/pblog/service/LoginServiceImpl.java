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
    public boolean vertifyUser(Admin admin) {
        List<Admin> admins = adminMapper.selectByExample(admin);
        if (admins.size() == 1) {
            return true;
        }
        /*for (Admin admin1 : admins) {
            if (admin1.getAdminname().equals(admin.getAdminname())) {
                if (admin1.getAdminpass().equals(admin.getAdminpass())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }*/
        return false;
    }
}
