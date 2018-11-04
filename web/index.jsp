<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.23
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="${pageContext.request.contextPath}/PayServlet"><br>
      订单号：<input type="text" name="orderNum" value="<%=new Random().nextInt(100000) %> "/>
      支付金额:<input type="text" name="amt" value=""/><br>
      选择支付的银行：建设银行<input type="radio" name="bank" value="CCB-NET" /><br>
      <input type="submit" value="支付"/>
  </form>
  </body>
</html>
