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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>board main</title>


</head>
<body>
	<form id="frm">
		<input type="hidden" id="userid" name="userid"
			value="${S_USER.userid }">

		<!-- 개발 확인용 코드 추후 삭제 요망 시작 -->
		<br> 추후 삭제 세션 객체 <br> S_USER값 ${S_USER } <br> userid 값
		not session : ${userid }
		<!-- 개발 확인용 코드 추후 삭제 요망 끝 -->

		<h1>게시판 진입 완료</h1>
		로그인 아이디 : ${S_USER.userid } <br> 로그인 시각 : ${logintime } <br>
		<br> <input type="button" value="게시글 보기"> <input
			type="button" value="로그 아웃" onClick="location.href='${cp }/logout'">
		<br>
		<hr>

		<input type="text" id="addBoardName" name="addBoardName"
			placeholder="추가할 게시판 이름 입력"> <input type="button"
			id="addBoardBtn" name="addBoardBtn" value="게시판생성" onclick="/boardCreate">
		<hr>
		조회된 게시판 출력<br> FOR>>>>> 조건 BCODE == ORIGINNO 이고
		GROUPORD =0 GROUPLAYER=0 <br> <input type="button"
			id="bcode${i.bcode }" name="bcode ${i.bcode }" value="${i.title }"
			onclick="#"> <br> select * from board
	</form>
</body>
</html>







