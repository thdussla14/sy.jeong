<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 </title>

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->

	<div class="container">
	
		<h3> 게시물 목록 </h3>
		<a href="/jspweb/board/write.jsp"> 게시글 쓰기 </a>
		
		<table class="boardlist">
		
		</table>
		
	</div>

	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>