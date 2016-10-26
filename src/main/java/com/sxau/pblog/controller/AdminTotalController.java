package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.AdminTotal;
import com.sxau.pblog.service.IService.AdminTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
@RequestMapping("/admin")
@Controller
public class AdminTotalController extends BaseController {
    @Autowired
    private AdminTotalService adminTotalService;

    /**
     * 查询每个月的文章总数
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAllTitleForChart", method = RequestMethod.GET)
    public List<AdminTotal> selectAllTitleForChart() {
        return adminTotalService.selectAdminTitleTotal();
    }

    /**
     * 查询没个分类下的文章总数
     */
    @ResponseBody
    @RequestMapping("/selectTitleCountOfCate")
    public List<AdminTotal> selectTitleCountForCate() {
        return adminTotalService.selectTitleCountOfCate();
    }
}
