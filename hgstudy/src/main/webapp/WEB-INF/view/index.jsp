<%@page import="java.util.ArrayList"%>
<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <div class="col-sm-3 left-list">
                <ul>
                    <li id="ios-title"><img src="img/jsj.png" alt="计算机"><span>计算机</span></li>
                    <li id="java-title"><img src="img/wy.png" alt="外语"><span>外语</span></li>
                    <li id="c-title"><img src="img/wxls.png" alt="文学历史"><span>文学历史</span></li>
                    <li id="python-title"><img src="img/gongxue.png" alt="工学"><span>工学</span></li>
                    <li id="jsp-title"><img src="img/lixue.png" alt="理学"><span>理学</span></li>
                </ul>
            </div>
            <!-- 右侧内容 -->
            <div class="col-sm-9 right-list">
                <div id="ios-course" class="course">
                	<c:if test="${empty jsj}">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该类课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					
					<c:if test="${not empty jsj }">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${jsj.couImg }" alt="">
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${jsj.couName }</h2><br>
	                            <p>${jsj.couSchool }&nbsp;&nbsp;&nbsp;  &nbsp;${jsj.tea.teaName }</p><br>
	                            <div class="row">
	                                <div class="col-sm-6">
	                                    <a href="selectCourseInfor?couid=${jsj.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${jsj.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                <div id="java-course" class="course">
					<c:if test="${empty wy}">
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
					
					<c:if test="${not empty wy}">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${wy.couImg }" alt="" >
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${wy.couName }</h2><br>
	                            <p>${wy.couSchool}&nbsp;&nbsp;&nbsp;  &nbsp;${wy.tea.teaName}</p><br>
	                            <div class="row">
	                                <div class="col-sm-6">
	                                    <a href="selectCourseInfor?couid=${wy.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${wy.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                
                <div id="python-course" class="course">
                	<c:if test="${empty gx}">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					<c:if test="${not empty gx}">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${gx.couImg }" alt="" >
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${gx.couName }</h2><br>
	                            <p>${gx.couSchool}&nbsp;&nbsp;&nbsp;  &nbsp;${gx.tea.teaName}</p><br>
	                            <div class="row">
	                                <div class="col-sm-6">
	                                    <a href="selectCourseInfor?couid=${gx.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${gx.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                <div id="c-course" class="course">
                	<c:if test="${empty wx}">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					<c:if test="${not empty wx}">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${wx.couImg }" alt="" >
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${wx.couName }</h2><br>
	                            <p>${wx.couSchool}&nbsp;&nbsp;&nbsp;  &nbsp;${wx.tea.teaName}</p><br>
	                            <div class="row">
	                                <div class="col-sm-6">
	                                    <a href="selectCourseInfor?couid=${wx.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${wx.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
                
                <div id="jsp-course" class="course">
                	<c:if test="${empty lx }">
						<br><br><br>
                        <div class="col-sm-offset-2 col-sm-8" style="border: 1px solid black">
                            <br><br><br>
                            <h1>暂无该课程</h1>
                            <br><br><br>
                        </div>
                        <p></p>
					</c:if>
					
					<c:if test="${ not empty lx }">
	                    <div class="row">
	                        <div class="col-xs-6">
	                            <img class="img-responsive" src="${lx.couImg }" alt="" >
	                        </div>
	                        <div class="col-xs-6">
	                            <h2>${lx.couName }</h2><br>
	                            <p>${lx.couSchool}&nbsp;&nbsp;&nbsp;  &nbsp;${lx.tea.teaName}</p><br>
	                            <div class="row">
	                                <div class="col-sm-6">
	                                    <a href="selectCourseInfor?couid=${lx.couId}"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="row" style="margin:30px">
	                        <h4>课程概述</h4>
	                        <p>${lx.couinfor }</p>
	                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>


    <div class="more-course" style="height: 780px;">
        <div class="container">
            <h2>精品课程</h2>
            <hr class="more-course-line">
            <div class="row">
                <c:forEach var="course" items="${courses}" varStatus="index">
					<div class="index-course col-sm-3 col-xs-6">
						<a href="selectCourseInfor?couid=${course.couId}">
						<img class="course-img img-responsive" src="${course.couImg}" alt=""></a>
		                <div class="course-img-down img-responsive">
	                        <span class="course-img-down-title" style="padding-top: 5px">${course.couName}</span><br>
	                        <div class="course-info">
	                        <span class="course-info">${course.couSchool}</span>                        
	                        <span class="pull-right"><img src="img/students.png" alt="">${course.evaluate}</span>                        
	                        </div>
	                        <div class="course-info">
                        	<p name="courseinfor">${course.couinfor}</p>
                        	</div>
                    	</div>
					</div>
					<%-- <c:if test="${(index.count/4) != 0 }">
						<br>
					</c:if>	 --%>			
				</c:forEach> 
				
				<%-- <c:forEach var="course" items="${courses1}">
					<div class="index-course col-sm-3 col-xs-6">
						<a href="CourseAction?couID=${course.couId}">
						<img class="course-img img-responsive" src="${course.couImg}" alt=""></a>
						<div class="course-img-down img-responsive">
	                        <span class="course-img-down-title">${course.couName}</span><br><br>
	                        <span class="course-info">淮海工学院</span>
	                        <span class="course-info pull-right"><img src="img/students.png" alt="">${course.evaluate}</span>
                        <p name="courseinfor">${course.couinfor}</p>
                    	</div>
					</div>
				</c:forEach> --%> 
            </div>   
        </div>
    </div>

	<div class="more-course">
		<div class="container">
			<h2>正在直播</h2>
			<hr class="more-course-line">
			<div class="row">
				<c:forEach var="live" items="${lives}" varStatus="index">
					<div class="index-course col-sm-3 col-xs-6">
						<a href="toLiveRoom?id=${live.id}">
							<img class="course-img img-responsive" src="${live.image}" alt=""></a>
						<div class="course-img-down img-responsive">
							<span class="course-img-down-title" style="padding-top: 5px">${live.title}</span><br>
							<div class="course-info">
								<span class="course-info">${live.teaName}</span>
							</div>
							<div class="course-info">
								<p name="courseinfor">${live.description}</p>
							</div>
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
        $("#java-title").mouseenter(function () {
            $(".course").hide()
            $("#java-course").show()
            $("#java-title").css({'background-color':'#537585'})
        })
        $("#java-title").mouseleave(function () {
            $("#java-title").css({'background-color':'white'})
        })
        $("#c-title").mouseenter(function () {
            $(".course").hide()
            $("#c-course").show()
            $("#c-title").css({'background-color':'#537585'})
        })
        $("#c-title").mouseleave(function () {
            $("#c-title").css({'background-color':'white'});
        })
        $("#python-title").mouseenter(function () {
            $(".course").hide();
            $("#python-course").show()
            $("#python-title").css({'background-color':'#537585'})
        })
        $("#python-title").mouseleave(function () {
            $("#python-title").css({'background-color':'white'});
        })
        $("#jsp-title").mouseenter(function () {
            $(".course").hide();
            $("#jsp-course").show()
            $("#jsp-title").css({'background-color':'#537585'})
        })
        $("#jsp-title").mouseleave(function () {
            $("#jsp-title").css({'background-color':'white'});
        })
        
        var wordlength = 40;		
		var cname=document.getElementsByName("courseinfor");
		for(var i=0;i<cname.length;i++){                  
            var nowLength=cname[i].innerHTML.length;       
            if(nowLength > wordlength){                     
                cname[i].innerHTML=cname[i].innerHTML.substr(0,wordlength)+'...';
            }
		}
    })
</script>
</body>
</html>