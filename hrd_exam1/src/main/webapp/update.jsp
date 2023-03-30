<%@page import="controller.Dao"%>
<%@page import="controller.memberDto"%>
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
		int custno = Integer.parseInt(request.getParameter("custno"));
	
		Dao dao    = new Dao();
		memberDto dto = dao.getMember(custno);
	
	%>

	<center> 	
		<h3> 홈쇼핑 회원 수정 </h3>
		<form name="updateform"  action="/hrd_exam1/exam" method="get">
			<table border="1" width="600px">
				<tr>
					<th> 회원번호 </th> 
					<td> <input name="custno"   type="text" value="<%=custno%>"></td>
				</tr>
				<tr>
					<th> 회원성명 </th> 
					<td> <input name="custname" type="text" value="<%=dto.getCustname()%>" ></td>
				</tr>
				<tr>
					<th> 회원전화 </th> 
					<td> <input name="phone"   type="text"  value="<%=dto.getPhone()%>" ></td>
				</tr>
				<tr>
					<th> 회원주소 </th> 
					<td> <input name="address" type="text"  value="<%=dto.getAddress()%>" ></td>
				</tr>		
				<tr>
					<th> 가입일자 </th> 
					<td> <input name="joindate" type="text" value="<%=dto.getJoindate()%>"></td>
				</tr>		
				<tr>
					<th> 고객등급 [A:VIP,B:일반,C:직원] </th> 
					<td> <input name="grade" type="text"    value="<%=dto.getGrade()%>"></td>
				</tr>
				<tr>
					<th> 도시코드 </th> 
					<td> <input name="city"  type="text"    value="<%=dto.getCity()%>"></td>
				</tr>	
				<tr>
					<th colspan="2"> 
						<button onclick="update()" type="button"> 수정 </button>
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