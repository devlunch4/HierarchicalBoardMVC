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

<title>메인</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="./resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="./resources/bootstrap/dist/css/adminlte.min.css">


<!-- summernote script -->
<%@ include file="/common/summerNoteScript.jsp"%>

</head>
<body class="hold-transition sidebar-mini">
	<input type="hidden" id="userid" name="userid"
		value="${S_USER.userid }" />

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
								<h1>메인</h1>
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">메인</li>
									<li class="breadcrumb-item">화면</li>
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
							<div>
								${S_USER.userid } 님 반갑습니다.<br> 접속 시간은 ${logintime } 입니다.<br>
								화면이동은 상단바, 또는 좌측 상단을 눌러 왼쪽바로 이동해주세요~<br> 아래 게시판 링크를 클릭하면 해당
								게시판으로 이동됩니다<br><br>
								게시판테이블내 게시판이 일종의 글로 인식이 되며 해당 게시판>>>글로 계층이 구분됩니다.<br>
								해당 DB set table sql, insert sql, exerd 파일 등의 DB정보파일은 프로젝트 내 dbsqlSet 폴더에 있습니다.
								
							</div>
							<hr>
							<div>
								*사용된 테이블 구조(이미지)<br>
								<br> <img alt="#" src="../dbsqlSet/hBoard_shot.png">
							</div>
							<hr>
							<div style="margin-left: 10%;">
								<c:forEach items="${boardList }" var="boardList">
									<div
										<c:if test="${boardList.active == '1' }"> style="display: none;"</c:if>>
										<div class="info">
											<div class="row">
												<a class="col-md-8"
													href="/pagingBoard?bcode=${boardList.bcode }"
													<c:if test="${boardList.active == '1' }"> style="display: none;"</c:if>>${boardList.title }</a>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
							<!-- <div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered">
										<tbody>
											<tr>
												<th>수행</th>
												<th>완료</th>
											</tr>

										</tbody>
									</table>
								</div>
								col-sm-12
							</div> -->
							<!-- row -->
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
	<%-- 	<%@ include file="/common/jqBootLte.jsp"%> --%>
</body>
</html>