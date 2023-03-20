<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시물 상세 </title>

	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<link href = "/jspweb/css/board/board.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->

	<%
		// 1. jsp 이용한 http url 변수 호출
		String bno = request.getParameter("bno");
	%>
	 <!-- java 코드 HTML 출력  -->
	<!-- cno 숨겨서 js 전달 -->
	<input type="hidden" class="bno" value="<%=bno%>">


	<div class="container">
	
		<div class="boardbox">
			<div class="minfo"> 
				<div class="pimgbox"></div>
				<div>
					<div class="mid"></div>
					<div class="infobox"></div>
				</div>
			</div>
			<div class="title"> </div>
			<div class="bcontent"></div>
			<div class="bfilebox"> 
				<div class="bfile"> </div>
				<div class="btnbox"></div>
			</div>
			
			<div class="rcount"> </div>
			<div class="replybox"> 
				<textarea class="rcontent" rows="" cols="45"></textarea>
				<button onclick="rwrite()" class="rwritebtn cbtn" type="button">  댓글 작성 </button>
			</div>
			<div class="replylistbox"> 
			
			</div>
			
		</div> <!-- boardbox e  -->	
	</div> <!-- container e  -->

	<%@ include file = "/footer.jsp" %>


	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>
	
</body>
</html>