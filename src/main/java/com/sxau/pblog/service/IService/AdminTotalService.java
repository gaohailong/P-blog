package com.sxau.pblog.service.IService;

import com.sxau.pblog.pojo.AdminTotal;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public interface AdminTotalService {
    /**
     * 查询每个月文章的总数
     *
     * @return
     */
    List<AdminTotal> selectAdminTitleTotal();

    /**
     * 查询没个分类下的文章总数
     */

    List<AdminTotal> selectTitleCountOfCate();
}
