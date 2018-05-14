<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<link href="/video-5/video-js.css" rel="stylesheet">
	<script src="/video-5/ie8/videojs-ie8.js"></script>
	<script src="http://vjs.zencdn.net/5.20.1/video.js"></script>
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
	<!--<source src="rtmp://172.21.2.75/rtmplive/test" type="rtmp/flv">-->
	<c:if test="${not empty video}">
		<video id="example_video_1" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="auto" width="960" height="460" poster="${video.vidImg }" data-setup="{}">
			<!--<source src="rtmp://172.21.2.75/rtmplive/test" type="rtmp/flv">-->
			<source src="video/${video.vidPath }" type="video/mp4">

			<p class="vjs-no-js">播放视频需要启用 JavaScript，推荐使用支持HTML5的浏览器访问。
				To view this video please enable JavaScript, and consider upgrading to a web browser that
				<a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
			</p>
		</video>
	</c:if>
	<%--<video width="700" height="500"  height="auto" controls>--%>
	    <%--<source src="${video.vidPath }" type="video/mp4">--%>
	<%--</video>--%>
</div>
</body>
</html>