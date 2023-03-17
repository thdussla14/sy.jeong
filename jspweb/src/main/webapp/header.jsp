<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 부트스트랩  -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" >
	<!-- 모든 페이지 공통 css -->
	<link href = "/jspweb/css/modal.css" rel="stylesheet">
	<link href = "/jspweb/css/index.css" rel="stylesheet">

	
</head>
<body>

	<div class="container">
	
		<div class="header">
			
			<!-- logo -->
			<div class="mainlogo"> 				
				<a href="/jspweb/index.jsp">
					<img src="/jspweb/img/logo.png">
				</a>
			</div>
			
			<!-- 본메뉴 -->
			<ul class="mainmenu"> 
				<li><a href="/jspweb/board/list.jsp?cno=1"> 공지사항 	</a></li>
				<li><a href="/jspweb/board/list.jsp?cno=2"> 커뮤니티 	</a></li>
				<li><a href="/jspweb/board/list.jsp?cno=3"> QnA 	</a></li>
				<li><a href="/jspweb/board/list.jsp?cno=4"> 노하우	</a></li>
				<li><a href="#"> 기능메뉴5 </a></li>
				<li><a href="#"> 기능메뉴6 </a></li>
				<li><a href="#"> 기능메뉴7 </a></li>
			</ul>
			
			<!-- 서브메뉴 -->
			<div class="submenu"> 

		
			</div>
			
		</div>	<!-- header e -->
		
	</div>	<!-- container e -->
	
	<!-- 모든 페이지 공통 js -->
	<!-- jquery -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- 사용자정의 -->
	<script src ="/jspweb/js/modal.js"  type="text/javascript"></script>	
	<script src ="/jspweb/js/header.js" type="text/javascript"></script>

	
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


