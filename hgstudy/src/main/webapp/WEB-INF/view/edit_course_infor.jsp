<%@page import="java.util.*"%>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 	request.setCharacterEncoding("UTF-8");
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
    <title>编辑课程信息</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/js/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/js/kindeditor/plugins/code/prettify.css" />
	<script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/top.js"></script>
    <script src="js/home.js"></script>
	<script charset="utf-8" src="js/kindeditor/js/kindeditor.js"></script>
	<script charset="utf-8" src="js/zh_CN.js"></script>
	<script charset="utf-8" src="js/kindeditor/plugins/code/prettify.js"></script>
    <!-- 全局js -->

    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="outview"]', {
				cssPath : 'plugins/code/prettify.css',
				items : [ "source", "preview", "fontname", "fontsize",
						"forecolor", "hilitecolor", "bold", "italic",
						"underline", "justifyleft", "justifycenter",
						"justifyright", "justifyfull", "insertorderedlist",
						"insertunorderedlist", "quickformat", "selectall",
						"formatblock", "strikethrough", "lineheight", "hr",
						"table" ],
				allowFileManager : false,
				afterBlur: function(){this.sync();} 
			});
			prettyPrint();
			
			var editor2 = K.create('textarea[name="outline"]', {
				cssPath : 'plugins/code/prettify.css',
				items : [ "source", "preview", "fontname", "fontsize",
						"forecolor", "hilitecolor", "bold", "italic",
						"underline", "justifyleft", "justifycenter",
						"justifyright", "justifyfull", "insertorderedlist",
						"insertunorderedlist", "quickformat", "selectall",
						"formatblock", "strikethrough", "lineheight", "hr",
						"table" ],
				allowFileManager : false,
				afterBlur: function(){this.sync();} 
			});
			prettyPrint();
		});
	</script>
</head>
<body>
<div class="text-center">
    <h3>编辑课程</h3>
</div>
<form class="form-horizontal" name="example"  action="editCourseInfor" target="_parent" method="post">
	<input type="hidden"  name="couId" value="${couid }"/>
    <div class="form-group">
        <label for="edit-course-title" class="col-sm-2 control-label">课程名称</label>
        <div class="col-sm-10">
            <input type="text" name="couName" class="form-control" id="edit-course-title" value="${cou.couName }" required>
        </div>
    </div>
    <div class="form-group">
        <label for="edit-course-2" class="col-sm-2 control-label">课程介绍</label>
        <div class="col-sm-10">
            <textarea class="form-control" name="couinfor" rows="4" id="edit-course-1" required>${cou.couinfor }</textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="edit-course-2" class="col-sm-2 control-label">课程概述</label>
        <div class="col-sm-10">
            <textarea class="form-control" name="outview" rows="8" id="edit-course-2" >${cou.outview }</textarea>
        </div>
    </div>
	<div class="form-group">
        <label for="edit-course-3" class="col-sm-2 control-label">课程大纲</label>
        <div class="col-sm-10">
            <textarea class="form-control" name="outline" rows="8" id="edit-course-3" >${cou.outline }</textarea>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-8 text-left">
            <button type="submit" class="btn btn-default">保存</button>
            <button type="reset" class="btn btn-default">取消</button>
        </div>
    </div>
</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>