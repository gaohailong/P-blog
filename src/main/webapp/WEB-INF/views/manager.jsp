<%--
  Created by IntelliJ IDEA.
  User: gaohailong
  Date: 2016/9/29
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>

    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/pblog/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="<%=request.getContextPath()%>/pblog/web/js/jquery-1.11.3.js" language="javascript"></script>
    <script src="<%=request.getContextPath()%>/pblog/bootstrap/js/bootstrap.js" language="javascript"></script>
    <link href="<%=request.getContextPath()%>/pblog/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link href="<%=request.getContextPath()%>/pblog/web/css/index.css" rel="stylesheet">
    <script language="JavaScript" src="<%=request.getContextPath()%>/pblog/web/js/blog.js"></script>

    <!--网络请求-->
    <script src="<%=request.getContextPath()%>/pblog/web/js/title.js" language="javascript"></script>
    <script src="<%=request.getContextPath()%>/pblog/web/js/category.js" language="javascript"></script>

    <!--ueditor编辑器-->
    <!-- 配置文件 -->
    <script language="javascript" src="<%=request.getContextPath()%>/Ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script language="javascript" src="<%=request.getContextPath()%>/Ueditor/ueditor.all.js"></script>
    <!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->
    <script language="javascript" src="<%=request.getContextPath()%>/Ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12" style="height: 80px;background-color: #ffffff">
            <h1 style="margin-left: 20px; " class="col-lg-4">Welcome</h1>
            <div class="col-lg-4 col-lg-offset-3" style="margin-top: 22px;">
                <div class="input-group">
                    <input type="text" class="form-control">
                          <span class="input-group-btn">
                              <button class="btn btn-default" type="button">Go!</button>
                          </span>
                </div><!-- /input-group -->
            </div><!-- /.col-lg-6 -->
        </div>
    </div>
    <div class="row" style="background-color: #efefef">
        <div class="col-lg-3" style="color: #080808;">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true"
                 style="margin-top: 21px;">
                <div class="panel panel-default" style="margin-top: 0px;">
                    <div class="panel-heading" role="tab" id="headingOne"
                         style="color: #ffffff;background-image:linear-gradient(to bottom,#f5f5f5 0,#293543 0%)">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true"
                               aria-controls="collapseOne">
                                文章列表
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel"
                         aria-labelledby="headingOne">
                        <ul class="list-group">
                            <li class="list-group-item" style="padding-left: 30px;"><a href="javascript:void(0)"
                                                                                       onclick="allTitle()">所有文章</a>
                            </li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="javascript:void(0)"
                                                                                       onclick="addTitlePre()">添加文章</a>
                            </li>
                            <!--<li class="list-group-item" style="padding-left: 30px;"><a  href="javascript:void(0)" onclick="setIframeHtml(allTitle)">Bootply</a></li>-->
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default" style="margin-top: 0px;">
                    <div class="panel-heading" role="tab" id="headingTwo"
                         style="color: #ffffff;background-image:linear-gradient(to bottom,#f5f5f5 0,#293543 0%)">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"
                               aria-expanded="false" aria-controls="collapseTwo">
                                分类管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <ul class="list-group">
                            <li class="list-group-item" style="padding-left: 30px;"><a href="javascript:void (0)"
                                                                                       onclick="allCategory()">所有分类</a>
                            </li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="javascript:void (0)"
                                                                                       onclick="addCategory()">添加分类</a>
                            </li>
                            <!--<li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>-->
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default" style="margin-top: 0px;">
                    <div class="panel-heading" role="tab" id="headingThree"
                         style="color: #ffffff;background-image:linear-gradient(to bottom,#f5f5f5 0,#293543 0%)">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree"
                               aria-expanded="false" aria-controls="collapseThree">
                                个人管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingThree">
                        <ul class="list-group">
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default" style="margin-top: 0px;">
                    <div class="panel-heading" role="tab" id="headingFour"
                         style="color: #ffffff;background-image:linear-gradient(to bottom,#f5f5f5 0,#293543 0%)">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour"
                               aria-expanded="false" aria-controls="collapseThree">
                                微信发布
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingFour">
                        <ul class="list-group">
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                        </ul>
                    </div>
                </div>
                <div class="panel panel-default" style="margin-top: 0px;">
                    <div class="panel-heading" role="tab" id="headingFive"
                         style="color: #ffffff;background-image:linear-gradient(to bottom,#f5f5f5 0,#293543 0%)">
                        <h4 class="panel-title">
                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFive"
                               aria-expanded="false" aria-controls="collapseFive">
                                信息统计
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="headingFive">
                        <ul class="list-group">
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="#">Bootply</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-8 "
             style="background-color: #ffffff;border-radius: 10px; border: #d4d4d4 1px solid;margin: 20px;">
            <!--start 所有文章-->
            <div id="d_title" class="col-lg-12">
                <h3> 文章列表</h3>
                <div class="row" style="padding: 10px 15px 15px;">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>名称</th>
                            <th>阅读量</th>
                            <th>发表日期</th>
                            <th>状态</th>
                            <th>所属分类</th>
                            <%--<th>置顶</th>--%>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="d_body">
                        </tbody>
                    </table>
                </div>
                <nav class="text-center " id="all-title">
                    <ul class="pagination pagination-lg" id="t-page">
                    </ul>
                </nav>
            </div>
            <!--end 所有文章-->
            <!--start 填写文章-->
            <div id="i_title" class="col-lg-12">
                <h3> 填写文章</h3>
                <div class="row form-horizontal" style="padding: 10px 15px 15px;">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="标题">
                        </div>
                    </div>
                    <div class="col-sm-1"></div>
                    <div class="form-group col-sm-11">
                        <script id="container" name="content" type="text/plain"></script>
                        <script type="text/javascript">
                            var editor = UE.getEditor('container')
                            function getContentByUeditor() {
                                return editor.getContent();
                            }
                        </script>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-1 col-sm-offset-1"></div>
                        <label class="col-sm-1 control-label">分类</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="s_category">
                                <%-- <option>1</option>
                                 <option>2</option>--%>
                            </select>
                        </div>
                        <label class="col-sm-1 col-sm-offset-1 control-label">显示</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="d_YN">
                                <option>是</option>
                                <option>否</option>
                            </select>
                        </div>
                        <label class="col-sm-1 control-label">排序</label>
                        <div class="col-sm-2">
                            <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                            <button type="button" class="btn btn-primary btn-lg btn-block" onclick="addTitleAft()">
                                确认提交
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!--end 填写文章-->
            <!--start 修改文章-->
            <div id="u_title" class="col-lg-12">
                <h3> 修改文章</h3>
                <div class="row form-horizontal" style="padding: 10px 15px 15px;">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">标题</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" id="u_t_head" placeholder="标题">
                        </div>
                    </div>
                    <div class="col-sm-1"></div>
                    <div class="form-group col-sm-11">
                        <script id="container" name="content" type="text/plain"></script>
                        <script type="text/javascript">
                            var editor = UE.getEditor('container')
                            editor.ready(function () {
                                //这里写要编辑的文本
                                editor.setContent('<p>hello!</p>');
                            });
                            /* function getContentByUeditor() {
                             return editor.getContent();
                             }*/
                        </script>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-1 col-sm-offset-1"></div>
                        <label class="col-sm-1 control-label">分类</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="u_t_category">
                                <%-- <option>1</option>
                                 <option>2</option>--%>
                            </select>
                        </div>
                        <label class="col-sm-1 col-sm-offset-1 control-label">显示</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="u_YN">
                                <option>是</option>
                                <option>否</option>
                            </select>
                        </div>
                        <%-- <label class="col-sm-1 control-label">排序</label>
                         <div class="col-sm-2">
                             <select class="form-control">
                                 <option>1</option>
                                 <option>2</option>
                                 <option>3</option>
                                 <option>4</option>
                                 <option>5</option>
                             </select>
                         </div>--%>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                            <button type="button" class="btn btn-primary btn-lg btn-block" onclick="addTitleAft()">
                                确认提交
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!--end 修改文章-->
            <!--start 所有分类-->
            <div id="d_category" class="col-lg-12">
                <h3> 分类列表</h3>
                <div class="row" style="padding: 10px 15px 15px;">
                    <table class="table table-striped ">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>分类</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="c_body">
                        </tbody>
                    </table>
                    <nav class="text-center">
                        <ul class="pagination pagination-lg" id="c-page">
                        </ul>
                    </nav>
                </div>
            </div>
            <!--end 所有分类--->
            <!--start 填写分类-->
            <div id="i_category" class="col-lg-12">
                <h3> 填加分类</h3>
                <div class="row form-horizontal" style="padding: 10px 15px 15px;">
                    <div class="form-group">
                        <label class="col-sm-offset-2 col-sm-1 control-label">标题</label>
                        <div class="col-sm-7">
                            <input type="email" class="form-control" id="c_title" placeholder="标题">
                        </div>
                        <%-- <label class=" col-sm-1 control-label">名称</label>
                       <div class="col-sm-3">
                            <input type="email" class="form-control" id="c_title" placeholder="名称">
                        </div>--%>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                            <button type="button" class="btn btn-primary btn-lg btn-block"
                                    onclick="addCategoryForCate()">确认提交
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!--end 填写分类--->
            <!--start 修改分类-->
            <div id="u_c_category" class="col-lg-12">
                <h3> 修改分类</h3>
                <div class="row form-horizontal" style="padding: 10px 15px 15px;">
                    <div class="form-group">
                        <label class="col-sm-offset-2 col-sm-1 control-label">标题</label>
                        <div class="col-sm-7">
                            <input type="hidden" class="form-control" id="u_c_id">
                            <input type="text" class="form-control" id="u_c_head" placeholder="标题">
                        </div>
                        <%-- <label class=" col-sm-1 control-label">名称</label>
                       <div class="col-sm-3">
                            <input type="email" class="form-control" id="c_title" placeholder="名称">
                        </div>--%>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                            <button type="button" class="btn btn-primary btn-lg btn-block"
                                    onclick="updateCateById()">确认提交
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <!--end 修改分类--->
            <%--<iframe src="allTitle.html" class="col-lg-12" scrolling="no" id="right_iframe"></iframe>--%>
        </div>
    </div>
</div>
</body>
</html>
