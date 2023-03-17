<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

	<link href = "/jspweb/css/board/board.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->
	<div class="container">
		<h3> 모든 회원 명단 </h3>
		<table class ="box table table-hover"> 
		
		</table>
	</div>
	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
	
</body>
</html>