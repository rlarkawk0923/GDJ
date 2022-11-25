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
<script>
	
	$(document).ready(function(){
		$(window).on('load', function(){
		      alert("전체 10개의 목록을 불러왔습니다");
		      $.ajax({
		         type: 'get',
		         url : '${contextPath}/searchAllMovies',
		         dataType: 'json',
		         success: function(resData) {
		            $('#list').empty();
		            $.each(resData, function(i, movie){
		               $('<tr>')
		               .append($('<td>').text(movie.title))
		               .append($('<td>').text(movie.genre))
		               .append($('<td>').text(movie.description))
		               .append($('<td>').text(movie.star))
		               .appendTo('#list');
		            });
		         }
		      });
		   });
	});
</script>
</head>
<body>

	<div>
	
		<form id="frm_search">
			
			<select id="column" name="column">
				<option value="TITLE">제목</option>
				<option value="GENRE">장르</option>
				<option value="DESCRIPTION">내용</option>
			</select>
			<input type="text" id="searchText" name="searchText">
			<input type="button" id="btn_search" value="검색">
			<input type="button" id="btn_init" value="초기화">
			
			<br><hr><br>
			
			<table border="1">
				<thead>
					<tr>
						<td>제목</td>
						<td>장르</td>
						<td>내용</td>
						<td>평점</td>
					</tr>
				</thead>
				<tbody id="list">

				</tbody>
			</table>
			
		</form>
		
	</div>

</body>
</html>