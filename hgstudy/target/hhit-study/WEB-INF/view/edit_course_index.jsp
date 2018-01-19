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
    <meta charset="UTF-8">
    <meta name="author" content="ycw">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>编辑课程</title>
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
<div class="text-center">
    <h3>课程标题</h3>
    <hr>
    <div style="margin-top: 150px;">
        <div class="col-xs-offset-3 col-xs-2">
            <a type="button" id="kjList-btn" onclick="kejian(${couid})" class="btn btn-default btn-lg">课件列表</a>
        </div>
        <div class="col-xs-2">
            <a type="button" id="addZJ-btn" onclick="addchapter(${couid})" class="btn btn-default btn-lg">添加章节</a>
        </div>
        <div class="col-xs-2">
            <a type="button" id="fengmian-btn" onclick="editimage(${couid})" class="btn btn-default btn-lg">编辑课程封面</a>
        </div>
    </div>

</div>

<script>
	function addchapter(couid) {
		location.href = "toAddChapter?couid="+couid
	}
	function kejian(couid) {
		location.href = "showCourseware?couid="+couid+"&curpage=1"
	}
	function editimage(couid) {
		location.href = "html/courseimage.jsp?couid="+couid
	}

</script>
</body>
</html>