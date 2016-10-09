<%--
  Created by IntelliJ IDEA.
  User: gaohailong
  Date: 2016/9/25
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <c:forEach items="${titles}" var="t">
        <tr>
            <td>${t.id}</td>
            <td>${t.articlename}</td>
            <td>${t.articleimg}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
