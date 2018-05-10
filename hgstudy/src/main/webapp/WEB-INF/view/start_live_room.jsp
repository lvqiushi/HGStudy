<%@page import="java.util.*"%>
<%@ page language="java"    contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<base href="<%=basePath%>" id="base">
		<title></title>
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
		<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
			.left{
				float: left;
				width: 50%;
			}
			.right{
				float: right;
				width: 50%;
			}
			.center{
				width: 50%;
				height: 50%;
				margin-left: 150px;
				margin-top: 200px;
				
			}
		</style>
	</head>
	<body>
		<div>
			<div class="left">
				<label>第一步：打开obs软件如图点击preference进行视频流相关配置</label>
				<img src="obs/first.png" style="height: 300px;width: 800px" />
				<label>第二步：创建直播间后，将页面返回的url流地址和流名称填入下图相应选型中</label>
				<img src="obs/second.png" style="height: 300px;width: 800px"/>
				<label>第三步：流配置完成后，点击页面中开始推流即可开始直播</label>
				<img src="obs/trid.png" style="height: 300px;width: 800px"/>
			</div>
			<div class="right">
				<div class="center">
					<form class="bs-example bs-example-form" role="form" id="live-room">
						<div class="input-group input-group-lg">
							<span class="input-group-addon">直播流地址：</span>
							<input type="text"  class="form-control" style="width: 360px" value="${liveURL}">
						</div>
						<br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">直播流名称：</span>
							<input type="text" class="form-control"  value="${roomName}">
						</div>
						<br>'
						<div class="center_mid" id="live-btn">
							<c:if test="${status eq 0 }">
								<a class="btn btn-info" onclick="startLive(${liveId})">开始直播</a>
							</c:if>
							<c:if test="${status eq 1 }">
								<a class="btn btn-info" onclick="closeLive(${liveId})">关闭直播</a>
							</c:if>
						</div>
						<input type="hidden" name="id" value="${liveId}">
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
            function startLive(liveId){
                var form = new FormData(document.getElementById("live-room"));
                $.ajax({
                    url:document.getElementById("base").href+"/startLive",
                    type:"post",
                    data:form,
                    processData:false,
                    contentType:false,
                    success:function(data){
                        if(data.success == true){
                            $("#live-btn a:eq(0)").remove();
                            $("#live-btn").append("<a class=\"btn btn-info\" onclick=\"closeLive(${liveId})\">关闭直播</a>");
                            alert("开启直播成功");
                        }else {
                            alert(data.message);
                        }
                    },
                    error:function(e){
                        alert("错误");
                    }
                });
            }

            function closeLive(liveId){
                var form = new FormData(document.getElementById("live-room"));
                $.ajax({
                    url:document.getElementById("base").href+"/closeLive",
                    type:"post",
                    data:form,
                    processData:false,
                    contentType:false,
                    success:function(data){
                        if(data.success == true){
                            $("#live-btn a:eq(0)").remove();
                            $("#live-btn").append("<a class=\"btn btn-info\" onclick=\"startLive(${liveId})\">开始直播</a>");
                            alert("关闭直播成功");
                        }else {
                            alert(data.message);
                        }
                    },
                    error:function(e){
                        alert("错误！！");
                        window.clearInterval(timer);
                    }
                });
            }
		</script>
	</body>
</html>
