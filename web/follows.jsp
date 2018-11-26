<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/26/18
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Follows</title>
</head>
<body>
<%@include file="top.jsp"%>
<c:choose>
    <c:when test="${sessionScope.follows!=null&&sessionScope.follows.size()!=0}">
        <ul>
        <c:forEach var="follow" items="${sessionScope.follows}">
            <li><a href="/user/${follow.username}"><c:out value="${follow.username}"/></a> </li>
        </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <h1>你还没有关注的人哦！</h1>
    </c:otherwise>
</c:choose>

</body>
</html>
