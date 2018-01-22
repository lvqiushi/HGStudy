<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>错误页面</title>
<link rel="stylesheet" type="text/css" href="style/register-login.css">
</head>
<body>
错误信息

<c:if test="${not empty errCode}">
    <h1>System Errors:${exception}</h1>
</c:if>

<c:if test="${not empty url}">
    <h2>URL:${url}</h2>
</c:if>

</body>
</html>