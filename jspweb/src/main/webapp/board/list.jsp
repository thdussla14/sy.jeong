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

	<%
		// 1. jsp 이용한 http url 변수 호출
		String cno = request.getParameter("cno");
	%>
	<!-- cno 숨겨서 js 전달 -->
	<input type="hidden" class="cno" value="<%=cno%>">
	
	
	<div class="container">
	
		<h3  class="cname"> </h3>
		
			<a href="/jspweb/board/write.jsp"> <button class="cbtn"> 게시글 쓰기</button> </a>
			<button onclick="reset()" class="cbtn" type="button"> 전체보기 </button>	
			<div class="searchcount"> 총 게시물 수  </div>
			<select class="listsize" onchange="setsize()">
				<option value="3" >3</option>
				<option value="5" >5</option>
				<option value="10">10</option>
			</select>
			
			<!-- 검색 -->		
			<div class="searchbox">				
				<select class="key">
					<option value="b.btitle"> 	제목 		</option>
					<option value="m.mid"> 		작성자 	</option>
					<option value="b.bdate"> 	작성일 	</option>
					<option value="b.bcontent"> 내용 		</option>
				</select>					
				<input  class="keyword" type="text">							  
				<button onclick="searchBlist()" class="cbtn" type="button"> 검색 </button>		
			</div>		



			<table class="boardlist table table-hover" >
			
			</table>

			<!-- 페이징 처리 버튼들 -->
			<div class="page btn-group"> 

			</div>
			
			

	</div>

	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>