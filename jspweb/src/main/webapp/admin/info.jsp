<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->

	<h3> 모든 회원 명단 </h3>
	<table class ="box" border="1"> 
	
	</table>
	
	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
	
</body>
</html>