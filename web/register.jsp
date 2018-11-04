<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.24
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/InsertServlet">
    用户名：<input type="text" name="username"/> <br>
    密码：<input type="text" name="password"/><br>
    邮箱：<input type="email" name="email"/><br>
    <input type="submit" value="提交"/>
</form>

</body>
</html>
