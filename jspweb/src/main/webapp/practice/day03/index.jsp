<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> 예제1 : HTTP 메소드 </h3>
	<button onclick="doPOST()" 	type="button"> POST 메소드 	</button>
	<button onclick="doGET()" 	type="button"> GET 메소드 	</button>
	<button onclick="doPUT()" 	type="button"> PUT 메소드 	</button>
	<button onclick="doDELETE()"type="button"> DELETE 메소드 	</button>
	
	<h3> 예제2 : 방문록 </h3>
	내용 		: <input type="text" class="content" >	
	작성자	: <input type="text" class="writer"> 
	<button onclick="onWrite()" type="button"> 방문록 등록 </button>
	<p></p>
	<table class="boardtable" border="1"> </table>

	<!-- jsp,js,dao 기존파일 / servlet, dto 새로 작성	
		1. 제품등록	[제품명, 가격]
		2. 제품출력	[테이블에 모두 출력]
		3. 제품삭제	[제품번호 이용한 삭제]
		4. 제품수정	[제품명,가격수정]	=> prompt 입력받기
	 -->
	 
	<h3> 과제3 : 제품관리 </h3>
	제품 	: <input type="text" class="pname" >	
	가격	: <input type="text" class="price"> 
	<button onclick="onRegister()" type="button"> 제품 등록 </button>
	<p></p>
	<table class="producttable" border="1"> 
	</table>


	<!-- 순서 중요 사용자정의 js가 가장 마지막 -->
	<!-- 1. 최신 JQUERY (AJAX 사용시 필요!) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 2. JS 연동 -->
	<script  src="index.js" type="text/javascript"></script>

</body>
</html>