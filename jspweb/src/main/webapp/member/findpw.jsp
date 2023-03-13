<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 비밀번호 찾기 </title>

	<link href = "/jspweb/css/member/signup.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->

	<div class="container">
		<form class="signupForm">
			<h3> 비밀번호 찾기 </h3>
			<p> 회원님의 계정 정보를 찾아드립니다.</p>
					
			<div class="title"> 아이디</div>
			<input type="text" 	   name="mid"  		 class="mid">				
			<div class="title"> 이메일 </div>
			<input type="text" 	   name="memail"  	 class="memail">		
			<div class="checkconfirm"></div>
			<button class="signupbtn" type="button" onclick="findpw()"> 비밀번호 찾기 </button>

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