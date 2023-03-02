<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> 예제1 : [C:쓰기] 입력받은 데이터 -> JS -> 서블릿 -> DAO </h3>
	<input  type="text" class="inputdata">
	<button type="button" onclick="Ex1()"> 예제1 실행</button>

	<h3> 예제2 : [R:읽기] DB저장 데이터 DAO -> 서블릿 -> JS -> </h3>
	<div class = "ex2box"> </div>

	<h3> 과제1 : </h3>
	
	<h3> 과제1 :[C:쓰기] </h3>
	<input type="text" class="data">
	<button type="button" onclick="과제1C()">과제1 실행</button> 
	<h3> 과제1 :[R:읽기] </h3>
	<div class="box"> </div>


	<!--  최신 jquery -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- JS 연동 -->
	<script  src="js/index.js" type="text/javascript"></script>

</body>
</html>