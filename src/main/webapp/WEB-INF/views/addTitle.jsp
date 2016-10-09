<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- Bootstrap -->
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.11.3.js" language="javascript"></script>
    <script src="../bootstrap/js/bootstrap.js" language="javascript"></script>
    <link href="../bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }
    </style>
</head>
<body>
<div id="i_title">
    <h3> 填写文章</h3>
    <div class="row form-horizontal" style="padding: 10px 15px 15px;">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">标题</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" id="inputEmail3" placeholder="标题">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-1"></div>
            <label class="col-sm-1 control-label">分类</label>
            <div class="col-sm-2">
                <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
            <label class="col-sm-1 control-label">显示</label>
            <div class="col-sm-2">
                <select class="form-control">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
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
                <button type="button" class="btn btn-primary btn-lg btn-block">确认提交</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>