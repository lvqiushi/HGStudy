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
		<base href="<%=basePath%>">
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
					<form class="bs-example bs-example-form" role="form">
						<div class="input-group input-group-lg">
							<span class="input-group-addon">直播流地址：</span>
							<input type="text"  class="form-control" value="${liveURL}">
						</div>
						<br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">直播流名称：</span>
							<input type="text" class="form-control"  value="${roomName}">
						</div>
						<br>
						<div class="center_mid" id="live-btn">
							<button class="btn btn-info" onclick="startLive(${liveId})">开始直播</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
            function startLive(liveId){
                $.ajax({
                    url:"/startLive",
                    type:"post",
                    data:{liveId:liveId},
                    processData:false,
                    contentType:false,
                    success:function(data){
                        if(data.success == true){
                            $("#live-btn button:eq(0)").remove();
                            $("#live-btn").append("<button class=\"btn btn-info\" onclick=\"closeLive(${liveId})\">关闭直播</button>");
                            alert("开启直播成功");
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

            function closeLive(liveId){
                $.ajax({
                    url:"/closeLive",
                    type:"post",
                    data:{liveId:liveId},
                    processData:false,
                    contentType:false,
                    success:function(data){
                        if(data.success == true){
                            $("#live-btn button:eq(0)").remove();
                            $("#live-btn").append("<button class=\"btn btn-info\" onclick=\"startLive(${liveId})\">开始直播</button>");
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