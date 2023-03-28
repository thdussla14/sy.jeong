<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 제품등록 </title>

	<style type="text/css">
		.fileDrop{width:500px; height : 150px; overflow:auto; border: 1px solid black;}
	</style>

</head>
<body>

	<%@ include file = "/header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->
	
	<div class="container"> 
	
		<form class="writeForm"> 
			
			제품명 	:  <input type="text" name="pname">			<br>
			제품설명 	:  <input type="text" name="pcontent">	 	<br>
			제품가격 	:  <input type="text" name="pprice">		<br>
			위치 		:  
			<div id="map" style="width:100%;height:350px;"></div>		
						
<!-- 		첨부파일	:
			<input type="file" name="pfiles" multiple="multiple" accept="image/*">	 -->		
						
			<!-- 드래그앤 드랍 : multiple -->
			<div class="fileDrop">
				여기에 첨부파일을 넣어주세요		
			</div>
			
			<button onclick="onwrite()" type="button"> 제품등록 </button>		
			
			
			
			
			<!-- 
				<h3>첨부파일 1개</h3>
				<input type="file" name="pfile" accept="image/*">	
				<h3>첨부파일 여러개</h3>
				<input type="file" name="pfile1" accept="image/*">
				<input type="file" name="pfile2" accept="image/*">
				<input type="file" name="pfile3" accept="image/*">
			 -->

			
			
			
		</form>
	
	
	</div>

	<%@ include file = "/footer.jsp" %>


	<!-- 카카오 지도에 필요한 클래스/메소드 가지고 있는 js 라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3af099b2c66ef75958a992c6b8ba20c3&libraries=services,clusterer,drawing"></script>

	<script src="/jspweb/js/product/write.js" type="text/javascript"></script>

</body>
</html>