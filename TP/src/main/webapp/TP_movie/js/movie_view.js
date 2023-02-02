
let movieList=[
	{name:'BTS: Yet To Come in Cinemas',img:'방탄콘서트.jpg',감독 :'오윤동' 	   , 장르 : '공연실황', 	평점:8.83, 개봉일:'20230201', 상영시간: 120},
	{name:'아바타-물의 길',		img:'아바타.jpg',			감독 :'James Cameron'   , 장르 : 'SF', 		평점:8.83, 개봉일:'20221214', 상영시간: 120},
	{name:'오늘 밤,세계에서 이 사랑이 사라진다해도',	img:'오늘밤.jpg',	감독 :'Takahiro Miki' , 장르 : 'SF', 	평점:8.83, 개봉일:'20221214', 상영시간: 120},
	{name:'영웅',				img:'영웅.jpg',			감독 :'윤제균' 		   , 장르 : '드라마', 		평점:8.42, 개봉일:'20221221', 상영시간: 120},
	{name:'교섭',				img:'교섭.jpg',			감독 :'임순례' 		   , 장르 : '드라마', 		평점:6.29, 개봉일:'20230118', 상영시간: 120},
	{name:'상견니',			img:'상견니.jpg',			감독 :'Tianren Huang'   , 장르 : '드라마', 		평점:7.85, 개봉일:'20230125', 상영시간: 120},
	{name:'올뺴미',			img:'올빼미.jpg',			감독 :'안태진' 		   , 장르 : '스릴러', 		평점:8.73, 개봉일:'20221113', 상영시간: 120},
	{name:'메간',				img:'메간.jpg',			감독 :'Gerard Johnstone', 장르 : '공포', 		평점:7.34, 개봉일:'20230125', 상영시간: 120},
	{name:'슬램덩크',			img:'슬램덩크.jpg',		감독 :'Takehiko Inoue', 장르 : '애니메이션',		평점:9.24, 개봉일:'20230104', 상영시간: 120},
	{name:'돌핀보이',			img:'돌핀보이.jpg',		감독 :'Andrey Goglev' , 장르 : '애니메이션', 		평점:6.00, 개봉일:'20230125', 상영시간: 120},
	{name:'몬스터하우스',		img:'몬스터하우스.jpg',		감독 :'James Cameron' , 장르 : 'SF', 			평점:8.83, 개봉일:'20221214', 상영시간: 120},
	{name:'장화신은 고양이:끝내주는 모험',img:'장화신은고양이.jpg',	감독 :'Joel Crawford' , 장르 : '애니메이션',	평점:8.41, 개봉일:'20230104', 상영시간: 120},	
]

let setlist = [
	{movie:'아바타-물의 길', space : '서울', room: '3관',  time: '10:00'},
	{movie:'아바타-물의 길', space : '서울', room: '4관',  time: '09:20'},
	{movie:'아바타-물의 길', space : '서울', room: '5관',  time: '11:30'},
	{movie:'아바타-물의 길', space : '서울', room: '5관',  time: '16:00'},
	{movie:'아바타-물의 길', space : '수원', room: '3관',  time: '09:20'},
	{movie:'아바타-물의 길', space : '수원', room: '3관',  time: '16:00'},
	{movie:'아바타-물의 길', space : '수원', room: '4관',  time: '10:00'},
	{movie:'아바타-물의 길', space : '수원', room: '4관',  time: '11:30'},
	{movie:'아바타-물의 길', space : '수원', room: '4관',  time: '16:00'},
	{movie:'아바타-물의 길', space : '수원', room: '5관',  time: '10:00'},
	{movie:'아바타-물의 길', space : '안산', room: '3관',  time: '11:30'},
	{movie:'아바타-물의 길', space : '안산', room: '3관',  time: '16:00'},
	{movie:'아바타-물의 길', space : '안산', room: '4관',  time: '10:00'},
	{movie:'아바타-물의 길', space : '안산', room: '5관',  time: '09:20'},
	{movie:'아바타-물의 길', space : '안산', room: '5관',  time: '11:30'},
	{movie:'아바타-물의 길', space : '안산', room: '5관',  time: '16:00'}
]

list()

function list(){
	
	html = ``
	
	movieList.forEach((o,i)=>{
	
	html += `<div><button class="list" onclick="print(${i})"> ${o.name}</button> </div>`
		
	})
	document.querySelector('.movie_list').innerHTML =html
}


print(0)
function print(i){
	html = ``
	
	let choosen =  movieList[i].name
	
	movieList.forEach((o2)=>{
	
	if(choosen==o2.name)
	
	html += `
				<h3>  ${o2.name}  </h3>
				
				<div class="row"> 
					<div class="col-md-4"> 
						<img class="main_img" src="img/${o2.img}" width="100%">
					</div>				
					<div class="col-md-8"> 
						<div class="m_title" > 		  ${o2.name}  </div>
						<div class="m_score" > 평점 	: ${o2.평점}	 </div>
						<div class="m_info" >
							  <div> 감독 		: 	${o2.감독}			</div>
							  <div> 장르		: 	${o2.장르}			</div>
							  <div> 개봉일	:	${o2.개봉일}		</div>
							  <div> 상영시간	:	${o2.상영시간}	분	</div>
						</div>
						<div class="btns">
								<button onclick="printtime(${i})" type="button">   상영시간표	</button>							
								<a href="movie_list.html"><button class="back" type="button">목록보기</button></a>
						</div>				
					</div>
				</div>	<!-- row e -->`
		
	})// for e
	document.querySelector('.moviebox').innerHTML = html

}// fun e


 function reseve(){
	 
	 document.querySelector('.modal_wrap').style.display='flex';
 }
 
 function close(){
	 
	 document.querySelector('.modal_wrap').style.display='none';	 
 }


 function printtime(i) {
	 
	 let html = `<tr>
					<th> 지역 </th> <th> 상영관 </th> <th> 시간 </th>
				</tr>`;
	 
	 setlist.forEach((o3,j)=>{
		
		 
		 if( movieList[i].name == o3.movie)
			 
			 {	setlist.forEach((o4,k)=>{		 
				 
				 if( o3[j].movie == o4[k].movie && o3[j].space == o4[k].space)
			 			
			 			{  setlist.forEach((o5,l)=>{
							 
							 if(o4[k].movie == o5[l].movie && o4[k].space == o5[l].space && o4[k].room == o5[l].room)
							 
							 { html += `<tr>
											<th> ${o5.space}</th> 
											<th> ${o5.room}</th>
											<th> ${o5.time}</th> 
										</tr>`
										
										 
									 }	// if e
											 
									})	// for5 e	
									 	 			 
							 }	// if e
				
						})	// for4 e
							 
					 }	// if e
					
				})	// for3 e
				 
				 document.querySelector('.momo').innerHTML=html;
				 
				 
			 }	// fun e
			




