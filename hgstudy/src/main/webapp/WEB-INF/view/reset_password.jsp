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
    <base href="<%=basePath%>" id="base">
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
                <div class="panel-body">
                    <form role="form" id="set-password">
                        <fieldset>
                            <div class="form-group" style="height: 230px">
                                <h3 align=center>重新设置密码</h3>
                                <input type="password" class="form-control" style="margin-top: 40px;height: 50px" placeholder="新密码" name="password" id="password"  autofocus>

                                <input type="password" class="form-control" style="margin-top: 40px;height: 50px" placeholder="重复新密码" name="repassword" id="repassword">
                                <input type="hidden"  name="token" value="${param.token}">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <a onclick="setPassword()" class="btn btn-lg btn-success btn-block">确定</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    /* to convert strings to a list of ascii values */
    var sAscii = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var sAscii = sAscii + "[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    /* convert integer to hex string */
    var sHex = "0123456789ABCDEF";
    function hex(i){
        h = "";
        for(j = 0; j <= 3; j++){
            h += sHex.charAt((i >> (j * 8 + 4)) & 0x0F) +
                sHex.charAt((i >> (j * 8)) & 0x0F);
        }
        return h;
    }
    /* add, handling overflows correctly */
    function add(x, y) {
        return ((x&0x7FFFFFFF) + (y&0x7FFFFFFF)) ^ (x&0x80000000) ^ (y&0x80000000);
    }
    /* MD5 rounds functions */
    function R1(A, B, C, D, X, S, T) {
        q = add(add(A, (B & C) | (~B & D)), add(X, T));
        return add((q << S) | ((q >> (32 - S)) & (Math.pow(2, S) - 1)), B);
    }
    function R2(A, B, C, D, X, S, T) {
        q = add(add(A, (B & D) | (C & ~D)), add(X, T));
        return add((q << S) | ((q >> (32 - S)) & (Math.pow(2, S) - 1)), B);
    }
    function R3(A, B, C, D, X, S, T) {
        q = add(add(A, B ^ C ^ D), add(X, T));
        return add((q << S) | ((q >> (32 - S)) & (Math.pow(2, S) - 1)), B);
    }
    function R4(A, B, C, D, X, S, T) {
        q = add(add(A, C ^ (B | ~D)), add(X, T));
        return add((q << S) | ((q >> (32 - S)) & (Math.pow(2, S) - 1)), B);
    }
    /* main entry point */
    function calcMD5(sInp){
        /* Calculate length in machine words, including padding */
        wLen = (((sInp.length + 8) >> 6) + 1) << 4;
        var X = new Array(wLen);
        /* Convert string to array of words */
        j = 4;
        for (i = 0; (i * 4) < sInp.length; i++) {
            X[i] = 0;
            for (j = 0; (j < 4) && ((j + i * 4) < sInp.length); j++) {
                X[i] += (sAscii.indexOf(sInp.charAt((i * 4) + j)) + 32) << (j * 8);
            }
        }
        /* Append padding bits and length */
        if (j == 4) {
            X[i++] = 0x80;
        }
        else {
            X[i - 1] += 0x80 << (j * 8);
        }
        for(; i < wLen; i++) {
            X[i] = 0;
        }
        X[wLen - 2] = sInp.length * 8;
        /* hard-coded initial values */
        a = 0x67452301;
        b = 0xefcdab89;
        c = 0x98badcfe;
        d = 0x10325476;
        /* Process each 16-word block in turn */
        for (i = 0; i < wLen; i += 16) {
            aO = a;
            bO = b;
            cO = c;
            dO = d;
            a = R1(a, b, c, d, X[i+ 0], 7 , 0xd76aa478);
            d = R1(d, a, b, c, X[i+ 1], 12, 0xe8c7b756);
            c = R1(c, d, a, b, X[i+ 2], 17, 0x242070db);
            b = R1(b, c, d, a, X[i+ 3], 22, 0xc1bdceee);
            a = R1(a, b, c, d, X[i+ 4], 7 , 0xf57c0faf);
            d = R1(d, a, b, c, X[i+ 5], 12, 0x4787c62a);
            c = R1(c, d, a, b, X[i+ 6], 17, 0xa8304613);
            b = R1(b, c, d, a, X[i+ 7], 22, 0xfd469501);
            a = R1(a, b, c, d, X[i+ 8], 7 , 0x698098d8);
            d = R1(d, a, b, c, X[i+ 9], 12, 0x8b44f7af);
            c = R1(c, d, a, b, X[i+10], 17, 0xffff5bb1);
            b = R1(b, c, d, a, X[i+11], 22, 0x895cd7be);
            a = R1(a, b, c, d, X[i+12], 7 , 0x6b901122);
            d = R1(d, a, b, c, X[i+13], 12, 0xfd987193);
            c = R1(c, d, a, b, X[i+14], 17, 0xa679438e);
            b = R1(b, c, d, a, X[i+15], 22, 0x49b40821);
            a = R2(a, b, c, d, X[i+ 1], 5 , 0xf61e2562);
            d = R2(d, a, b, c, X[i+ 6], 9 , 0xc040b340);
            c = R2(c, d, a, b, X[i+11], 14, 0x265e5a51);
            b = R2(b, c, d, a, X[i+ 0], 20, 0xe9b6c7aa);
            a = R2(a, b, c, d, X[i+ 5], 5 , 0xd62f105d);
            d = R2(d, a, b, c, X[i+10], 9 , 0x2441453);
            c = R2(c, d, a, b, X[i+15], 14, 0xd8a1e681);
            b = R2(b, c, d, a, X[i+ 4], 20, 0xe7d3fbc8);
            a = R2(a, b, c, d, X[i+ 9], 5 , 0x21e1cde6);
            d = R2(d, a, b, c, X[i+14], 9 , 0xc33707d6);
            c = R2(c, d, a, b, X[i+ 3], 14, 0xf4d50d87);
            b = R2(b, c, d, a, X[i+ 8], 20, 0x455a14ed);
            a = R2(a, b, c, d, X[i+13], 5 , 0xa9e3e905);
            d = R2(d, a, b, c, X[i+ 2], 9 , 0xfcefa3f8);
            c = R2(c, d, a, b, X[i+ 7], 14, 0x676f02d9);
            b = R2(b, c, d, a, X[i+12], 20, 0x8d2a4c8a);
            a = R3(a, b, c, d, X[i+ 5], 4 , 0xfffa3942);
            d = R3(d, a, b, c, X[i+ 8], 11, 0x8771f681);
            c = R3(c, d, a, b, X[i+11], 16, 0x6d9d6122);
            b = R3(b, c, d, a, X[i+14], 23, 0xfde5380c);
            a = R3(a, b, c, d, X[i+ 1], 4 , 0xa4beea44);
            d = R3(d, a, b, c, X[i+ 4], 11, 0x4bdecfa9);
            c = R3(c, d, a, b, X[i+ 7], 16, 0xf6bb4b60);
            b = R3(b, c, d, a, X[i+10], 23, 0xbebfbc70);
            a = R3(a, b, c, d, X[i+13], 4 , 0x289b7ec6);
            d = R3(d, a, b, c, X[i+ 0], 11, 0xeaa127fa);
            c = R3(c, d, a, b, X[i+ 3], 16, 0xd4ef3085);
            b = R3(b, c, d, a, X[i+ 6], 23, 0x4881d05);
            a = R3(a, b, c, d, X[i+ 9], 4 , 0xd9d4d039);
            d = R3(d, a, b, c, X[i+12], 11, 0xe6db99e5);
            c = R3(c, d, a, b, X[i+15], 16, 0x1fa27cf8);
            b = R3(b, c, d, a, X[i+ 2], 23, 0xc4ac5665);
            a = R4(a, b, c, d, X[i+ 0], 6 , 0xf4292244);
            d = R4(d, a, b, c, X[i+ 7], 10, 0x432aff97);
            c = R4(c, d, a, b, X[i+14], 15, 0xab9423a7);
            b = R4(b, c, d, a, X[i+ 5], 21, 0xfc93a039);
            a = R4(a, b, c, d, X[i+12], 6 , 0x655b59c3);
            d = R4(d, a, b, c, X[i+ 3], 10, 0x8f0ccc92);
            c = R4(c, d, a, b, X[i+10], 15, 0xffeff47d);
            b = R4(b, c, d, a, X[i+ 1], 21, 0x85845dd1);
            a = R4(a, b, c, d, X[i+ 8], 6 , 0x6fa87e4f);
            d = R4(d, a, b, c, X[i+15], 10, 0xfe2ce6e0);
            c = R4(c, d, a, b, X[i+ 6], 15, 0xa3014314);
            b = R4(b, c, d, a, X[i+13], 21, 0x4e0811a1);
            a = R4(a, b, c, d, X[i+ 4], 6 , 0xf7537e82);
            d = R4(d, a, b, c, X[i+11], 10, 0xbd3af235);
            c = R4(c, d, a, b, X[i+ 2], 15, 0x2ad7d2bb);
            b = R4(b, c, d, a, X[i+ 9], 21, 0xeb86d391);
            a = add(a, aO);
            b = add(b, bO);
            c = add(c, cO);
            d = add(d, dO);
        }
        return hex(b) + hex(c);
    }

    function setPassword(){
        var pass = document.getElementById("password").value;
        var repass = document.getElementById("repassword").value;
        if(pass != repass){
            alert("两次密码不一致，请重新输入！")
           return false;
        }
        document.getElementById("password").value=calcMD5(pass).toLowerCase();

        var form = new FormData(document.getElementById("set-password"));

        $.ajax({
            url:document.getElementById("base").href+"/editPassword",
            type:"post",
            data:form,
            processData:false,
            contentType:false,
            success:function(data){
                if(data.success == true){
                    alert("修改密码成功！请重新登录");
                }else {
                    alert(data.message);
                }
            },
            error:function(e){
                alert("错误！！");
            }
        });
    }
</script>
</body>

</html>
