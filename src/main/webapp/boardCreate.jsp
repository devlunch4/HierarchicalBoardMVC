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
<script type="text/javascript">
	$(function() {

		//수정 버튼 클릭시-게시판 정보수정/활성상태수정
		$(".bUpdateBtn")
				.on(
						"click",
						function() {
							var userid = $("#userid").val();

							var bcode = $(this).data("bcode");
							var title = $("#title" + bcode).val();
							var active = $("#activeSlt" + bcode).val();
							
							$("#bcode").val(bcode);
							$("#title").val(title);
							$("#active").val(active);
							alert("게시판 수정 클릭후 hidden frm 설정 \n bcode 값: "
									+ bcode + "\n title 값: " + title
									+ "\n active 값: " + active +"\n 사용자 아이디 : "+userid);
							$("#frm").attr("method", "post");
							$("#frm").attr("action", "${cp }/boardActUpdate");
							$("#frm").submit();
						});

		//게시판 추가버튼 클릭시
		$("#addBoardBtn").on(
				"click",
				function() {
					var userid = $("#userid").val();
					
					var addBoardName = $("#addBoardName").val();
					$("#addBName").val(addBoardName);
					var addBName = $("#addBName").val();
					alert("검색게시판 추가 \n 클릭후 hidden frm 설정 \n bcode 값: " + bcode
							+ "\n title 값: " + title + "\n active 값: " + active
							+ "\n\n\n" + "추가할 게시판 이름 : " + addBName +"\n 사용자 아이디 : "+userid);
					//userid, title.
					$("#frm").attr("method", "post");
					$("#frm").attr("action", "${cp }/boardCreateMove");
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
		<form id="frm">
			<!-- 사용자 아이디 값 -->
			<input type="hidden" id="userid" name="userid" value="${S_USER.userid }" />
			<!-- 게시판 조회/수정시 사용 bcode, title, active-->
			<input type="hidden" id="bcode" name="bcode" value="" /> <input
				type="hidden" id="title" name="title" value="" /> <input
				type="hidden" id="active" name="active" value="" />
			<!-- 생성 시 사용 -->
			<input type="hidden" id="addBName" name="addBName" value="" />
		</form>

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
							<div>${S_USER.userid }님
								<br>게시판 현황을 확인할수 있습니다.
							</div>
							<hr>

							<!-- add board -->
							<form action="${cp }/boardCreateMove" method="POST">
								<input type="text" id="addBoardName" name="addBoardName"
									placeholder="추가할 게시판 이름 입력"> <input type="button"
									id="addBoardBtn" name="addBoardBtn" value="게시판추가">
							</form>
							<hr>

							<form id="frmboardInfo">
								<c:forEach items="${boardList }" var="boardList">
									<div class="boardList" data-bcode="${boardList.bcode }">
										<!-- 게시글 이름 -->
										게시글 이름 : <input type="text" id="title${boardList.bcode }"
											name="title${boardList.bcode }" value="${boardList.title }" />
										<!-- 활성 상태 -->
										<select class="bUpdateSlt" id="activeSlt${boardList.bcode }"
											name="activeSlt${boardList.bcode }">
											<option value="0"
												<c:if test="${boardList.active == 0 }"> selected </c:if>>활성</option>
											<option value="1"
												<c:if test="${boardList.active == 1 }"> selected </c:if>>비활성</option>
										</select> <input class="bUpdateBtn" type="button" id="updateBtn"
											name="updateBtn" data-bcode="${boardList.bcode }" value="수정" />
									</div>
								</c:forEach>
							</form>
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
	<%-- <%@ include file="/common/jqBootLte.jsp"%> --%>
</body>
</html>