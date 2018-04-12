<%@page import="java.util.*"%>
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
<body>
	<div class="panel panel-default public-profile">
        <div class="panel-heading"><h4>编辑信息</h4></div>
        <div class="panel-body">
            <div class="row">
                <div class="col-xs-9">
                    <form class="form-horizontal" role="form" action="editStuInfor" target="_parent">
                        <div class="form-group">
                            <label for="my_name" class="col-sm-2 control-label">昵称</label>
                            <div class="col-sm-10">
                                <input type="text" name="stuName" class="form-control" id="my_name" value="${stu.stuName }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="my_email" class="col-sm-2 control-label">学校</label>
                            <div class="col-sm-10">
                                <input type="text" name="stuSchool" class="form-control" id="my_email"  value="${stu.stuSchool }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <c:if test="${stu.stuSex eq '男' }">
                                        <input type="radio" name="stuSex" id="inlineRadio1" selected="selected" value="男"> 男
                                    </c:if>
                                </label>
                                <label class="radio-inline">
                                    <c:if test="${stu.stuSex eq '女' }">
                                        <input type="radio" name="stuSex" id="inlineRadio2" selected="selected" value="女"> 女
                                    </c:if>
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="bio" class="col-sm-2 control-label">邮箱</label>
                            <div class="col-sm-10">
                                <input type="text" name="emailAdress" class="form-control"  value="${stu.emailAdress }">
                            </div>
                        </div>
                        <input name="stuId" type="hidden" value="${stu.stuId}" />
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