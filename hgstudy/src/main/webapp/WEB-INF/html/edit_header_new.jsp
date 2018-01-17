<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
		<title>修改头像</title>
		
		<script src="../js/jquery-1.11.1.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<script src="../head/html2canvas.js"></script>
		<link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
		<link href="../head/sitelogo.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
		<link href="../head/cropper.min.css" rel="stylesheet">
		<script src="../head/cropper.js"></script>
		<script src="../head/sitelogo.js"></script>
		
		<style type="text/css">
		.avatar-btns button {
			height: 35px;
		}
		</style>
</head>
<body>

</body>
</html>