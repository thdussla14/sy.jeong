console.log('index js')


let productList = null;
// 사이드바 제품 목록 출력---------------------------------------------------------------------------------------------------
function printproductList(){
	
	let html = '';
			productList.forEach((o,i)=>{
				html+=`<div onclick="printProduct(${i})" class="productbox">
							<div class="pimgbox">
								<img src="/jspweb/product/pimg/${o.pimglist[0]}">
							</div>
							<div class="pcontentbox">
								<div class="pdate">  ${o.pdate} 	</div>
								<div class="pname">  ${o.pname}		</div>
								<div class="pprice"> ${o.pprice}원 	</div>
								<div class="petc">
									<i class="far fa-eye"></i> ${o.pview}	<!-- 조회수 -->
									<i class="far fa-thumbs-up"  ></i> 5	<!-- 찜수 -->
									<i class="far fa-comment-dots"></i> 2	<!-- 쪽지수 -->						
								</div>
							</div>
						</div>`
			})			
	 document.querySelector('.productlistbox').innerHTML = html;
}
// 제품 1개 출력---------------------------------------------------------------------------------------------------------
function printProduct(i){
		
		let p = productList[i];console.log(p);
		
		let imghtml = ``;
		
		p.pimglist.forEach((img,i)=>{			
			if(i==0){
				imghtml+=`<div class="carousel-item active">
							<img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
						</div>`
			}else{
				imghtml+=`<div class="carousel-item">
							<img src="/jspweb/product/pimg/${img}" class="d-block w-100" alt="...">
						</div>`
			}
		})

		let html = ``;
		html +=`<div class="pviewbox">
				
						<!-- 등록한 회원 정보 -->
						<div class="pviewinfo">
							<div class="mimgbox">
								<img src="/jspweb/member/pimg/사람.png" class="hpimg" alt="" > <span class="mid"> qweqwe </span>
							</div>
							<div>
								<button class="pbadge" onclick="get동서남북()" type="button"> 목록보기 </button>
							</div>
						</div>
					
						<!-- 등록한 회원 정보 -->
						<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
						  <div class="carousel-inner">
						    ${imghtml}
						  </div>
						  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Previous</span>
						  </button>
						  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Next</span>
						  </button>
						</div>
						
						<!-- 제품 상세 내용 -->
						<div class="pdate">  	${p.pdate} 			</div>
						<div class="pname">   	${p.pname}			</div>
						<div class="pcontent"> 	${p.pcontent}		</div>
						<div class="pstate"> 	<span class="pbadge"> ${p.pstate==1?'판매중':'거래완료'}</span> </div>
						<div class="pprice"> 	${p.pprice.toLocaleString()} 원 </div>
						<div class="petc"> 
							<i class="far fa-eye"></i>${p.pview}	<!-- 조회수 -->
							<i class="far fa-thumbs-up"  ></i> 5	<!-- 찜수 -->
							<i class="far fa-comment-dots"></i> 2	<!-- 쪽지수 -->							
						</div>
						<div class="pviewbtnbox">
							<button class="plikebtn" onclick="setplike(${p.pno})" type="button"><i class="far fa-heart"></i> </button>
							<button onclick="chatprint(${i})" type="button"> 채팅 </button>
						</div>
						
				</div> <!-- pviewbox e -->`		
							
		document.querySelector('.productlistbox').innerHTML = html;	
		getplike(p.pno); 
}

// 채팅페이지로 전환-------------------------------------------------------------------------------
function chatprint(i){
	
	if(memberInfo == null){
		alert('회원제 기능입니다. 로그인 후 사용해주세요.'); return ; 
	}
	let chathtml ='';
	let p = productList[i];console.log(p);
	
	$.ajax({
			url 	: "/jspweb/pchat",
			method 	: "get",
			data	:{"pno":p.pno},
			async	: false,
			success	: (r)=>{
				console.log(r)
				r.forEach((o)=>{
					if(o.frommno == memberInfo.mno){
						chathtml +=`<div class="sendbox">		${o.ncontent}	</div>`
					}else{
						chathtml +=`<div class="recievebox">	${o.ncontent}	</div>`
					}
				})
			
			
			} // success e
		}) // ajax e

	let html = `	<div class="chatbox">
					
						<!-- 등록한 회원 정보 -->
						<div class="pviewinfo">
							<div class="mimgbox">
								<img src="/jspweb/product/pimg/${p.pimglist[0]}" class="hpimg" alt="" > 
								<span class="pname"> ${p.pname} </span>
							</div>
							<div>
								<button class="pbadge" onclick="get동서남북()" type="button"> 목록보기 </button>
							</div>
						</div>
						
						<div class="chatcontent">
							${chathtml}
						</div><!-- chatcontent e -->
						
						<div class="chatbtn">
							<textarea class="ncontentinput" rows="" cols=""></textarea>
							<button onclick="sendchat(${p.pno},${p.mno})" type="button"> 전송 </button>
						</div>
						
						
					</div> <!-- chatbox e -->`
	
	document.querySelector('.productlistbox').innerHTML = html;
}

