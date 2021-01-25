<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="/main.jsp" class="brand-link"> <img
		src="./resources/images/line.png"
		class="brand-image img-circle elevation-3" style="opacity: .8">
		<span class="brand-text font-weight-light">메인화면이동</span>
	</a>
	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="./profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="#" class="d-block">접속자: ${S_USER.userid}</a>
				</div>
			</div>
		</div>

		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="./profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="/boardCreateMove" class="d-block">게시판
						생성</a>
				</div>
			</div>
		</div>


		<c:forEach items="${boardList }" var="boardList">
			<div class="user-panel mt-3 pb-3 mb-3" <c:if test="${boardList.active == '1' }"> style="display: none;"</c:if>>
				<div class="info">
					<div class="row">
						<a class="col-md-8"
							href="/boardOneSelect?bcode=${boardList.bcode }" <c:if test="${boardList.active == '1' }"> style="display: none;"</c:if>>${boardList.title }</a>
					</div>
				</div>
			</div>
		</c:forEach>


		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img src="./profile/sally.png" class="img-circle elevation-2"
					alt="User Image">
			</div>
			<div class="info">
				<div class="row">
					<a class="col-md-8" href="/logout" class="d-block">로그아웃</a>
				</div>
			</div>
		</div>


		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column subMenuList"
				data-widget="treeview" data-accordion="false">

			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>