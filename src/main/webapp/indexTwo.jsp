<%--
  Created by IntelliJ IDEA.
  User: gaohailong
  Date: 2016/9/25
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>first</title>
    <!-- 配置文件 -->
    <script language="javascript" src="ueditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script language="javascript" src="ueditor/ueditor.all.js"></script>
    <!-- 语言包文件(建议手动加载语言包，避免在ie下，因为加载语言失败导致编辑器加载失败) -->
    <script language="javascript" src="ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>

<script id="container" name="content" type="text/plain">这里写你的初始化内容</script>
<script type="text/javascript">
    var editor = UE.getEditor('container')

    //测试文件成功
    function test() {
        alert(editor.getContent());
    }
</script>
<button type="button" onclick="test()">test</button>
</body>
</html>