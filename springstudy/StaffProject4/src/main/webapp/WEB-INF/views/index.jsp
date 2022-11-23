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
		fn_insertStaff();
		fn_queryStaff();
		fn_selectStaffList();
	});
	function fn_insertStaff(){
		$('#btn_add').click(function(){
			var regSNO = /^[0-9]{5}$/;
			if (regSNO.test($('#sno').val()) == false) {
				alert("사원번호는 5자리 숫자입니다.");
				return;
			}
			var regDEPT = /^[가-힣]{3,5}$/;
			if (regDEPT.test($('#dept').val()) == false) {
				alert("부서는 3~5자리 한글입니다.");
				return;
			} 
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				data: $('#frm_add').serialize(),
				dataType: 'text',
				success: function(resData) {
					alert(resData);
					fn_selectStaffList();
					$('#sno').val('');
					$('#name').val('');
					$('#dept').val('');
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);
				}
			});
		});
	}
	function fn_queryStaff(){
		$('#btn_query').click(function(){
			$.ajax({
				type: 'get',
				url: '${contextPath}/query.json',
				data: 'query=' + $('#query').val(),
				dataType: 'json',
				success: function(resData) {
					$('#staff_list').empty();
					$('<tr>')
					.append( $('<td>').text(resData.sno) )
					.append( $('<td>').text(resData.name) )
					.append( $('<td>').text(resData.dept) )
					.append( $('<td>').text(resData.salary) )
					.appendTo('#staff_list');						
				},
				error: function(){
					alert('조회된 사원 정보가 없습니다.');
				}
			});
		});
	}
	function fn_selectStaffList(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData) {
				$('#staff_list').empty();
				$.each(resData, function(i, staff){
					$('<tr>')
					.append( $('<td>').text(staff.sno) )
					.append( $('<td>').text(staff.name) )
					.append( $('<td>').text(staff.dept) )
					.append( $('<td>').text(staff.salary) )
					.appendTo('#staff_list');
				});
			}
		});
	}
</script>
</head>
<body>
	<h3>사원등록</h3>
	<form id="frm_add">
		<input type="text" name="sno" id="sno" placeholder="사원번호">
		<input type="text" name="name" id="name" placeholder="사원명">
		<input type="text" name="dept" id="dept" placeholder="부서명">
		<input type="button" value="등록" id="btn_add">
	</form>
	<hr>
	<h3>사원조회</h3>
	<form id="frm_query">
		<input type="text" name="query" id="query" placeholder="사원번호입력">
		<input type="button" value="조회" id="btn_query">
		<input type="button" value="전체" onclick="fn_selectStaffList()">
	</form>
	<hr>
	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="staff_list"></tbody>
	</table>
</body>
</html>