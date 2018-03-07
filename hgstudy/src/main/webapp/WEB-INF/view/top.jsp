<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
    <section class="topWrap">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid" id="nvabar-container">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="navbar-header">
                    <a class="" ><img class="img-responsive logo" src="img/logo.png" style="margin-right: 20px"></a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" id="top">
                    <ul class="nav navbar-nav text-center">
                        <li class="dropdown"><a href="index" class="dropdown-toggle">首页</a></li>
                        <li class="dropdown"><a href="selectCourses?curpage=1" class="dropdown-toggle">课程</a></li>
                    </ul>
                    <form class="navbar-form navbar-right" role="search" action="searchCourses" onsubmit="return checkSearch();">
                        <div class="form-group">
                            <input type="text" class="form-control" id="search" name="keyword" placeholder="Search">
                        </div>
                        <input name="curpage" type="hidden" value=1 />
                        <button type="submit" class="btn btn-default">搜索</button>
                        <span class="dropdown">
                        	<c:if test="${empty user}">
								<a href="login.jsp"><img src="img/user.png" alt=".." class="dropdown-toggle img-circle head-top"></a>
							</c:if>
							<c:if test="${not empty user}">
                            <a href="ShowInforAction"><img src="img/userhover.png" alt=".." class="dropdown-toggle img-circle head-top"></a>
                            <ul class="dropdown-menu" role="menu">
                                <c:if test="${'student' == userType}">
                            		<li><a href="stuInfor">个人中心</a></li>
                            	</c:if>
                            	<c:if test="${'teacher' == userType}">
                            		<li><a href="teaInfor">个人中心</a></li>
                            	</c:if> 
                                <li><a href="html/editpassword.jsp">修改密码</a></li>
                                <li><a href="logout">退出</a></li>
                            </ul>
                            </c:if>
                        </span>

                    </form>
                </div>
            </div>
        </nav>
    </section>
</header>
<script language="JavaScript">
		function checkSearch() {
			var search = document.getElementById("search").value;
			if (search.length > 0) {
				return true;
			}
			else{
				alert("请先输入关键字");
				return false;
			}
		}		
	</script>