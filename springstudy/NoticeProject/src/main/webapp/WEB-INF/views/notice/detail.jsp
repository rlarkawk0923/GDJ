<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	$(function(){
		$('#edit_area').hide(); // 편집영역 숨기기
		$('#btn_edit').click(function(){
			$('#edit_area').show(); // 편집영역 보여주기
			$('#detail_area').hide();// 상세영역 숨기기
		})
	});
</script>
</head>
<body>
		<div id="detail_area">
		<h1>공지번호 ${notice.noticeNo}</h1>
		<h1>제목 ${notice.title}</h1>
		<h1>내용 ${notice.content}</h1>
		<h1>조회수 ${notice.hit}</h1>
		<h1>작성일 ${notice.createDate}</h1>
		<h1>수정일 ${notice.modifyDate}</h1>
		<div>
		<form id ="frm_remove" action="${contextPath}/ntc/remove" method="post">
		<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
			<input type="button" value="편집" id="btn_edit">
			<input type="submit" value="삭제" id="btn_remove">
			<input type="button" value="목록" onclick="location.href='${contextPath}/ntc/list'">
		</form>
		<script>
			$('frm_remove').submit(function(event){
				if(confirm('공지를 삭제할까요?')==false){
					event.preventDefault();// 서브밋을 막겠다
					return; // 코드진행 막음
				}
			});
		</script>
		</div>
	</div>
	

	<div id="edit_area">
		<form action="${contextPath}/ntc/modify" method="post"> <!-- 서브밋하려면 폼 필요 -->
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" value="${notice.title}" ><!-- 서브밋은 name으로! required 필수항목일때, 주로생략 --> 
			</div><!-- name 속성이 있으면 null검사를 할수없음(널일리가없는느낌) 널체크하는 optional로도 못함-->
			<div>
				<label for="content">내용</label><br>
				<textarea id="content" name="content" rows="5" cols="30">${notice.content}</textarea> <!-- 서브밋은 name으로! textarea는 value값넣으면 안댐ㅁ-->
			</div>
			<div>
				<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
				<button>공지수정하기</button>
				<input type="reset" value="입력초기화">
				<input type="button" value="목록" onclick="location.href='${contextPath}/ntc/list'"><!-- onclick영역은 스크립트영역 -->
			</div>

		</form>
	</div>
</body>
</html>