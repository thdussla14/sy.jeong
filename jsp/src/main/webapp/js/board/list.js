
// DB -> JAVA 로 전달된 게시물리스트 데이터

// js 열릴때 실행 
board_print(null,null)

// 1. 게시물 출력 함수	
// 인수  1. 게시판 열렸을때[조건X : keyword=null, key=null]		
//      2. 검색되었을때  [조건O : keyword=입력받은값, key=입력받은값]
//		3. 페이지 전환되었을때
function board_print(keyword, key){
	// 1. JAVA[백엔드]로부터 데이터 요청
		// 1. 검색이 없는 경우 -> JAVA에게 검색[조건]이 없는 게시물들을 요청
		if(keyword == null && key == null){alert('검색이 없는 게시물 출력')}
		// 2. 검색이 있는 경우 -> JAVA에게 keyword, key 보내서 검색[조건]이 맞는 게시물들을 요청
		else {alert('검색에 맞는 게시물 출력')}
	// 2. DB -> JAVA 로 전달된 게시물리스트 데이터 
	let boardlist = [
   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
   { no : 4 , title : '안녕하세요B' , writer : '강호동' , date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
	]
	// 3. 출력	
	let html = ``
				
	boardlist.forEach((o)=>{
		html += `<tr> 
					<td> ${o.no} </td> 
					<td> <a href="view.html"> ${o.title} </a> </td> 
					<td> ${o.writer}  </td> 
					<td> ${o.date}  </td> 
					<td> ${o.view}  </td> 
					<td> ${o.up}  </td> 
					<td> ${o.down}  </td>
				</tr>`		
	})				
	document.querySelector('.boardlist').innerHTML = html
}

// 2. 검색 버튼을 클릭했을때
document.querySelector('.searchbtn').addEventListener('click',(e)=>{
	// 1. 키워드
	let keyword = document.querySelector('.keyword').value
	// 2. 검색어
	let key = document.querySelector('.key').value
	// 3. 유효성 검사 생략


	// 4. 키워드, 검색어 전달 
	board_print(keyword, key)
	console.log('keyword : '+keyword)
	console.log('key : '+key)
})

