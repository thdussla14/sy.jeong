<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

	<link href = "/jspweb/css/admin/info.css" rel="stylesheet">

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- (webapp 이하 생략) 절대 경로  -->
	<div class="container">
		
		<h3> Chart.js 사용 </h3>
		<div>		
			 <canvas id="myChart"></canvas>		
		</div>
	
	
		<h3> 회원 명단 </h3>
		
		<div class="top">
			<button onclick="reset()" class="cbtn" type="button"> 전체보기 </button>	
			<div class="searchcount"> 총 게시물 수  </div>
			<select class="listsize" onchange="setsize()">
					<option value="3" >3 </option>
					<option value="5" >5 </option>
					<option value="10">10</option>
			</select>
		</div>
		<!-- 검색 -->		
		<div class="searchbox">				
			<select class="key">
				<option value="mno"> 		회원번호 	</option>
				<option value="mid"> 		아이디 	</option>
				<option value="memail"> 	이메일 	</option>
			</select>					
			<input  class="keyword" type="text">							  
			<button onclick="searchMlist()" class="cbtn" type="button"> 검색 </button>		
			<span class="searchcount"> </span>
		</div>	
		
		
		<table class ="box table table-hover"> 
		
		</table>
		
		<!-- 페이징 처리 버튼들 -->
		<div class="page btn-group"> 

		</div>
			

		
	</div>
	<%@ include file = "/footer.jsp" %>
	
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="/jspweb/js/admin/info.js" type="text/javascript"></script>
	
</body>
</html>