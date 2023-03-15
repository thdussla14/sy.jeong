<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 게시판 글작성 </title>
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
	
		<h3> 글쓰기 </h3>

		<form class="writeform">
			카테고리 	:
					 <select 	name="cno">
						<option value="1"> 공지사항 	</option>
						<option value="2"> 커뮤니티 	</option>
						<option value="3"> QnA  	</option>
						<option value="4"> 노하우   	</option>
					  </select>					  
			제목		: <input  	name="btitle" 	type="text">
			내용		: <textarea name="bcontent" rows="3" cols="3"></textarea>
			첨부파일	: <input 	name="bfile" 	type="file">				
			<button onclick="bwrite()" type="button"> 글등록 </button>
		</form>
	
	
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