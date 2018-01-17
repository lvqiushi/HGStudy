<%@ page language="java" import="hiber.pojo.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>
<div style="text-align: center; ">
	<c:if test="${empty video}">
		<div style="width: 750px; margin: 0px auto">
			<div style="text-align: center; font-size: 26px">本章节还没有上传视频</div>
			<div style="padding: 20px;font-size: 20px">
				<p> </p>
			</div>
		</div>
	</c:if>
	<video width="700" height="500"  height="auto" controls>
	    <source src="video/${video.vidPath }" type="video/${prefix }">
	</video>
</div>
</body>
</html>