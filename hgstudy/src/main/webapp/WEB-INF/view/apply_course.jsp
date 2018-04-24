<%@page import="java.util.*"%>
<%@ page language="java"    contentType="text/html; charset=UTF-8"
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
    <title></title>
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
	<div class="container" style="margin: 0;width: 100%">
        <div class="panel panel-default teacher-profile">
            <div class="panel-heading"><h4>课程申请</h4></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-9">
                        <form class="form-horizontal" role="form" action="applyCourse" method="post" target="_parent">
                            <div class="form-group">
                                <label for="teacher_name" class="col-xs-3 col-md-2 control-label">课程名称</label>
                                <div class="col-xs-9 col-md-10">
                                    <input type="text" name="courseName" class="form-control" id="teacher_name" >
                                </div>
                            </div>
							<div class="form-group">
								<label for="teacher_name" class="col-xs-3 col-md-2 control-label">课程类别</label>
								<div class="col-xs-9 col-md-10">
									<select name="courseType" class="form-control">
										<option value="1" >计算机</option>
										<option value="2" >外语</option>
										<option value="3" >工学</option>
										<option value="4" >文学</option>
										<option value="5" >理学</option>
									</select>
								</div>
							</div>

                            <input name="teaId" type="hidden" value="${teaId}" />
                             <hr style="margin: 10px">
			                <div class="form-group">
			                    <div class="col-sm-offset-2 col-sm-10">
			                        <button type="submit" class="btn btn-default">保存</button>
			                        <button type="reset" class="btn btn-default">取消</button>
			                    </div>
			                </div>
                        </form>
                    </div>
                </div>              
            </div>
        </div>
    </div>
</body>

</html>