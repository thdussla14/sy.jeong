<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<%@ include file = "header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->

	<div class="container">
	
		<h3> 포인트 결제 </h3>
	
		<button type="button" onclick="setPay(10000)">  10000원</button> 
		<button type="button" onclick="setPay(5000)">  5000원</button> 
	
		<button type="button" onclick="requestPay()">결제하기</button> <!-- 결제하기 버튼 생성 -->

	</div>

	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

	<script src="/jspweb/js/point.js" type="text/javascript"></script>
	
	
</body>
</html>