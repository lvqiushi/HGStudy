<%@page import="java.util.*"%>
<%@ page language="java"  import="hiber.dao.*" import="hiber.pojo.*" contentType="text/html; charset=UTF-8"
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
    <meta charset="UTF-8">
    <meta name="author" content="ycw">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
    <title>老师页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- 全局js -->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/top.js"></script>
    <script src="js/home.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<article>
	<div class="all-course">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>课程列表</h4>
			</div>
			<div class="panel-body">
				<c:forEach var="course" items="${courses}">
					<div class="row">
						<div class="col-xs-3">
							<a href="CourseAction?couID=${course.couId}" target="_parent"><img
								class="img-responsive" src="${course.couImg}" alt=""></a>
						</div>
						<div class="col-xs-9">
							<p>
							<h4>${course.couName}</h4>
							</p>
							<br>
							<p>${course.couinfor}</p>
						</div>
					</div>
					<hr>
				</c:forEach>

				<nav aria-label="Page navigation" class="text-center">
				<ul class="pagination">
					<li><a href="ShowCourseAction?curpage=0">首页</a></li>
					<c:if test="${curpage>0}">
						<li><a href="ShowCourseAction?curpage=${curpage-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:if test="${curpage<(totalpage-1)}">
						<li><a href="ShowCourseAction?curpage=${curpage+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	</article>
</body>
</html>