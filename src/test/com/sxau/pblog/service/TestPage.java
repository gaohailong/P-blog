package com.sxau.pblog.service;

import com.sxau.pblog.base.SpringTestCase;
import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.utils.PagedResult;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by gaohailong on 2016/9/30.
 */
public class TestPage extends SpringTestCase {
    @Resource
    private TitleServiceImpl userService;

    @Test
    public void queryPage() {
        PagedResult<Title> pagedResult = userService.queryByPage(null, 1, 2);//null表示查全部

    }
}
