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

<title>글 조회</title>

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

		//글 수정하기 클릭
		$("#updateBtn").on("click", function() {
			var activeValue = $("#active").is(":checked");
			$("#activeValue").val(activeValue)
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "${cp }/boardOneUpdate");
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





		<div id="if_list_div"
			style="position: relative; padding: 0; overflow: auto; height: 750px;">
			<div class="content-wrapper" style="min-height: 584px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<div class="container-fluid">
						<div class="row md-2">
							<div class="col-sm-6">
								<h1>글 수정</h1>
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">글</li>
									<li class="breadcrumb-item">수정</li>
								</ol>
							</div>
						</div>
					</div>
				</section>
				<!-- Main content -->
				<section class="content">


					<div class="card">


						<!-- 넘겨줄 히든 값. -->
						<form id="frm">
							<!-- 사용자 아이디 값 -->
							<input type="hidden" id="userid" name="userid"
								value="${S_USER.userid }" />
							<!-- 게시판 조회/수정시 사용 bcode, title, active-->
							<input type="hidden" id="bcode" name="bcode"
								value="${boardVo.bcode }" /> <input type="hidden" id="originno"
								name="originno" value="${boardVo.originno }" /> <input
								type="hidden" id="writer" name="writer"
								value="${boardVo.writer }" /> <input type="hidden"
								id="activeValue" name="activeValue" value="" />
							<!--  <input type="hidden" id="title"
				name="title" value="" /> <input type="hidden" id="context"
				name="context" value="" /><input type="hidden" id="active"
				name="active" value="" />  -->
							<!-- 생성 시 사용 -->



							<%-- 	<!-- card header -->
						<%@ include file="/common/cardheadersearchbar.jsp"%> --%>
							<div class="card-body" style="text-align: left;">
								<div>${S_USER.userid }님
									<br>글 수정 할수 있습니다.
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-12">
										<!-- summernote 추가 -->
										실제 글번호 : ${boardVo.bcode }<br> 게시판번호 : ${boardVo.originno }<br>
										글 번호 : ${boardVo.groupord } <br>


										<hr>
										작성자 : <input value="${boardVo.writer }" readonly="readonly" />
										<br> 제&nbsp;&nbsp;&nbsp;목 : <input type="text" id="title"
											name="title" value="${boardVo.title }" /> 공개/삭제 <input
											type="checkbox" id="active" name="active"
											<c:choose>
<c:when test="${boardVo.active == 0 }"> value="0" checked="checked"</c:when>
<c:otherwise>value="1" </c:otherwise>
</c:choose>>
										<br> <br>
										<textarea id="summernote" name="summernote">
											${boardVo.content }
										</textarea>
										<hr>
										<div style="text-align: right;">
											<button type="button" class="btn btn-primary" id="golistBtn"
												name="golistBtn"
												onclick="location.href='${cp }/boardOneSelect?bcode=${boardVo.originno }';">목록으로</button>
											<button type="button" class="btn btn-primary" id="updateBtn"
												name="updateBtn"
												<c:if test="${S_USER.userid  != boardVo.writer}"> style="display: none;"</c:if>>글수정완료</button>
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



	</div>

	<!-- Main Footer -->
	<%@ include file="/common/mainfooter.jsp"%>
	<!-- ./wrapper -->
	<%-- <!-- REQUIRED SCRIPTS -->
	<%@ include file="/common/jqBootLte.jsp"%> --%>
</body>
</html>