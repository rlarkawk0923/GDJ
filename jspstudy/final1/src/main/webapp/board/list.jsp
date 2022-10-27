<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
	
<script>

$(document).ready(function(){
	$('#fn_write').click(function(event){
		location.href='${contextPath}/board/write.do';
	});
});

</script>
</head>
<body>
<table border="1">
	<caption style="text-align:left;">총 게시글 : ${count} 개</caption>
	<thead>
		<tr>
			<td>순번</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
	</thead>
	<tbody>
	<c:if test="${count eq 0}">
		<tr>
			<td>게시물이 없습니다.</td>
		</tr>
	</c:if>
	<c:if test="${count ne 0}">
	<c:forEach items="${boards}" var="b">
		<tr onclick="location.href='${contextPath}/detail.do?no=${b.boardNo}'">
			<td>${b.boardNo}</td>
			<td>${b.writer}</td>
			<td>${b.title}</td>
			<td>${b.createDate}</td>
		</tr>
		
	</c:forEach>
	</c:if>

	</tbody>
	<tfoot>
		<tr>
			<td><input type=button id="fn_write" value="새글 작성"></td>

		</tr>
	</tfoot>
	
	</table>
</body>
</html>