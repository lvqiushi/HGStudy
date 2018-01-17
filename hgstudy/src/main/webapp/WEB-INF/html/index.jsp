<%@page import="java.util.ArrayList"%>
<%@ page language="java"  import="hiber.dao.*" import="java.util.*" import="hiber.pojo.*" contentType="text/html; charset=UTF-8"
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
                    <div class="row">
                        <div class="col-xs-6">
                            <img class="img-responsive" src="img/c1.PNG" alt="ios课程图片">
                        </div>
                        <div class="col-xs-6">
                            <h2>ios课程标题</h2><br>
                            <p>淮海工学院&nbsp;&nbsp;&nbsp;  &nbsp;教师名字</p><br>
                            <div class="row">
                                <div class="col-sm-6" style="margin-bottom: 10px">
                                    <a href="../html/video.html"><button type="button" class="btn btn-primary btn-block">播放视频</button></a>
                                </div>
                                <div class="col-sm-6">
                                    <a href="../html/course_details.html"><button type="button" class="btn btn-primary btn-block">课程详情</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="margin:30px">
                        <h4>课程概述</h4>
                        <p>这是相关的课程概述---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</p>
                    </div>
                </div>
                <div id="java-course" class="course">
                    <div class="row">
                        <div class="col-xs-6">
                            <img class="img-responsive" src="img/c2.PNG" alt="java课程图片" style="margin: 0">
                        </div>
                        <div class="col-xs-6">
                            <h2>java课程标题</h2><br>
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
                </div>
                <div id="c-course" class="course">
                    <div class="row">
                        <div class="col-xs-6">
                            <img class="img-responsive" src="img/c3.PNG" alt="C/C++课程图片" style="margin: 0">
                        </div>
                        <div class="col-xs-6">
                            <h2>C/C++课程标题</h2><br>
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
                </div>
                <div id="python-course" class="course">
                    <div class="row">
                        <div class="col-xs-6">
                            <img class="img-responsive" src="img/c4.PNG" alt="python课程图片" style="margin: 0">
                        </div>
                        <div class="col-xs-6">
                            <h2>python课程标题</h2><br>
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
                </div>
                <div id="jsp-course" class="course">
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
                </div>
            </div>
        </div>
    </div>


    <div class="more-course">
        <div class="container">
            <h2>精品课程</h2>
            <hr class="more-course-line">
            <div class="row">
            <%
      			CourseDaoImpl cdao = new CourseDaoImpl();
      			String hql="select a from Course as a order by a.evaluate desc";
      			List<Course> courses=cdao.queryList(hql,4,0);
      			for(Course cou:courses){
	      			out.println("<div class=\"col-sm-3 col-xs-6\">");     			
	      			out.println("<a href=\"CourseAction?couID="+cou.getCouId()+"\">");
	      			out.println("<img class=\"img-responsive\" src=\""+cou.getCouImg()+"\" ></a>");
	      			out.println("<p>"+cou.getCouName()+"</p>");
	      			out.println("</div>");
      			}
      		%>
            </div> 
            
            <div class="row">
            <%
      			String hql1="select a from Course as a order by a.evaluate desc";
      			List<Course> courses1=cdao.queryList(hql1,4,4);
      			for(Course cou:courses1){
	      			out.println("<div class=\"col-sm-3 col-xs-6\">");     			
	      			out.println("<a href=\"CourseAction?couID="+cou.getCouId()+"\">");
	      			out.println("<img class=\"img-responsive\" src=\""+cou.getCouImg()+"\" ></a>");
	      			out.println("<p>"+cou.getCouName()+"</p>");
	      			out.println("</div>");
      			}
      		%>
            </div>    
        </div>
    </div>
</article>
<footer>
    <section class="footWrap">
        <div class="container">
            <div class="footMain row">
                <div class="col-md-6">
                    <div class="row">
                        <div class="title"><h3 style="margin-bottom: 10px">相关链接</h3></div>
                    </div>
                    <div class="row">
                        <p>
                        <div class="col-xs-4">
                            <a href="http://www.hhit.edu.cn" target="_blank"><button type="button" class="btn btn-primary btn-block">淮工首页</button></a>
                        </div>
                        <div class="col-xs-4">
                            <a href="#" target="_blank"><button type="button" class="btn btn-primary btn-block">相关链接</button></a>
                        </div>
                        <div class="col-xs-4">
                            <a href="#" target="_blank"><button type="button" class="btn btn-primary btn-block">相关链接</button></a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="row right-buttom">
                        <div class="col-sm-3 col-xs-6">
                            <a href="http://weibo.com/hhittw" target="_blank">
                                <img class="img-responsive xlwb" src="img/xlwb.png" alt="新浪微博">
                            </a>
                        </div>
                        <div class="col-sm-3 col-xs-6">
                            <a href="http://weibo.com/hhittw" target="_blank">
                                <img class="img-responsive ewm" src="img/xlwb2wmz_128.png" alt="新浪微博二维码">
                            </a>
                        </div>
                        <div class="col-sm-3 col-xs-6">
                            <a href="#">
                                <img class="img-responsive ewm" src="img/wx.png" alt="微信公众号">
                            </a>
                        </div>
                        <div class="col-sm-3 col-xs-6">
                            <a href="#">
                                <img class="img-responsive ewm" src="img/wx2wm128.png" alt="微信公众号二维码">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyrights">
                <p>地址：江苏省连云港市新浦区苍梧路59号 邮编：222005 | 苏ICP备05071369号</p>
                <p>Copyright © 2006-2016 HuaiHai Institute of Technology. All Rights Reserved 版权所有</p>
            </div>
        </div>
    </section>
</footer>
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