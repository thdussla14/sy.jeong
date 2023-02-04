let movieList=[
	{name:'BTS: Yet To Come in Cinemas',	img:'방탄콘서트.jpg',		감독 :'오윤동' 	   , 			장르 : '공연실황', 	평점:8.83, 개봉일:'2023.02.01', egg: '99', 예매율: '32.1'},
	{name:'아바타-물의 길',			img:'아바타.jpg',			감독 :'James Cameron'   ,		 	장르 : 'SF', 		평점:8.83, 개봉일:'2022.12.14', egg: '96', 예매율: '32.1'},
	{name:'오늘 밤,세계에서 이 사랑이 사라진다해도',	img:'오늘밤사라진다해도.jpg',	감독 :'Takahiro Miki' , 	장르 : 'SF', 		평점:8.83, 개봉일:'2022.12.14', egg: '97', 예매율: '32.1'},
	{name:'영웅',					img:'영웅.jpg',			감독 :'윤제균' 		   , 		장르 : '드라마', 	평점:8.42, 개봉일:'2022.12.21', egg: '97', 예매율: '32.1'},
	{name:'교섭',					img:'교섭.jpg',			감독 :'임순례' 		   , 		장르 : '드라마', 	평점:6.29, 개봉일:'2023.01.18', egg: '97', 예매율: '32.1'},
	{name:'상견니',				img:'상견니.jpg',			감독 :'Tianren Huang'   , 			장르 : '드라마', 	평점:7.85, 개봉일:'2023.01.25', egg: '97', 예매율: '32.1'},
	{name:'올뺴미',				img:'올빼미.jpg',			감독 :'안태진' 		   , 		장르 : '스릴러', 	평점:8.73, 개봉일:'2022.11.13', egg: '97', 예매율: '32.1'},
	{name:'메간',					img:'메간.jpg',			감독 :'Gerard Johnstone', 			장르 : '공포', 	평점:7.34, 개봉일:'2023.01.25', egg: '97', 예매율: '32.1'},
	{name:'슬램덩크',				img:'슬램덩크.jpg',			감독 :'Takehiko Inoue', 			장르 : '애니메이션',	평점:9.24, 개봉일:'2023.01.04', egg: '97', 예매율: '32.1'},
	{name:'돌핀보이',				img:'돌핀보이.jpg',			감독 :'Andrey Goglev' , 			장르 : '애니메이션', 평점:6.00, 개봉일:'2023.01.25', egg: '97', 예매율: '32.1'},
	{name:'몬스터하우스',			img:'몬스터하우스.jpg',		감독 :'James Cameron' , 			장르 : 'SF', 		평점:8.83, 개봉일:'2022.12.14', egg: '97', 예매율: '32.1'},
	{name:'장화신은 고양이:끝내주는 모험',img:'장화신은고양이.jpg',		감독 :'Joel Crawford' , 			장르 : '애니메이션',	평점:8.41, 개봉일:'2023.01.04', egg: '97', 예매율: '32.1'}]

let nextmovieList=[
	{name:'라스트버스',		img:'라스트버스.jpg',		감독 :'Gillies MacKinnon', 장르 : '드라마', 		개봉일:'2023.02.09'},
	{name:'어메이징 모리스',		img:'어메이징모리스.jpg',	감독 :'Toby Genkel'  		, 장르 : '애니메이션', 	개봉일:'2023.02.15'},
	{name:'앤트맨과 와스프: 퀀텀매니아',	img:'앤트맨.jpg',	감독 :'Peyton Reed' 		, 장르 : 'SF', 		개봉일:'2023.02.15'},
	{name:'피터 본 칸트',		img:'피터 본 칸트.jpg',	감독 :'Francois Ozon' 	, 장르 : '로맨스', 	개봉일:'2023.02.15'},
	{name:'스톰보이',			img:'스톰보이.jpg',		감독 :'Shawn Seet'   		, 장르 : '드라마', 	개봉일:'2023.02.16'},
	{name:'TAR타르',			img:'타르.jpg',			감독 :'Todd Field'    	, 장르 : '드라마', 	개봉일:'2023.02.22'},
	{name:'미녀와 야수: 마법에 걸린 왕자',	img:'미녀야수.jpg',감독 :'Viktor Glukhushin', 장르 : '애니메이션', 	개봉일:'2023.02.22'},
	{name:'서치 2',			img:'서치.jpg',			감독 :'Nicholas D. Johnson', 장르 : '스릴러',	개봉일:'2023.02.22'}
]
//-------------------현재 상영작 출력---------------------------------------------------------------------------------------//
movie_print()

function movie_print(){
	
	let html = ``
	
	movieList.forEach((o)=>{
		
		html += `<div class="item" >					
					<img class="m_img" src="img/${o.img}" >
					<div class="m_name"> ${o.name}	</div>
					<div class="m_al"> <span> 예매율 ${ o.예매율 }%</span> <span>|</sapn><span class="al"> <img src="img/황금알.png"> ${ o.egg }%</span></div>
					<div class="m_score"> 평점  <span class="percent"> ${o.평점}</span> </div>
					<div class="m_date"> ${o.개봉일} 개봉 	</div>
					<div > <a href="movie_view.html"> <button class="viewbtn" type="button"> 상세보기 </button> </a> </div>
				</div>`
		})
		
	document.querySelector('.items').innerHTML = html
}

//---------------------상영 예정작 출력------------------------------------------------------------------------------------//
function nextmovie_print(){
	
	let html = ``
	
	nextmovieList.forEach((o)=>{
		
		html += `<div class="item" >
					<img class="m_img" src="img/${o.img}" >
					<div class="m_name"> ${o.name}	</div>
					<div class="m_direc"> ${o.감독}	</div>
					<div class="m_genre"> ${o.장르}	</div>
					<div class="m_date"> ${o.개봉일} 개봉예정 	</div>
				</div>`
		})
		
	document.querySelector('.items').innerHTML = html
}

//-------------------카테고리 선택 이벤트------------------------------------------------------------------------------------//

document.querySelector('.now').addEventListener('click', (e)=>{
	document.querySelector('.now').style.color='#FFC600'
	document.querySelector('.next').style.color='black'
	document.querySelector('.select_title').innerHTML = '현재상영작'
	movie_print()
})

document.querySelector('.next').addEventListener('click', (e)=>{
	document.querySelector('.next').style.color='#FFC600'
	document.querySelector('.now').style.color='black'
	document.querySelector('.select_title').innerHTML = '상영예정작'
	nextmovie_print()
})

