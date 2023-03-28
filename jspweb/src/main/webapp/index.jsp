<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>

	<%@ include file = "header.jsp" %>	<!-- JSP 별도의 페이지를 현재 페이지에 삽입 -->

		
		<div class="search_box"> 검색창 </div>
		
		<div class="mapbox">
			<div id="map" style="width:75%;height:700px;"></div>	
			
			<div class="productlistbox">

			</div>	
		
		</div>

	<%@ include file = "footer.jsp" %>
	
	<!-- 카카오 지도에 필요한 클래스/메소드 가지고 있는 js 라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3af099b2c66ef75958a992c6b8ba20c3&libraries=services,clusterer,drawing"></script>

	<script src="/jspweb/js/index.js" type="text/javascript"></script> 
	
</body>
</html>