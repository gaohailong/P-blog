package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
import com.sxau.pblog.utils.PagedResult;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by gaohailong on 2016/9/25.
 */
@Api(value = "product", description = "商品管理", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("/title")
public class TitleController extends BaseController {
    //service类
    @Autowired
    private TitleService titleService;

    /**
     * 后台管理部分
     */

    /**
     * 查询文章
     *
     * @param page
     * @param pageNumber
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findTitle", method = RequestMethod.GET)
    @ApiOperation(value = "分页查询", httpMethod = "GET", response = ApiResponse.class, notes = "分页获取对象")
    public PagedResult<Title> queryByPage(@ApiParam(required = true, name = "page", value = "页数") @RequestParam(value = "page") int page, @ApiParam(required = true, name = "pageNumber", value = "条数") @RequestParam(value = "pageNumber") int pageNumber) {
        PagedResult<Title> pagedResult = titleService.queryByPage(null, page, pageNumber);//null表示查全部
        return pagedResult;
    }

    /**
     * 添加文章
     *
     * @param titleName
     * @param titleContent
     * @param titleCate
     * @param titleDisplay
     */
    @ResponseBody
    @RequestMapping(value = "/addTitle", method = RequestMethod.POST)
    public String addTitle(@RequestParam(value = "titleName", required = true) String titleName, @RequestParam(value = "titleContent", required = true) String titleContent, @RequestParam(value = "titleCate") String titleCate, @RequestParam(value = "titleDisplay") String titleDisplay) throws Exception {
        int num = titleService.addTitle(titleName, titleContent, titleCate, titleDisplay);
        if (num != 0) {
            return responseStringToJson("添加成功！");
        }
        return responseStringToJson("添加失败！");
    }

    @ResponseBody
    @RequestMapping(value = "/deleteTitle", method = RequestMethod.GET)
    public String deleteTitleById(@RequestParam(value = "id", required = true) int id) throws Exception {
        int num = titleService.deleteTitle(id);
        if (num != 0) {
            return responseStringToJson("删除成功！");
        }
        return responseStringToJson("删除失败！");
    }
    /**
     *前台展示部分
     */

    /**
     *app部分
     */

    /*@ApiOperation(value = "获得商品信息", notes = "获取商品信息(用于数据同步)", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "商品信息"),
            @ApiResponse(code = 201, message = "(token验证失败)", response = String.class),
            @ApiResponse(code = 202, message = "(系统错误)", response = String.class)})
    @RequestMapping(value = "/findUser", method = RequestMethod.GET)
    @ResponseBody
    public List<Title> testJson() {
        List<Title> titles = titleService.findAllTitle();
        return titles;
    }*/
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
