<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/><%-- ==<%=request.getContextPath()%>컨텍스트패스 값03/Mvc 불러오기 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3><a href="${contextPath}/today.do"/><%--컨텍스트 패스+urlmapping(today라는 이름의 서블릿 필요) --%>쫩쫩 오늘은 며칠입니가?쫩쫩</h3>
	<h3><a href="${contextPath}/now.do"/>쫩쫩 지금은 몇 시입니가?쫩쫩</h3>
	<h3><a href="${contextPath}/input.do"/>입력화면으로 이동하기</h3>

</body>
</html>