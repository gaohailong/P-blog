package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
import com.sxau.pblog.utils.PagedResult;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.lang.model.type.ErrorType;
import java.util.List;

/**
 * Created by gaohailong on 2016/9/25.
 */
@Api(value = "product", description = "商品管理", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/title")
public class TitleController {
    //service类
    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/findTitle", method = RequestMethod.GET)
    @ResponseBody
    public PagedResult<Title> queryByPage(@ApiParam(required = true, name = "page", value = "页数") int page, @ApiParam(required = true, name = "pageNumber", value = "条数") int pageNumber) {
        PagedResult<Title> pagedResult = titleService.queryByPage(null, page, pageNumber);//null表示查全部
        return pagedResult;
    }

    @ApiOperation(value = "获得商品信息", notes = "获取商品信息(用于数据同步)", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
            @ApiResponse(code = 201, message = "(token验证失败)", response = String.class),
            @ApiResponse(code = 202, message = "(系统错误)", response = String.class)})
    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    @ResponseBody
    public List<Title> testJson() {
        List<Title> titles = titleService.findAllTitle();
        return titles;
    }
/*
    @ApiOperation(value = "获得文章信息", notes = "获取文章信息", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "文章信息"),
            @ApiResponse(code = 201, message = "(token验证失败)", response = String.class),
            @ApiResponse(code = 202, message = "(系统错误)", response = String.class)})
    @RequestMapping(value = "/findTitle/page={page}/pageNumber={pageNumber}", method = RequestMethod.GET)
    @ResponseBody
    public PagedResult<Title> queryByPage(@ApiParam(required = true, name = "page", value = "页数") @PathVariable int page,
                                          @ApiParam(required = true, name = "pageNumber", value = "条数") @PathVariable int pageNumber) {
        PagedResult<Title> pagedResult = titleService.queryByPage(null, page, pageNumber);//null表示查全部
        return pagedResult;
    }*/

    /*@RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public String testPage() {
        return "addTitle";
    }*/
       /*   @RequestMapping(value = "/findUser")
       @ResponseBody
       public List<Title> testJson() {
           List<Title> titles = userService.findAllTitle();
           return titles;
       }*/

  /*  @RequestMapping("/findUser")
    public ModelAndView findTitle() throws E
    xception {
        ModelAndView modelAndView = new ModelAndView();
        //调用service方法得到用户列表
        List<Title> titles = userService.findAllTitle();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("titles", titles);
        //设置响应的jsp视图
        modelAndView.setViewName("findTitle");
        return modelAndView;
    }*/
}
