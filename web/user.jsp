<%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/22/18
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.username}</title>
</head>
<body>
<%@include file="top.jsp"%>
<c:choose>
    <c:when test="${requestScope.users!=null}">
        <div>
            <br>${requestScope.username}的微博
        </div>
        <table style="text-align: left;width: 510px;height: 88px">
        <thead>
            <tr><th><hr></th></tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${requestScope.users}">
            <tr>
                <td style="vertical-align: top">
                    ${user.username}:<br>
                        ${user.txt}<br>
                        ${user.date}
                    <hr>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        <hr style="width: 100%;height: 1px">
    </c:when>
    <c:otherwise>
        <h1>${requestScope.username}用户不存在</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
