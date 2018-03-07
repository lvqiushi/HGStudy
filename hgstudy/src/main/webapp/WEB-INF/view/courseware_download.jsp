<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<base href="<%=basePath%>">
<title>课件下载</title>
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
	<%@ include file="top.jsp"%>
	<article>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">
				课件列表 <span class="pull-right"><a
					href="selectCourseInfor?couid=${couid}">返回</a></span>
			</div>
			<div class="panel-body">
				<table class="table">
					<tr>
						<th style="width: 300px">课件名</th>
						<th>课件简介</th>
						<th>上传时间</th>
					</tr>
					<c:forEach var="c" items="${pagebean.contents}">
						<tr>
							<td><a href="DownloadCourseware?fileid=${c.fileId}">${c.fileName}</a></td>
							<td><div class="kjjj">${c.fileInfor }</div></td>
							<td>${c.time }</td>
						</tr>
					</c:forEach>
				</table>
			</div>

			<c:if test="${not empty pagebean}">
				<nav aria-label="Page navigation" class="text-center" id="page">
				<ul class="pagination">
					<li><a href="toDownloadCourseware?couid=${couid}">首页</a></li>

					<c:if test="${pagebean.curPage>1}">
						<li><a href="toDownloadCourseware?couid=${couid}&curpage=${pagebean.curPage-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach begin="${pagebean.star}" end="${pagebean.end}" var="i">
						<c:if test="${pagebean.curPage==i}">
							<li class="active"><span aria-hidden="true">${i }</span></li>
						</c:if>
						<c:if test="${pagebean.curPage!=i}">
							<li><a href="toDownloadCourseware?couid=${couid}&curpage=${i}"
								aria-label="Next"> <span aria-hidden="true">${i }</span>
							</a></li>
						</c:if>
					</c:forEach>

					<c:if test="${pagebean.curPage<pagebean.pageCount}">
						<li><a href="toDownloadCourseware?couid=${couid}&curpage=${pagebean.curPage+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a
						href="toDownloadCourseware?couid=${couid}&curpage=${pagebean.pageCount}">末页</a>
					</li>
				</ul>
				</nav>
			</c:if>

		</div>
	</div>
	</article>
</body>
</html>