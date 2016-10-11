package com.sxau.pblog.service;

import com.github.pagehelper.PageHelper;
import com.sxau.pblog.mapper.CategoryMapper;
import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.service.IService.CategoryService;
import com.sxau.pblog.utils.BeanUtil;
import com.sxau.pblog.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/26.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        List<Category> category = categoryMapper.selectByExample(null);
        return category;
    }

    @Override
    public PagedResult<Category> queryByPage(String categoryName, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(categoryMapper.selectCategoryByCategory(categoryName));
    }

    @Override
    public void addCategory(String headName) {
        Category category = new Category();
        category.setCategory(headName);
        categoryMapper.insertSelective(category);
    }
}
