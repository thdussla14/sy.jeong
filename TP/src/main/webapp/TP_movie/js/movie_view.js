let movieList=[
	{name:'아바타-물의 길',		img:'아바타.jpg',			감독 :'James Cameron'   , 장르 : 'SF', 		평점:8.83, 개봉일:'2022.12.14', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'BTS: Yet To Come in Cinemas',img:'방탄콘서트.jpg',감독 :'오윤동' 	   , 장르 : '공연실황', 	평점:8.83, 개봉일:'2023.02.01', 상영시간: 120, egg: '99', 예매율: '32.1'},	
	{name:'오늘 밤,세계에서 이 사랑이 사라진다해도',	img:'오늘밤사라진다해도.jpg',	감독 :'Takahiro Miki' , 장르 : 'SF', 	평점:8.83, 개봉일:'2022.12.14', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'영웅',				img:'영웅.jpg',			감독 :'윤제균' 		   , 장르 : '드라마', 		평점:8.42, 개봉일:'2022.12.21', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'교섭',				img:'교섭.jpg',			감독 :'임순례' 		   , 장르 : '드라마', 		평점:6.29, 개봉일:'2023.01.18', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'상견니',			img:'상견니.jpg',			감독 :'Tianren Huang'   , 장르 : '드라마', 		평점:7.85, 개봉일:'2023.01.25', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'올빼미',			img:'올빼미.jpg',			감독 :'안태진' 		   , 장르 : '스릴러', 		평점:8.73, 개봉일:'2022.11.13', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'메간',				img:'메간.jpg',			감독 :'Gerard Johnstone', 장르 : '공포', 		평점:7.34, 개봉일:'2023.01.25', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'슬램덩크',			img:'슬램덩크.jpg',		감독 :'Takehiko Inoue', 장르 : '애니메이션',		평점:9.24, 개봉일:'2023.01.04', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'돌핀보이',			img:'돌핀보이.jpg',		감독 :'Andrey Goglev' , 장르 : '애니메이션', 		평점:6.85, 개봉일:'2023.01.25', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'몬스터하우스',		img:'몬스터하우스.jpg',		감독 :'James Cameron' , 장르 : 'SF', 			평점:8.83, 개봉일:'2022.12.14', 상영시간: 120, egg: '99', 예매율: '32.1'},
	{name:'장화신은 고양이:끝내주는 모험',img:'장화신은고양이.jpg',	감독 :'Joel Crawford' , 장르 : '애니메이션',	평점:8.41, 개봉일:'2023.01.04', 상영시간: 120, egg: '99', 예매율: '32.1'},	
]

let spaceList = [
{local:'서울', space: [{s:'강남'},{s:'강변'},{s:'건대입구'},{s:'구로'},{s:'대학로'},{s:'등촌'},{s:'명동'},{s:'미아'},{s:'송파'},{s:'신촌'}] },
{local:'경기', space: [{s:'광교'},{s:'구리'},{s:'김포'},{s:'동수원'},{s: '동탄'},{s:'부천'},{s:'안산'},{s:'야탑'},{s:'의정부'},{s:'인천'},{s:'일산'},{s:'판교'}]},
{local:'충청', space: [{s:'논산'},{s:'대전'},{s:'세종'},{s:'아산'},{s:'천안'},{s:'청주'}]},
{local:'전라', space: [{s:'광양'},{s:'광주'},{s:'목포'},{s:'순천'},{s:'익산'},{s:'전주'},{s:'제주'}]},
{local:'경상', space: [{s:'김해'},{s:'대구'},{s:'마산'},{s:'서면'},{s:'울산'},{s:'창원'}]}
]
let roomList = [
{room: '3관'			, times: [{time:'09:20'},{time:'13:00'},{time:'14:40'},{time:'16:00'}]},	
{room: '4관'			, times: [{time:'10:00'},{time:'15:30'},{time:'18:10'},{time:'21:00'}]},		
{room: '5관'		 	, times: [{time:'11:00'},{time:'15:30'},{time:'16:00'},{time:'22:40'}]},	
{room: '4DX관'	 	, times: [{time:'09:20'},{time:'13:00'},{time:'14:40'},{time:'16:00'}]},
{room: 'SCREENX관'	, times: [{time:'10:00'},{time:'15:30'},{time:'18:10'},{time:'21:00'}]}	
]


//--영화 리스트 출력-----------------------------------------------------------------------------------------------------//

function list(){
	
	let html = ``
	let 영화 = document.querySelector('.movie').innerHTML; console.log(영화);
	
	movieList.forEach((o,i)=>{
	
	if(영화 == o.name)
		{html += `<button type="button" class="list" onclick="print(${i})"> >> ${o.name} </button>`;}
	else{html += `<button type="button" class="list" onclick="print(${i})">    ${o.name} </button>`;}
		
	})
	
	document.querySelector('.movie_list').innerHTML =html
}

//---선택 영화 정보 출력---------------------------------------------------------------------------------------------------//

