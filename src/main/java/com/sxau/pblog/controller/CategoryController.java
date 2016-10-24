package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.service.IService.CategoryService;
import com.sxau.pblog.utils.PagedResult;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/26.
 */
@Api(value = "category", description = "分类管理", produces = MediaType.APPLICATION_JSON_VALUE)
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
    @ApiOperation(value = "查询分类", httpMethod = "GET", response = Category.class, notes = "查询所有分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "查询成功！")})
    @ResponseBody
    @RequestMapping(value = "/findAllCategory", method = RequestMethod.GET)
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    /**
     * 通过id查询分类
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "查询分类", httpMethod = "GET", response = Category.class, notes = "通过id查询所有分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "查询成功！")})
    @ResponseBody
    @RequestMapping(value = "/selectCategoryById", method = RequestMethod.GET)
    public Category getCategoryById(@ApiParam(value = "id", name = "id", required = true)
                                    @RequestParam(value = "id", required = true) int id) {
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
    @ApiOperation(value = "分页查询", httpMethod = "GET", response = Category.class, notes = "分页查询分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "查询成功！")})
    @ResponseBody
    @RequestMapping(value = "/findForCategory", method = RequestMethod.GET)
    public PagedResult<Category> queryByPage(@ApiParam(value = "页号", name = "page", required = true)
                                             @RequestParam(value = "page") int page,
                                             @ApiParam(value = "条数", name = "pageNumber", required = true)
                                             @RequestParam(value = "pageNumber") int pageNumber) {
        PagedResult<Category> pagedResult = categoryService.queryByPage(null, page, pageNumber);
        return pagedResult;
    }

    /**
     * 添加分类
     *
     * @param headName 查询是否已有
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "添加分类", httpMethod = "POST", response = String.class, notes = "添加分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加成功")})
    @ResponseBody
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCategory(@ApiParam(value = "分类名称", name = "headName", required = true)
                              @RequestParam(value = "headName") String headName) throws Exception {
        int num = categoryService.addCategory(headName);
        return responseStringToJsonForCUD(num, 0);
    }

    /**
     * 通过id删除分类
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "删除分类", httpMethod = "GET", response = String.class, notes = "通过id删除分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加成功")})
    @ResponseBody
    @RequestMapping(value = "/deleteCate", method = RequestMethod.GET)
    public String deleteCateById(@ApiParam(value = "分类id", name = "id", required = true)
                                 @RequestParam(value = "id", required = true) int id) throws Exception {
        int num = categoryService.deleteCate(id);
        return responseStringToJsonForCUD(num, 1);
    }

    /**
     * 通过id更新分类
     *
     * @param id
     * @param cate
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "更新分类", httpMethod = "POST", response = String.class, notes = "通过id更新分类", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加成功！")})
    @ResponseBody
    @RequestMapping(value = "/updateCateById", method = RequestMethod.POST)
    public String updateCateById(@ApiParam(value = "分类id", name = "id", required = true)
                                 @RequestParam(value = "id", required = true) int id,
                                 @ApiParam(value = "分类名称", name = "cate", required = true)
                                 @RequestParam(value = "cate", required = true) String cate) throws Exception {
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
