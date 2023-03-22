<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 채팅 </title>

	<link href="/jspweb/css/board/chatting.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->
	
	<div class="container"> 
	
		<div class="chattingbox"> 
		
			<!-- 채팅창 -->
			<div class="contentbox">  

				
			
			</div> <!-- contentbox e -->
		
			<!-- 채팅 입력창 -->
			<textarea onkeyup="enterkey()" class="msgbox" rows="" cols=""> </textarea>
		

			<div class="chattingbtnbox">
				<div> 이모티콘 </div>
				<div> 첨부파일 </div>
				<!-- 채팅 전송 버튼 -->
				<button  class="sendbtn" onclick="전송()" type="button"> 전송 </button>
			</div>

		</div> <!-- chattingbox e -->
	</div> <!-- container e -->

	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/board/chatting.js" type="text/javascript"></script>


</body>
</html>