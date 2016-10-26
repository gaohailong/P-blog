package com.sxau.pblog.mapper;

import com.sxau.pblog.pojo.AdminTotal;
import com.sxau.pblog.pojo.Category;
import com.sxau.pblog.pojo.CategoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * category接口
 */
public interface CategoryMapper {
    int countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    /**
     * 通过id删除分类
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入分类
     *
     * @param record 分类实体类
     * @return
     */
    int insert(Category record);

    /**
     * 选择插入实体类
     *
     * @param record
     * @return
     */
    int insertSelective(Category record);

    /**
     * 查询实体类
     *
     * @param example
     * @return
     */
    List<Category> selectByExample(CategoryExample example);

    /**
     * 查询分类通过分类
     *
     * @param category
     * @return
     */
    List<Category> selectCategoryByCategory(@Param("category") String category);

    /**
     * 通过主键查询分类
     *
     * @param id
     * @return
     */
    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    /**
     * 通过主键更新数据
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Category record);

}