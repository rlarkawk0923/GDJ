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
<div>
	<form action="${contextPath}/adder.do">
		<div>
		<input type="text" name="a">
		+
		<input type="text" name="b">
		</div>
		<button>계산</button>
		 
	</form>
</div>
</body>
</html>