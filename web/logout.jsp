<%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/17/18
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = (String) session.getAttribute("login");
    session.invalidate();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="top.jsp"%>
<%
    if(user!=null){
        out.print("<h1>"+user+"已注销</h1>");
    }
%>

</body>
</html>
