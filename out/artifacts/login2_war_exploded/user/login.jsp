<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/11
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
<form action = "${pageContext.request.contextPath}/LoginServlet" method = "post">
    <table>
        <tr>
            <td align="right">用户名：</td>
            <td><input type="text" name = "username"/></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="password" name = "password"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
