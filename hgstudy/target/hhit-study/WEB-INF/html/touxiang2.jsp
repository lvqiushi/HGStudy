
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
<title>Insert title here</title>
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
#preview-pane .preview-container {
    width: 170px;
    height: 250px;
    overflow: hidden;
}
</style>
</head>
<body>
<div class="container">
        <div class="row">
            <div class="span12">
                <div class="jc-demo-box">
                	<c:if test="${empty imageName }">
                		<img src="" id="target" alt="[Jcrop Example]" />
                	</c:if>
                	<c:if test="${not empty imageName }">
                    	<img src="temp/${imageName }" id="target" alt="[Jcrop Example]" />
                    </c:if>
                    <div id="preview-pane">
                        <div class="preview-container">
                            <img src="" class="jcrop-preview"
                                alt="Preview" />
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
    </div>

   <form action="touxiang" method="post">  
	    点击  
	    <input type="hidden" name="prefix" value="${prefix }"/>
	    <input type="hidden" name="imageName" value="${imageName }"/> 
	    <input type="hidden" name="userid" value="${userid }"/> 
	    <input type="hidden" name="image.x" id="x"/>  
	    <input type="hidden" name="image.y" id="y"/>  
	    <input type="hidden" name="image.width" id="width"/>  
	    <input type="hidden" name="image.height" id="height"/>  
	    <input type="submit" value="确定" />  
	    ，设置完成。  
	</form> 
   <script >  
    var x;  
    var y;  
    var width;  
    var height;  
    $(function(){  
        var jcrop_api, boundx, boundy;  
        $preview = $('#preview-pane'), $pcnt = $('#preview-pane .preview-container'), $pimg = $('#preview-pane .preview-container img'),
        xsize = $pcnt.width(), ysize = $pcnt.height();
        console.log('init', [ xsize, ysize ]);
      //使原图具有裁剪功能
        $('#target').Jcrop({  
        	aspectRatio: 1, //选中区域宽高比为1，即选中区域为正方形 
        	minSize:[200,200],
        	maxSize:[250,250],
        	onChange: updatePreview,  
            onSelect: updatePreview,  
        },function(){  
            // Use the API to get the real image size  
            var bounds = this.getBounds();  
            boundx = bounds[0];  
            boundy = bounds[1];  
            // Store the API in the jcrop_api variable  
            jcrop_api = this;  
            $preview.appendTo(jcrop_api.ui.holder);
        });  
        	//裁剪过程中，每改变裁剪大小执行该函数
        function updatePreview(c){  
            if (parseInt(c.w) > 0){    
                $('#preview').css({  
                    width: Math.round(200 / c.w * boundx) + 'px',   //200 为预览div的宽和高 
                    height: Math.round(200 / c.h * boundy) + 'px',  
                    marginLeft: '-' + Math.round(200 / c.w * c.x) + 'px',  
                    marginTop: '-' + Math.round(200 / c.h * c.y) + 'px'  
                });  
                $('#width').val(c.w);  //c.w 裁剪区域的宽  
                $('#height').val(c.h); //c.h 裁剪区域的高  
                $('#x').val(c.x);  //c.x 裁剪区域左上角顶点相对于图片左上角顶点的x坐标  
                $('#y').val(c.y);  //c.y 裁剪区域顶点的y坐标
            }  
          };  
    });  
  </script>
</body>
</html>