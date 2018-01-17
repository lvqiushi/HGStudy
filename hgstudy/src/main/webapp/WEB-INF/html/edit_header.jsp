
<%@ page language="java"   contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags" %>
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
<title>头像上传</title>
<style type="text/css">
.jcrop-holder #preview-pane {
    display: block;
    position: absolute;
    z-index: 2000;
    top: 10px;
    right: -240px;
    padding: 6px;
    border: 1px rgba(0, 0, 0, .4) solid;
    background-color: white;
    -webkit-border-radius: 6px;
    -moz-border-radius: 6px;
    border-radius: 6px;
    -webkit-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
    -moz-box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
    box-shadow: 1px 1px 5px 2px rgba(0, 0, 0, 0.2);
}
#preview-pane .preview-container{
    width: 200px;
    height: 200px;
    overflow: hidden;
}

</style>
</head>
<body>
	<img alt="" src="" id="cutimg" /> 
	        
        <div id="preview-pane">
            <div class="preview-container">
                <img src="" class="jcrop-preview" alt="">
            </div>
        </div>
	 <form name="form" action="touxiangupload" class="form-horizontal" method="post" enctype="multipart/form-data" target="_parent" onsubmit="return checkimg();">
        <div class="modal-body text-center">
            <div class="zxx_main_con">
                <div class="zxx_test_list"> 
                    <input type="hidden"  name="userid"  value="${param.userid }"/> 
                    <input type="hidden" id="x" name="x" /> 
                    <input type="hidden" id="y" name="y" /> 
                    <input type="hidden" id="w" name="w" /> 
                    <input type="hidden" id="h" name="h" />
                </div>
            </div>
        </div>
      
        <div class="modal-footer">
        	<input class="photo-file" type="file" name="pic" id="fcupload" onchange="readURL(this);" />
            <button id="submit" >上传新头像</button>
        </div>
    </form>
    
    <script type="text/javascript">
        //定义一个全局api，这样操作起来比较灵活
        var api = null, 
        
        boundx, 
        boundy, 
        
        $preview = $('#preview-pane'), 
        $pcnt = $('#preview-pane .preview-container'), 
        $pimg = $('#preview-pane .preview-container img'),

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

                    api = $.Jcrop('#cutimg', {
                    	setSelect: [ 20, 20, 200, 200 ],
                        aspectRatio: 1, //选中区域宽高比为1，即选中区域为正方形 
                    	minSize:[200,200],
                    	maxSize:[250,250],
                        onSelect: updateCoords,
                        onChange: updateCoords,
                    });
                    var bounds = api.getBounds();
                    boundx = bounds[0];
                    boundy = bounds[1];
                    $preview.appendTo(api.ui.holder);
                };
                if (api != undefined) {
                    api.destroy();
                }
            }
            function updateCoords(obj) {
                $("#x").val(obj.x);
                $("#y").val(obj.y);
                $("#w").val(obj.w);
                $("#h").val(obj.h);
                if (parseInt(obj.w) > 0) {
                    var rx = xsize / obj.w;
                    var ry = ysize / obj.h;
                    $pimg.css({
                        width : Math.round(rx * boundx) + 'px',
                        height : Math.round(ry * boundy) + 'px',
                        marginLeft : '-' + Math.round(rx * obj.x) + 'px',
                        marginTop : '-' + Math.round(ry * obj.y) + 'px'
                    });
                }
            };
          
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
				else
					return true;
			}
			else{
				alert("没有上传头像");
				return false;
			}
				
		}

    </script>
</body>
</html>