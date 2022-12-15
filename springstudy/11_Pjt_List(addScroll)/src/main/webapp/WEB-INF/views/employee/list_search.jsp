<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
	}
	a {
		text-decoration: none;
		color: gray;
	}
	.paging {
		margin-top: 15px;
	}
	.paging a, .paging strong.page {
		font-size: 14px;
		color: silver;
		letter-spacing: -1px;
		text-align: center;
		display: inline-block;
		min-width: 26px;
		height: 30px;
		padding: 4px;
		text-decoration: none;
	}
	.prev_page {
		margin-right: 13px;
	}
	.paging a.page {
		text-align: center;
	}
	.paging strong.page {
		color: limegreen;
		font-weight: 900;
		border: 1px solid silver;
	}
	.next_page {
		margin-left: 13px;
		padding: 4px;
	}
	.paging *:hover {
		color: limegreen;
	}
	table {
		width: 1760px;
		border-collapse: collapse;
	}
	td:nth-of-type(1) { width: 80px; }
	td:nth-of-type(2) { width: 160px; }
	td:nth-of-type(3) { width: 240px; }
	td:nth-of-type(4) { width: 240px; }
	td:nth-of-type(5) { width: 240px; }
	td:nth-of-type(6) { width: 160px; }
	td:nth-of-type(7) { width: 160px; }
	td:nth-of-type(7) { width: 160px; }
	td:nth-of-type(7) { width: 160px; }
	td:nth-of-type(7) { width: 160px; }
	td {
		padding: 5px;
		border-top: 1px solid silver;
		border-bottom: 1px solid silver;
		text-align: center;
	}
	tfoot td {
		border-left: 0;
		border-right: 0;
		border-bottom: 0;
	}
</style>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
	
		// 자동 완성
		$('#query').keyup(function(){
			if($('#column1').val() == 'EMPLOYEE_ID' || $('#column1').val() == 'DEPARTMENT_ID'){
				return;
			}
			if($(this).val() == ''){
				return;
			}
			$('#auto_complete').empty();
			$.ajax({
				/* 요청 */
				type: 'get',
				url: '${contextPath}/emp/autoComplete',
				data: $('#frm_search1').serialize(),
				/* 응답 */
				dataType: 'json',
				success: function(resData){
					if(resData.status == 200){
						$.each(resData.list, function(i, emp){
							$('#auto_complete')
							.append($('<option>').val(emp[resData.column]));
						});
					}
				}
			});
		});
		
		$('#frm_search1').submit(function(event){
			if($('#column1').val() == '' || $('#query').val() == ''){
				alert('검색 조건을 확인하세요.');
				event.preventDefault();
				return;
			}
		});
		
		$('#frm_search2').submit(function(event){
			if($('#column2').val() == '' || $('#start').val() == '' || $('#stop').val() == ''){
				alert('검색 조건을 확인하세요.');
				event.preventDefault();
				return;
			}
		});
		
	});
	
</script>
</head>
<body>

	<div>	
		<input type="button" value="사원조회_스크롤" onclick="location.href='${contextPath}/emp/list/scroll/page'">
		<input type="button" value="사원조회_페이징" onclick="location.href='${contextPath}/emp/list/paging'">
	</div>
	
	<hr>

	<div>
		<form id="frm_search1" action="${contextPath}/emp/search">
			<select name="column" id="column1">
				<option value="">:::선택:::</option>
				<option value="EMPLOYEE_ID">사원번호</option>
				<option value="FIRST_NAME">이름</option>
				<option value="PHONE_NUMBER">연락처</option>
				<option value="EMAIL">이메일</option>
				<option value="DEPARTMENT_ID">부서번호</option>
			</select>
			<input type="text" name="query" id="query" list="auto_complete">
			<datalist id="auto_complete"></datalist>
			<input type="submit" value="조회">
		</form>
	</div>

	<div>
		<form id="frm_search2" action="${contextPath}/emp/search">
			<select name="column" id="column2">
				<option value="">:::선택:::</option>
				<option value="HIRE_DATE">고용일</option>
				<option value="SALARY">연봉</option>
			</select>
			<input type="text" name="start" id="start">
			~
			<input type="text" name="stop" id="stop">
			<span>
				<input type="submit" value="조회">
			</span>
		</form>
	</div>
	
	<hr>

	<div>
		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td>사원번호</td>
					<td>사원명</td>
					<td>이메일</td>
					<td>전화번호</td>
					<td>입사일자</td>
					<td>연봉</td>
					<td>커미션</td>
					<td>부서번호</td>
					<td>부서명</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employeeList}" var="emp" varStatus="vs">
					<tr>
						<td>${beginNo - vs.index}</td>
						<td>${emp.employeeId}</td>
						<td>${emp.firstName} ${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.phoneNumber}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.salary}</td>
						<td>${emp.commissionPct}</td>
						<td>${emp.deptDTO.departmentId}</td>
						<td>${emp.deptDTO.departmentName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10">
					    ${paging}
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>