// 쪽지보내기  ----------------------------------------------------------------------------------
function sendchat(pno,tomno){
	
	if(memberInfo.mno == tomno){
		alert('본인에게 쪽지 보내기는 불가능합니다.'); return ;
	}
	
	let ncontent = document.querySelector('.ncontentinput').value;	
	console.log(ncontent)
	
	$.ajax({
		url 	: "/jspweb/pchat",
		method 	: "post",
		data	:{"pno":pno ,"tomno":tomno ,"ncontent":ncontent},
		success	: (r)=>{
			if(r=='true'){
				document.querySelector('.ncontentinput').value ='';
			}else{
				alert('[오류] 관리자에게 문의바랍니다.')
			}
			
		} // success e
	}) // ajax e	
}

// 찜하기 추가/취소 -----------------------------------------------------------------------------
function setplike(pno){
	console.log(pno)
	
	if(memberInfo == null){
		alert('회원제 기능입니다. 로그인 후 사용해주세요.'); return ; 
	}
	
	// $.get ("/jspweb/plike?pno"=pno,(r)=>{})
	// $.post("/jspweb/plike",{"pno":pno},(r)=>{}) // post 방식은 물음표 사용 불가능 !!!!!!
	
	$.ajax({
		url 	: "/jspweb/plike",
		method 	: "post",
		data	: {"pno": pno},
		success	: (r)=>{
			console.log(r)
			if(r=='true'){
				alert('찜하기 등록');
				document.querySelector('.plikebtn').innerHTML = '<i class="fas fa-heart"></i>'  ; 
			}else{
				alert('찜하기 취소');
				document.querySelector('.plikebtn').innerHTML = '<i class="far fa-heart"></i>' ; 
			}
		} 
	})	
}
// 찜하기 불러오기 ---------------------------------------------------------------------------
function getplike(pno){
	console.log(pno)	
	if(memberInfo == null){return document.querySelector('.plikebtn').innerHTML='<i class="far fa-heart"></i>';}
	$.ajax({
		url 	: "/jspweb/plike",
		method 	: "get",
		async 	: false,
		data	: {"pno": pno},
		success	: (r)=>{
			console.log(r)
			if(r=='true'){document.querySelector('.plikebtn').innerHTML='<i class="fas fa-heart"></i>';}
			else{document.querySelector('.plikebtn').innerHTML='<i class="far fa-heart"></i>' ;}
		} 
	})	
}

//-------지도를 표시할 div -----------------------------------------------------------------------
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

// --------- 마커 클러스터[ 마커들을 관리 ] -------------------------------------------------- 
 // 마커 클러스터러를 생성합니다 
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
        minLevel: 4 // 클러스터 할 최소 지도 레벨 
    });
 
// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";  

// ----------좌표구하기-------------------------------------------------------------------
get동서남북();
function get동서남북(){	
	// 지도의 현재 영역을 얻어옵니다 
    var bounds   = map.getBounds();
    // 영역의 남서쪽 좌표를 얻어옵니다 
    var swLatLng = bounds.getSouthWest(); 
    // 영역의 북동쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast(); 
    
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 북 = neLatLng.getLat();
    let 동 = neLatLng.getLng();
    
    getPlist(동,서,남,북)
}
// ----------------------------------------------------------------------------------------
// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener(map, 'dragend', function() {
	get동서남북();
});
// ----------------------------------------------------------------------------------------
function getPlist(동,서,남,북){
	// 클러스터가 누적되므로 좌표 이동시 클러스터 비우고 마커 생성
	clusterer.clear(); 
	
	$.ajax({
		url		: "/jspweb/productinfo",
		method	: "get",
		async	: false,
		data 	: {"동":동 , "서": 서 , "남":남, "북":북},
		success : (r)=>{
			console.log('응답')
			console.log(r)
			
			// 사이드바 제품 리스트 출력 
			productList = r;
			printproductList()
			
			// 지도에 등록된 제품 출력
			
			// .map((인덱스, 반복객체명))=>{})		실행문에서 return 가능
			//  vs
			// .forEach((인덱스, 반복객체명))=>{})	실행문에서 return 불가능
						
			var markers = $(r).map(function(i, o ) {
			
				// 마커 이미지의 이미지 크기 입니다
  				var imageSize = new kakao.maps.Size(24, 35); 
    
			    // 마커 이미지를 생성합니다    
			    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
			
				// 마커 생성 객체
	            let marker = new kakao.maps.Marker({
	                position : new kakao.maps.LatLng( o.plat, o.plng ) ,
	                image  :  markerImage
	            });
	            
            	// 위에서 생성된 마커객체의 클릭 이벤트 추가 하기   
		        kakao.maps.event.addListener(marker, 'click', function() {	
					printProduct(i)				
				}); // event e

            	// 리턴해서 markers에 대입하기 [ map함수 제공 ]
	            return marker;
	            
	        }); // map end 
	        clusterer.addMarkers(markers);  // 클러스터러에 마커들/배열 을 추가합니다
	        console.log(markers)
	    	console.log(clusterer)
		}
	})		
}













