<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

	<link href = "/jspweb/css/member/signup.css" rel="stylesheet">

</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->

	<div class="container">

		<form class="signupForm">	<!-- form 전송시 input 식별 name 식별자 사용 -->
		
			<h3> Ezen commmunity </h3>
			<p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다.</p>
			
			<div class="title"> 아이디</div>
			<input onkeyup="idcheck()" 			maxlength="30" type="text" 	   name="mid"  		 class="mid">		
			<div class="checkconfirm"></div>
				
			<div class="title">비밀번호</div>
			<input onkeyup="pwcheck()" 			maxlength="20" type="password" name="mpw" 		 class="mpw">
				
			<div class="title">비밀번호 확인</div>	
			<input onkeyup="pwconfirmcheck()" 	maxlength="20" type="password" name="mpwconfirm" class="mpwconfirm">	
			<div class="checkconfirm"></div>
			
			<div class="title">이메일</div>	
			<div class="mailbox">											
				<input onkeyup="mailcheck()" 	type="text" name="memail" class="memail">
				<button onclick="getauth()" class="authbtn" type="button" disabled="disabled"> 인증 </button>
			</div>	
			<!-- 인증 코드 입력 -->			
			<div class="authbox">

			</div>
			<div class="checkconfirm"></div>
				
			<div class="title">프로필</div>	
			<div class="pimgbox">																		
				<input onchange="premimg(this)"	type="file"	name="mimg"  id="file" class="mimg">		
				<img class="premimg" alt="" src="/jspweb/member/pimg/사람.png"> 
			</div>	
																								
			<button class="signupbtn" type="button" onclick="signup()"> 가입 </button>
		</form>
	
	</div>
	
		<!-- 모달 구역 -->

	<div class="modal_wrap">	
		<div class="modal_box">
		
		<h3  class="modal_title"> 환영합니다! </h3>		
		<div class="modal_content">
			가족이 되어주셔서 감사합니다 ~
		</div>
		
		<div class="modal_btns">
			<button onclick="closemodal()" class="modal_cancel btns" type="button"> 닫기 </button>
		</div>
			
		</div>	<!-- modal_box e -->
	</div>	<!-- modal_wrap e -->
	
	<%@ include file = "/footer.jsp" %>

	<script src ="/jspweb/js/member/signup.js" type="text/javascript"></script>

</body>
</html>