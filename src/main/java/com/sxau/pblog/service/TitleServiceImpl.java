package com.sxau.pblog.service;

import com.github.pagehelper.PageHelper;
import com.sxau.pblog.mapper.TitleMapper;
import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
import com.sxau.pblog.utils.BeanUtil;
import com.sxau.pblog.utils.DateUtil;
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

    public List<Title> findAllTitle() {
        List<Title> titles = titleMapper.selectByExample(null);
        return titles;
    }

    public PagedResult<Title> queryByPage(String titleName, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(titleMapper.selectTitleByTitleName(titleName));
    }

    public void addTitle(String titleName, String titleContent, String titleCate, String titleDisplay) {
        Title title = new Title();
        title.setArticlename(titleName);
        title.setArticlecontent(titleContent);
        title.setCategory(titleCate);
        title.setIsshow(false);
        title.setDate(new Date());
        titleMapper.insertSelective(title);
    }
}
