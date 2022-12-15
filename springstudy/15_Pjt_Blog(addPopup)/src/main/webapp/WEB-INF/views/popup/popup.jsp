<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팝업</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js" integrity="sha512-3j3VU6WC5rPQB4Ld1jnLV7Kd5xr+cq9avvhwqzbH/taCRNURoeEpoPBK9pDyeukwSxwRPJ8fDgvYXd6SkaZ2TA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	
	$(function(){
		fn_closePopup();
	});
	
	function fn_closePopup(){
		$('#btn_close').click(function(){
			// "오늘 더 이상 이 창을 열지 않기"를 체크했다면 noShowPopup이라는 쿠키를 1일동안 모든 경로('/')에서 사용할 수 있도록 저장해 둔다.
			if($('#chk_do_not_open').is(':checked')){
				$.cookie('noShowPopup', 'true', {expires: 1, path: '/'});
			}			
			window.close();
		});
	}
	
</script>
<style>
	* {
		padding: 0;
		margin: 0;
	}
	body{
		position: relative;
	}
	#footer {
		position: absolute;
		bottom: 5px;
		right: 5px;
	}
</style>
</head>
<body>

	<div>
		<!-- 이미지 표시를 위한 mapping : BlogController에서 작업해 두었음 -->
		<img src="${contextPath}/resources/images/redheart.png" width="400px">
	</div>
	
	<div id="footer">
		<form>
			<label for="chk_do_not_open">
				<input type="checkbox" id="chk_do_not_open">
				오늘 더 이상 이 창을 열지 않기
			</label>
			<input type="button" value="닫기" id="btn_close">
		</form>
	</div>

</body>
</html>