<%@ page import="java.util.List" %>
<%@ page import="User.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/1/11
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<font color="black" size="90px">你的历史消费</font>

<%
    User u = (User)session.getAttribute("sessionUser");
    List<Integer> list = u.getHistory();
    for(Integer n : list){
        response.getWriter().println(n);
    }
%>
<form action="${pageContext.request.contextPath}/MarkServlet" method="post">
    <input type="text" name="price">
    <input type="submit" value="记账">
</form>
</body>
</html>
