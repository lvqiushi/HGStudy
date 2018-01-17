<%@page import="java.util.*"%>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
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
<%
	String msg = (String)request.getAttribute("msg");         // 获取提示信息
	if(msg != null) {
%>
	<script type="text/javascript" language="javascript">
		alert("<%=msg%>");                                            // 弹出提示信息
	</script>	
<%
	}
%>
<div class="panel panel-default">
    <div class="panel-heading">课件列表</div>
		<div class="panel-body text-center">
			<p class="text-left">课件总数 : ${pagebean.pageCount}</p>
			<table class="table kjTable">
				<tr>
					<th>课件名</th>
					<th>上传日期</th>
					<th>上传者</th>
					<th>操作</th>
				</tr>
				<c:forEach var="c" items="${pagebean.contents}">
					<tr>
						<td>${c.fileName}</td>
						<td>${c.time }</td>
						<td>${c.uploader.teaName }</td>
						<td><a href="delectCourseware?coursewareid=${c.fileId}&couid=${couid}">删除</a> </td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${not empty pagebean}">		
		<nav aria-label="Page navigation" class="text-center" id="page">
		<ul class="pagination">
			<li><a href="showCourseware?couid=${couid}&curpage=1">首页</a></li>

			<c:if test="${pagebean.curPage>1}">
				<li><a href="showCourseware?couid=${couid}&curpage=${pagebean.curPage-1}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a></li>
			</c:if>

			<c:forEach begin="${pagebean.star}" end="${pagebean.end}" var="i">
				<c:if test="${pagebean.curPage==i}">
					<li class="active"><span aria-hidden="true">${i }</span></li>
				</c:if>
				<c:if test="${pagebean.curPage!=i}">
					<li><a href="showCourseware?couid=${couid}&curpage=${i}"
						aria-label="Next"> <span aria-hidden="true">${i }</span>
					</a></li>
				</c:if>
			</c:forEach>

			<c:if test="${pagebean.curPage<pagebean.pageCount}">
				<li><a href="showCourseware?couid=${couid}&curpage=${pagebean.curPage}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
			</c:if>
			<li><a
				href="showCourseware?couid=${couid}&curpage=${pagebean.pageCount}">末页</a></li>
		</ul>
		</nav>
		</c:if>
		<form class="form-horizontal" action="addCourseware" role="form" method="post" enctype="multipart/form-data" onsubmit="return checkcourse();">
    	<input name="couId" type="hidden" value="${couid }" />
    	<input name="uploader.teaId" type="hidden" value="100" />
        <div class="form-group">
            <label for="add-kj" class="col-sm-2 control-label">添加课件</label>
            <div class="col-sm-10">
                <input type="file" name="courseware" class="form-control" id="add-kj" >
            </div>
        </div>
        <div class="form-group">
                    <label for="kjjs" class="col-sm-2 control-label">课件介绍</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" name="fileInfor" rows="4" id="kjjs" placeholder="课件介绍" required></textarea>
                    </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10 text-left">
                <button type="submit" class="btn btn-default"  >保存</button>
                <button type="reset" class="btn btn-default">取消</button>
            </div>
        </div>
    </form>
</div>
	<script language="JavaScript">
		function checkcourse() {
			var fileName = document.getElementById("add-kj").value;
			if (fileName.length > 0) {
				var idx = fileName.lastIndexOf(".");
				var suffix = fileName.substring(idx + 1);
				if (suffix.toLowerCase() != 'ppt'
						&& suffix.toLowerCase() != 'doc'
						&& suffix.toLowerCase() != 'docx'
						&& suffix.toLowerCase() != 'wps'
						&& suffix.toLowerCase() != 'txt') {
					alert("文件必须为ppt、doc、txt、docx或wps格式");
					return false;
				}
			}
			else{
				alert("请先选择文件");
				return false;
			}
		}		
	</script>
</body>
</html>