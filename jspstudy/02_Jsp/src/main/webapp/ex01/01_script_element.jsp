<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 : 소스보기에서 확인 가능 -->
	<%-- JSP 주석 : 소스보기에서 확인 불가능--%>

	<%!
		// 선언부(Declaration) : 전역 변수 선언, 메소드 정의
		public int getSum(int begin, int end){
			int sum = 0;
			for(int n = begin; n <=end; n++){
				sum+= n;
			}
			return sum;
	} %>
	
	<% 
		// 스크립트릿(Scriptlet) : 일반 자바코드
		int sum = getSum(1, 100);
	%>
	<!-- 표현식 : 값을 나타낼 때 사용 -->
	<div><%=sum %></div>
	<div><%=getSum(1, 1000) %></div>
	
	<!-- 연습. 화면에 1~10 출력하기 -->
	<% for(int n = 1; n <= 10; n++){ %>
		<div><%=n%></div>
	<% } %> 
	
	<!-- 
		연습. select 태그 만들기
	 -->
	 <div>
	 	<select name="month">
	 		<option value="">월 선택</option>
	 		<% for(int m = 1; m <= 12; m++){ %>
	 			<option value="<%=m%>"><%=m %>월</option>
	 			<% } %>
	 	</select>
	 </div>
</body>
</html>