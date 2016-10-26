package com.sxau.pblog.dao;

import com.sxau.pblog.base.SpringTestCase;
import com.sxau.pblog.mapper.TitleMapper;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/25.
 */
public class TestTitle extends SpringTestCase {
    @Resource
    private TitleMapper titleMapper;

    @Test
    public void selectAdminTitleTotal() {
       System.out.print( titleMapper.selectAdminTitleTotal().get(0).getAdminTitleDate());
    }

    @Test
    public void testSelectTitleCountOfCate() {
        System.out.print(titleMapper.selectTitleCountOfCate().get(0).getCateTitleCount());
    }
}
