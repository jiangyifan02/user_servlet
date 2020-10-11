<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/11
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%String id = request.getParameter("id");%>
<form action="UserServlet"method="post">
    <table width="600"border="1">


        <tr>
            <td><input type="text"name="id"value="<%=id%>"></td>

            <td>
                <input type="text" name="username"value="${user1.username}">
            </td>
            <td>
                <input type="text" name="password"value="${user1.password}">
            </td>
            <td>
                <input type="submit"name="comm" value="update">
            </td>
        </tr>

    </table>

</form>

</body>
</html>
