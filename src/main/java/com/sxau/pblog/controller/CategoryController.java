package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.service.IService.CategoryService;
import com.sxau.pblog.utils.PagedResult;
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
public class CategoryController extends BaseController {
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

    @ResponseBody
    @RequestMapping(value = "/selectCategoryById", method = RequestMethod.GET)
    public Category getCategoryById(@RequestParam(value = "id", required = true) int id) {
        Category category = categoryService.getCateById(id);
        return category;
    }

    /**
     * 分页查询
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

    @ResponseBody
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@RequestParam(value = "headName") String headName) throws Exception {
        int num = categoryService.addCategory(headName);
        return responseStringToJsonForCUD(num, 0);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCate", method = RequestMethod.GET)
    public String deleteCateById(@RequestParam(value = "id", required = true) int id) throws Exception {
        int num = categoryService.deleteCate(id);
        return responseStringToJsonForCUD(num, 1);
    }

    @ResponseBody
    @RequestMapping(value = "/updateCateById", method = RequestMethod.POST)
    public String updateCateById(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "cate", required = true) String cate) throws Exception {
        Category category = new Category();
        category.setId(id);
        category.setCategory(cate);
        int num = categoryService.updateCategoryById(category);
        if (num > 0) {
            return responseStringToJson("修改成功！");
        } else {
            return responseStringToJson("修改失败！");
        }
    }
    /**
     * 前台部分
     */

    /**
     * app部分
     */
}
