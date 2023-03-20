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
		<div class="boardbox"> 
			<div class="toptitle">
				<h3  class="cname"> </h3>
				<p> 다양한 사람들과 정보를 공유해보세요. </p>
			</div>
			
			<div class="topetc">
			
				<a href="/jspweb/board/write.jsp"> <button class="cbtn">글쓰기 <i class="fas fa-pen"></i></button> </a>
				<div> 
					<span class="searchcount"> 총 게시물 수  </span>
					<button onclick="reset()" class="cbtn" type="button"> 전체보기 </button>	
					<select class="listsize" onchange="setsize()">
						<option value="3" >3</option>
						<option value="5" >5</option>
						<option value="10">10</option>
					</select>
				</div>				
			</div> <!-- topetc e -->

			<div class="boardlist table table-hover" >

			</div>
			<!-- 페이징 처리 버튼들 -->
			<div class="page"> 

			</div>
			<!-- 검색 -->		
			<div class="searchbox">				
				<select class="key">
					<option value="b.btitle"> 	제목 		</option>
					<option value="m.mid"> 		작성자 	</option>
					<option value="b.bdate"> 	작성일 	</option>
					<option value="b.bcontent"> 내용 		</option>
				</select>					
				<input  class="keyword" type="text">							  
				<button onclick="searchBlist()" class="cbtn" type="button"> 검색 <i class="fas fa-search"></i></button>		
			</div>	
			
		</div> <!-- boardbox e -->
	</div> <!-- container e -->


	<%@ include file = "/footer.jsp" %>

	<script src="/jspweb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>