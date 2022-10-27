<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
</script>
</head>
<body>
	<form id="frm_write" action="${contextPath}/board/add.do" method="POST">
	<table border="1">
	<thead>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer" ></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>내용</td>
			<td><textarea cols=40 rows=4 name="content" ></textarea></td>
			</tr>
		<tr>
		 <td colspan="2">
		 <input type="submit" value="등록" >
		 <input type="button" value="목록" onclick="location.href='${contextPath}/board/list.do'">
		 </td>

		</tr>
	</table>
		</form>
</body>
</html>