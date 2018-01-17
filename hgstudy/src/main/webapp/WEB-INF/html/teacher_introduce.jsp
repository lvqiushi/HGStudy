<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
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
    <title>课程</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- 全局js -->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/top.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<title>教师信息</title>
</head>
<body class="info-bg">
<%int i = 0;%>
<%@ include file="top.jsp" %>
<article class="container">
    <div class="row teacher-info-box">
        <div class="col-sm-3 text-center">
            <img class="img-rounded teacher-head" src="${tea.teaimage }">
        </div>
        <div class="col-sm-9">
            <h3>${tea.teaName}</h3><br>
            <p>${tea.teaTil}</p>
            <p>${tea.teaSchool}</p>
        </div>
    </div>

    <br>

    <div class="row">
        <div class="col-sm-12">
            <div class="panel panel-default">
                <div class="panel-heading">课程列表</div>
                <div class="panel-body">                   
                    	<c:forEach var="course" items="${courses}">
                    		<%
                    			if(i%4==0){
                    		%>
                    			<div class="row">
                    		<%}%>
	                        <div class="index-course col-sm-3 col-xs-6">
	                            <a href="CourseAction?couID=${course.couId}">
								<img class="course-img img-responsive" src="${course.couImg}" alt=""></a>
	                            <div class="course-img-down img-responsive">
	                                <span class="course-img-down-title">${course.couName}</span><br><br>
	                                <span class="course-info">${course.couSchool}</span>
	                            </div>
	                        </div>
	                        <%
                    			if((i+1)%4==0){
                    		%>
                    			</div> 
                    		<%}%>
                    		<% i = i + 1;%>
                        </c:forEach>                                       
                </div>
            </div>
        </div>
    </div>
</article>

</body>
</html>