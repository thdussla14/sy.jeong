<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file = "header.jsp" %>

	<%
		// 마지막 회원번호 +1
		Dao dao = new Dao();
		int custno = dao.getMno()+1;	
		// 오늘 날짜 구하기
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String now = sdf.format(date);
	%>

	<center> 	
		<h3> 홈쇼핑 회원 등록 </h3>
		<form name="signupform"  action="/hrd_exam1/exam" method="post">
			<table border="1" width="600px">
				<tr>
					<th> 회원번호 (자동발생) </th> 
					<td> <input name="custno"   type="text" value="<%=custno%>"></td>
				</tr>
				<tr>
					<th> 회원성명 </th> 
					<td> <input name="custname" type="text" ></td>
				</tr>
				<tr>
					<th> 회원전화 </th> 
					<td> <input name="phone"   type="text" ></td>
				</tr>
				<tr>
					<th> 회원주소 </th> 
					<td> <input name="address" type="text" ></td>
				</tr>		
				<tr>
					<th> 가입일자 </th> 
					<td> <input name="joindate" type="text" value="<%=now%>"></td>
				</tr>		
				<tr>
					<th> 고객등급 [A:VIP,B:일반,C:직원] </th> 
					<td> <input name="grade" type="text" ></td>
				</tr>
				<tr>
					<th> 도시코드 </th> 
					<td> <input name="city"  type="text" ></td>
				</tr>	
				<tr>
					<th colspan="2"> 
						<button onclick="signup()" type="button"> 등록 </button>
						<a href="/hrd_exam1/view.jsp"><button type="button"> 조회 </button></a>
					</th> 
				</tr>								
			</table>
		</form>
	</center>

	<%@include file = "footer.jsp" %>

	<script src="/hrd_exam1/js/signup.js" type="text/javascript"></script>
	
</body>
</html>