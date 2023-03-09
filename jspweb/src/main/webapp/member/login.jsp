<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->
	
	<h3> 로그인 </h3>
	아이디 		:	<input type="text"		class="mid">		<br>
	비밀번호		:	<input type="password"	class="mpw">		<br>
	<button type="button" onclick="login()"> 로그인 </button>
	
	<%@ include file = "/footer.jsp" %>
		
	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>
	
</body>
</html>