<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h3> 예1) [C] HTML -document.querySelector-> JS -AJAX-> servlet -메소드-> DAO </h3>
	
	data1[문자열] 	: <input type="text" 			class="data1">		<br/>
	data2[패스워드] 	: <input type="password" 		class="data2"> 		<br/>
	data3[실수]		: <input type="text"			class="data3">		<br/>
	data4[정수]		: <input type="number"			class="data4">		<br/>
	data5[날짜]		: <input type="date"			class="data5">		<br/>
	data6[날짜/시간]	: <input type="datetime-local"	class="data6">		<br/>
	data7[선택버튼]	: <input type="radio" name="data7" value="남"> 남
					  <input type="radio" name="data7" value="여"> 여		<br/>
	data8[체크상자]	: <input type="checkbox"		class="data8">승인	<br/>
	data9[목록상자]	: <select class="data9">
						<option> 안산 </option><option> 수원 </option><option> 성남 </option>
					 </select>											    <br/>
	data10[긴글]		: <textarea  class="data10" rows="" cols=""></textarea>	<br/>			 
					 
	<button type="button" onclick="Ex1()">전송</button>				 
	
	<h3> 예1) [R] DAO -|메소드|-> servlet -|AJAX/JSON|-> JS -|document.querySelector|->  HTML</h3>
	<div class="box"></div>
	
	
	<h3> 과제2 : 학생 명단 등록 </h3>
	이름			: <input type="text" 			class="sdata1">		<br/>
	전화번호		: <input type="text" 			class="sdata2">		<br/>
	키			: <input type="text" 			class="sdata3">		<br/>
	나이			: <input type="number" 			class="sdata4">		<br/>
	등록일		: <input type="date" 			class="sdata5">		<br/>
	성별			: <input type="radio" name="sdata6" value="남">	남	
				  <input type="radio" name="sdata6" value="여">	여	<br/>
	개인정보동의	: <input type="checkbox" 		class="sdata7">	동의	<br/>
	사는지역		: <select class="sdata8">
					<option>안산</option><option>안양</option><option>수원</option>
				 </select>											<br/>
	자기소개		: <textarea class="sdata9" rows="" cols="" ></textarea><br/>
	
	<button type="button" onclick="Register()">등록</button>
	
	<h3> 학생 명단 </h3>
	
	<div class="box2"> </div>
	
	
	
	<!-- 순서 중요 사용자정의 js가 가장 마지막 -->
	<!-- 1. 최신 JQUERY (AJAX 사용시 필요!) -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 2. JS 연동 -->
	<script  src="index.js" type="text/javascript"></script>

</body>
</html>