<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

</script>
</head>
<body>
	<div>
		<form action="${contextPath}/ntc/add" method="post"> <!-- 서브밋하려면 폼 필요 -->
			<div>
				<label for="title">제목</label>
				<input type="text" id="title" name="title" required="required"><!-- 서브밋은 name으로! required 필수항목일때, 주로생략 --> 
			</div>
			<div>
				<label for="content">제목</label><br>
				<textarea id="content" name="content" rows="5" cols="30"></textarea> <!-- 서브밋은 name으로! -->
			</div>
			<div>
				<button>공지등록하기</button>
				<input type="reset" value="입력초기화">
				<input type="button" value="목록" onclick="location.href='${contextPath}/ntc/list'"><!-- onclick영역은 스크립트영역 -->
			</div>

		</form>
	</div>
</body>
</html>