<%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/26/18
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fans</title>
</head>
<body>
<%@include file="top.jsp"%>
<c:choose>
    <c:when test="${sessionScope.fans!=null&&sessionScope.fans.size()!=0}">
            <ul>
        <c:forEach var="fan" items="${sessionScope.fans}">
            <li>
                <a href="/user/${fan.username}"><c:out value="${fan.username}"/></a>
            </li>
        </c:forEach>
            </ul>
    </c:when>
    <c:otherwise>
        <h1>你还没有粉丝哦!</h1>
    </c:otherwise>
</c:choose>

</body>
</html>
