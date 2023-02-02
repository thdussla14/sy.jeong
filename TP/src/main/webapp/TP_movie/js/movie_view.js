
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
	{name:'돌핀보이',			img:'돌핀보이.jpg',		감독 :'Andrey Goglev' , 장르 : '애니메이션', 		평점:6.00, 개봉일:'20230125', 상영시간: 120},
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
{movie:'아바타', space : '수원', room: '3관',  time: '10:00'},
{movie:'아바타', space : '안산', room: '3관',  time: '11:30'},
{movie:'아바타', space : '안산', room: '4관',  time: '09:20'},
{movie:'아바타', space : '안산', room: '5관',  time: '16:00'},
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

	 	setlist2.forEach((o)=>{

			html += `<tr>
						<th> ${o.space}  </th>
						<th> ${o.room } </th>
						<th> <button class="time" onclick="select()"> ${o.time}</button>   </th>
					</tr>`
		
			})	// for e
			
		document.querySelector('.timebox').style.display='block';	
			
		document.querySelector('.momo').innerHTML=html;		 
 			 			 
	 }	// fun e
//------------------------------------------------------------------------------------------------------------------//			

 
//------------------------------------------------------------------------------------------------------------------//


 document.querySelector('.reserve').addEventListener('click',(e)=>{
	 
	 document.querySelector('.modal_wrap').style.display='flex';
 })
 
 document.querySelector('.modal_cancel').addEventListener('click',(e)=>{
	 
	 document.querySelector('.modal_wrap').style.display='none';
 })
 
 document.querySelector('.modal_close').addEventListener('click',(e)=>{
	 
	 document.querySelector('.modal_wrap').style.display='none';
 })
