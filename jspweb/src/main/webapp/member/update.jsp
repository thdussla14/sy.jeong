<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원정보수정 </title>

			<link href = "/jspweb/css/member/info.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>

	<div class="container">
	
		<div class="myprofile">
			<h3> 회원정보수정 </h3>
			<form class="updateform">
				<div>
					<div>
						<img   class="mimg" alt=" " src=""> <br>
						 <div   class="title"> 프로필 변경   </div> 
						<input class="newmimg"     type="file" name="newmimg"> <br>
						기본프로필 사용	<input class="defaultimg "  type="checkbox"> 
					</div>
					<div>
						<div   class="title"> 아이디 </div>
						<div   class="mid">  </div>
					</div>
					<div>
						<div   class="title"> 현재 비밀번호 </div>
						<input class="mpw in"           name="mpw"> 
					</div>
					<div>
						<div   class="title"> 변경 비밀번호 </div>
						<input class="newmpw in"        name="newmpw"> 
					</div>
					<div>
						<div   class="title"> 변경 비밀번호 확인 </div>
						<input class="newmpwconfirm in" name="newmpwconfirm"> 
					</div>
					
					<div class="title"> 변경 이메일 </div>
					<div class="info">
						<input  class="memail in"        name="newmemail"> 
						<button class="btns" type="button"> 인증 </button>
					</div>
				</div>
			
				<button onclick="setUpdate()" class="btns" type="button"> 정보수정 </button>
				
			</form>
			
		</div>
	</div>

	<%@ include file = "/footer.jsp" %>

	<script src = "/jspweb/js/member/update.js" type="text/javascript"></script>


</body>
</html>