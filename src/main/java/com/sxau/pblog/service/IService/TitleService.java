package com.sxau.pblog.service.IService;

import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.utils.PagedResult;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/25.
 */
public interface TitleService {
    List<Title> findAllTitle();

    PagedResult<Title> queryByPage(String titleName, Integer pageNo, Integer pageSize);
}
