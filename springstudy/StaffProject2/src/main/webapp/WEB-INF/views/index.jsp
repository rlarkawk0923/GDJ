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
	
	$(function(){
		fn_list();
		fn_add();
		
		
	});
	
	function fn_list(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				$('#list').empty();
				$.each(resData, function(i, staff){
				// $.each() 에서 첫번째 인수는 배열이 온다.
				// resData는 배열임.
			
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#list').append(tr);
					
					/*
					$('<tr>')
					.append( $('<td>').text(staff.sno) )
					.append( $('<td>').text(staff.name) )
					.append( $('<td>').text(staff.dept) )
					.append( $('<td>').text(staff.salary) )
					.appendTo('#list');
					*/
					
				});
			}
		});
	}
	
	function fn_add(){
		$('#btn_add').click(function(){
			if( /^[0-9]{5}$/.test($('#sno').val()) == false ) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				// data: $('#frm_add').serialize(),
				data: 'sno=' + $('#sno').val() + '&name=' + $('#name').val() + '&dept=' + $('#dept').val(),
				dataType: 'text',
				success: function(resData){
					alert(resData);
					fn_list();
					$('#sno').val() = 
				}
			});
		});
	}
	
</script>
</head>
<body>

	<h3>사원등록</h3>
	<form id="frm_add">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원이름">
		<input type="text" id="dept" name="dept" placeholder="부서이름">
		<input type="button" value="등록" id="btn_add">
	</form>
	
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
		<tbody id="list">
			<tr>
				<td></td>
			</tr>
		</tbody>
	
	</table>
	

</body>
</html>