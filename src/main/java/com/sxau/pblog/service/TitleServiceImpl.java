package com.sxau.pblog.service;

import com.github.pagehelper.PageHelper;
import com.sxau.pblog.mapper.TitleMapper;
import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
import com.sxau.pblog.utils.BeanUtil;
import com.sxau.pblog.utils.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by gaohailong on 2016/9/25.
 */
@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    private TitleMapper titleMapper;

    @Override
    public List<Title> findAllTitle() {
        List<Title> titles = titleMapper.selectByExample(null);
        return titles;
    }

    @Override
    public PagedResult<Title> queryByPage(String titleName, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(titleMapper.selectTitleByTitleName(titleName));
    }

    @Override
    public int addTitle(String titleName, String titleContent, String titleCate, String titleDisplay) {
        List<Title> titles = titleMapper.selectTitleByTitleName(titleName);
        if (titles.size() == 0) {
            Title title = new Title();
            title.setArticlename(titleName);
            title.setArticlecontent(titleContent);
            title.setCategory(titleCate);
            title.setIsshow(false);
            title.setDate(new Date());
            return titleMapper.insertSelective(title);
        }
        return 0;
    }

    @Override
    public int deleteTitle(int id) {
        System.out.print("getId()"+id);
        Title title = titleMapper.selectByPrimaryKey(id);
        if (title.getId() != null) {
            int num = titleMapper.deleteByPrimaryKey(id);
            return num;
        }
        return 0;
    }
}
