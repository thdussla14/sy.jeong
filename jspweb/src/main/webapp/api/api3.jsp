<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 안산시 약국 API </title>
</head>
<body>

	<%@include file="/header.jsp" %>
	
	<div class="modal_wrap">	
			<div class="modal_box">
			
			<h3  class="modal_title">  </h3>		
			<div class="modal_content">
			
			</div>
			
			<div class="modal_content">
				<button onclick="closemodal()" class="modal_cancel btns" type="button"> 닫기 </button>
			</div>
				
			</div>	<!-- modal_box e -->
	</div>	<!-- modal_wrap e -->
	
	
	<div class="container"> 
	
		<!-- 카카오 지도가 표시될 구역 -->
		<div id="clickLatlng"></div>
		<!-- 카카오 지도가 표시될 구역 -->
		<div id="map" style="width:100%;height:700px;"></div>
		
	</div>

	<%@include file="/footer.jsp" %>
	
	<!-- 카카오 지도에 필요한 클래스/메소드 가지고 있는 js 라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	3af099b2c66ef75958a992c6b8ba20c3&libraries=services,clusterer,drawing"></script>
	
	<script src ="/jspweb/api/api3.js" type="text/javascript"></script>


</body>
</html>