package com.sxau.pblog.mapper;

import com.sxau.pblog.pojo.AdminTotal;
import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.pojo.TitleExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TitleMapper {
    int countByExample(TitleExample example);

    int deleteByExample(TitleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Title record);

    int insertSelective(Title record);

    List<Title> selectByExampleWithBLOBs(TitleExample example);

    //分页
    List<Title> selectTitleByTitleName(@Param("titleName") String titleName);

    List<Title> selectByExample(TitleExample example);

    Title selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByExampleWithBLOBs(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByExample(@Param("record") Title record, @Param("example") TitleExample example);

    int updateByPrimaryKeySelective(Title record);

    int updateByPrimaryKeyWithBLOBs(Title record);

    int updateByPrimaryKey(Title record);

    /**
     * 查询每个月发表的文章总数
     *
     * @return
     */
    List<AdminTotal> selectAdminTitleTotal();

    /**
     * 查询每个分类下的文章总数
     */
    List<AdminTotal> selectTitleCountOfCate();
}