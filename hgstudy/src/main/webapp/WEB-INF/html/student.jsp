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
    
    <link href="head/cropper.min.css" rel="stylesheet">
    <link href="head/sitelogo.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">
    <script src="head/html2canvas.js"></script>
	<script src="head/cropper.js"></script>
	<script src="head/sitelogo.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@ include file="top.jsp" %>
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
<article class="container">
    <div class="row info-row">
        <div class="col-xs-3  head-img">
            <div class="row">
                <div class="col-md-6 col-sm-12">
                    <a href="#avatar-modal" data-toggle="modal" id="student-head-btn"><img class="img-rounded" id="studentHeader" src="${user.stuimage}"></a>
                </div>
                <div class="col-md-6">
                	<br>
                    <h4>${user.stuName }</h4>
                    <h5>${user.stuSchool }</h5><br>
                </div>
            </div>
            <div class="info-btn">
                <a type="button" id="bio-btn"  onclick="click2('${user.stuId}')"  class="btn btn-default btn-block">编辑信息</a><br>
                <a type="button" id="history-btn"  onclick="click3()"  class="btn btn-default btn-block">关注课程</a><br>
                <button type="button" class="btn btn-default btn-block"  data-toggle="modal" data-target="#avatar-modal" >修改头像</button>
            </div>
        </div>
        <div class="col-xs-9">
            <iframe id="student-iframe" class="iframeGroup" src="ShowHistoryAction" height="1200px" width="100%" frameborder="0"></iframe>
        </div>
    </div>
</article>

<!-- 上传头像界面 -->
	<div class="modal fade" id="avatar-modal"  aria-hidden="true" aria-labelledby="avatar-modal-label" data-backdrop="static" role="dialog" tabindex="-1">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">-->
					<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">
						<div class="modal-header">
							<button class="close" data-dismiss="modal" type="button">&times;</button>
							<h4 class="modal-title" id="avatar-modal-label">上传图片</h4>
						</div>
						<div class="modal-body">
							<div class="avatar-body">
								<div class="avatar-upload">
									<input class="avatar-src" name="avatar_src" type="hidden">
									<input class="avatar-data" name="avatar_data" type="hidden">
									<label for="avatarInput" style="line-height: 35px;">图片上传</label>
									<button class="btn btn-danger"  type="button" style="height: 35px;" onClick="$('input[id=avatarInput]').click();">请选择图片</button>
									<span id="avatar-name"></span>
									<input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div>
								<div class="row">
									<div class="col-md-9">
										<div class="avatar-wrapper"></div>
									</div>
									<div class="col-md-3">
										<div class="avatar-preview preview-lg" id="imageHead"></div> 
										<!--<div class="avatar-preview preview-md"></div>-->
								<!--<div class="avatar-preview preview-sm"></div>-->
									</div>
								</div>
								<div class="row avatar-btns">
									<div class="col-md-4">
										<div class="btn-group">
											<button class="btn btn-danger fa fa-undo" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"> 向左旋转</button>
										</div>
										<div class="btn-group">
											<button class="btn  btn-danger fa fa-repeat" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"> 向右旋转</button>
										</div>
									</div>
									<div class="col-md-5" style="text-align: right;">								
										<button class="btn btn-danger fa fa-arrows" data-method="setDragMode" data-option="move" type="button" title="移动">
							            <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;setDragMode&quot;, &quot;move&quot;)">
							            </span>
							          </button>
							          <button type="button" class="btn btn-danger fa fa-search-plus" data-method="zoom" data-option="0.1" title="放大图片">
							            <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;zoom&quot;, 0.1)">
							              <!--<span class="fa fa-search-plus"></span>-->
							            </span>
							          </button>
							          <button type="button" class="btn btn-danger fa fa-search-minus" data-method="zoom" data-option="-0.1" title="缩小图片">
							            <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;zoom&quot;, -0.1)">
							              <!--<span class="fa fa-search-minus"></span>-->
							            </span>
							          </button>
							          <button type="button" class="btn btn-danger fa fa-refresh" data-method="reset" title="重置图片">
								            <span class="docs-tooltip" data-toggle="tooltip" title="" data-original-title="$().cropper(&quot;reset&quot;)" aria-describedby="tooltip866214">
								       </button>
							        </div>
									<div class="col-md-3">
										<button class="btn btn-danger btn-block avatar-save fa fa-save" type="button" data-dismiss="modal"> 保存修改</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
		
<script>

	function click2(userid) {
		$("#student-iframe").attr("src","ShowPersonInfor!student.action?userid="+userid)
	}
	function click3() {
		 $("#student-iframe").attr("src","ShowHistoryAction.action")
	}
	$('#avatarInput').on('change', function(e) {
		var filemaxsize = 1024 * 5;//5M
		var target = $(e.target);
		var Size = target[0].files[0].size / 1024;
		if(Size > filemaxsize) {
			alert('图片过大，请重新选择!');
			$(".avatar-wrapper").childre().remove;
			return false;
		}
		if(!this.files[0].type.match(/image.*/)) {
			alert('请选择正确的图片!')
		} else {
			var filename = document.querySelector("#avatar-name");
			var texts = document.querySelector("#avatarInput").value;
		
			testend = texts.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的
			filename.innerHTML = testend;
		}
	
	});

	$(".avatar-save").on("click", function() {
		
		var $img_lg = document.getElementById('imageHead');
		var $image = $('.avatar-wrapper > img');
		//var canvasdata = $image.cropper("getCanvasData");
		//var cropBoxData = $image.cropper('getCropBoxData'); 
		//console.log(cropBoxData);
		var imgData=$image.cropper('getCroppedCanvas');
		console.log(imgData);
		var dataurl = imgData.toDataURL('image/png');
		console.log(dataurl);
		imagesAjax(dataurl);
		
	})
	
	function imagesAjax(src) {
		var data = {};
		data.img = src;
		data.teaid = ${user.stuId};
		$.ajax({
			url: "Header.action",
			data: {
				img:src,
				teaid:data.teaid
			},
			type: "POST",
			dataType: 'json',
			success: function(re) {
				if(re.data.success == true){
					$("#studentHeader").attr('src',src );
					alert(re.data.message);				
				}
				else{					
				}
			},
			error:function(){
				alert("系统异常，请稍后重试！");
			}
		});
	}
</script>
</body>
</html>