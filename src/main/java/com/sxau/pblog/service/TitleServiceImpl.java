package com.sxau.pblog.service;

import com.sxau.pblog.mapper.TitleMapper;
import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
