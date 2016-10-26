package com.sxau.pblog.service;

import com.sxau.pblog.base.SpringTestCase;
import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.utils.PagedResult;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by gaohailong on 2016/9/30.
 */
public class TestTitle extends SpringTestCase {
    @Resource
    private TitleServiceImpl tittleService;

    @Test
    public void queryPage() {
        PagedResult<Title> pagedResult = tittleService.queryByPage(null, 1, 2);//null表示查全部
        System.out.print(pagedResult);
    }

}
