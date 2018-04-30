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
			
			.right{
				float: right;
				width: 100%;
			}
			.center{
				width: 95%;
				height: 100%;
				margin-left: 50px;
				margin-top: 200px;
				
			}
			.center_mid{
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div>
			<div class="right">
				<div class="center">
					<form class="bs-example bs-example-form" role="form" action="announce" id="announce">
						<div class="input-group input-group-lg">
							<span class="input-group-addon">收件人：</span>
							<input type="text" class="form-control" placeholder="收件人">
						</div>
						<br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">标题：</span>
							<input type="text" class="form-control" name="title" placeholder="标题">
						</div>
						<br>
						<div class="form-group form-group-lg">
							<span class="input-group-addon">正文：</span>
							<textarea class="form-control" name="content" placeholder="正文" rows="10"></textarea>
						</div>
						<div class="center_mid">
							<button class="btn btn-info" type="submit">发送</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-danger"  type="reset">重置</button>
						</div>
						<input type="hidden" name="couId" value="${couId}">
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">
            function send(){
                $.ajax({
                    url:"/sendMailToStudent",
                    type:"post",
                    data:form,
                    processData:false,
                    contentType:false,
                    success:function(data){
                        if(data.success == true){
                            alert("success");
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
