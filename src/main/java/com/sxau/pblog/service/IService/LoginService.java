package com.sxau.pblog.service.IService;

import com.sxau.pblog.pojo.Admin;
import com.sxau.pblog.pojo.AdminExample;

/**
 * Created by gaohailong on 2016/10/17.
 */
public interface LoginService {
    boolean vertifyUser(String username, String password);

    int updateSessionByAdmin(String sessionid, String username, String password);
}
