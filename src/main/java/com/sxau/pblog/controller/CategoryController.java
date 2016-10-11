package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.CategoryService;
import com.sxau.pblog.utils.PagedResult;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/26.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    //分类的service
    @Autowired
    private CategoryService categoryService;

    /**
     * 后端管理部分
     */

    /**
     * 查询所有分类（添加文章用）
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findAllCategory", method = RequestMethod.GET)
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    /**
     * 查询所有分类
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findForCategory", method = RequestMethod.GET)
    public PagedResult<Category> queryByPage(@RequestParam(value = "page") int page, @RequestParam(value = "pageNumber") int pageNumber) {
        PagedResult<Category> pagedResult = categoryService.queryByPage(null, page, pageNumber);
        return pagedResult;
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public void addCategory(@RequestParam(value = "headName") String headName) {
        categoryService.addCategory(headName);
    }

    /**
     * 前台部分
     */

    /**
     * app部分
     */


}
