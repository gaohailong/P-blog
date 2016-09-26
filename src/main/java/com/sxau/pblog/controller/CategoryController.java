package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.service.IService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/26.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/findAllCategory")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }
}
