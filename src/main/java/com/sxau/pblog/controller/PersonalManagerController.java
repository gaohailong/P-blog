package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.AdminTotal;
import com.sxau.pblog.service.IService.AdminTotalService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by gaohailong on 2016/10/11.
 */
@Api(value = "personalManager", description = "个人信息管理", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/admin")
@Controller
public class PersonalManagerController {
    @Autowired
    private AdminTotalService adminTotalService;

    /**
     * 查询每个月的文章总数
     *
     * @return
     */
    @ApiOperation(value = "获取每月文章总数", notes = "获取每月文章总数", response = AdminTotal.class, httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200,message = "获取成功")})
    @ResponseBody
    @RequestMapping(value = "/selectAllTitleForChart", method = RequestMethod.GET)
    public List<AdminTotal> selectAllTitleForChart() {
        return adminTotalService.selectAdminTitleTotal();
    }

    /**
     * 查询没个分类下的文章总数
     */
    @ApiOperation(value = "获取每个分类下的文章", notes = "获取每个分类下的文章", response = AdminTotal.class, httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200,message = "获取成功")})
    @ResponseBody
    @RequestMapping("/selectTitleCountOfCate")
    public List<AdminTotal> selectTitleCountForCate() {
        return adminTotalService.selectTitleCountOfCate();
    }
}
