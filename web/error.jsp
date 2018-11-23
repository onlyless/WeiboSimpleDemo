<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
        <c:forEach var="error" items="${requestScope.errors}">
            <li><c:out value="${error}"/></li>
        </c:forEach>
    </ul>
    <a href="/register.jsp">返回注册页面</a>
</body>
</html>
