console.log('pwrite js')

// 회원제 페이지 
if(memberInfo == null){
	alert('로그인 후 사용 가능한 기능입니다.'); location.href="/jspweb/member/login.jsp";
}



let plat = 0;
let plang= 0;

// 1. 제품 등록 
function onwrite(){
	
	let writeForm     = document.querySelectorAll('.writeForm')[0];
	let writeFormData = new FormData(writeForm);
	
	writeFormData.set("plat",plat);
	writeFormData.set("plang",plang);
	
	if( plat == 0 || plang == 0 ){alert('위치 선택 후 등록해주세요'); return ;}
	if(fileList.length < 1 ){alert('하나 이상의 이미지 등록해주세요'); return ;}
	
	// 폼에 첨부파일 등록 
	fileList.forEach((f)=>{
		writeFormData.append("fileList",f);
	})

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

//------- 드래그앤 드랍 구현 ---------------------------------------------------------
// 1. 드래그앤드랍 구역[DOM] 객체 호출
let fileDrop = document.querySelector('.fileDrop');
let fileList = [];

// 2. 해당 구역에 이벤트 등록
	// 2-1. dragenter
	fileDrop.addEventListener("dragenter",(e)=>{
		console.log('드래그 요소가 해당 구역에 닿았을때')
		// 문제점 : 브라우저 영역에 드랍했을때 해당 페이지 열림 [ 브라우저 자체 이벤트 실행 ]
		// 해결법	: 고유이벤트 [ 브라우저 자체 이벤트 ] 제거
		e.preventDefault(); 
	})
	// 2-2. dragover
	fileDrop.addEventListener("dragover",(e)=>{
		console.log('드래그 요소가 해당 구역에 위치하고 있을때')
		// 문제점 : 브라우저 영역에 드랍했을때 해당 페이지 열림 [ 브라우저 자체 이벤트 실행 ]
		// 해결법	: 고유이벤트 [ 브라우저 자체 이벤트 ] 제거
		e.preventDefault(); 
		fileDrop.style.backgroundColor = '#e8e8e8';
	})
	// 2-3. dragleave
	fileDrop.addEventListener("dragleave",(e)=>{
		console.log('드래그 요소가 해당 구역에서 나갈때')
		// 문제점 : 브라우저 영역에 드랍했을때 해당 페이지 열림 [ 브라우저 자체 이벤트 실행 ]
		// 해결법	: 고유이벤트 [ 브라우저 자체 이벤트 ] 제거
		e.preventDefault(); 
		fileDrop.style.backgroundColor = '#ffffff';
	})
	// 2-4. drop
	fileDrop.addEventListener("drop",(e)=>{
		console.log('드래그 요소가 해당 구역에 드랍되었을때')
		// 문제점 : 브라우저 영역에 드랍했을때 해당 페이지 열림 [ 브라우저 자체 이벤트 실행 ]
		// 해결법	: 고유이벤트 [ 브라우저 자체 이벤트 ] 제거
		e.preventDefault(); 
		// 드랍된 파일 호출
		let files = e.dataTransfer.files;
		console.log(files)		
		// 드랍된 파일 files forEach 사용불가 
		for(let i=0 ; i<files.length ; i++){
				if(files[i] != null && files[i] != undefined){ // 파일이 존재하면 
				fileList.push(files[i]);}
		}
		printfiles();
		fileDrop.style.backgroundColor = '#ffffff';
		console.log(fileList)		
	})
	
// 3. 해당구역에 드랍된 파일 목록 출력
function printfiles(){
	let html = '';
	fileList.forEach((f,i)=>{
		console.log(f.name);
		let fname = f.name; // 파일명 호출
		let fsize = (f.size/ 1024).toFixed(1); // 파일용량 [바이트->키로바이트]
		html += `<div>
					<span>${fname}</span> <span>${fsize}KB</span>
					<span><button type="button" onclick="filedelete(${i})"> 삭제 </button></span>
				</div>`
	})
	fileDrop.innerHTML = html;
}
// 4. 선택한 파일 취소
function filedelete(i){
	fileList.splice(i,1);printfiles();
}




