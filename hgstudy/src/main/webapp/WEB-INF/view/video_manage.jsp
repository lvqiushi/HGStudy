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
    <meta charset="UTF-8">
    <meta name="author" content="ycw">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>编辑视频</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- 全局js -->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<article>
        <div class="panel panel-default">
            <div class="panel-heading">视频列表</div>
            <div class="panel-body">
				<c:if test="${empty video}">
					该小节还未上传视频<a href="toUploadVideo?jointid=${joint.jid }&operte=1">是否现在上传</a>
				</c:if>
				
				<c:if test="${not empty video}">				
                    <div class="form-group">
                        <label for="video-name" class="col-xs-3 control-label  text-center">视频名</label>
                        <div class="col-xs-9">
                            <p id="video-name">${video.vidName }</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upload-date" class="col-xs-3 control-label  text-center">上传日期</label>
                        <div class="col-xs-9">
                            <p id="upload-date">${video.time}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="xj-name" class="col-xs-3 control-label  text-center">所在小节</label>
                        <div class="col-xs-9">
                            <p id="xj-name">第${joint.jointIndex}节   ${joint.jointTitle}</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="operate" class="col-xs-3 control-label  text-center">操作</label>
                        <div class="col-xs-9">
                            <p id="operate"><a href="delVideo?videoId=${video.vidId}">删除</a> | <a href="toUploadVideo?jointid=${joint.jid }&operte=2">重新上传</a></p>
                        </div>
                    </div>
				</c:if>
            </div>
        </div>
</article>
</body>
</html>