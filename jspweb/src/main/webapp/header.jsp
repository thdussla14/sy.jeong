<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 모든 페이지 공통 css -->
	<link href = "/jspweb/css/index.css" rel="stylesheet">
</head>
<body>

	<h3> 헤더 입니다. </h3>
	<!-- 모든 페이지 공통 메뉴 !! url : 절대경로 !! -->
	<div class="header"></div>
	
	
	<!-- 모든 페이지 공통 js -->
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/js/header.js" type="text/javascript"></script>
	
</body>
</html>



<%-- 

	<% String login = (String)request.getSession().getAttribute("login"); 	%>	
	<a href = "/jspweb/index.jsp">			 	홈 		</a>
	<% if(login == null){  										// 로그인전  	%>
		<a href = "/jspweb/member/signup.jsp"> 회원가입 	</a>
		<a href = "/jspweb/member/login.jsp"> 	로그인 	</a>
	<% }else if(login.equals("admin") ){						// 관리자로그인 %>
		<a href = "/jspweb/admin/info.jsp"> 관리자 페이지 	</a>
		<a href = "/jspweb/member/logout.jsp"> 	로그아웃 	</a>
	<% }else {													// 로그인 	%>
	<%=login%>님 안녕하세요!
	<a href = "/jspweb/member/logout.jsp"> 	    로그아웃 	</a>
	<% } 	%> 
	
	--%>


