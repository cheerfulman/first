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
<h1>好羞啊</h1><hr/>
<h2>过目不忘记账本</h2>
<form action="${pageContext.request.contextPath}/MarkServlet" method="post">
    小东西，今天又花了多少钱？:<input type="text" name="price">
</form>

</body>
</html>
