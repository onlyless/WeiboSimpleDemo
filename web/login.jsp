<%--
  Created by IntelliJ IDEA.
  User: onlyless
  Date: 11/16/18
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="top.jsp"%>
<form action="login.do" method="post" name="login">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" size="25" maxlength="100" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" size="25" maxlength="100" name="password"></td>
        </tr>
        <tr>
            <td><img src="/VerifyCode.do"></td>
            <td><input type="text" name="verifyCode" maxlength="4"></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit" name="submit"></td>
        </tr>
    </table>
</form>

</body>
</html>
