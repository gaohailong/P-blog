<%--
  Created by IntelliJ IDEA.
  User: gaohailong
  Date: 2016/10/8
  Time: 15:56
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
</head>
<body>
<div class="container">
    <div class="row col-md-6 col-md-offset-3" style="margin-top: 10%">
        <div class="panel panel-primary ">
            <div class="panel-heading col-md-12">登录</div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <label>User name</label>
                        <input type="text" class="form-control" placeholder="Enter text">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-primary" onclick="javascript:login()">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<a href="/queryToken">test</a>
</body>
</html>
