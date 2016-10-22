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
    <script src="<%=request.getContextPath()%>/pblog/web/js/jquery-1.11.3.js" language="javascript"></script>
    <script src="<%=request.getContextPath()%>/pblog/web/js/jQuery.md5.js" language="javascript"></script>

    <script language="JavaScript" src="<%=request.getContextPath()%>/pblog/web/js/blog.js"></script>
    <link href="<%=request.getContextPath()%>/pblog/web/css/style.css" rel="stylesheet">
    <script language="JavaScript" src="<%=request.getContextPath()%>/pblog/web/js/Particleground.js"></script>
    <script language="JavaScript" src="<%=request.getContextPath()%>/pblog/web/js/verificationNumbers.js"></script>
    <style>
        body {
            height: 100%;
            background: #16a085;
            overflow: hidden;
        }

        canvas {
            z-index: -1;
            position: absolute;
        }
    </style>
    <script>
        $(document).ready(function () {
            //粒子背景特效
            $('body').particleground({
                dotColor: '#5cbdaa',
                lineColor: '#5cbdaa'
            });
            //验证码
//            createCode();
            //测试提交，对接程序删除即可
            /* $(".submit_btn").click(function () {
             location.href = "javascrpt:;"/!*tpa=http://!***index.html*!/;
             });*/
        });
    </script>
</head>
<body>
<canvas class="pg-canvas" width="1600" height="745"></canvas>
<form class="admin_login" action="/verifyUser" method="post">
    <dt>
        <strong>博客后台管理系统</strong>
        <em>Management System</em>
    </dt>
    <dd class="user_icon">
        <input type="text" placeholder="用户名" name="username"  class="login_txtbx">
    </dd>
    <dd class="pwd_icon">
        <input type="password" placeholder="密码" name="password" class="login_txtbx">
    </dd>
    <!-- <dd class="val_icon">
     <div class="checkcode">
       <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
       <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
     </div>
     <input type="button" value="验证码核验" class="ver_btn" onclick="validate();">
      </dd> -->
    <dd>
        <input type="submit" value="立即登陆" class="submit_btn" >
    </dd>
    <dd>
        <p>© 2015-2016 jq22 版权所有</p>
        <%--<p>陕B2-8998988-1</p>--%>
    </dd>
</form>
<%--<div class="container">
    <div class="row col-md-6 col-md-offset-3" style="margin-top: 15%">
        <div class="panel panel-primary ">
            <div class="panel-heading col-md-12">登录</div>
            <div class="panel-body">--%>
<%-- <form method="post" action="/queryToken">
     <div class="form-group">
         <label>User name</label>
         <input type="text" class="form-control" id="username" placeholder="User name">
     </div>
     <div class="form-group">
         <label>Password</label>
         <input type="password" class="form-control" id="password" placeholder="Password">
     </div>
     <button type="submit" class="btn btn-primary">Submit</button>
 </form>--%>
<%-- </div>
</div>
</div>
</div>--%>
</body>
</html>
