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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	
	$(function(){
		fn_openPopup();
	});
	
	function fn_openPopup(){
		// noShowPopup이라는 쿠키가 없으면 팝업 창을 연다.
		var noShowPopup = $.cookie('noShowPopup');
		if(noShowPopup != 'true') {
			window.open('${contextPath}/view/popup', 'pop', 'width=400,height=410,top=100,left=500,menubar=no,history=no');
		}
	}
	
</script>
</head>
<body>

	<c:if test="${loginUser == null}">
		<form action="${contextPath}/user/login" method="post">
			<input type="text" name="id" placeholder="ID"><br>
			<input type="password" name="pw" placeholder="Password"><br>
			<button>로그인</button>
		</form>
	</c:if>
	
	<c:if test="${loginUser != null}">
		${loginUser.name} 님 반갑습니다
		<input type="button" value="로그아웃" onclick="location.href='${contextPath}/user/logout'">
	</c:if>

	<hr>

	<a href="${contextPath}/blog/list">블로그</a>

</body>
</html>