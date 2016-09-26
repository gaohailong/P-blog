package com.sxau.pblog.service;

import com.sxau.pblog.mapper.CategoryMapper;
import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.service.IService.CategoryService;
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

    public List<Category> getAllCategory() {
        return categoryMapper.selectByExample(null);
    }
}
