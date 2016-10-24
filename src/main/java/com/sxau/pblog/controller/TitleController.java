package com.sxau.pblog.controller;

import com.sxau.pblog.pojo.Title;
import com.sxau.pblog.service.IService.TitleService;
import com.sxau.pblog.utils.PagedResult;
import com.wordnik.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    @ApiOperation(value = "分页查询", httpMethod = "GET", response = Title.class, notes = "分页获取对象", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "文章")})
    @RequestMapping(value = "/findTitle", method = RequestMethod.GET)
    public PagedResult<Title> queryByPage(@ApiParam(required = true, name = "page", value = "页数")
                                          @RequestParam(value = "page") int page,
                                          @ApiParam(required = true, name = "pageNumber", value = "条数")
                                          @RequestParam(value = "pageNumber") int pageNumber) {
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
    @ApiOperation(value = "添加文章", httpMethod = "POST", response = String.class, notes = "添加文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加成功！")})
    @RequestMapping(value = "/addTitle", method = RequestMethod.POST)
    public String addTitle(@ApiParam(required = true, name = "titleName", value = "文章名称")
                           @RequestParam(value = "titleName", required = true) String titleName,
                           @ApiParam(required = true, value = "文章内容", name = "titleContent")
                           @RequestParam(value = "titleContent", required = true) String titleContent,
                           @ApiParam(required = true, name = "titleCate", value = "文章分类")
                           @RequestParam(value = "titleCate") String titleCate,
                           @ApiParam(value = "是否展示", required = true, name = "titleDisplay")
                           @RequestParam(value = "titleDisplay") String titleDisplay) throws Exception {
        int num = titleService.addTitle(titleName, titleContent, titleCate, titleDisplay);
        if (num != 0) {
            return responseStringToJson("添加成功！");
        }
        return responseStringToJson("添加失败！");
    }

    /**
     * 通过id删除文章
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ApiOperation(value = "删除文章", httpMethod = "GET", response = String.class, notes = "通过id删除文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "删除成功！")})
    @RequestMapping(value = "/deleteTitle", method = RequestMethod.GET)
    public String deleteTitleById(@ApiParam(required = true, value = "文章id", name = "id")
                                  @RequestParam(value = "id", required = true) int id) throws Exception {
        int num = titleService.deleteTitle(id);
        if (num != 0) {
            return responseStringToJson("删除成功！");
        }
        return responseStringToJson("删除失败！");
    }

    @ResponseBody
    @ApiOperation(value = "查询文章", httpMethod = "GET", response = Title.class, notes = "通过id查询文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "查询成功")})
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public Title selectTitleById(@ApiParam(required = true, name = "id", value = "文章id")
                                 @RequestParam(value = "id", required = true) int id) throws Exception {
        return titleService.selectById(id);
    }

    @ResponseBody
    @ApiOperation(value = "修改文章", httpMethod = "POST", response = String.class, notes = "通过id修改文章", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "修改成功")})
    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    public String updateTitleById(@ApiParam(required = true, value = "文章id", name = "id")
                                  @RequestParam(value = "id", required = true) int id,
                                  @ApiParam(required = true, value = "文章的标题", name = "head")
                                  @RequestParam(value = "head", required = true) String head,
                                  @ApiParam(required = true, value = "文章内容", name = "content")
                                  @RequestParam(value = "content", required = true) String content,
                                  @ApiParam(required = true, value = "文章分类", name = "titleCate")
                                  @RequestParam(value = "titleCate", required = true) String titleCate,
                                  @ApiParam(required = true, value = "是否展示", name = "titleDisplay")
                                  @RequestParam(value = "titleDisplay", required = true) String titleDisplay) throws Exception {
        int num = titleService.updateTitleById(id, head, content, titleCate, titleDisplay);
        if (num != 0) {
            return responseStringToJson("修改成功！");
        } else {
            return responseStringToJson("修改失败！");
        }
    }
    /**
     *前台展示部分
     */

    /**
     * 微信部分
     */

    /**
     *app部分
     */
}
