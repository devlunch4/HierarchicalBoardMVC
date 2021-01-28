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
			$("#frm").attr("action", "${cp }/boardOneUpdateMove");
			$("#frm").submit();
		});

		//답글 작성하기 클릭
		$("#reBoardBtn").on("click", function() {
			$("#frm").attr("method", "post");
			$("#frm").attr("action", "${cp }/boardReWriteMove");
			$("#frm").submit();
		});

		//$("#replyBtn").on("click", function() {
		//댓글 작성하기 클릭
		$("#replyWriteBtn").on("click", function() {
			//필요 정보 
			//원글replyBcode ok
			//활성값 replyActive 0 set
			$("#replyActive").val(0);
			//내용 replyContent ok
			//작성자 replyWriter ok
			//날짜 servlet auto
			$("#frm2").attr("method", "post");
			$("#frm2").attr("action", "${cp }/replyWrite");
			$("#frm2").submit();
		});

		$(".oneReply").on("click", function() {
			alert("삭제 상태 설정됩니다.");
			var rcode = $(this).data("rcode")
			//삭제시 필요
			//rcode
			$("#replyRcode").val(rcode);
			//상태값
			$("#replyActive").val(1);

			$("#frm2").attr("method", "post");
			$("#frm2").attr("action", "${cp }/replyDelete");
			$("#frm2").submit();

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
								<h1>글 확인</h1>
							</div>
							<div class="col-sm-6">
								<ol class="breadcrumb float-sm-right">
									<li class="breadcrumb-item">글</li>
									<li class="breadcrumb-item">확인</li>
								</ol>
							</div>
						</div>
					</div>
				</section>
				<!-- Main content -->
				<section class="content">


					<div class="card">


						<!-- 넘겨줄 히든 값. -->
						<form id="frm" enctype="multipart/form-data">
							<!-- 사용자 아이디 값 -->
							<input type="hidden" id="userid" name="userid"
								value="${S_USER.userid }" />
							<!-- 게시판 조회/수정시 사용 bcode, title, active-->
							<!-- 현재글의 bcode -->
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
									<br>글 조회/수정/답글/댓글 작성을 할수 있습니다.
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-12">
										<!-- summernote 추가 -->
										실제 글번호 : ${boardVo.bcode } / 게시판번호 : ${boardVo.originno } / 글
										번호 : ${boardVo.groupord } <br>
										<hr>
										작성자 : <input value="${boardVo.writer }" readonly="readonly" />
										<br> 제&nbsp;&nbsp;&nbsp;목 : <input type="text" id="title"
											name="title" value="${boardVo.title }" readonly="readonly" />
										공개/삭제 <input type="checkbox" id="active" name="active"
											onclick="checkbox"
											<c:choose>
<c:when test="${boardVo.active == 0 }"> value="0" checked="checked"</c:when>
<c:otherwise>value="1" </c:otherwise>
</c:choose>>
										<br> <br>
										<textarea id="summernote" name="summernote"
											readonly="readonly">
											${boardVo.content }
										</textarea>
										<hr>

										<!-- 파일 정보 보여주는 공간 -->
										<!-- <input type="file" id="file1" class="form-control"
											name="file1" style="height: 37px;" accept=".gif, .jpg, .png"> -->
										파일코드: <label>${fileVo.fcode }</label> , 파일명 : <label>${fileVo.fname }</label>
										, 파일공개/삭제 <input type="checkbox" id="fileactive"
											name="fileactive" onclick="checkbox"
											<c:choose>
<c:when test="${fileVo.active == 0 }"> value="0" checked="checked"</c:when>
<c:otherwise>value="1" </c:otherwise>
</c:choose>>

										<hr>
										<div style="text-align: right;">
											<button type="button" class="btn btn-primary" id="golistBtn"
												name="golistBtn"
												onclick="location.href='${cp }/boardOneSelect?bcode=${boardVo.originno }';">목록으로</button>
											<button type="button" class="btn btn-primary" id="reBoardBtn"
												name="reBoardBtn">답글작성하기</button>

											<button type="button" class="btn btn-primary" id="updateBtn"
												name="updateBtn"
												<c:if test="${S_USER.userid  != boardVo.writer}"> style="display: none;"</c:if>>글수정하기</button>
										</div>
									</div>
									<!-- col-sm-12 -->
								</div>
							</div>
							<!-- card-body -->
							<!-- card-footer -->
						</form>
						<form id="frm2" name="frm2">
							<input type="hidden" id="replyBcode" name="replyBcode"
								value="${boardVo.bcode }" /> <input type="hidden"
								id="replyRcode" name="replyRcode" value="" /> <input
								type="hidden" id="replyActive" name="replyActive" value="" /> <input
								type="hidden" id="replyWriter" name="replyWriter"
								value="${S_USER.userid }" />


							<div style="margin-left: 5%;">*** 댓글 보기 ***</div>
							<table class="table table-bordered">
								<tr>
									<th>작성자</th>
									<th>댓글내용</th>
									<th>작성시간</th>
									<th>체크해제시 바로 삭제</th>
								</tr>
								<c:forEach items="${replyList }" var="replyList">
									<tr class="oneReply" data-rcode="${replyList.rcode }">
										<td>${replyList.writer }</td>
										<td><c:choose>
												<c:when test="${replyList.active == 0}">${replyList.content }</c:when>
												<c:otherwise>삭제 처리 되었습니다.</c:otherwise>
											</c:choose></td>
										<td><fmt:formatDate value="${replyList.reg_datetime }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td><input type="checkbox" id="replyActiveBox"
											name="replyActiveBox"
											<c:if test="${S_USER.userid  != boardVo.writer}"> style="display: none;"</c:if>
											<c:choose>
<c:when test="${replyList.active == 0 }"> value="0" checked="checked"</c:when>
<c:otherwise>value="1" </c:otherwise>
</c:choose>>
											<c:if test="${S_USER.userid  != boardVo.writer}">권한없음</c:if>
										</td>
									</tr>
								</c:forEach>
							</table>
							<hr>
							<div style="margin-left: 5%;">*** 댓글 작성 ***</div>

							<div style="text-align: left;">
								<textarea id="replyContent" name="replyContent" rows="3"
									cols="120"></textarea>
							</div>
							<div style="text-align: right;">
								<button type="button" class="btn btn-primary" id="replyWriteBtn"
									name="replyWriteBtn">댓글작성완료</button>
							</div>
							<br> <br>
						</form>
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