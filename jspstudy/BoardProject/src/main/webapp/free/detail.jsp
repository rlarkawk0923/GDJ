<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<body>

	<h1>게시글 상세보기</h1>
	<div>글번호 ${freeNo}</div>
	<div>작성자 ${writer}</div>
	<div>작성IP ${ip}</div>
	<div>조회수 ${hit}</div>
	<div>제목 ${title}</div>
	<div><pre>${content}</pre></div>

	<div>
		<input type="button" value="편집" onclick="location.href='${contextPath}/modify.do?no=${board.no}'">
		<input type="button" value="목록" onclick="location.href='${contextPath}/free/list.do'">
	</div>
	
</body>
</html>