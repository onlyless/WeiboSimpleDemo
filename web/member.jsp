<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="Service.UserService" %><%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/16/18
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Weibo</title>
</head>
<body>
<%@include file="top.jsp"%>
<h1>会员<%=username%>，你好</h1>
<div>
    <form action="/message.do" method="post">
        <table>
            <tr>
                <td>
                    分享新鲜事
                </td>
            </tr>
            <tr>
                <td>
                    <textarea name="blabla" cols="60" rows="10" placeholder="信息要在140字以内"></textarea>
                </td>
            </tr>
            <tr>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</div>
<div>
    <form>
        <table>
            <tr>
                <th>时间</th>
                <th>内容</th>
            </tr>
            <%--<c:forEach var="user" items="${requestScope.users}">--%>
                <%--<tr>--%>
                    <%--<td><c:out value="${user.date}"/></td>--%>
                    <%--<td><c:out value="${user.txt}"/></td>--%>
                    <%--<td><a href="delete.do?id=${user.id}">删除</a> </td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
    <%
        UserService userService = (UserService) application.getAttribute("userService");
        User t = new User();
        t.setUsername(username);
        List<User> blahs = userService.getUsers(t);
        for(User blah:blahs){
            %>
            <tr>
                <td><%=blah.getDate()%></td>
                <td><%=blah.getTxt()%></td>
                <td><a href="delete.do?id=<%=blah.getId()%>">删除</a> </td>
            </tr>
    <%
        }
    %>
        </table>
    </form>
</div>

</body>
</html>
