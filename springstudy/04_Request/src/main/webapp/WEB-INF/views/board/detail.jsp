<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시판 상세 보기</h1>
	
	<div>제목 ${title}</div>    <%-- ${member.id}는 member.getId()를 호출한다. --%>
	<div>조회수 ${hit}</div>  <%-- ${member.pw}는 member.getPw()를 호출한다. --%>

</body>
</html>