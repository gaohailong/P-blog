package com.sxau.pblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gaohailong on 2016/10/8.
 */
@Controller
public class MainController {
    @RequestMapping("/queryToken")
    public String redirectPage(){
        return "manager";
    }
}
