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
	<div class="container">
        <div class="panel panel-default teacher-profile">
            <div class="panel-heading"><h4>编辑信息</h4></div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-9">
                        <form class="form-horizontal" role="form" action="editTeaInfor" method="post" target="_parent">
                            <div class="form-group">
                                <label for="teacher_name" class="col-xs-3 col-md-2 control-label">姓名</label>
                                <div class="col-xs-9 col-md-10">
                                    <input type="text" name="teaName" class="form-control" id="teacher_name" value="${tea.teaName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="teacher_email" class="col-xs-3 col-md-2 control-label">学校</label>
                                <div class="col-xs-9 col-md-10">
                                    <input type="text"  name="teaSchool" class="form-control" id="teacher_school" value="${tea.teaSchool}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="teacher_email" class="col-xs-3 col-md-2 control-label">邮箱</label>
                                <div class="col-xs-9 col-md-10">
                                    <input type="email"  name="emailAdress" class="form-control" id="teacher_email" value="${tea.emailAdress}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="teacher_name" class="col-xs-3 col-md-2 control-label">学历</label>
                                <div class="col-xs-9 col-md-10">
                                	<select name="teaEduca" class="form-control"> 
                                		<c:if test="${tea.teaEduca eq '本科' }">
                                			<option value="本科" selected="selected">本科</option>
                                		</c:if>
                                		<c:if test="${tea.teaEduca ne '本科' }">
                                			<option value="本科" >本科</option>
                                		</c:if>
                               		
                                		<c:if test="${tea.teaEduca eq '专科' }">
                                			<option value="专科" selected="selected">专科</option>
                                		</c:if>
                                		<c:if test="${tea.teaEduca ne '专科' }">
                                			<option value="专科" >专科</option>
                                		</c:if>
                                		
                                		<c:if test="${tea.teaEduca eq '研究生' }">
                                			<option value="研究生" selected="selected">研究生</option>
                                		</c:if>
                                		<c:if test="${tea.teaEduca ne '研究生' }">
                                			<option value="研究生" >研究生</option>
                                		</c:if>
                                		
                                		<c:if test="${tea.teaEduca eq '博士' }">
                                			<option value="博士" selected="selected">博士</option>
                                		</c:if>
                                		<c:if test="${tea.teaEduca ne '博士' }">
                                			<option value="博士" >博士</option>
                                		</c:if>
                                		
                                		<c:if test="${tea.teaEduca eq '其他' }">
                                			<option value="其他" selected="selected">其他</option>
                                		</c:if>
                                		<c:if test="${tea.teaEduca ne '其他' }">
                                			<option value="其他" >其他</option>
                                		</c:if>
                                	</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="teacher_name" class="col-xs-3 col-md-2 control-label">职衔</label>
                                <div class="col-xs-9 col-md-10">
                                	<select name="teaTil" class="form-control"> 
                                		<c:if test="${tea.teaTil eq '助教' }">
                                			<option value="助教" selected="selected">助教</option>
                                		</c:if>
                                		<c:if test="${tea.teaTil ne '助教' }">
                                			<option value="助教" >助教</option>
                                		</c:if>
                               		
                                		<c:if test="${tea.teaTil eq '讲师' }">
                                			<option value="讲师" selected="selected">讲师</option>
                                		</c:if>
                                		<c:if test="${tea.teaTil ne '讲师' }">
                                			<option value="讲师" >讲师</option>
                                		</c:if>
                                		
                                		<c:if test="${tea.teaTil eq '副教授' }">
                                			<option value="副教授" selected="selected">副教授</option>
                                		</c:if>
                                		<c:if test="${tea.teaTil ne '副教授' }">
                                			<option value="副教授" >副教授</option>
                                		</c:if>
                                		
                                		<c:if test="${tea.teaTil eq '教授' }">
                                			<option value="教授" selected="selected">教授</option>
                                		</c:if>
                                		<c:if test="${tea.teaTil ne '教授' }">
                                			<option value="教授" >教授</option>
                                		</c:if>
                                		
                                		<c:if test="${tea.teaTil eq '其他' }">
                                			<option value="其他" selected="selected">其他</option>
                                		</c:if>
                                		<c:if test="${tea.teaTil ne '其他' }">
                                			<option value="其他" >其他</option>
                                		</c:if>
                                	</select>                                    
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-xs-3 col-md-2 control-label">性别</label>
                                <div class="col-xs-9 col-md-10">
                                    <label class="radio-inline">
                                    	<c:if test="${tea.teaSex eq '男' }">
                                        	<input type="radio" name="teaSex" id="inlineRadio1" value="男" checked="checked"> 男
                                    	</c:if>
                                    	<c:if test="${tea.teaSex ne '男' }">
                                        	<input type="radio" name="teaSex" id="inlineRadio1" value="男" > 男
                                    	</c:if>
                                    </label>
                                    <label class="radio-inline">
                                    	<c:if test="${tea.teaSex eq '女' }">
                                        	<input type="radio" name="teaSex" id="inlineRadio1" value="女" checked="checked"> 女
                                    	</c:if>
                                    	<c:if test="${tea.teaSex ne '女' }">
                                        	<input type="radio" name="teaSex" id="inlineRadio1" value="女" > 女
                                    	</c:if>
                                    </label>
                                </div>
                            </div>
                            <input name="teaId" type="hidden" value="${tea.teaId}" />
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