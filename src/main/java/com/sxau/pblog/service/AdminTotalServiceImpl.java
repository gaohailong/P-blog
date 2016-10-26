package com.sxau.pblog.service;

import com.sxau.pblog.mapper.TitleMapper;
import com.sxau.pblog.pojo.AdminTotal;
import com.sxau.pblog.service.IService.AdminTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
@Service
public class AdminTotalServiceImpl implements AdminTotalService {
    @Autowired
    private TitleMapper titleMapper;

    @Override
    public List<AdminTotal> selectAdminTitleTotal() {
        List<AdminTotal> adminTotals = titleMapper.selectAdminTitleTotal();
        return adminTotals;
    }

    @Override
    public List<AdminTotal> selectTitleCountOfCate() {
        List<AdminTotal> adminTotals = titleMapper.selectTitleCountOfCate();
        return adminTotals;
    }
}
