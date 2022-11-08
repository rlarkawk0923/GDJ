<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자유게시판 게시글 상세보기화면</h1>
	<form action="/BoardProject/modify.do" method="post">
		게시글번호 ${free.freeNo}<br>
		작성자 ${free.writer}<br>
		작성IP ${free.ip}<br>
		조회수 ${free.hit}<br>
		제목 <input type="text" name="title" value="${free.title}"><br>
		<textarea name="content">${free.content}</textarea><br>
		<input type="hidden" name="freeNo" value="${free.freeNo}">
		<button>수정</button>
		<input type="button" value="목록" onclick="location.href='/BoardProject/list.do'">
	</form>
</body>
</html>