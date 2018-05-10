<%@page import="java.util.*"%>
<%@ page language="java"    contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>">
		<title></title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
			.left{
				float: left;
				width: 50%;
			}
			.right{
				float: right;
				width: 50%;
			}
			.center{
				width: 50%;
				height: 50%;
				margin-left: 150px;
				margin-top: 200px;
				
			}
		</style>
	</head>
	<body>
		<div>
			<div class="left">
				<label>第一步：打开obs软件如图点击preference进行视频流相关配置</label>
				<img src="obs/first.png" style="height: 300px;width: 800px" />
				<label>第二步：创建直播间后，将页面返回的url流地址和流名称填入下图相应选型中</label>
				<img src="obs/second.png" style="height: 300px;width: 800px"/>
				<label>第三步：流配置完成后，点击页面中开始推流即可开始直播</label>
				<img src="obs/trid.png" style="height: 300px;width: 800px"/>
			</div>
			<div class="right">
				<div class="center">
					<form class="bs-example bs-example-form" role="form" action="applyLive">
						<div class="input-group input-group-lg">
							<span class="input-group-addon">直播间名称：</span>
							<input type="text" name="roomName" class="form-control" placeholder="直播间名称">
						</div>
						<br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">直播标题：</span>
							<input type="text" class="form-control" name="title" placeholder="标题">
						</div>
						<br>
						<div class="form-group form-group-lg">
							<span class="input-group-addon">简介：</span>
							<textarea class="form-control" name="description" rows="5"></textarea>
						</div>
						<div class="center_mid">
							<button class="btn btn-info" type="submit">提交</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-danger"  type="reset">重置</button>
						</div>
						<input type="hidden" name="couId" value="${couId}">
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
