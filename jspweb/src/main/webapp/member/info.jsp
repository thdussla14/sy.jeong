<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> MY PAGE </title>

		<link href = "/jspweb/css/member/info.css" rel="stylesheet">
		<link href = "/jspweb/css/modal.css"       rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>
	
	<div class="container">
		<div class="myprofile">
			<h3> 회원정보 </h3>
			<div>
				<div>
					<img class="mimg"  width="20%" alt=" " src="">
				</div>
				<div>
					<div class="title"> 아이디 </div>
					<div class="mid">  </div>
				</div>
				<div>
					<div class="title"> 이메일 </div>
					<div class="memail"> </div>
				</div>
				<div>
					<div class="title"> 보유포인트 </div>
					<div class="mpoint"> </div>
				</div>
			</div>
		
			<a href="/jspweb/member/update.jsp"><button class="btns" > 회원수정 </button></a>
			<button onclick="openmodal()" class="btns" type="button"> 회원탈퇴 </button>
		</div>
	</div>

	<!-- 모달 구역 -->

	<div class="modal_wrap">	
		<div class="modal_box">
		
		<h3  class="modal_title"> 회원탈퇴를 진행하시겠습니까? </h3>		
		<div class="modal_content">
			비밀번호 <input type="password" class="mpw">
		</div>
		
		<div class="modal_btns">
			<button onclick="setDelete()"  class="btns" type="button"> 탈퇴 </button>
			<button onclick="closemodal()" class="btns" type="button"> 취소 </button>
		</div>
			
		</div>	<!-- modal_box e -->
	</div>	<!-- modal_wrap e -->

	

	<%@ include file = "/footer.jsp" %>

	<script src = "/jspweb/js/member/info.js" type="text/javascript"></script>


</body>
</html>

<!--  

	동일한 HTML 에서 열리는 JS 파일은 메모리 
	* 단 먼저 호출된 JS 순서대로 
	* 주의 AJAX
		1. $.ajax({})				비동기통신 [ 요청 보내고 응답을 기다리지 않음 ]
		
		요청1 ------ > 요청1 처리
		|
		요청2 ------ > 요청2 처리
		|
		|<========    요청2 응답
		|<========    요청1 응답  [ 요청2가 빠르게 처리되면 먼저 응답 가능 ]
		
		
		2. $.ajax({async : false})	동기통신 [ 요청 보내고 응답이 와야 다음 요청 처리 ]
		
		요청1 ------ > 요청1 처리
		|<========    요청1 응답
		|
		요청2 ------ > 요청2 처리
		|
		|<========    요청2 응답  [ 요청2가 빠르게 처리되어도 먼저 응답 불가능 ]		
		
 -->