<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

	<link href = "/jspweb/css/member/signup.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->

	<div class="container">
		<form class="signupForm">
			<h3> Ezen commmunity </h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다.</p>
					
			<div class="title"> 아이디</div>
			<input type="text" 	   name="mid"  		 class="mid">		
						
			<div class="title">비밀번호</div>
			<input type="password" name="mpw" 		 class="mpw">
			
			<button class="signupbtn" type="button" onclick="login()"> 로그인 </button>
			
			<div class="checkconfirm"></div>
			
			<div class="subbtnbox">
				<a href = "/jspweb/member/findid.jsp"> 아이디 찾기</a>
				<a href = "/jspweb/member/findpw.jsp"> 비밀번호 찾기</a>
			</div>
			
		</form>
	</div>
	

		
	<%@ include file = "/footer.jsp" %>
		
	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>
	
</body>
</html>