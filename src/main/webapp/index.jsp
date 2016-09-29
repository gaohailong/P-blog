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
    <link href="pblog/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="pblog/web/js/jquery-1.11.3.js" language="javascript"></script>
    <script src="pblog/bootstrap/js/bootstrap.js" language="javascript"></script>
    <link href="pblog/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link href="pblog/web/css/index.css" rel="stylesheet">
    <script language="JavaScript" src="pblog/web/js/blog.js"></script>
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
                                                                                       onclick="setIframeHtml('allTitle')">所有文章</a>
                            </li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="javascript:void(0)"
                                                                                       onclick="setIframeHtml('addTitle')">添加文章</a>
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
                                                                                       onclick="setIframeHtml('allCategory')">所有分类</a>
                            </li>
                            <li class="list-group-item" style="padding-left: 30px;"><a href="javascript:void (0)"
                                                                                       onclick="setIframeHtml('addCategory')">添加分类</a>
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
            </div>
        </div>
        <div class="col-lg-8 "
             style="background-color: #ffffff;border-radius: 10px; border: #d4d4d4 1px solid;margin: 20px;">
            <iframe src="allTitle.html" class="col-lg-12" scrolling="no" id="right_iframe"></iframe>
        </div>
    </div>
</div>
</body>
</html>
