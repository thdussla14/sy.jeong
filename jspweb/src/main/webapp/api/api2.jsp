<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 카카오 지도 </title>
</head>
<body>

	<%@include file="/header.jsp" %>

	<div class="container"> 

		<div id="map" style="width:500px;height:400px;"></div>
		
	</div>

	<%@include file="/footer.jsp" %>
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c046128498eec11ec40c8070276fb71d"></script>
	<script src ="/jspweb/api/api2.js" type="text/javascript"></script>
	
</body>
</html>