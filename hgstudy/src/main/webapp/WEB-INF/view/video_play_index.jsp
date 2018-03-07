
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
    <title>video</title>
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
<%
	int i=1;
%>
<article class="container-fluid" style="margin-top: 30px">
    <div class="row">
        <div class="container">
            <span style="font-size: 30px">${cou.couName }</span>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;授课教师：${cou.tea.teaName }</span>
        </div>
        <hr style="margin: 12px">
        <div class="leftNav col-sm-3 col-lg-2">
            <div class="panel-group  text-center" id="accordion" role="tablist" aria-multiselectable="true">
            
            <c:forEach var="c" items="${chapters}">
 				<div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse<%=i %>" aria-expanded="false" aria-controls="collapseOne">
                                <b>${c.chapterTitle }</b>
                            </a>
                        </h4>
                    </div>
                    <div id="collapse<%=i %>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                    <c:forEach var="j" items="${c.joints}">                   
                        <div class="panel-body">
                            <a type="button"  onclick="play('${j.jid}')" class="btn btn-primary btn-block">${j.jointTitle }</a>
                        </div>                   
                    </c:forEach>   
                    </div> 
                </div>
                <%
	                    	i=i+1;
	                    %>
			</c:forEach> 
    
            </div>
        </div>
        <div class="video-box col-sm-9 col-lg-10 text-center">
            <iframe  id="video-iframe" src="PlayVideo?jointId=${playVideoId}" frameborder="0" width="100%" height="800px"></iframe>
        </div>
    </div>
</article>
<script>
    function play(jointid) {
    	$("#video-iframe").attr("src","PlayVideo?jointid="+jointid)
    }
</script>
</body>
</html>