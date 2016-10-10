package com.sxau.pblog.service.IService;

import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.utils.PagedResult;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/26.
 */
public interface CategoryService {
    List<Category> getAllCategory();
    PagedResult<Category> queryByPage(String categoryName, Integer pageNo, Integer pageSize);
}
