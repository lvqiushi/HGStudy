<%@page import="java.util.ArrayList"%>
<%@ page language="java"  import="hiber.pojo.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="<%=basePath%>">
    <title>淮工MOOC</title>
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
<article class="mainWrap">
    <div class="container">
        <div class="row">
            <!-- 左侧边栏 -->
            <div class="col-sm-3 left-list text-center" style="margin-bottom: 15px">
                <ul>
                    <li id="ios-title"><img src="img/ios.png" alt="" style="margin-right: 20px">ios&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li id="java-title"><img src="img/java.png" alt="" style="margin-right: 20px">java&nbsp;&nbsp;&nbsp;&nbsp;</li>
                    <li id="c-title"><img src="img/c.png" alt="" style="margin-right: 20px">C/C++</li>
                    <li id="python-title"><img src="img/python.png" alt="" style="margin-right: 20px">python</li>
                    <li id="jsp-title"><img src="img/jsp.png" alt="" style="margin-right: 20px">jsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                </ul>
            </div>
            <!-- 右侧内容 -->
            <div class="col-sm-9 right-list">
                <div id="ios-course" class="course">
                	<c:if test="${empty ios}">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					
					<c:if test="${not empty ios }">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${ios.couImg }" alt="ios课程图片">
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${ios.couName }</h2><br>
	                            <p>${iosteacher.teaSchool }&nbsp;&nbsp;&nbsp;  &nbsp;${iosteacher.teaName }</p><br>
	                            <div class="row">
	                                <div class="col-sm-6" style="margin-bottom: 10px">
	                                    <a href="../html/video.html"><button type="button" class="btn btn-primary btn-block">播放视频</button></a>
	                                </div>
	                                <div class="col-sm-6">
	                                    <a href="CourseAction?couID=${ios.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${ios.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                <div id="java-course" class="course">
					<c:if test="${empty java}">
						<div class="row">
	                        <br><br><br>
	                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
	                            <br><br><br>
	                            <h1>暂无该课程</h1>
	                            <br><br><br>
	                        </div>
	                        <p></p>
                    	</div>
					</c:if>
					
					<c:if test="${not empty java}">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${java.couImg }" alt="java课程图片" style="margin: 0">
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${java.couName }</h2><br>
	                            <p>${jteacher.teaSchool }&nbsp;&nbsp;&nbsp;  &nbsp;${jteacher.teaName }</p><br>
	                            <div class="row">
	                                <div class="col-sm-6" style="margin-bottom: 10px">
	                                    <a href="#"><button type="button" class="btn btn-primary btn-block">播放视频</button></a>
	                                </div>
	                                <div class="col-sm-6">
	                                    <a href="CourseAction?couID=${java.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${java.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                
                <div id="c-course" class="course">
                	<c:if test="${empty c}">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					<c:if test="${not empty c}">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${c.couImg }" alt="C/C++课程图片" style="margin: 0">
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${c.couName }</h2><br>
	                            <p>${cteacher.teaSchool }&nbsp;&nbsp;&nbsp;  &nbsp;${cteacher.teaName }</p><br>
	                            <div class="row">
	                                <div class="col-sm-6" style="margin-bottom: 10px">
	                                    <a href="#"><button type="button" class="btn btn-primary btn-block">播放视频</button></a>
	                                </div>
	                                <div class="col-sm-6">
	                                    <a href="CourseAction?couID=${c.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${c.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                <div id="python-course" class="course">
                	<c:if test="${empty python}">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					<c:if test="${not empty python}">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${python.couImg }" alt="python课程图片" style="margin: 0">
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${python.couName }</h2><br>
	                            <p>${pteacher.teaSchool }&nbsp;&nbsp;&nbsp;  &nbsp;${pteacher.teaName }</p><br>
	                            <div class="row">
	                                <div class="col-sm-6" style="margin-bottom: 10px">
	                                    <a href="#"><button type="button" class="btn btn-primary btn-block">播放视频</button></a>
	                                </div>
	                                <div class="col-sm-6">
	                                    <a href="CourseAction?couID=${python.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${python.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                
                <div id="jsp-course" class="course">
                	<c:if test="${empty jsp }">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					
					<c:if test="${ not empty jsp }">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="img/c5.PNG" alt="jsp课程图片" style="margin: 0">
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>jsp课程标题</h2><br>
	                            <p>淮海工学院&nbsp;&nbsp;&nbsp;  &nbsp;教师名字</p><br>
	                            <div class="row">
	                                <div class="col-sm-6" style="margin-bottom: 10px">
	                                    <a href="#"><button type="button" class="btn btn-primary btn-block">播放视频</button></a>
	                                </div>
	                                <div class="col-sm-6">
	                                    <a href="#"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>这是相关的课程概述---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
	                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>


    <div class="more-course">
        <div class="container">
            <h2>精品课程</h2>
            <hr class="more-course-line">
            <div class="row">
                <c:forEach var="course" items="${courses}">
					<div class="index-course col-sm-3 col-xs-6">
						<a href="CourseAction?couID=${course.couId}">
						<img class="img-responsive" src="${course.couImg}" alt=""></a>
						<div class="course-img-down">	
		                	<p><span>${course.couName}</span></p>
		                	<p class="course-text">hhit</p>
		                </div>
					</div>
				</c:forEach> 
				
				<c:forEach var="course" items="${courses1}">
					<div class="index-course col-sm-3 col-xs-6">
						<a href="CourseAction?couID=${course.couId}">
						<img class="img-responsive" src="${course.couImg}" alt=""></a>
						<div class="course-img-down">	
		                	<p><span>${course.couName}</span></p>
		                	<p class="course-text">hhit</p>
		                </div>
					</div>
				</c:forEach> 
            </div>   
        </div>
    </div>
</article>
<%@ include file="tail.jsp" %>
<script>
    $(document).ready(function () {
        $("#ios-course").show()
        $("#ios-title").mouseenter(function () {
            $(".course").hide()
            $("#ios-course").show()
            $("#ios-title").css({'background-color':'#537585'})
        })
        $("#ios-title").mouseleave(function () {
            $("#ios-title").css({'background-color':'white'})
        })
        $("#ios-title").click(function () {
            location.href = "../html/course_details.html"
        })
        $("#java-title").mouseenter(function () {
            $(".course").hide()
            $("#java-course").show()
            $("#java-title").css({'background-color':'#537585'})
        })
        $("#java-title").mouseleave(function () {
            $("#java-title").css({'background-color':'white'})
        })
        $("#java-title").click(function () {
            location.href = "../html/course_details.html"
        })
        $("#c-title").mouseenter(function () {
            $(".course").hide()
            $("#c-course").show()
            $("#c-title").css({'background-color':'#537585'})
        })
        $("#c-title").mouseleave(function () {
            $("#c-title").css({'background-color':'white'});
        })
        $("#c-title").click(function () {
            location.href = "../html/course_details.html"
        })
        $("#python-title").mouseenter(function () {
            $(".course").hide();
            $("#python-course").show()
            $("#python-title").css({'background-color':'#537585'})
        })
        $("#python-title").mouseleave(function () {
            $("#python-title").css({'background-color':'white'});
        })
        $("#python-title").click(function () {
            location.href = "../html/course_details.html"
        })
        $("#jsp-title").mouseenter(function () {
            $(".course").hide();
            $("#jsp-course").show()
            $("#jsp-title").css({'background-color':'#537585'})
        })
        $("#jsp-title").mouseleave(function () {
            $("#jsp-title").css({'background-color':'white'});
        })
        $("#jsp-title").click(function () {
            location.href = "../html/course_details.html"
        })
    })
</script>
</body>
</html>