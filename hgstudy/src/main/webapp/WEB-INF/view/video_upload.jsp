<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

<html> 
<head><title>视频上传</title>
<base href="<%=basePath%>">
	<link href="js/plupload/js/jquery.plupload.queue/css/jquery.plupload.queue.css" rel="stylesheet">
	<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/plupload/js/plupload.full.js"></script>
	<script type="text/javascript" src="js/plupload/js/jquery.plupload.queue/jquery.plupload.queue.js"></script>
	<script type="text/javascript" src="js/plupload/js/i18n/cn.js"></script>
	<script type="text/javascript">
// Convert divs to queue widgets when the DOM is ready
	$(function() {
		$("#uploader").pluploadQueue({
			// General settings
			runtimes : 'gears,flash,silverlight,browserplus,html5,html4',
			url : 'UploadVideo',
			max_file_size : '1000mb',
			unique_names : true,
			multiple_queues : true,
			multi_selection : false,
			chunk_size: '3mb',
			// Specify what files to browse for
			filters : [
				{title : "Video", extensions : "mp4"}

			],
	
			// Flash settings
			flash_swf_url : 'js/plupload/js/plupload.flash.swf',
			// Silverlight settings
			silverlight_xap_url : 'js/plupload/js/plupload.silverlight.xap'
		});
		$('form').submit(function(e) {
	        var uploader = $('#uploader').pluploadQueue();
	        if (uploader.files.length > 0) {
	            // When all files are uploaded submit form
	            uploader.bind('StateChanged', function() {
	                if (uploader.files.length === (uploader.total.uploaded + uploader.total.failed)) {
	                    $('form')[0].submit();
	                }
	            });
	            uploader.start();
	        } else {
				alert('请先上传数据文件.');
			}
	        return false;
    	});
	});
	
	
</script>

</head>

<body>
	<div>
		<div style="width: 750px; margin: 0px auto">
			<form id="formId" action="submitUpload" method="post" enctype="multipart/form-data">
				<input name="jointId" type="hidden" value="${param.jointId }" />
				<input name="operte" type="hidden" value="${param.operte }" />
				<div id="uploader">
					<p>您的浏览器未安装 Flash, Silverlight, Gears, BrowserPlus 或者支持 HTML5 .</p>
				</div>
				<input type="submit" value="完成"/>
			</form>
		</div>
	</div>
</body>

</html>