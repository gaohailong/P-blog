package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by gaohailong on 2016/9/25.
 */
@Controller
@RequestMapping("/title")
public class TitleController {
    //service类
    @Autowired
    private TitleService userService;

    @RequestMapping("/findUser")
    public ModelAndView findTitle() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //调用service方法得到用户列表
        List<Title> titles = userService.findAllTitle();
        //将得到的用户列表内容添加到ModelAndView中
        modelAndView.addObject("titles", titles);
        //设置响应的jsp视图
        modelAndView.setViewName("findTitle");
        System.out.print("fasfds"+titles.get(0).getId());
        return modelAndView;
    }
}
