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

<title>게시판</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="./resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="./resources/bootstrap/dist/css/adminlte.min.css">


<script src="<c:url value="/js/jquery.min.js" />"></script>
<!-- summernote script -->
<%@ include file="/common/summerNoteScript.jsp"%>
<script>
	$(document).ready(function() {
		$('#summernote').summernote();
	});
</script>
<script type="text/javascript">
	$(function() {

		//글 작성완료 클릭시
		$("#writeBtn").on("click", function() {
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "${cp }/boardWrite");
			$("#frm").submit();
		});

	});
</script>

</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<%@ include file="/common/navi.jsp"%>
		<!-- Main Sidebar Container -->
		<%@ include file="/common/mainside.jsp"%>

		<!-- 넘겨줄 히든 값. -->
		<form id="frm" enctype="multipart/form-data">
			<!-- 사용자 아이디 값 -->
			<input type="hidden" id="userid" name="userid"
				value="${S_USER.userid }" />
			<!-- 게시판 조회/수정시 사용 bcode, title, active-->
			<input type="hidden" id="parentBcode" name="parentBcode"
				value="${parentBoardVo.originno }" />
			<%-- 	<input type="hidden" id="bcode"
				name="bcode" value="${parentBoardVo.bcode }" /> --%>
				<input type="hidden" id="groupord"
				name="groupord" value="${parentBoardVo.groupord }" />  
						<input type="hidden" id="grouplayer"
				name="grouplayer" value="${parentBoardVo.grouplayer + 1}" />  
			<!-- <input type="hidden" id="title"
				name="title" value="" /> <input type="hidden" id="context"
				name="context" value="" /><input type="hidden" id="active"
				name="active" value="" /> -->
			<!-- 생성 시 사용 -->



			<div id="if_list_div"
				style="position: relative; padding: 0; overflow: auto; height: 750px;">
				<div class="content-wrapper" style="min-height: 584px;">
					<!-- Content Header (Page header) -->
					<section class="content-header">
						<div class="container-fluid">
							<div class="row md-2">
								<div class="col-sm-6">
									<h1>답글 작성</h1>
								</div>
								<div class="col-sm-6">
									<ol class="breadcrumb float-sm-right">
										<li class="breadcrumb-item">답글</li>
										<li class="breadcrumb-item">작성</li>
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
								<div>${S_USER.userid }님
									<br>답글작성을 할수 있습니다.<br> 원글 정보 :
									bcode:${parentBoardVo.bcode } originno:${parentBoardVo.originno }
									title:${parentBoardVo.title }
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-12">
										<!-- summernote 추가 -->
										제목 : <input type="text" id="title" name="title" value="" /> <br>
										<br>
										<textarea id="summernote" name="summernote">
											<p>답글 작성 내용 입력</p>
										</textarea>
										<div style="text-align: right;">
											<button type="button" class="btn btn-primary" id="writeBtn"
												name="writeBtn">답글 작성완료</button> <button type="button" class="btn btn-primary" id="golistBtn"
											name="golistBtn"
											onclick="location.href='${cp }/boardOneSelect?bcode=${parentBoardVo.originno }';">답글작성취소</button>
										</div>
										

									</div>
									<!-- col-sm-12 -->
								</div>


							</div>
							<!-- card-body -->
							<!-- card-footer -->
						</div>
						<!-- card  -->
					</section>
				</div>
			</div>
		</form>
	</div>

	<!-- Main Footer -->
	<%@ include file="/common/mainfooter.jsp"%>
	<!-- ./wrapper -->
	<%-- <!-- REQUIRED SCRIPTS -->
	<%@ include file="/common/jqBootLte.jsp"%> --%>
</body>
</html>