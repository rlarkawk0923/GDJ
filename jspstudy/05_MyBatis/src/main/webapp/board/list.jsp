<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>게시글 전체 목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	
	// ready 이벤트
	// 문서를 모두 확인한 뒤 처리하는 window.onload 이벤트를 대신하는 jQuery 이벤트
	
	$(document).ready(function(){
		
		$('#btn_write').click(function(event){
			location.href = '${contextPath}/board/write.do';
		});
		
		$('#remove_link').click(function(event){
			if(!confirm('삭제할까요?')){  // if(confirm('삭제할까요?')==false){
				alert('취소되었습니다.');
				event.preventDefault();  // <a> 태그의 기본 이벤트는 링크 이동이므로 preventDefault()를 통해서 링크 이동이 막힘
				return;
			}
		});
		
	});
	
</script>
</head>
<body>

	<h1>게시글 목록 보기</h1>
	<div>
		<input type="button" value="새 게시글 작성하러 가기" id="btn_write">
	</div>
	<hr>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성일</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="board">
					<tr>
						<td>${board.board_no}</td>
						<td><a href="${contextPath}/board/detail.do?board_no=${board.board_no}">${board.title}</a></td>
						<td>${board.create_date}</td>
						<td>
							<a id="remove_link" href="${contextPath}/board/remove.do?board_no=${board.board_no}"><i class="fa-solid fa-x"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

=======
<title>게시판</title>
<style type="text/css">
	
	* {
		box-sizing: border-box;
		padding: 0;
		margin: 0;
		color: #333;
		}
	
	a {
		text-decoration: none;
		}
	
	h1 {
		margin-top: 30px;
		text-align: center;
	}
	.btn_write {
		width: 100px;
		height: 40px;
		text-align: center;
		line-height: 40px;
		margin: 40px auto 20px;
		background-color: teal;
		color: #fff;
		cursor: pointer;
		}
	.btn_write:hover {
		background-color: orange;
		}
	ul {
		list-style : none;
		display: flex;
		flex-wrap: wrap;
		width: 630px;
		margin : 30px auto;
		}
	ul > li {
		width:200px;
		height: 200px;
		text-align: center;
		margin-right: 10px;
		margin-top: 10px;
		border: 1px solid gray;
		border-radius: 5px;
		}
	ul > li > a{
		display: block;
		width: 100%;
		height: 100%;
	}
	ul > li > a:hover {
		background-color: orange;
	}
	

</style>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn_write').click(function(event){
			location.href='${contextPath}/board/write.do';
		});
	});
</script>
</head>
<body>
	<h1>게시글 목록 보기</h1>
	<div class="btn_write" id="btn_write">추가</div>
	<ul>
		<c:forEach items="${boards}" var="b">
			<li>
				<a href="${contextPath}/board/detail.do?boardNo=${b.boardNo}">
					<div>${b.title}</div>
					<div>${b.createDate}</div> <!--camelCase 자바이름-->
				</a>
			</li>
		</c:forEach>
	</ul>
>>>>>>> c75a8e6c98cc08ab96481493b891ba67c8be16f5
</body>
</html>