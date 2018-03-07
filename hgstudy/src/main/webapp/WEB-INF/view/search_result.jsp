<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta name="author" content="ycw">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <!-- 全局js -->
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/top.js"></script>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<title>查询结果</title>
</head>
<body>
<%@ include file="top.jsp" %>
<article>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div>
                    <h5>共<label>${pagebean.rowCount}</label>条与<label>${keyword }</label>相关的结果</h5>
                </div>
                <div class="tab-content">
                	<c:if test="${pagebean.rowCount == 0}">
                		<br>
                		<p><h4>没有您所查找的结果</h4></p>
                	</c:if>
                	<c:if test="${pagebean.rowCount != 0}">
                    <div role="tabpanel" class="tab-pane active" id="course-hot">
                        <br>
                        <c:forEach var="course" items="${pagebean.contents}">
	                        <div class="row">
	                            <div class="col-sm-4">
	                                <a href="selectCourseInfor?couid=${course.couId}"><img class="img-responsive" src="${course.couImg}" alt=""></a>
	                            </div>
	                            <div class="col-sm-8">
	                            	<p><h4>${course.couName}</h4></p>
	                            	<p class="search-result-p">${course.couSchool} &nbsp;&nbsp;&nbsp;&nbsp; <a href="showTeacherInfor?teaid=${course.tea.teaId}}">${course.tea.teaName}</a></p>
	                                <p>${course.couinfor}</p>
	                            </div>
	                        </div>
	                        <hr>
						</c:forEach> 

			            <nav aria-label="Page navigation" class="text-center">
			                <ul class="pagination">
			                	<li><a href="searchCourses?curpage=1&keyword=${keyword}">首页</a> </li>
			                	
			                	<c:if test="${curpage>1}">
			                		<li>
			                        	<a href="searchCourses?curpage=${curpage-1}&keyword=${keyword}" aria-label="Previous">
			                            	<span aria-hidden="true">&laquo;</span>
			                        	</a>
			                   		</li>
								</c:if> 
								
								<c:forEach begin="${pagebean.star}" end="${pagebean.end}" var="i">
									<c:if test="${curpage==i}">
										<li class="active"><span aria-hidden="true">${i }</span></li>
									</c:if>
									<c:if test="${curpage!=i}">
										<li><a href="searchCourses?curpage=${i}&keyword=${keyword}" aria-label="Next">
												<span aria-hidden="true">${i }</span>
										</a></li>
									</c:if>
								</c:forEach>
								
								<c:if test="${pagebean.curPage<pagebean.pageCount}">
			                		<li>
			                        	<a href="searchCourses?curpage=${curpage+1}&keyword=${keyword}" aria-label="Next">
			                            	<span aria-hidden="true">&raquo;</span>
			                        	</a>
			                   		</li>
								</c:if> 
								<li><a href="searchCourses?curpage=${pagebean.pageCount}&keyword=${keyword}">末页</a> </li>
			                </ul>
			            </nav>
                    </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</article>
</body>
</html>