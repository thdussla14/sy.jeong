<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 글작성 </title>

	<link href = "/jspweb/css/board/board.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->

	<%
		// 로그인 여부 제어
		Object o = request.getSession().getAttribute("login");
		if(o==null){
			response.sendRedirect("/jspweb/member/login.jsp");
		}
	
	%>

	<div class="container">
	
		<div class="box">
		
		<form class="writeform">
		
		<h3> 글쓰기 </h3>

		<div class="col-auto">
		 <label class="form-label">카테고리 	:</label>		 
					 <select class="form-control"	name="cno">
						<option value="1"> 공지사항 	</option>
						<option value="2"> 커뮤니티 	</option>
						<option value="3"> QnA  	</option>
						<option value="4"> 노하우   	</option>
					  </select>		
		</div>
		<div class="col-auto">
		<label class="form-label">제목		:</label>		  								
			 <input  class="form-control"	name="btitle" 	type="text">
		</div>
		<div class="col-auto">	
		<label class="form-label">내용		:</label>			
			 <textarea class="form-control" name="bcontent" rows="" cols=""></textarea>
		</div>
		<div class="col-auto">			 
		<label class="form-label">첨부파일		:</label>			
			 <input  class="form-control"	name="bfile" 	type="file">		
		</div>		 			
			<button onclick="bwrite()"  class="btn btn-primary" type="button"> 글등록 </button>			
		</form>
	
		</div>
		
	</div>

	<%@ include file = "/footer.jsp" %>
	
	<script src="/jspweb/js/board/write.js" type="text/javascript"></script>
	
</body>
</html>

<!-- 
	HTML --- > form 
			<from method="post" action="서블렛" >
				1. enctype = "appication/x-www-urlencoded" 	: 기본 폼 전송 타입 / js .ajax 없이 전송 / 동기식, 페이지 전환 O
				2. enctype = "multipart/form-data"			: 첨부파일 포함 전송
			- 주의 form 태그 내부 <button> type 생략시 type="submit" (폼 보내기)
			- js 에서 유효성검사를 진행하기 위해  기본 폼 전송 타입 전송 사용 안함
-->