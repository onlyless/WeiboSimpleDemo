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
        <%
            String username = (String)request.getSession(false).getAttribute("login");
            if(username!=null){
                out.print("<a href=\"/member.jsp\">"+username+"</a>");
            }else {
                out.print("<a href=\"/login.jsp\">Login</a>");
            }
        %>

        <a href="/logout.jsp">Logout</a>
        <a href="/register.jsp">register</a>
        <a href="/success.jsp">success</a>
        <a href="/error.jsp">error</a>
        <a href="/Draw.do">Draw</a>
        <a href="/user/admin">admin</a>
    </nav>
</div>
