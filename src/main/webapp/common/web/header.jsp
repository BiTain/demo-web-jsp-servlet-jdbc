<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#home">Start Bootstrap</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav ml-auto">
				<li><a href="#about">Trang chủ</a></li>
				<c:if test="${not empty USERMODEL}">
					<li class="nav-item">
						<a class="nav-link" href="#"> Wellcome ,${USERMODEL.fullName}</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="<c:url value='/thoat?action=logout'/>">Thoát</a>
					</li>
				</c:if>
				
				<c:if test="${empty USERMODEL}">
					<li class="nav-item">
						<a class="nav-link" href="<c:url value='/dang-nhap?action=login'/>">Đăng nhập</a>
					</li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>