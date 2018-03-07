<%@page import="java.util.ArrayList"%>
<%@ page language="java"   contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
    <title>课程</title>
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

<%@ include file="top.jsp" %>

<article class="container">
    <div class="row">
        <div class="col-sm-8" id="courseinfor">
            <h1 id="attention" class="course-details-title"><b>${cou.couName}</b>
                <c:if test="${not empty statu}">
                     <c:if test="${statu==2 }">
                        <button onclick="attention(${cou.couId},2)" class="btn" style="background-color: #b2dba1; color: white">取消关注</button>
                     </c:if>
                     <c:if test="${statu==1 }">
                        <button onclick="attention(${cou.couId},1)" class="btn" >关注</button>
                     </c:if>
                </c:if>
             </h1><br>
            <p class="course-details-summary">${cou.couinfor}</p>
        </div>
        <div class="col-sm-4">
            <img class="img-responsive course-details-top-img" src="${cou.couImg }" alt="">
        </div>
    </div>
    <hr style="margin: 50px 0">
    <div class="row">
        <div class="col-sm-9">
			<div class="panel panel-default">
                <div class="panel-heading">课程概述</div>
                <div class="panel-body">
                    <p class="p-text-indent">${cou.outview }</p>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">授课大纲</div>
                <div class="panel-body">
					${cou.outline }
				</div>
            </div>
        </div>
        <div class="col-sm-3 text-center">
            <a href="PlayAction.action?couid=${cou.couId }&teaid=${cou.tea.teaId}" type="button" id="course-btn" class="btn btn-info btn-lg btn-block">播放视频</a><br><br>
            <a href="toDownloadCourseware?couid=${cou.couId }" type="button" id="class-list" class="btn btn-info btn-lg btn-block">课件列表</a><br><br>
            <div class="panel panel-success">
                <div class="panel-heading">授课教师</div>
                <div class="panel-body teacher-list">
                    <div class="row">
                        <div class="col-sm-6">
                            <a href="showTeacherInfor?teaid=${cou.tea.teaId}"><img class="img-responsive img-circle" src="header/${cou.tea.teaImage }" alt=""></a>
                        </div>
                        <div class="col-sm-6">
                            <h4>${cou.tea.teaName }<br><br>${cou.tea.teaTil }</h4>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</article>
<script type="text/javascript">
    /*$(document).ajaxComplete(function(event, xhr, settings) {
        //验证附加的头部信息
        if(xhr.getResponseHeader("status")=="nologin"){
                alert("请先进行登陆!");
                //回到登录页面
                window.location.replace("/login.jsp");
        }
    });*/
    /* 提交结果，执行ajax */
    function attention(couid,oper){
        $.ajax({
            type:"post",
            url:"AttentionCou",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
            data:{//设置数据源
                couid:couid,
                oper:oper //这里不要加","  不然会报错，而且根本不会提示错误地方
            },
            dataType:"json",//设置需要返回的数据类型

            success:function(data){
                //var d = $.parseJSON(data);//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                //得到的d是一个形如{"key":"value","key1":"value1"}的数据类型，然后取值出来

                var divshow = $("#attention");
                if(data.nologin != null){
                    alert("请先进行登陆!");
                    //回到登录页面
                    window.location.href="/login.jsp";
                }
                else{
                    alert(data.jsonResult.message);
                    if(data.jsonResult.success == true){
                        $("#courseinfor button:eq(0)").remove();
                        if(data.jsonResult.otherinfor == 1){
                            //$("#courseinfor").children("button:first").remove();
                            divshow.append("<button onclick=\"attention(${cou.couId},2)\" class=\"btn\" style=\"background-color: #b2dba1; color: white\">取消关注</button>");
                        }
                        else{
                            divshow.append("<button onclick=\"attention(${cou.couId},1)\" class=\"btn\" >关注</button>");
                        }
                    }
                    else{

                    }
                }
            },
            error:function(data,state){
                alert(data+"系统异常，请稍后重试！"+state);
            }//这里不要加","
        });
    }

</script>
</body>
</html>