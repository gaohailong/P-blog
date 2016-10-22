package com.sxau.pblog.service;

import com.sxau.pblog.base.SpringTestCase;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by gaohailong on 2016/10/9.
 */
public class TestCategory extends SpringTestCase {
    @Resource
    public CategoryServiceImpl categoryService;

    @Test
    public void getAllCategory() {
        System.out.print(categoryService.getAllCategory().get(0).getCategory());
    }

    @Test
    public void getAllCategoryFoeCategory() {
        System.out.print(categoryService.queryByPage(null, 1, 2));
    }

    @Test
    public void getCategoryById(){
        System.out.print(categoryService.getCateById(1).getId());
    }
}
