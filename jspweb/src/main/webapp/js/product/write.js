console.log('pwrite js')

let plat = 0;
let plang= 0;

// 1. 제품 등록 
function onwrite(){
	
	let writeForm     = document.querySelectorAll('.writeForm')[0];
	let writeFormData = new FormData(writeForm);
	
	writeFormData.set("plat",plat);
	writeFormData.set("plang",plang);
	
	if( plat == 0 || plang == 0 ){alert('위치 선택 후 등록해주세요')}
	
	console.log(writeFormData)

	$.ajax({
		url		: "/jspweb/productinfo",
		method	: "post",
		data	: writeFormData,
		contentType : false,
        processData : false,
		success : (r)=>{
			console.log('응답')
			console.log(r)
			if(r=='true'){alert('등록 성공'); location.href="/jspweb/index.jsp"}
			else{alert('등록 실패')}
		}
	})	
}

//-------지도를 표시할 div --------------------------------------------------------------
var mapContainer = document.getElementById('map'),
    mapOption = { 
		// 지도의 중심 지정
        center: new kakao.maps.LatLng(37.3218778,126.8308848), 
        // 지도의 확대 레벨
        level: 3 
    };
// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption); 

//-------지도를 클릭한 위치에 표출할 마커-----------------------------------------------------
// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

//------- 지도에 클릭 이벤트를 등록---------------------------------------------------------
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
	plat = latlng.getLat() ; console.log('위도 : '+plat)
	plang= latlng.getLng() ; console.log('경도 : '+plang)
    
});












