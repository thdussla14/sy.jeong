<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/practice/과제1/과제1.css" rel="stylesheet">

</head>
<body>
	<!-- 인사등록 -->
	<div>
		<form action="">
			사원명 : <input type="text"> <br>
			직급 :<select>
					<option>인턴</option>
					<option>사원</option>
					<option>대리</option>
					<option>부장</option>
					<option>과장</option>
					<option>대표</option>
				</select>	<br>		
			고용형태 :<select>
					<option>계약직</option>
					<option>정규직</option>
					<option>임원</option>
				</select><br>
			부서 :<select>
					<option>인사팀</option>
					<option>영업팀</option>
					<option>개발팀</option>
				</select><br>
			입사일 :<input type="date"><br>
			사원사진 :<input type="file"><br>
		</form>
	</div>
	

	
	<!-- 인사수정 -->
	<div>
		<table>
			<tr>
				<th>사원번호</th>
				<th>사원사진</th>
				<th>사원명</th>
				<th>직급</th>
				<th>고용형태</th>
				<th>부서</th>
				<th>입사일</th>
				<th>퇴사일</th>
				<th>퇴사사유</th>
			</tr>
			
			<tr>
				<td>사원번호X</td>
				<td>사원사진v</td>
				<td>사원명v</td>
				<td>직급v</td>
				<td>고용형태v</td>
				<td>부서v</td>
				<td>입사일v?</td>
				<td>퇴사일v</td>
				<td>퇴사사유v</td>
			</tr>
		</table>
	</div>
	
	
	<!-- 인사출력 -->
	<button onclick = "getStaff()"  	type="button"> 전체 </button>
	<button onclick = "getStaff_e()"  	type="button"> 직무 </button>
	<button onclick = "getStaff_d()" 	type="button"> 퇴사 </button>
	
	<div> 사원검색 : <input class="search" type="text">
		<button onclick = "searchStaff()" 	type="button"> 검색 </button>
	</div>
	
	<div>
		<table class="stafftable" border="1">

		</table>
	</div>
	
	<!-- 인사삭제 -->

	<div class="modal_wrap_D">	
		<div class="modal_box">
		
		<h3  class="modal_title">  인사 기록을 삭제하시겠습니까? </h3>		
		<div class="modal_content">
				<div> 사원번호 : <input class="sno" type="text"> </div>
		</div>
		
		<div class="modal_content">
			<button onclick="deleteStaff()"   class="modal_cancel btns" type="button"> 삭제 </button>
			<button onclick="closemodal_D()"  class="modal_cancel btns" type="button"> 취소 </button>
		</div>
			
		</div>	<!-- modal_box e -->
	</div>	<!-- modal_wrap e -->
	


	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/practice/과제1/과제1.js" type="text/javascript"></script>
	
</body>
</html>