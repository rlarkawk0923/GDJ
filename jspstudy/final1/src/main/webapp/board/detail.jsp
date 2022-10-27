<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardNo}번 게시글</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		
		$('#btn_edit').click(function(event){
			location.href = '${contextPath}/board/edit.do?boardNo=${board.boardNo}';
		});
		
		
		$('#btn_remove').click(function(event){
			if(confirm('게시글을 삭제할까요?')){
				location.href = '${contextPath}/board/remove.do?boardNo=${board.boardNo}';
			}else{
				alert('취소되었습니다.');
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do'
		})
	})
</script>
</head>
<body>
<form id="frm_write" action="${contextPath}/board/add.do" method="POST">
	<table border="1">
	<thead>
		<tr>
			<td>작성자</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text"></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>내용</td>
			<td><textarea cols=40 rows=4></textarea></td>
			</tr>
		<tr>
		 <td colspan="2">
		 <input type="submit" value="수정">
		 <input type="button" value="목록" onclick="location.href='${contextPath}/board/list.do'">
		 <input type="button" value="삭제" onclick="location.href='${contextPath}/board/delete.do'">
		 </td>

		</tr>
	</table>
		</form>
</body>
</html>