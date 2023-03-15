<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 커뮤니티 </title>
	
	<link href = "/jspweb/css/board/board.css" rel="stylesheet">
	
</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->

	<div class="container">
	
		<div class="box">

			카테고리 	:
			<select class ="cno">
				<option value="0"> 전체 		</option>
				<option value="1"> 공지사항 	</option>
				<option value="2"> 커뮤니티 	</option>
				<option value="3"> QnA  	</option>
				<option value="4"> 노하우   	</option>
			</select>	
					  
			<button onclick="getBlist_c()" class="cbtn" type="button"> 출력 </button>
				  
			<a href="/jspweb/board/write.jsp"> 게시글 쓰기 </a>

			<table class="boardlist table table-hover" >
			
			</table>
		
			<select class="search">
				<option value="1"> 제목 		</option>
				<option value="2"> 작성자 	</option>
				<option value="3"> 작성일 	</option>
			</select>	
				
			<input class="searchinput" type="text">
				
					  
			<button onclick="searchBlist()" class="cbtn" type="button"> 검색 </button>	
		
		
		</div>
		
	</div>

	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>