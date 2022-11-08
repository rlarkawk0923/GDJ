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
<title>${board.board_no}번 게시글</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
<<<<<<< HEAD
	$(document).ready(function(){
=======

$(document).ready(function(){
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
		
		$('#btn_edit').click(function(event){
			location.href = '${contextPath}/board/edit.do?board_no=${board.board_no}';
		});
<<<<<<< HEAD
		
		$('#btn_remove').click(function(event){
			if(confirm('게시글을 삭제할까요?')){
				location.href = '${contextPath}/board/remove.do?board_no=${board.board_no}';
			} else {
				alert('취소되었습니다.');
			}
		});
=======
		$('#btn_remove').click(function(event){
			if(confirm('게시글을 삭제할까요?')){
				location.href = '${contextPath}/board/remove.do?board_no=${board.board_no}';
			}else{
				alert('취소되었습니다.');
			}
		})
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do';
		});
		
<<<<<<< HEAD
=======
		
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
	});
</script>
</head>
<body>

	<h1>게시글 상세 보기</h1>
<<<<<<< HEAD
	<div>
		게시글 번호 : ${board.board_no}
	</div>
	<div>
		게시글 제목 : ${board.title}
	</div>
=======
	<div>게시글 번호 : ${board.board_no}</div>
	<div>게시글 제목: ${board.title}</div>
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
	<div>
		<pre>${board.content}</pre>
	</div>
	<div>
<<<<<<< HEAD
		작성일자 : ${board.create_date}
	</div>
	<div>
		<input type="button" value="편집" id="btn_edit">
		<input type="button" value="삭제" id="btn_remove">
=======
	작성일자 : ${board.create_date}
	</div>
	<div>
		<input type="button" value="편집" id="btn_edit"> 
		<input type="button" value="삭제" id="btn_remove"> 
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
		<input type="button" value="목록" id="btn_list">
	</div>

</body>
</html>