<%@page import="java.util.ArrayList"%>
<%@ page language="java"   contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="ycw">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>编辑课程</title>
    <base href="<%=basePath%>">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="font/css/font-awesome.min.css" rel="stylesheet" >
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
<%
	int i=1;
	String msg = (String)request.getAttribute("msg");         // 获取提示信息
	if(msg != null) {
%>
	<script type="text/javascript" language="javascript">
		alert("<%=msg%>");                                            // 弹出提示信息
	</script>	
<%
	}
%>
<article>
    <div class="container">
        <div class="row ">
            <h1>${couname }        	
            	<a id="editHome" class="pull-right"><i onclick="home('${couid}')" class="fa fa-home fa-fw" style="width: 42px"></i></a>
            	<!--  <a  class="pull-right" id="teacher-user"><i onclick="videomanager('${couid}')" class="fa fa-file-video-o fa-fw"></i></a>-->
                <a  class="pull-right"><i onclick="editinfor('${couid}')" class="fa fa-edit fa-fw"></i></a>
                <a href="teaInfor" class="pull-right" id="teacher-user"><i class="fa fa-user-circle fa-fw"></i></a>
				<a class="pull-right" id="send-mail"><i onclick="announce('${couid}')" class="fa fa-envelope-open" style="width: 42px"></i></a>
				<a href="toApplyLive?couId=${couid}" target="_blank" class="pull-right" id="live-apply"><i class="fa fa-video-camera" style="width: 46px"></i></a>
            </h1>
            <hr style="margin: 30px 0">
            <div class="col-xs-4">
                <div class="panel panel-default">
                	<c:forEach var="c" items="${chapters}">
	                	<div class="panel-heading" role="tab" id="heading-1">
	                        <h1 class="panel-title">
	                        	第${c.chapterIndex}章 &nbsp;
	                            ${c.chapterTitle}
	                            <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse<%=i %>" aria-expanded="false" aria-controls="collapse-1">
	                                <i class="pull-right fa fa-toggle-down fa-lg"></i>
	                            </a>
	                            <a class="leftEditZJ"><i onclick="editchapter('${c.chapterId}','${couid }')" class="fa fa-edit fa-lg pull-right"></i></a>
	                            <a class="leftAddXJ"><i onclick="addjoint('${c.chapterId}','${couid }')" class="fa fa-plus fa-lg pull-right"></i></a>
	                        </h1>
	                    </div>
	                    	<c:if test="${empty c.joints}">
	                    		<div id="collapse<%=i %>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading-1">
			                        <div class="panel-body">
			                        	<div class="btn btn-primary btn-block">暂无添加小节 </div>
			                        </div>
		                    	</div>
	                    	</c:if>
						<div id="collapse<%=i%>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading-1">
							<div class="panel-body">
								<c:forEach var="j" items="${c.joints}">
									<c:if test="${not empty j}">
										<a type="button" onclick="editjoint('${j.jid}','${couid }')"
											class="btn btn-primary btn-block">第${j.jointIndex}节&nbsp;${j.jointTitle }</a>
									</c:if>
								</c:forEach>
							</div>
						</div>
						<%
							i = i + 1;
						%>
                	</c:forEach>
                </div>
            </div>
            <div class="col-xs-8">
                <iframe id="upload-iframe" class="iframeGroup" src="toEditCourseIndex?couid=${couid }" height="100%" width="100%" frameborder="0" scrolling="no" ></iframe>
               
            </div>
        </div>
    </div>
</article>
<script>
//    $(window.parent.document).find("#upload-iframe").load(function(){
//
//        var main = $(window.parent.document).find("#upload-iframe");
//
//        var thisheight = document.getElementById("upload-iframe").contentWindow.document.body.scrollHeight+30;
//        //var thisheight = $(document).height()+30;
//
//        main.height(thisheight);
//
//    });

//控制内联框架iframe的窗体高度
function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
			if(iframeWin.document.body.scrollHeight < 700)
                $("#upload-iframe").css("height",500);
			else
            	$("#upload-iframe").css("height",iframeWin.document.body.scrollHeight);
        }
    }
};

setInterval(function() {
    var objDOM = document.getElementById('upload-iframe');
    setIframeHeight(objDOM);
}, 400);

</script>
	
<script>
	function addjoint(chapterid,couid) {
        $("#upload-iframe").attr("src","toaddjoint?chapterid="+chapterid+"&couid="+couid)
    }
    function announce(couId) {
        $("#upload-iframe").attr("src","toAnnounce?couId="+couId)
    }

    function live(couId) {
        $("#upload-iframe").attr("src","toApplyLive?couId="+couId)
    }

	function editchapter(chapterid,couid) {
		$("#upload-iframe").attr("src","toEditChapter?chapterId="+chapterid)
        $("#ZJtitle").text("编辑章节")
	}
	function editjoint(jid,couid) {
		$("#upload-iframe").attr("src","toeditjoint?jointid="+jid+"&couid="+couid)
	}
	function home(couid) {
		$("#upload-iframe").attr("src","toEditCourseIndex?couid="+couid)
	}
	function editinfor(couid) {
		$("#upload-iframe").attr("src","toEditCourseInfor?couid="+couid)
	}

</script>
</body>

</html>