package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
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
 * Created by gaohailong on 2016/9/25.
 */
@Api(value = "title", description = "文章", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/title")
public class TitleController {
    //service类
    @Autowired
    private TitleService userService;

    /*   @RequestMapping(value = "/findUser")
       @ResponseBody
       public List<Title> testJson() {
           List<Title> titles = userService.findAllTitle();
           return titles;
       }*/
    @ApiOperation(value = "获取文章信息", notes = "获取全部文章", httpMethod = "GET")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
            @ApiResponse(code = 201, message = "(token验证失败)", response = String.class),
            @ApiResponse(code = 202, message = "(系统错误)", response = String.class)})
    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    @ResponseBody
    public List<Title> testJson() {
        List<Title> titles = userService.findAllTitle();
        return titles;
    }

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
