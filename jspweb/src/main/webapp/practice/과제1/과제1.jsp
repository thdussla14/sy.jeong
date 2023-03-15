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

	<div class="wrap">
		<!-- 인사등록 -->
		<div class="box1">
		 <div class="form-wrap">
			<h3>인사등록</h3>
			<form class="insertForm">
			<div class="form-group">
				<label for="sname">사원명 :</label>
				 	<input type="text" 		class="sname" 	name="sname" maxlength="10"> 
			</div>	
			<div class="form-group">
				<label for="sname">직급 :</label>	
					<select 				class="sclass" 	name="sclass">
							<option>인턴</option>
							<option>사원</option>
							<option>대리</option>
							<option>부장</option>
							<option>과장</option>
							<option>대표</option>
						</select>														
			</div>
			<div class="form-group">
				<label for="sname">고용형태 :</label>	
					<select 				class="stype" 	name="stype">
							<option>계약직</option>
							<option>정규직</option>
							<option>임원</option>
						</select><br>
			</div>
			<div class="form-group">
				<label for="sname">부서   :</label>		
				<select 				class="field" 	name="field">
							<option>인사팀</option>
							<option>영업팀</option>
							<option>개발팀</option>
						</select>
			</div>
			<div class="form-group">
				<label for="sname">입사일 :</label>	
					<input type="date" 		class="edate" 	name="edate">
			</div>
			<div class="form-group">
				<label for="sname">사원사진 :</label>	
				
					<div class="pimgbox">
						<input 	type="file" 	class="simg" 	name="simg" 	onchange="premimg(this)"><br>		
						<img class="premimg" alt="" src="/jspweb/practice/과제1/simg/default.webp">
					</div>
			</div>	
				<button type="button" onclick="insertStaff()" class="insertStaff">등록</button>
			</form>
		</div>
			
			<div class="fieldbox">
				<h3>부서</h3>
				<table class="fieldtable" border="1">
				</table>
			</div>
			
			
		</div>
		
		<!-- 인사출력 -->
		<div class="box2">
		<h3>인사목록</h3>
			<div class="top">
				<button onclick = "getStaff()"  	type="button"> 전체 </button>
				<button onclick = "getStaff_e()"  	type="button"> 재직 </button>
				<button onclick = "getStaff_d()" 	type="button"> 퇴사 </button>
			
				<span> 사원검색 : <input class="search" type="text">
					<button onclick = "search()" 	type="button"> 검색 </button>
				</span>
			</div>
			<div>
				<table class="stafftable" border="1">
		
				</table>
			</div>
		</div>
	</div>
	
	
	
	<!-- 인사수정 -->
	<div class="update_modal_wrap">
		<div class="update_modal_box">
		<div class="form-wrap">
				<form class="updateForm">
					<div class="form-group">
						<label for="sno">사원번호 : </label>
						<span class="update_sno" 	name="update_sno" ></span> <br>
					</div>
					<div class="form-group">
						<label for="simg">사원사진 :	</label>							
						<div class="update_pimgbox">
							<input 	type="file" 	class="update_simg" 	name="update_simg" 	onchange="update_premimg(this)"> <br>		
							<img width=30% class="update_premimg" alt="" src="/jspweb/practice/과제1/simg/default.webp">
						</div>
					</div>
					<div class="form-group">
						<label for="sname">사원명 : 	</label>							
						<input type="text" 		class="update_sname" 	name="update_sname"> 
					</div>
					<div class="form-group">
						<label for="sname">직급 :	 	</label>	
						<select 				class="update_sclass" 	name="update_sclass">
									<option>인턴</option>
									<option>사원</option>
									<option>대리</option>
									<option>부장</option>
									<option>과장</option>
									<option>대표</option>
						</select>														
					</div>
					<div class="form-group">
						<label for="sname">고용형태 :	</label>
					<select 				class="update_stype" 	name="update_stype">
								<option>계약직</option>
								<option>정규직</option>
								<option>임원</option>
							</select><br>
					</div>
					<div class="form-group">
						<label for="sname">부서 :	 	</label>
						<select 				class="update_field" 	name="update_field">
								<option>인사팀</option>
								<option>영업팀</option>
								<option>개발팀</option>
						</select>
					</div>
					<div class="form-group">
						<label for="sname">입사일 :	</label>
						<span class="update_edate" 	name="update_edate"></span>
					</div>
					<div class="form-group">
						<label for="sname">퇴사일 :		</label>
						<input type="date" class="update_ddate" 	name="update_ddate">
					</div>
					<div class="form-group">
						<label for="sname">퇴사사유 :</label>
						<input type="text" class="update_dcontent" 	name="update_dcontent">
					</div>

					<div class="update_modal_btns">
						<button type="button" onclick="updateStaff()" class="update_modal_btns">등록</button>
						<button type="button" onclick="closeupdateModal()" class="update_modal_btns">취소</button>
					</div>
				</form>
			</div>
		</div>
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
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/jspweb/practice/과제1/과제1.js"></script>
	
</body>
</html>