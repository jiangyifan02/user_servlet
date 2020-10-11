<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/11
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UserServlet?&comm=add" method="post">
    <table width="600"border="1">


        <tr>

            <td>
                用户名<input type="text" name="username"value="">
            </td>
            <td>
                密码<input type="text" name="password"value="">
            </td>
            <td>
                <input type="submit" value="add">
            </td>
        </tr>

    </table>

</form>
</body>
</html>
