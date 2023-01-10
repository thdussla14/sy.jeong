/* 
 <마크업 속성="속성값">
	1. 이벤트 속성		
			1.onclick="JS함수명()"	: 해당 마크업 클릭했을때 JS 함수 실행

	2. vlaue 속성 : input, select, textarea	/div, span, table, p, h [X]
	3. innnerHTML속성		:<마크업> innnerHTML </마크업>

1. HTML 마크업을 변수화하기 = DOM[document=HTML]
	
		1. class 명으로 해당 마크업을 JS 변수로 가져올 때
			let HTML 변수명 = document.querySelector('.클래스명')
			
		2. id 명으로 해당 마크업을  JS 변수로 가져올 때
			let HTML 변수명 = document.querySelector('#클래스명')
			
			마크업의 속성 호출
					*HTML변수명.속성명
					HTML변수명.value	: 해당 마크업의 value 속성 호출
					
2. 	HTML  ---> JS	document.querySelector
	HTML <---- JS				
*/

// 함수 밖에 만든 이유 : 함수가 실행될때마다 선언하면 기존 데이터 삭제

 let 학생리스트 = []	// 배열선언, 초기 요소 없다 [깡통]

/* 1. 추가 버튼을 눌렀을 때 이벤트 함수 */

 function onAdd () {//alert('클릭함수 실행합니다.')
	 //1. function 	: 함수 정의 키워드
	 //2. onAdd 	: 함수명	[아무거나]
	 //3. ()		: 인수	[함수 안으로 전달 받은 데이터]
	 //4. {}		: 함수가 실행되는 구역
	
	 /* 2. sname 변수에 <input> 마크업 저장 */
	 let sname = document.querySelector('.sname')  //sname 변수에 input 마크업 저장
	 
	 /* 3. 마크업에서 값 가져오기 */
	 //alert (sname.value )
	 학생리스트.push (sname.value)
	 	
	 /* 4. 마크업에 출력 */
	 console.log(학생리스트) 
	 		//1. slist 변수에 <ul> 마크업 저장
	 		let slist = document.querySelector('#slist')
	 		slist.innerHTML = '<li>' + 학생리스트 +'</li>'
 }
 /* 1.함수 끝 */
 
 /* 2.클릭시 배열내 요소를 삭제하는 함수 */
 
 function onDelete(){	
	 
	//[입력부]]
 	//1. <input> 가져와서 변수에 저장 [DOM 객체]
 	let sname = document.querySelector('.sname')
 	//2. <input>에 이력된 value[값 가져오기]
	let dname = sname.value 
	//3. 배열내 값으로 요소 인덱스 찾기
	let dindex = 학생리스트.indexOf( dname );
	//4. 배열내 해당 인덱스의 요소 제거
	학생리스트.splice( dindex, 1);
	
	//[출력부]
	//1. <ul> 가져와서 변수에 저장 [ DOM 객체 ]
	let slist = document.querySelector('#slist')
	//2. <ul> innerHTML 이용한 <ul> {여기에 데이터 넣기} </ul>
	slist.innerHTML = '<li>'+학생리스트+'</li>'
	
	
 }
 
 
 
 
 
 
  
 



 