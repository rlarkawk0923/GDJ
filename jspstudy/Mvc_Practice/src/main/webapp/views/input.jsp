<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${contextPath}/adder.do">
 <%-- 너비/높이 입력 폼 : 삼각형버튼, 사각형 버튼 --%>
 <div>
 너비<input type="text"  name="width"><br>
 높이<input type="text"  name="height">
 </div><br>
 <button id="triangle">삼각형 넓이 확인</button>
 <button id="rectangle">사각형 넓이 확인</button>
 <hr>
 <%-- 반지름 입력 폼 : 원버튼 --%>
<div>
<input type="text" id="circle" name="radius">
</div><br>
<button id="circle">원 넓이 확인</button>
</form>
</body>
</html>