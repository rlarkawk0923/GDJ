<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Optional<String> opt = Optional.ofNullable(request.getParameter("title"));
	String title = opt.orElse("Welcome");
	pageContext.setAttribute("title", title);  // EL사용을 위함 (${title})
	pageContext.setAttribute("contextPath", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script src="${contextPath}/resources/js/moment-with-locales.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.js"></script>
<script src="${contextPath}/resources/summernote-0.8.18-dist/lang/summernote-ko-KR.min.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/summernote-0.8.18-dist/summernote-lite.css">
<style>
	@import url("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css");
	@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');
	* {
		font-family: 'Noto Sans KR', sans-serif;
		color: #202020;
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	html {
		background-color: #f7f9fa;
	}
	a {
		text-decoration: none;
	}
	</style>
</head>
<body>

	<div>
		<h1>Welcome To My BLOG</h1>
		<c:if test="${loginUser != null}">
			${loginUser.name}(회원번호 ${loginUser.userNo}) 님 반갑습니다
			<input type="button" value="로그아웃" onclick="location.href='${contextPath}/user/logout'">
		</c:if>
	</div>
	
	<hr>
