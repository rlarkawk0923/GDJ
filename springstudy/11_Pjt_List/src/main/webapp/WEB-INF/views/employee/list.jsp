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
		width: 210px;
		margin: 0 auto;
		color: gray;
	}
	.paging a, .paging span {
		display: inline-block;
		width: 30px;
		height: 30px;
		line-height: 30px;
		text-align: center;
	}
	.hidden {
		visibility: hidden;
	}
	.now_page {
		border: 1px solid gray;
		color: teal;
		font-weight: 900;
	}
	.lnk:hover {
		border: 1px solid gray;
		color: skyblue;
	}
</style>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		// area1, area2 표시
		// 초기 상태 : area1, area2 둘 다 숨김
		$('#area1, #area2').css('display', 'none');
		// column 선택에 따른 area1, area2 표시
		$('#column').change(function(){
			let combo = $(this);
			if(combo.val() == ''){
				$('#area1, #area2').css('display', 'none');
			} else if(combo.val() == 'HIRE_DATE' || combo.val() == 'SALARY'){
				$('#area1').css('display', 'none');
				$('#area2').css('display', 'inline');
			} else {
				$('#area1').css('display', 'inline');
				$('#area2').css('display', 'none');
			}
		});
	
		// 자동 완성
		$('#param').keyup(function(){
			$('#auto_complete').empty();
			if($(this).val() == ''){
				return;
			}
			$.ajax({
				/* 요청 */
				type: 'get',
				url: '${contextPath}/emp/autoComplete',
				data: 'target=' + $('#target').val() + '&param=' + $(this).val(),
				/* 응답 */
				dataType: 'json',
				success: function(resData){
					if(resData.status == 200){
						$.each(resData.list, function(i, emp){
							$('#auto_complete')
							.append($('<option>').val(emp[resData.target]));
						});
					}
				}
			});
		});
		
	});
	
</script>
</head>
<body>

	<div>
		<form id="frm_search" action="${contextPath}/emp/search">
			<select id="column" name="column">
				<option value="">:::선택:::</option>
				<option value="EMPLOYEE_ID">사원번호</option>
				<option value="E.DEPARTMENT_ID">부서번호</option>				
				<option value="LAST_NAME">성</option>
				<option value="FIRST_NAME">이름</option>
				<option value="PHONE_NUMBER">연락처</option>
				<option value="HIRE_DATE">입사일</option>
				<option value="SALARY">연봉</option>
			</select>
			<span id="area1">
				<input type="text" id="query" name="query">
			</span>
			<span id="area2">
				<input type="text" id="start" name="start">
				~
				<input type="text" id="stop" name="stop">
			</span>
			<span>
				<input type="submit" value="검색">
				<input type="button" value="전체사원조회" id="btn_all">
			</span>
		</form>
	</div>
	
	<div>
		<select name="target" id="target">
			<option value="FIRST_NAME">이름</option>
			<option value="LAST_NAME">성</option>
			<option value="EMAIL">이메일</option>
		</select>
		<input type="text" id="param" name="param" list="auto_complete">
		<datalist id="auto_complete"></datalist>
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
    <!--    
               <c:if test="${pageUtil.beginPage != 1 }">
                     <a href="${contextPath}/emp/list?page=${pageUtil.beginPage -1}">
                        ◀
                     </a>
                  </c:if>
                  
                  <!-- 페이지 번호 : 현재 페이지는 링크가없다 
                   <c:forEach var="p" begin="${pageUtil.beginPage}" end="${pageUtil.endPage}" step="1">
                           <c:if test="${p == pageUtil.page }">
                              <span class="low_btn blind">${p}</span>
                           </c:if>
                           <c:if test="${p != pageUtil.page }">
                              <a href="${contextPath}/emp/list?page=${p}">${p}</a>
                           </c:if>
                        </c:forEach>

                  <!-- 다음블록 : 마지막 블록이 아니면 다음블록이 있다 
                   <c:if test="${pageUtil.endPage != pageUtil.totalPage}">
                           <a href="${contextPath}/emp/list?page=${pageUtil.endPage + 1}">▶</a>
                        </c:if>  코드 페이지 유틸로 넘어감-->