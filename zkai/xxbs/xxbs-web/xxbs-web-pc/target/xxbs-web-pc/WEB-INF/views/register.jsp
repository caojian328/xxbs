<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/register" method="post">
    <table align="center">
        <tr>
            <td>手机号：</td><td><input type="text" name="moblie" value="18028729119"></td>
        </tr>

        <tr>
            <td>验证码：</td><td><input type="text" name="account" value="12345" ></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="立即注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
