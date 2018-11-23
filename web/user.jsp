<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
<%
    List<User> users = (List<User>) request.getAttribute("users");
    if(users!=null){
%>
<div>
    <br>${requestScope.username}的微博
</div>
<table style="text-align: left;width: 510px;height: 88px">
    <thead>
    <tr><th><hr></th></tr>
    </thead>
    <tbody>
    <%
        for(User user:users){
            %>
            <tr>
                <td style="vertical-align: top">
                    <%=user.getUsername()%>:<br>
                    <%=user.getTxt()%><br>
                    <%=user.getDate()%>
                    <hr>
                </td>
            </tr>
    <%
        }
    %>
    </tbody>
</table>
<hr style="width: 100%;height: 1px">
<%
    }
    else{
%>
<h1>${requestScope.username}用户不存在</h1>
<%
    }
%>

</body>
</html>
