/*
 	new Date() 날짜/시간 관련 클래스
 		1. let date = new Date() : 현재 날짜/시간 객체
 		2. let date = new Date( 2023 , 01 , 31 ) : 사용자정의 날짜/시간 객체
 			1. get 함수
 				1. date.getFullYear() 	: 연도
 				2. date.getMonth()		: 월 [ 0 ~ 11 / 0 : 1월]
				3. date.getDate()		: 일
				4. date.getDay()		: 요일 [ 0 ~ 6 / 0 : 일요일]

	let date = new Date() ; console.log('date : '+date)
	let date2 = new Date(2023,01,31) ;  console.log('date2 : '+date2)
	console.log('연도 : '+date.getFullYear())
	console.log('월 : '+date.getMonth())
	console.log('일 : '+date.getDate())
	console.log('요일 : '+date.getDay())
 
 */

let contents = [
	{ date : '20230101', content : '새해맞이 여행',bg_color:'#ff9995'},
	{ date : '20230103', content : '친구랑 캠핑',bg_color:'#ff9995'},
	{ date : '20230101', content : '세계여행 (with.family)',bg_color:'#ff9995'},
	{ date : '20230101', content : '불꽃축제',bg_color:'#ff9995'}
]

//-----------------------전역변수 : 모든 함수{} 공용으로 사용되는 메모리 [변수]-----------------------//

 // 1. js가 열렸을때 현재 연도와 월을 구해서 변수에 저장
 let year = new Date().getFullYear();	// 기본값 : 현재 연도 // 이전/다음 버튼 클릭에 따른 변경
 let month = new Date().getMonth()+1;	// 기본값 : 현재 월  // 이전/다음 버튼 클릭에 따른 변경
 

 // 2. 캘린더 출력 함수 [1. js 열렸을때 	2.이전/다음 버튼 클릭시마다 ]
 function cal_print(){
	 // 1. 캘린더 상단에 현재 연도와 월 출력
	  document.querySelector('.top_date').innerHTML = `${year}년 ${month}월`	 
	  
	 // 2. html 구성
	  let html = `<div class="day weekday sunday"> 일 </div>
				<div class="day weekday"> 월 </div>
				<div class="day weekday"> 화 </div>
				<div class="day weekday"> 수 </div>
				<div class="day weekday"> 목 </div>
				<div class="day weekday"> 금 </div>
				<div class="day weekday"> 토 </div>`

		// 현재 캘린더 설정된 날짜의 마지막 일 구하기
	    let lastday = new Date(year,month,0).getDate(); console.log('현재 캘린더 마지막 일 : '+lastday)
			
		// 현재 캘린더 설정된 날짜의 1일 시작 요일 구하기
		let weekday = new Date(year,month-1,1).getDay() ;console.log('현재 캘린더 시작 요일 : '+weekday)
		
		// 시작 요일 공백 만들기
		for(let b=1 ; b<=weekday ; b++)
			{html += `<div class="day"> </div>`}	
			
		// 일 만들기 [ 1 ~ 마지막 일까지 // new Date(year,month,0).getDate() // 마지막일 자동 설정!] 			
		for( let day = 1 ; day<=lastday; day++)		
			{// 순환하는 날짜 확인
			  let date = date_format(new Date(year,month-1,day));
			 console.log(date)	
						 
			  html += `<div class="day" onclick="openModal(${date})"> 
			  				${day} ${contents_print( date )} 
			  			</div>`}
				
	// 4. 마크업에 출력
	 document.querySelector('.cal_day').innerHTML = html
	 
 } // f e
 cal_print()
 
 // 3. 이전달 다음달 버튼 클릭 이벤트에 따른 연도와 월 변경
 document.querySelector('.previousbtn').addEventListener('click',(e)=>{ 
	 console.log('이전달 버튼');
	  month--;
	  if(month<1){year--;month=12;} // 1. 월 1차감 했을 경우 만약에 1보다 작아지면 연도 1차감 월 12 설정
	  cal_print();
 })
 document.querySelector('.nextbtn').addEventListener('click',(e)=>{
	  console.log('다음달 버튼'); 
	  month++;
	  if(month>12){year++;month=1;} // 1. 월 1증가 했을 경우 만약에 12보다 커지면 연도 1증가 월 1 설정
	  cal_print();
 })

 // 4. 날짜 포멧 함수 [ 인수 : 날짜  -------로직[포멧]-----------> 반환 : 변경된 날짜 형식 ]
 function date_format(date){
	 
	 let d_year = date.getFullYear();
	 let d_month = (date.getMonth()+1) <=9 ? '0'+ (date.getMonth()+1) :  (date.getMonth()+1) ;
	 let d_day = (date.getDate())<=9 ? '0'+ (date.getDate()): (date.getDate());
	 
	 return `${d_year}${d_month}${d_day}`	 
 }

 // 5. 일정 출력 함수
 function contents_print( date ){ 
	
	// 1. 인수로 전달된 날짜와 동일한 일정 날짜 찾기
	let html =``
	
	contents.forEach((o)=>{
		if( date == o.date )
			{html += `<div class="content" style="background-color:${o.bg_color}"> ${o.content} </div>`}
		})
	
	return html;
 }
 
  // 6. 모달 열기 함수
  function openModal(date){	  
	  console.log(date)
	  // 모달 배경 구역 css 변경하여 모달 보이기
	  document.querySelector('.modal_wrap').style.display='flex';
	  // 모달에 선택한 날짜 표시하기
	  document.querySelector('.modal_date').innerHTML=date	  
	  // 선택한 날짜의 모든 일정 출력
	  	// 기본 html 구성
	 	 let html =`<tr>
					<th width="5%"> # </th> <th> 일정내용 </th> <th width="15%"> 비고 </th>
					</tr>`
	  	// 동일한 날짜 일정 객체 개수 [ 화면 출력 인덱스]
	 	 let j = 0 ;
	  		
	 	 contents.forEach((o,i)=>{	  
		  		  
		  if(date==o.date)
		  	{j++;
			html += `<tr>
						<td> ${j} </td> 
						<td> ${o.content} </td> 
						<td> <button onclick="onDelete(${i})" type="button"> 삭제 </button> </td>
					</tr>`}
	  	})
	  	
	  document.querySelector('.modal_table').innerHTML = html  
	  

  }

 // 7. 모달 닫기 함수
  document.querySelector('.modal_close').addEventListener('click',(e)=>{
	  document.querySelector('.modal_wrap').style.display='none'
  })
	  	  
 // 8. 등록 버튼 이벤트 함수
 document.querySelector('.modal_write').addEventListener('click',(e)=>{
	 
	 // 입력 내용과 선택된 날짜 가져오기
	 let content = {
		 date : document.querySelector('.modal_date').innerHTML,
		 content : document.querySelector('.modal_input').value,
		 bg_color : document.querySelector('.modal_color').value
	 }
	 console.log(content)
	 // 유효성검사 생략
	 // 배열 저장
	 contents.push(content)
	 // 화면 업데이트
	 	// 입력 데이터 초기화
	 	document.querySelector('.modal_input').value='';
	 	// 모달 닫기
	 	document.querySelector('.modal_wrap').style.display='none'
	 	// 화면 업데이트
	 	cal_print()
	 
 })
 // 9. 모달 일정 삭제 함수
 function onDelete(i){
	 // 배열내 해당 인덱스 삭제
	 contents.splice(i,1)
	 document.querySelector('.modal_wrap').style.display='none'
	 cal_print()
	 console.log(contents)
 }





