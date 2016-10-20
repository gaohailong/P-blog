<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/10/20
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

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
<div id="i_s_title">
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
</body>
</html>
