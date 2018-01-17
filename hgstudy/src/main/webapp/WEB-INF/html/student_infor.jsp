<%@page import="java.util.*"%>
<%@ page language="java"  import="hiber.dao.*" import="hiber.pojo.*" contentType="text/html; charset=UTF-8"
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
    <meta charset="UTF-8">
    <meta name="author" content="ycw">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="<%=basePath%>">
    <title>学生页面</title>
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
	<div class="panel panel-default public-profile">
        <div class="panel-heading"><h4>编辑信息</h4></div>
        <div class="panel-body">
            <div class="row">
                <div class="col-xs-9">
                    <form class="form-horizontal" role="form" action="editinfor!student" target="_parent">
                        <div class="form-group">
                            <label for="my_name" class="col-sm-2 control-label">昵称</label>
                            <div class="col-sm-10">
                                <input type="text" name="name" class="form-control" id="my_name" value="${user.stuName }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="my_email" class="col-sm-2 control-label">学校</label>
                            <div class="col-sm-10">
                                <input type="text" name="school" class="form-control" id="my_email"  value="${user.stuSchool }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="sex" id="inlineRadio1" value="男"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="sex" id="inlineRadio2" value="女"> 女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bio" class="col-sm-2 control-label">年龄</label>
                            <div class="col-sm-10">
                                <input type="text" name="age" class="form-control"  value="${user.stuAge }">
                            </div>
                        </div>
                        <input name="userid" type="hidden" value="${user.stuId}" />
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
</article>
</body>
</html>