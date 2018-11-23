<%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/16/18
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>weibo</title>
  </head>
  <body>
  <%@include file="top.jsp"%>
  <form method="post" action="/register.do" name="login">
    <table>
      <tr>
        <td>邮箱</td>
        <td><input type="text" name="email" size="25" maxlength="100"></td>
      </tr>
      <tr>
        <td>用户名</td>
      <td><input type="text" name="username" size="25" maxlength="100"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password" size="25" maxlength="16"></td>
      </tr>
      <tr>
        <td>确认密码</td>
        <td><input type="password" name="confirmePasswd" size="25" maxlength="16"></td>
      </tr>
      <tr>
        <td><input type="submit" value="submit" name="submit"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
