<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시글 수정 </title>
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
		
		String bno = request.getParameter("bno");
		
	%>
	<input type="hidden" class="bno" value="<%=bno%>">
	
	<div class="container">
	
		<div class="box">
		
		<form class="updateform">
		
		<h3> 게시물 수정 </h3>

		<div class="col-auto">
		 <label class="form-label">카테고리 	:</label>		 
					 <select class="form-control cno"	name="cno">
						<option value="1"> 공지사항 	</option>
						<option value="2"> 커뮤니티 	</option>
						<option value="3"> QnA  	</option>
						<option value="4"> 노하우   	</option>
					  </select>		
		</div>
		<div class="col-auto">
		<label class="form-label">제목		:</label>		  								
			 <input  class="form-control btitle"	name="btitle" 	type="text">
		</div>
		<div class="col-auto">	
		<label class="form-label">내용		:</label>			
			 <textarea class="form-control bcontent" name="bcontent" rows="" cols=""></textarea>
		</div>
		<div class="col-auto">			 
		<label class="form-label">첨부파일		:</label>	
			 <div class="oldbfilebox"> </div>
			 <input  class="form-control bfile"	name="bfile" 	type="file">		
		</div>		 			
			<button onclick="bupdate()"  class="btn btn-primary" type="button"> 수정완료 </button>			
		</form>
	
		</div>
		
	</div>

	<%@ include file = "/footer.jsp" %>
	
	<script src="/jspweb/js/board/update.js" type="text/javascript"></script>