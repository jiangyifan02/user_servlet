<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/10
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center"width="500px" border="1">
    <tr>
        <td>编号</td>
        <td> 姓名</td>
        <td> 密码</td>
    </tr>
    <tr>
        <td>${user.id}
        </td>

        <td>${user.username}</td>
        <td>${user.password}
        </td>

    </tr>

</table>
<a href="list.jsp">返回</a>


</body>
</html>
