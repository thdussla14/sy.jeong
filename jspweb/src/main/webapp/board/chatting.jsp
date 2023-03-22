<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> chatting </title>
</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->
	
	<div class="container"> 
	
		<!-- 채팅 내용물이 표시되는 구역 -->
		<div class="contentbox"> </div>
		
		<!-- 채팅 입력창 -->
		<textarea class="msgbox" rows="" cols=""></textarea>
	
		<!-- 채팅 전송 버튼 -->
		<button onclick="전송()" type="button"> 전송 </button>
	
	</div>

	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>


</body>
</html>