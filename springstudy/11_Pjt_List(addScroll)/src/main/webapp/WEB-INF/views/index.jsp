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
</head>
<body>

	<div><a href="${contextPath}/emp/list/scroll/page">사원목록_무한스크롤</a></div>
	
	<div><a href="${contextPath}/emp/list/paging">사원목록_페이징</a></div>

	<div><a href="${contextPath}/emp/search/form">사원검색</a></div>	

</body>
</html>