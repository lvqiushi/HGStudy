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
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<img alt="" id="getYzm" src="" class="course-img img-responsive" onclick="change()">
	
<script language="JavaScript">
		function change() {
			var url = "getYzm"
			this.src = url;
		}
		
		$("#getYzm").click(function(){
			var url = "getYzm"
			this.src = url;
		}).click().show();
		
</script>
</body>

</html>