print(0)
function print(i){
	
	let html = ``
	
	let html2 =``
	
	let choosen =  movieList[i].name
	
	movieList.forEach((o2)=>{
	
	if(choosen==o2.name)
	{
	html += `<div class="row"> 
					<div class="col-md-3"> 
						<img class="main_img" src="img/${o2.img}" width="100%">
					</div>				
					<div class="col-md-9 information"> 
						<div class="m_title" > 	  	  ${o2.name}  </div>
						<div>
							  <div class="m_score">  예매율 ${ o2.예매율 }%<span>|</sapn><span class="al"> <img src="img/main_page/황금알.png"> ${ o2.egg }%</span></div>
							  <div class="m_info">	 평점 	:<span class="percent"> ${o2.평점}</span>	 </div>
							  <div class="m_info">   감독 	: 	${o2.감독}		</div>
							  <div class="m_info">   장르		: 	${o2.장르}		</div>
							  <div class="m_info">   개봉일	:	${o2.개봉일}		</div>
							  <div class="m_info">   상영시간	:	${o2.상영시간}	분	</div>
						</div>														
					</div>
				</div>	<!-- row e -->
				`
				
				
	html2 = `<img src="img/${o2.img}" width="80px;">`
	}	
	})// for e
	
	document.querySelector('.moviebox').innerHTML = html
	document.querySelector('.img').innerHTML = html2
	document.querySelector('.movie').innerHTML = document.querySelector('.m_title').innerHTML
	
	
}// fun e
//-----info 출력---------------------------------------------------------------------------------------------------//


document.querySelector('.info_print').addEventListener ('click',(e)=>{
	document.querySelector('.example_info').style.display='block';
	document.querySelector('.time_table').style.display='none';
})

document.querySelector('.grade').addEventListener ('click',(e)=>{
	alert('로그인이 필요한 서비스입니다.\n로그인페이지로 이동하시겠습니까?')
})


//-----상영 시간표 출력---------------------------------------------------------------------------------------------------//

document.querySelector('.timetable_print').addEventListener ('click',(e)=>{
	timetable_print()
})


function timetable_print(){
	document.querySelector('.example_info').style.display='none';
	document.querySelector('.time_table').style.display='flex';
	list()
	local_print()	
}

let 지역 = ``
let 상영관 = ``
let 상영시 = ``

function local_print(){
	
	html =``
	
	spaceList.forEach((o,j)=>{
		
		html += `<button type="button" class="list" onclick="space_print(${j})"> ${o.local}</button>`
		
	})
	
	document.querySelector('.local_list').innerHTML = html
	
}	// fun e
 
function space_print(j){
	
	if(document.querySelector('.date').value=='')
	
		{alert('관람일자를 설정해주세요.'); return ;}
	
	else{	html =``
	
			spaceList[j].space.forEach((o2,a)=>{
		
			html += `<button type="button" class="list" onclick="room_print(${a})"> ${o2.s}</button>`
	
			})
			지역 = j
			document.querySelector('.space_list').innerHTML = html } // if e

}	// fun e
 
function room_print(a){
	
	html =``
	
	roomList.forEach((o,k)=>{
		
		html += `<button type="button" class="list" onclick="time_print(${k})"> ${o.room}</button>`
	
	})
	
	document.querySelector('.space').innerHTML = `CGVOX `+spaceList[지역].space[a].s
	document.querySelector('.room_list').innerHTML = html	
	
}
 
function time_print(k){
	
	html =``
	
	roomList[k].times.forEach((o2,h)=>{
		
		html += `<button type="button" class="list" onclick="time_select(${h})"> ${o2.time}</button>`
	
	})
	상영관 =k
	document.querySelector('.room').innerHTML = roomList[k].room
	document.querySelector('.mime_list').innerHTML = html
}

function time_select(h){
	
	day_select()	
	document.querySelector('.tim').innerHTML = roomList[상영관].times[h].time	
	상영시 = roomList[상영관].times[h].time	
}

function day_select(){
	
	document.querySelector('.day').innerHTML = document.querySelector('.date').value
}




//----에매 내역 모달 내용 출력----------------------------------------------------------------------------------------------//

// 예매하기 버튼 클릭 이벤트
 document.querySelector('.reserve').addEventListener('click',(e)=>{
	 
	 if(상영관==''){alert('상영관을 선택해 주세요.'); return;}
	 
	 else if(상영시==''){alert('관람시간을 선택해 주세요.'); return;}
	 
	 else{document.querySelector('.modal_wrap').style.display='flex';
	 modal_print()}
	 
 })

// 예매내역 
function modal_print(){
	
	document.querySelector('.m_space').innerHTML	= document.querySelector('.space').innerHTML
	document.querySelector('.m_movie').innerHTML	= document.querySelector('.m_title').innerHTML
	document.querySelector('.m_room').innerHTML		= document.querySelector('.room').innerHTML
	document.querySelector('.m_day').innerHTML		= document.querySelector('.day').innerHTML
	document.querySelector('.m_time').innerHTML		= document.querySelector('.tim').innerHTML
	document.querySelector('.m_price').innerHTML	= `16,000원`
	
}

// 모달 버튼 이벤트
 document.querySelector('.modal_cancel').addEventListener('click',(e)=>{
	 
	 document.querySelector('.modal_wrap').style.display='none';
	 
 })
 
			

 
 
 
 
 
 
 
 
 
 