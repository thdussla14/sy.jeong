
let movieList=[
	{name:'BTS: Yet To Come in Cinemas',img:'방탄콘서트.jpg',감독 :'오윤동' 	   , 장르 : '공연실황', 	평점:8.83, 개봉일:'20230201', 상영시간: 120},
	{name:'아바타-물의 길',		img:'아바타.jpg',			감독 :'James Cameron'   , 장르 : 'SF', 		평점:8.83, 개봉일:'20221214', 상영시간: 120},
	{name:'오늘 밤,세계에서 이 사랑이 사라진다해도',	img:'오늘밤.jpg',	감독 :'Takahiro Miki' , 장르 : 'SF', 	평점:8.83, 개봉일:'20221214', 상영시간: 120},
	{name:'영웅',				img:'영웅.jpg',			감독 :'윤제균' 		   , 장르 : '드라마', 		평점:8.42, 개봉일:'20221221', 상영시간: 120},
	{name:'교섭',				img:'교섭.jpg',			감독 :'임순례' 		   , 장르 : '드라마', 		평점:6.29, 개봉일:'20230118', 상영시간: 120},
	{name:'상견니',			img:'상견니.jpg',			감독 :'Tianren Huang'   , 장르 : '드라마', 		평점:7.85, 개봉일:'20230125', 상영시간: 120},
	{name:'올빼미',			img:'올빼미.jpg',			감독 :'안태진' 		   , 장르 : '스릴러', 		평점:8.73, 개봉일:'20221113', 상영시간: 120},
	{name:'메간',				img:'메간.jpg',			감독 :'Gerard Johnstone', 장르 : '공포', 		평점:7.34, 개봉일:'20230125', 상영시간: 120},
	{name:'슬램덩크',			img:'슬램덩크.jpg',		감독 :'Takehiko Inoue', 장르 : '애니메이션',		평점:9.24, 개봉일:'20230104', 상영시간: 120},
	{name:'돌핀보이',			img:'돌핀보이.jpg',		감독 :'Andrey Goglev' , 장르 : '애니메이션', 		평점:6.85, 개봉일:'20230125', 상영시간: 120},
	{name:'몬스터하우스',		img:'몬스터하우스.jpg',		감독 :'James Cameron' , 장르 : 'SF', 			평점:8.83, 개봉일:'20221214', 상영시간: 120},
	{name:'장화신은 고양이:끝내주는 모험',img:'장화신은고양이.jpg',	감독 :'Joel Crawford' , 장르 : '애니메이션',	평점:8.41, 개봉일:'20230104', 상영시간: 120},	
]

let setlist2 = [
{movie:'아바타', space : '서울', room: '3관',  time: '10:00'},
{movie:'아바타', space : '서울', room: '3관',  time: '11:30'},
{movie:'아바타', space : '서울', room: '4관',  time: '09:20'},
{movie:'아바타', space : '서울', room: '5관',  time: '16:00'},
{movie:'아바타', space : '수원', room: '3관',  time: '10:00'},
{movie:'아바타', space : '수원', room: '3관',  time: '11:30'},
{movie:'아바타', space : '수원', room: '4관',  time: '09:20'},
{movie:'아바타', space : '수원', room: '5관',  time: '16:00'},
{movie:'아바타', space : '안산', room: '3관',  time: '10:00'},
{movie:'아바타', space : '안산', room: '3관',  time: '11:30'},
{movie:'아바타', space : '안산', room: '4관',  time: '09:20'},
{movie:'아바타', space : '안산', room: '5관',  time: '16:00'},
]

let times=[{time: '10:00'},{time: '11:30'},{time: '12:30'},{time: '14:00'},{time: '16:30'}]

let setlist = [
	{movie:'아바타', space : '서울', room: '3관',  times},
	{movie:'아바타', space : '서울', room: '4관',  times},
	{movie:'아바타', space : '서울', room: '5관',  times},
	{movie:'아바타', space : '수원', room: '3관',  times},
	{movie:'아바타', space : '수원', room: '3관',  times}
]

//--영화 리스트 출력-----------------------------------------------------------------------------------------------------//

list()

function list(){
	
	let html = ``
	
	movieList.forEach((o,i)=>{
	
	html += `<button type="button" class="list" onclick="print(${i})"> ${o.name}</button>`
		
	})
	document.querySelector('.movie_list').innerHTML =html
}
//---선택 영화 정보 출력---------------------------------------------------------------------------------------------------//

print(0)
function print(i){
	
	let html = ``
	
	let choosen =  movieList[i].name
	
	movieList.forEach((o2)=>{
	
	if(choosen==o2.name)
	
	html += `<div class="row"> 
					<div class="col-md-4"> 
						<img class="main_img" src="img/${o2.img}" width="100%">
					</div>				
					<div class="col-md-8 information"> 
						<div class="m_title" > 	  	  ${o2.name}  </div>
						<div >
							  <div class="m_info">	 평점 	:<span class="percent"> ${o2.평점}</span>	 </div>
							  <div class="m_info">   감독 	: 	${o2.감독}		</div>
							  <div class="m_info">   장르		: 	${o2.장르}		</div>
							  <div class="m_info">   개봉일	:	${o2.개봉일}		</div>
							  <div class="m_info">   상영시간	:	${o2.상영시간}	분	</div>
						</div>
												
						<div >
							<button class="btns" onclick="printtime( )" type="button">   상영시간표	</button>							
							<a href="movie_list.html"><button class="btns" type="button">목록보기</button></a>
						</div>				
					</div>
				</div>	<!-- row e -->`
		
	})// for e
	document.querySelector('.moviebox').innerHTML = html
	
}// fun e

//-----상영 시간표 출력---------------------------------------------------------------------------------------------------//

function printtime( ) {
	 
	 
	 
	 let html = `<tr>
					<th width="20%" > 지역 </th> <th width="20%" > 상영관 </th> <th width="60%" > 시간 </th>
				</tr>`;

	 	setlist2.forEach((o,i)=>{

			html += `<tr>
						<td> ${o.space}  </td>
						<td> ${o.room } </td>
						<td> <button class="time" onclick="select(${i})"> ${o.time}</button>   </td>
					</tr>`
		
			})	// for e
			
		document.querySelector('.timebox').style.display='block';	
			
		document.querySelector('.momo').innerHTML=html;		 
 }	// fun e
//------------------------------------------------------------------------------------------------------------------//			

function select (i){
	
	
	let 날짜     = document.querySelector('.date').value
	let 지역  	= setlist2[i].space
	let 관		= setlist2[i].room
	let 시간 		= setlist2[i].time

	if(날짜==''){alert('날짜를 선택해 주세요.'); return;}
	
	
	document.querySelector('.movie').innerHTML	= document.querySelector('.m_title').innerHTML
	document.querySelector('.space').innerHTML	= `CGVOX  `+지역
	document.querySelector('.room').innerHTML	= 관
	document.querySelector('.day').innerHTML	= 날짜
	document.querySelector('.tim').innerHTML	= 시간
	
	
}
//----에매 내역 모달 내용 출력----------------------------------------------------------------------------------------------//

// 예매하기 버튼 클릭 이벤트
 document.querySelector('.reserve').addEventListener('click',(e)=>{
	 
	 document.querySelector('.modal_wrap').style.display='flex';
	 modal_print()
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 