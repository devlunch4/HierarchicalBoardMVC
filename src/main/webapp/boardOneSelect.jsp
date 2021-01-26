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

<title>하나의 게시판 조회</title>

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

		//해당 글을 클릭하여 내용 조회시
		$(".oneBoard").on("click", function() {
			var bcode = $(this).data("bcode");
			$("#bcode").val(bcode);
			var writer = $(this).data("writer");
			$("#writer").val(writer);

			$("#frm").attr("method", "post");
			$("#frm").attr("action", "${cp}/readOneBoard");
			$("#frm").submit();
		});

		//글쓰기 버튼 클릭시
		$("#writeBtn").on("click", function() {
			$("#frm").attr("method", "get");
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
		<form id="frm">
			<!-- 사용자 아이디 값 -->
			<input type="hidden" id="userid" name="userid"
				value="${S_USER.userid }" />

			<!-- 게시판 조회/수정시 사용 bcode, title, active 글쓰기 에서 가져옴-->
			<input type="hidden" id="bcode" name="bcode" value="${bcode }" />
			<!-- 게시글 클릭시 필요 정보 -->
			<input type="hidden" id="writer" name="writer" value="" />

			<!-- 			 <input
				type="hidden" id="originno" name="originno" value="" /> <input
				type="hidden" id="groupord" name="groupord" value="" /> <input
				type="hidden" id="grouplayer" name="grouplayer" value="" /> <input
				type="hidden" id="writer" name="writer" value="" /> <input
				type="hidden" id="title" name="title" value="" /> <input
				type="hidden" id="active" name="active" value="" /> -->

			<!-- 생성 시 사용 -->
			<!-- <input type="hidden" id="addBName" name="addBName" value="" /> -->
		</form>

		<div id="if_list_div"
			style="position: relative; padding: 0; overflow: auto; height: 750px;">
			<div class="content-wrapper" style="min-height: 584px;">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<div class="container-fluid">
						<div class="row md-2">
							<div class="col-sm-6">
								<h1>게시판 조회</h1>
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">게시판</li>
									<li class="breadcrumb-item">조회</li>
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
								<br>선택한 ${boardtitle} 게시판을 확인할수 있습니다.
							</div>
							<hr>
							<form id="frm2">
								<div class="row">
									<div class="col-sm-12">
										<table class="table table-bordered">
											<tbody>
												<tr>
													<th>게시번호</th>
													<th>제목</th>
													<th>작성자</th>
													<th>작성일</th>
													<!-- yyyy-MM-dd  -->
												</tr>
												<c:forEach items="${oneBoardList }" var="oneBoardList"
													varStatus="loop">
													<tr class="oneBoard" data-bcode="${oneBoardList.bcode }"
														data-writer="${oneBoardList.writer }">
														<td>${oneBoardList.groupord }-${oneBoardList.grouplayer }</td>



														<td><c:if test="${oneBoardList.grouplayer > 1}">
																<c:forEach begin="2" end="${oneBoardList.grouplayer }">==></c:forEach>
														RE :
														</c:if> <c:choose>
																<c:when test="${oneBoardList.active == 0}">${oneBoardList.title }</c:when>
																<c:otherwise>삭제 처리 되었습니다.</c:otherwise>
															</c:choose></td>



														<td>${oneBoardList.writer }</td>
														<td><fmt:formatDate
																value="${oneBoardList.reg_datetime }"
																pattern="yyyy-MM-dd" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<!-- col-sm-12 -->
								</div>
							</form>
							<!-- row -->
						</div>


						<!-- card-body -->
						<div class="card-footer">
							<nav aria-label="member list Navigation">
								<ul class="pagination justify-content-center m-0">
									<li class="page-item"><a class="page-link"
										href="${cp }/pagingUser?page=1&pageSize=${pagevo.pageSize }"><i
											class="fas fa-angle-double-left"></i></a></li>


									<li class="page-item"><a class="page-link"
										href="${cp }/pagingUser?page=
<c:choose>
<c:when test="${pagevo.getPage()- 1 <= 0 }">1</c:when>
<c:otherwise>${pagevo.getPage()- 1}</c:otherwise>
</c:choose>&pageSize=${pagevo.pageSize }"><i
											class="fas fa-angle-left"></i></a></li>

									<c:forEach begin="1" end="${pagination }" var="i">
										<c:choose>
											<c:when test="${pagevo.page == i }">

												<li class="page-item active"><a class="page-link"
													href="#">${i }</a></li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link"
													href="${cp }/pagingUser?page=${i }&pageSize=${pagevo.pageSize }">${i }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<li class="page-item"><a class="page-link"
										href="${cp }/pagingUser?page=
<c:choose>
<c:when test="${pagevo.getPage()+ 1 > pagination }">${pagination }</c:when>
<c:otherwise>${pagevo.getPage()+ 1}</c:otherwise>
</c:choose>&pageSize=${pagevo.pageSize }"><i
											class="fas fa-angle-right"></i></a></li>



									<li class="page-item"><a class="page-link"
										href="${cp }/pagingUser?page=${pagination }&pageSize=${pagevo.pageSize }"><i
											class="fas fa-angle-double-right"></i></a></li>
								</ul>
							</nav>
						</div>

						<!-- card-footer -->
					</div>
					<!-- card  -->
					<button type="button" class="btn btn-primary" id="writeBtn"
						name="writeBtn">글쓰기</button>
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