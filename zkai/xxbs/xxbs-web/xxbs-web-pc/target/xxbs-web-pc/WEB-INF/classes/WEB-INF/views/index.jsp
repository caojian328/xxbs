<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>知识点</title>
</head>
<body>
<h2>${userEntity.realName}</h2>
<a href = "${pageContext.request.contextPath}/user/info">userInfo</a>
<a href = "${pageContext.request.contextPath}/goRegister">注册</a>
</body>
</html>
