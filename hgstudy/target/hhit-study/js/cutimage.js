// Create variables (in this scope) to hold the Jcrop API and image size
            
            
            
function bytesToSize(bytes) {
    var sizes = ['Bytes', 'KB', 'MB'];
    if (bytes == 0) return 'n/a';
    var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
    return (bytes / Math.pow(1024, i)).toFixed(1) + ' ' + sizes[i];
};
// check for selected crop region
function checkForm() {
    if (parseInt($('#w').val())) {
        return true;
        }else{
        $('.error').html('请选择一个裁剪的区域！').show();
        return false;
    }
};
 

 
// clear info by cropping (onRelease event handler)
function clearInfo() {
    $('#w').val('');
    $('#h').val('');
};
 
function fileSelectHandler() {
	
	var jcrop_api, boundx, boundy;
	$pcnt = $('#preview-pane .preview-container');
	$pimg = $('#preview-pane .preview-container img');
    xsize = $pcnt.width(); 
    ysize = $pcnt.height();

    // get selected file
    var oFile = $('#image_file')[0].files[0];
 
    // hide all errors
    $('.error').hide();
 
    // check for image type (jpg and png are allowed)
    var rFilter = /^(image\/jpeg|image\/png)$/i;
    if (! rFilter.test(oFile.type)) {
        $('.error').html('图片格式不符合要求，请重新选择！').show();      
        return;
    }
    var fsize=oFile.size ; //文件大小（bit）
    fsize=fsize/1024;//计算当前上传文件的大小
    // check for file size
    if (fsize>1024) {
        $('.error').html('上传的图片大小大于1MB，请重新选择！').show();       
        return;
    }
 
    // preview element
    var oImage = document.getElementById('preview');
 
    // prepare HTML5 FileReader

    var oReader = new FileReader();   
    // read selected file as DataURL
    oReader.readAsDataURL(oFile);
    oReader.onload = function(e) {       
        // e.target.result contains the DataURL which we can use as a source of the image
        oImage.src = e.target.result; 
        $pimg.removeAttr('src');
        $pimg.attr('src', e.target.result);
//        alert( oImage.src);
        oImage.onload = function () { // onload event handler
 
            // display step 2
            $('#uploadimg-control,#popUp-box-mask').fadeIn(500);
 
            
            // destroy Jcrop if it is existed
            if (typeof jcrop_api != 'undefined') 
                jcrop_api.destroy();
 
            // initialize Jcrop
            $('#preview').Jcrop({
            	setSelect: [ 20, 20, 200, 200 ],
                minSize: [32, 32], // min crop size
                aspectRatio : 1, // keep aspect ratio 1:1
                bgFade: true, // use fade effect
                bgOpacity: .3, // fade opacity
                onChange: updateInfo,
                onSelect: updateInfo,
                onRelease: clearInfo
            }, function(){
 
                // use the Jcrop API to get the real image size
                var bounds = this.getBounds();
                boundx = bounds[0];
                boundy = bounds[1];
 
                // Store the Jcrop API in the jcrop_api variable
                jcrop_api = this;
            });
        };
    };
 // update info by cropping (onChange and onSelect events handler)
    function updateInfo(e) {
    	
        
        $('#x').val(e.x);
        $('#y').val(e.y);
        $('#w').val(e.w);
        $('#h').val(e.h);
        
        if (parseInt(e.w) > 0) {
            var rx = xsize / e.w;
            var ry = ysize / e.h;
            $pimg.css({
                width : Math.round(rx * boundx) + 'px',
                height : Math.round(ry * boundy) + 'px',
                marginLeft : '-' + Math.round(rx * e.x) + 'px',
                marginTop : '-' + Math.round(ry * e.y) + 'px'
            });
        }
    };
}
$("#close,#resetBtn").bind("click",function(){
    alert("wwwee");
    $("#popUp-box-mask,#uploadimg-control").css("display","none");          
    $("#preview").attr("src",' ');
      $('#w').val('');
        $('#h').val('');
        $('#x1').val("");
        $('#x2').val("");
        $('#y1').val("");
        $('#y2').val("");
});