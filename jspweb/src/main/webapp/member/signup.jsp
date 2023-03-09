<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->

	<h3> 회원가입 </h3>
	<form class="signupForm">	<!-- form 전송시 input 식별 name 식별자 사용 -->
		아이디 		:	<input onkeyup="idcheck()" 			maxlength="30" type="text" 	   name="mid"  		 class="mid">		
						<span class="checkconfirm"></span>																		<br>	
		비밀번호		:	<input onkeyup="pwcheck()" 			maxlength="20" type="password" name="mpw" 		 class="mpw">		<br>
		비밀번호 확인	:	<input onkeyup="pwconfirmcheck()" 	maxlength="20" type="password" name="mpwconfirm" class="mpwconfirm">	
						<span class="checkconfirm"></span>																		<br>
		이메일 		:	<input onkeyup="mailcheck()" 					   type="text" 	   name="memail" 	 class="memail">		
						<span class="checkconfirm"></span>																		<br>
		프로필 		:	<input onchange="premimg(this)"	 				   type="file"	   name="mimg" 		 class="mimg">		<br>
		미리보기		<br>
					<img class="premimg" alt="" src="/jspweb/member/pimg/default.webp"> 										<br>													<br>
		<button type="button" onclick="signup()"> 가입 </button>
	</form>
	
	<%@ include file = "/footer.jsp" %>

	<script src ="/jspweb/js/member/signup.js" type="text/javascript"></script>

</body>
</html>