<%--
  Created by IntelliJ IDEA.
  User: lvqiushi
  Date: 2018/2/19
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <title>直播间</title>
    <link href="/video-5/video-js.css" rel="stylesheet">
    <script src="/video-5/ie8/videojs-ie8.js"></script>
    <script src="http://vjs.zencdn.net/5.20.1/video.js"></script>

</head>
<body>

<h1>${live.getTitle()}</h1>
<video id="example_video_1" class="video-js vjs-default-skin vjs-big-play-centered" controls preload="auto" width="960" height="460" poster="${live.getImage()}" data-setup="{}">
    <!--<source src="rtmp://172.21.2.75/rtmplive/test" type="rtmp/flv">-->
    <source src="${url}" type="rtmp/flv">
    <source src="rtmp://live.hkstv.hk.lxdns.com/live/hks" type="rtmp/flv">

    <p class="vjs-no-js">播放视频需要启用 JavaScript，推荐使用支持HTML5的浏览器访问。
        To view this video please enable JavaScript, and consider upgrading to a web browser that
        <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
    </p>
</video>

</body>
</html>
