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
    <meta charset="UTF-8">
    <meta name="author" content="ycw">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
    <title>课程页面</title>
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
<%@ include file="top.jsp" %>
<article>
    <div class="container" style="margin-left: 50px; margin-right: 20px; width: 100%">
        <div class="row">
            <div class="col-sm-3" style="padding-right: 30px">
                <div class="row all-course-list text-center">
                    <div class="list-group">
                        <a href="selectCourses?type=0" id="ac-all" class="list-group-item">全部</a>
                        <a href="selectCourses?type=1" id="ac-jsj" class="list-group-item">计算机</a>
                        <a href="selectCourses?type=2" id="ac-wy" class="list-group-item">外语</a>
                        <a href="selectCourses?type=3" id="ac-wxls" class="list-group-item">文学历史</a>
                        <a href="selectCourses?type=4" id="ac-gx" class="list-group-item">工学</a>
                        <a href="selectCourses?type=5" id="ac-lx" class="list-group-item">理学</a>
                    </div>
                </div>
            </div>



            <div class="col-sm-9" style="width: 1000px;">
                <ul class="nav nav-tabs" role="tablist" id="kind">
                    <li role="presentation"><a onclick="foward()" role="tab" data-toggle="tab">热门</a></li>
                    <li role="presentation"><a onclick="foward1()" role="tab" data-toggle="tab">最新</a></li>

                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="course-hot">
                        <br>
                        <c:forEach var="course" items="${pagebean.contents}">
	                        <div class="row">
	                            <div class="col-sm-4">
	                                <a href="selectCourseInfor?couid=${course.couId}"><img class="img-responsive" src="${course.couImg}" alt=""></a>
	                            </div>
	                            <div class="col-sm-8">
	                            	<p><h4>${course.couName}</h4></p>
	                            	<p class="search-result-p">${course.couSchool} &nbsp;&nbsp;&nbsp;&nbsp; <a href="showTeacherInfor?teaid=${course.tea.teaId}">${course.tea.teaName}</a></p>
	                                <p>${course.couinfor}</p>
	                            </div>
	                        </div>
	                        <hr>
						</c:forEach> 

						<c:if test="${not empty pagebean}">	
                        <nav aria-label="Page navigation" class="text-center"  id="page">
			                <ul class="pagination">
			                	<li><a href="selectCourses?curpage=1&type=${type}&kind=${kind}">首页</a> </li>
			                	
			                	<c:if test="${curpage>1}">
			                		<li>
			                        	<a href="selectCourses?curpage=${curpage-1}&type=${type}&kind=${kind}" aria-label="Previous">
			                            	<span aria-hidden="true">&laquo;</span>
			                        	</a>
			                   		</li>
								</c:if>

							<c:forEach begin="${pagebean.star}" end="${pagebean.end}" var="i">
								<c:if test="${curpage==i}">
									<li class="active"><span aria-hidden="true">${i }</span>
									</li>
								</c:if>
								<c:if test="${curpage!=i}">
									<li><a
										href="selectCourses?curpage=${i}&type=${type}&kind=${kind}"
										aria-label="Next"> <span aria-hidden="true">${i }</span>
									</a></li>
								</c:if>
							</c:forEach>

							<c:if test="${pagebean.curPage<pagebean.pageCount}">
			                		<li>
			                        	<a href="selectCourses?curpage=${curpage+1}&type=${type}&kind=${kind}" aria-label="Next">
			                            	<span aria-hidden="true">&raquo;</span>
			                        	</a>
			                   		</li>
								</c:if> 
								<li><a href="selectCourses?curpage=${pagebean.pageCount}&type=${type}&kind=${kind}">末页</a> </li>
			                </ul>
			            </nav>
			            </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</article>

<script>
$(document).ready(function () {
	var type = ${type+1};
	var kind = ${kind-1};
	$("a:nth-child("+type+")").addClass("active");
	$("#top").find("li:eq(1)").addClass("active");
	$("#kind").find("li:eq("+kind+")").addClass("active");
})
function foward() {
	window.location.href='selectCourses?kind=1&type=${type}';      
}
function foward1() {
	window.location.href='selectCourses?kind=2&type=${type}';      
}
</script>
</body>
</html>