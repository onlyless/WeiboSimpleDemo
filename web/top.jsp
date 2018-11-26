<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/17/18
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <nav>
        <a href="/">Home</a>
        <c:choose>
            <c:when test="${sessionScope.login!=null}">
                <a href="/member.jsp">${sessionScope.login}</a>
            </c:when>
            <c:otherwise>
                <a href="/login.jsp">Login</a>
            </c:otherwise>
        </c:choose>

        <a href="/logout.do">Logout</a>
        <a href="/register.jsp">register</a>
        <a href="/success.jsp">success</a>
        <a href="/error.jsp">error</a>
        <a href="/Draw.do">Draw</a>
        <a href="/fans.do">Fans</a>
        <a href="/follows.do">Follows</a>
    </nav>
</div>
