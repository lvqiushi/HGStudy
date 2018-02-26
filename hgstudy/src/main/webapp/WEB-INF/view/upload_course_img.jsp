<%@ page language="java"   contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>  
<script src="js/jquery.Jcrop.js" type="text/javascript"></script> 
<link rel="stylesheet" href="css/jquery.Jcrop.css" type="text/css" />
<title>上传课程封面图片</title>
<style type="text/css">
#cutimg {
    width: 400px;
    height: 300px;
    overflow: hidden;
}
.modal-body{
    text-align: center;
}
</style>
</head>
<body>
	
	 <form name="form" action="editcourseimage" class="form-horizontal" method="post" enctype="multipart/form-data" target="_parent" onsubmit="return checkimg();">
        <div class="modal-body">
        	<img alt="预览" src="" id="cutimg"  /> 
            <div class="zxx_main_con">
                <div class="zxx_test_list">
                    <input class="photo-file" type="file" name="pic" id="fcupload" onchange="readURL(this);" /> 
                    <button id="submit" >上传</button>
                	<input type="hidden"  name="couid"  value="${param.couid }"/> 
                </div>
            </div>
        </div>
             
    </form>
    
    <script type="text/javascript">
        boundx, 
        boundy, 
        
        xsize = $pcnt.width(), 
        ysize = $pcnt.height();

        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.readAsDataURL(input.files[0]);
                reader.onload = function(e) {
                    $('#cutimg').removeAttr('src');
                    $('#cutimg').attr('src', e.target.result);
                    $pimg.removeAttr('src');
                    $pimg.attr('src', e.target.result);
                };               
            }       
        }
        
        function checkimg(){
			var fileName =document.getElementById("fcupload").value;
			if(fileName.length>0){
				var idx = fileName.lastIndexOf(".");
				var suffix = fileName.substring(idx+1);
			if(suffix.toLowerCase()!='jpg'&&suffix.toLowerCase()!='png'&&suffix.toLowerCase()!='gif'){
					alert("图片必须为jpg、png或gif格式");
					return false;
				}
			}
		}
    </script>
</body>
</html>