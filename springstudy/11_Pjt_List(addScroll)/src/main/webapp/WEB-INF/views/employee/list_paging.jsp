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
	.title {
		cursor: pointer;
	}
	.title:hover {
		color: teal;
	}
	.paging {
		width: 210px;
		margin: 0 auto;
		color: gray;
	}
	.paging a, .paging span, .paging strong {
		display: inline-block;
		width: 30px;
		height: 30px;
		line-height: 28px;
		text-align: center;
	}
	.hidden {
		visibility: hidden;
	}
	.now_page {
		color: teal;
		font-weight: 900;
	}
	.lnk:hover {
		color: skyblue;
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
		
		// 세션에 recordPerPage가 없는 경우 recordPerPage 10으로 초기화
		var recordPerPage = ('${recordPerPage}'=='') ? '10' : '${recordPerPage}';
		$('#recordPerPage').val(recordPerPage);
		
		// recordPerPage 변경
		$('#recordPerPage').change(function(){
			location.href = '${contextPath}/emp/change/list?recordPerPage=' + $(this).val();
		});
		
		// 필드 제목으로 정렬
		$('.title').click(function(){
			location.href = '${contextPath}/emp/list?title=' + $(this).data('title') + '&order=' + $(this).data('order') + '&page=${page}';
		});
		
	});
	
</script>
</head>
<body>

	<div>	
		<input type="button" value="조회화면으로이동" onclick="location.href='${contextPath}/emp/search/form'">
	</div>

	<hr>

	<div>
		<h1>사원 목록 조회하기</h1>
	</div>

	<div>
		<select id="recordPerPage">
			<option value="10">10개</option>
			<option value="20">20개</option>
			<option value="30">30개</option>
		</select>
	</div>
	
	<hr>

	<div>
		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td><span class="title" data-title="EMPLOYEE_ID" data-order="${order}">사원번호</span></td>
					<td><span class="title" data-title="FIRST_NAME" data-order="${order}">사원명</span></td>
					<td><span class="title" data-title="EMAIL" data-order="${order}">이메일</span></td>
					<td><span class="title" data-title="PHONE_NUMBER" data-order="${order}">전화번호</span></td>
					<td><span class="title" data-title="HIRE_DATE" data-order="${order}">입사일자</span></td>
					<td><span class="title" data-title="SALARY" data-order="${order}">연봉</span></td>
					<td><span class="title" data-title="COMMISSION_PCT" data-order="${order}">커미션</span></td>
					<td><span class="title" data-title="DEPARTMENT_ID" data-order="${order}">부서번호</span></td>
					<td><span class="title" data-title="DEPARTMENT_NAME" data-order="${order}">부서명</span></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp" varStatus="vs">
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