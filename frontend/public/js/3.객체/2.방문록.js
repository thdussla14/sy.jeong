/*
	1. 작성자 , 내용, 비밀번호 입력 받기
	2. 테이블에 순차 출력
	3. 게시물 삭제시 비밀번호 확인
	4. 게시물 수정시 비밀번호 확인
 */
 console.log('1.js실행')
 
 //* 배열선언 [board 객체 여러개를 저장하는 배열 / 함수 밖에 있는 이유 : 누적 저장]
 let boardArray = []
 // 예시 : [{속성:값},{속성:값},{속성:값},{속성:값},{속성:값}]
 
 //1. 작성 버튼 클릭시 실행되는 함수
 function 작성(){ // onclick="작성()"
	 console.log('2.함수실행')
	 
	 //1. 입력받은 데이터 가져오기
	 let 작성자 = document.querySelector('.작성자').value
	 	console.log('3.작성자 :'+작성자)
	 let 내용 = document.querySelector('.내용').value
	 	console.log('4.내용 :'  +내용)		 
	 let 비밀번호 = document.querySelector('.비밀번호').value
	 	console.log('5.비밀번호 :'  +내용)			 	 
	 //2. 2개의 데이터를 하나로 객체화
	 let board = { writer : 작성자, content : 내용	, password: 비밀번호}	 
	 	console.log(board)	 
	 //3. 객체를 배열에 저장 [여러개의 객체를 저장]
	 boardArray.push(board)
	 	console.log(boardArray)
	 //4.  배열내 객체 출력	
	 print()
	
} // f e 
 
 function Delete(i)
 	{  	// 1. 비밀번호를 입력받는다.
		let 비밀번호 = prompt('비밀번호를 입력하세요')
 		// 2. 입력받은 비밀번호와 내가 선택한 게시물의 비밀번호가 일치하면 삭제
 		if( 비밀번호 == boardArray[i].password)
 		{boardArray.splice(i,1);alert('게시물 삭제 성공')}
 		// 2. 입력받은 비밀번호와 내가 선택한 게시물의 비밀번호가 일치하지 않으면 알람 
		else{alert('패스워드가 일치하지 않습니다.')}
		 print()		 
	 }// f e
 
 function print()    // [1. 작성 성공시 2. 출력 성공시]
 	{//4. 배열내 객체 출력
	 	//1. 테이블의 제목행 만들기
	 	let html = `<tr><th>번호</th><th>내용</th><th>작성자</th><th>비고</th></tr>`	
	 	//2. 반복문을 이용한 배열내 모든 요소 행 만들기 [누적]
	 		// 1.반복 이용해서 배열내 객체 하나씩 호출	boardArray[i]
	 		// 2.객체내 속성 호출 					boardArray[i].content
	 	for(let i=0 ; i<boardArray.length ;i++)
	 	{ html += `<tr>
			 			<td> ${ i+1 } </td>
			 			<td> ${boardArray[i].content}</td>
			 			<td> ${boardArray[i].writer} </td> 
			 			<td> <button onclick="Delete(${i})"> 삭제 </button>	
			 			     <button onclick="수정(${i})"> 수정 </button> </td>
	 		 		</tr>
	 	`}// for end
	 	//3. 반복문 종료시 누적된 html 해당 table 출력
	 	document.querySelector('.게시물테이블').innerHTML = html;
	 }// f e
 
 function 수정(i)
 	{	alert(i+'번째를 선택하셨군요.')
		// 1. 비밀번호를 입력받는다.
		let 비번 = prompt('비밀번호를 입력하세요')
 		// 2. 입력받은 비밀번호와 내가 선택한 게시물의 비밀번호가 일치 확인
 		if( 비번 != boardArray[i].password)
 		// 3. 비밀번호 불일치시 알람 	
 		{alert('패스워드가 일치하지 않습니다.')}		
 		// 4. 수정할 내용을 입력받는다.
 		else{let 수정 = prompt('수정할 내용을 입력하세요.')
 		// 5. 선택한 게시물의 속성의 값 수정
 		boardArray[i].content = 수정
 		alert('게시물 수정 성공')} 				
		print()		 
	 }// f e
 
 //boardArray				: 배열
 //boardArray[i]			: 배열내 i번쨰 요소 --> 객체 1개
 //boardArray[i].content	: 객체.속성명
 
 
 
 
 