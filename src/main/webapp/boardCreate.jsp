<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>게시판 생성</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="./resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="./resources/bootstrap/dist/css/adminlte.min.css">

</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<%@ include file="/common/navi.jsp"%>
		<!-- Main Sidebar Container -->
		<%@ include file="/common/mainside.jsp"%>


		<div id="if_list_div"
			style="position: relative; padding: 0; overflow: hidden; height: 750px;">
			<div class="content-wrapper" style="min-height: 584px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<div class="container-fluid">
						<div class="row md-2">
							<div class="col-sm-6">
								<h1>게시판 생성</h1>
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">게시판</li>
									<li class="breadcrumb-item">생성</li>
								</ol>
							</div>
						</div>
					</div>
				</section>
				<!-- Main content -->
				<section class="content">

					<div class="card">
						<%-- 	<!-- card header -->
						<%@ include file="/common/cardheadersearchbar.jsp"%> --%>
						<div class="card-body" style="text-align: left;">
							<div>${S_USER.userid }님 <br>게시판 현황을 확인할수 있습니다.</div>
							<hr>

							<!-- add board -->
							<input type="text" id="addBoardName" name="addBoardName"
								placeholder="추가할 게시판 이름 입력"> <input type="button"
								id="addBoardBtn" name="addBoardBtn" value="게시판 생성"
								onclick="/boardCreate">
							<hr>

							<!-- read active/nonactive board -->
							조회된 게시판 출력<br> FOR>>>>> 조건 BCODE == ORIGINNO 이고 GROUPORD =0
							GROUPLAYER=0 <br> <input type="button" id="bcode${i.bcode }"
								name="bcode ${i.bcode }" value="${i.title }" onclick="#">
							<br> select * from board

						</div>
						<!-- card-body -->
						<!-- card-footer -->
					</div>
					<!-- card  -->
				</section>
			</div>
		</div>
	</div>

	<!-- Main Footer -->
	<%@ include file="/common/mainfooter.jsp"%>
	<!-- ./wrapper -->
	<!-- REQUIRED SCRIPTS -->
	<%@ include file="/common/jqBootLte.jsp"%>
</body>
</html>