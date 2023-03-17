<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시물 상세 </title>

	<link href = "/jspweb/css/board/board.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->

	<%
		// 1. jsp 이용한 http url 변수 호출
		String bno = request.getParameter("bno");
	%>
	 <!-- java 코드 HTML 출력  -->

	<div class="container">
	
		<div class="box">
	
			<h3> 게시물 상세 </h3>
			<div> 
				<div class="title"> 게시물 번호    </div>
				<div class="bno"><%= bno %></div>
			</div>
			<div> 
				<div class="title"> 작성일 / 조회수 / 좋아요 / 싫어요</div>
				<div class="infobox"></div>
			</div>
			<div> 
				<div class="title"> 작성자[프로필] 	</div>
				<div class="pimgbox"></div>
			</div>
			<div> 
				<div class="title"> 제목 	 		</div>
				<div class="btitle"> </div>
			</div>
			<div> 
				<div class="title"> 내용 			</div>
				<div class="bcontent"></div>
			</div>
			<div> 
				<div class="title"> 첨부파일 		</div>
				<div class="bfile"> </div>
			</div>
			
			<div class="btnbox">
			
			
			</div>
			
		</div>
		
	</div>

	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/board/view.js" type="text/javascript"></script>
	
</body>
</html>