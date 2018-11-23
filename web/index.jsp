<%@ page import="Listener.OnlineUserCounter" %>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: onlyless--%>
  <%--Date: 11/17/18--%>
  <%--Time: 11:34--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="top.jsp"%>
<h1>Index Page</h1>
<h1>当前在线人数:<%=OnlineUserCounter.count%></h1>
</body>
</html>
