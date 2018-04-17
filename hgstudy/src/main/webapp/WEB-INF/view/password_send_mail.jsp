<%--
  Created by IntelliJ IDEA.
  User: lvqiushi
  Date: 2018/4/12
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"   contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>修改密码页面</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.11.1.min.js"></script>

    <link href="css/sb-admin-2.css" rel="stylesheet">



</head>

<body style="background-color:#f5f7ed;">

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <!--                     <div class="panel-heading">
                                        <h3 class="panel-title" align=center>重新设置密码</h3>
                                    </div> -->
                <div class="panel-body">
                    <form role="form"  id="send-mail">
                        <fieldset id="filed">
                            <div class="form-group" style="height: 130px" id="mail">
                                <h3 align=center>重新设置密码</h3>
                                <input class="form-control" style="margin-top: 40px;height: 50px" placeholder="E-mail" name="email" type="email" autofocus>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <a onclick="setPassword()" id="click" class="btn btn-lg btn-success btn-block">发送重设密码地址</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function setPassword(){
        var form = new FormData(document.getElementById("send-mail"));

        $.ajax({
            url: "/sendPasswordMail",
            type: "post",
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data.success == true) {
                    var parent = $("#filed");
                    var divshow = $("#mail");
                    var click = $("#click");
                    divshow.remove();
                    click.remove();
                    parent.append("<p class=\"form-control\" style=\"margin-top: 40px;height: 50px\" >已经将修改密码的连接地址发送到你的邮箱，请注意查收.</p>");
                    //parent.remove(click);
                } else {
                    alert("发送邮件失败，请稍后重试");
                }
            },
            error: function (e) {
                alert("错误！！");
                window.clearInterval(timer);
            }
        });
    }
</script>
</body>

</html>
