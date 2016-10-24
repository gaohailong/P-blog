package com.sxau.pblog.service.IService;

import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.utils.PagedResult;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/26.
 */
public interface CategoryService {
    /**
     * 获得所有分类
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 分页
     * @param categoryName
     * @param pageNo
     * @param pageSize
     * @return
     */
    PagedResult<Category> queryByPage(String categoryName, Integer pageNo, Integer pageSize);

    /**
     * 添加分类
     * @param headName
     * @return
     */
    int addCategory(String headName);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int deleteCate(int id);

    /**
     * 通过id获取分类
     * @param id
     * @return
     */
    Category getCateById(int id);

    /**
     * 通过id更新分类
     * @param category
     * @return
     */
    int updateCategoryById(Category category);
}
