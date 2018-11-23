<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/16/18
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fail</title>
</head>
<body>
<%@include file="top.jsp"%>
    <h1>Fail</h1>
    <ul style="color: red">
    <% List<String> errors = (List<String>)request.getAttribute("errors");
    if(errors!=null) {
        for (String error : errors) {
            %>
        <li><%=error%></li>
        <%
        }
    }
    %>
    </ul>
    <a href="/register.jsp">返回注册页面</a>
</body>
</html>
