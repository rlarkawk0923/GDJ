<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <input type="text" name="width">, 
 <input type="text" name="height">
 </div>
 <button id="triangle">삼각형</button>
 <button id="square">사각형</button>
 <%-- 반지름 입력 폼 : 원버튼 --%>
<div>
<input type="text" name="radius">
</div>
<button id="circle">원</button>
</form>
</body>
</html>