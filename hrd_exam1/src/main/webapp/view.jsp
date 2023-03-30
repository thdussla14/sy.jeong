<%@page import="controller.memberDto"%>
<%@page import="java.util.ArrayList"%>
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
		
	<center> 
	
		<h3> 회원목록조회/수정 </h3>
		
		<table border="1" width="80%">
			<tr>
				<th> 회원번호 </th>
				<th> 회원성명 </th>
				<th> 전화번호 </th> 
				<th> 주소 	</th> 
				<th> 가입일자 </th> 
				<th> 고객등급 </th> 
				<th> 거주지역 </th> 
			</tr>	
			
	<% 
		Dao dao = new Dao();
	    ArrayList<memberDto> list = dao.getMemberlist();
		
		for(memberDto dto : list) {%>	
		
			<tr>
				<td> <a href="/hrd_exam1/update.jsp?custno=<%=dto.getCustno()%>"><%= dto.getCustno() %></a> </td>
				<td><%= dto.getCustname()%></td> 
				<td><%= dto.getPhone()%></td> 
				<td><%= dto.getAddress()%></td> 
				<td><%= dto.getJoindate()%></td> 
				<td><%= dto.getGrade()%></td> 
				<td><%= dto.getCity()%></td>
			</tr>	
			
	<% } %>							
		</table>
		
	</center>
	
	<%@include file = "footer.jsp" %>


</body>
</html>