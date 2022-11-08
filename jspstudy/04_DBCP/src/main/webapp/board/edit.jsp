<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
=======
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>${board.board_no}번 게시글 수정</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
=======
<title>${board.board_no}번게시글 수정</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function() {
						
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
		$('#frm_edit').submit(function(event){
			// 제목, 내용 모두 변경이 없는 경우
			// 기존 제목, 내용   : ${board.title},    ${board.content}
			// 입력한 제목, 내용 : $('#title').val(), $('#content').val()
<<<<<<< HEAD
			if('${board.title}' == $('#title').val() && '${board.content}' == $('#content').val()){
=======
			if('${board.title}'== $('title').val() && '${board.content}' == $('#content').val()){
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
				alert('변경된 내용이 없습니다.');
				event.preventDefault();
				return;
			}
<<<<<<< HEAD
			// 제목이 비어 있는 경우
			if($('#title').val() == ''){
=======
			// 제목이 비어있는 경우
			if($('#title').val()==''){
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
				alert('제목은 필수입니다.');
				event.preventDefault();
				return;
			}
		});
<<<<<<< HEAD
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do';
		});
		
=======
		$('#btn_list').click(function(event) {
			location.href = '${contextPath}/board/list.do';
		});
	
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
	});
</script>
</head>
<body>

	<h1>게시글 편집 화면</h1>
	<div>
		<form method="POST" action="${contextPath}/board/modify.do" id="frm_edit">
<<<<<<< HEAD
			<div>
				게시글 번호 : ${board.board_no}
				<input type="hidden" name="board_no" value="${board.board_no}">
			</div>
			<div>
				게시글 제목 : <input type="text" name="title" id="title" value="${board.title}">
			</div>
			<div>
				게시글 내용<br>
				<textarea name="content" id="content" rows="5" cols="30">${board.content}</textarea>
			</div>
			<div>
				작성일자 : ${board.create_date}
			</div>
			<div>
				<input type="submit" value="수정">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>

=======
	
	<div>게시글 번호 : ${board.board_no}</div>
	<input type="hidden" name="board_no" value="${board.board_no}">
	<div>
		게시글 제목: <input type="text" name="title" id="title"
			value="${board.title}">
	</div>
	<div>
		게시글 내용 <br>
		<textarea name="content" id="content" rows="5" cols="30">${board.content}</textarea>
	</div>
	<div>작성일자 : ${board.create_date}</div>
	<div>
		<input type="submit" value="수정" > 
		<input type="button" value="목록" id="btn_list">
	</div>
</form>
</div>
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
</body>
</html>