console.log('js실행')

// 함수 밖에 만드는 이유 : 전역변수 : 모든 함수에서 동일한 메모리 사용
let contents=[]
 onprint()
	// 이벤트 함수
		// 1. <button type="button" onclick="onwrite()"> 글 등록 </button>
			//funtion onwrite() { }
		// 2. <button type="button" class="onwritebtn"> 글 등록 </button>
			// document.querySelector('.onwritebtn').addEventListener ('click', (e)=>{})

// 1. 
function onwrite(){
	console.log('함수열림')
	
	// 1. 
	let info={ // let 객체명 = {속성명:데이터, 속성명:데이터]}
	bwriter : document.querySelector('.bwriter').value,
	bpassword : document.querySelector('.bpassword').value,
	btitle : document.querySelector('.btitle').value,
	bcontent : document.querySelector('.bcontent').value,
	bdate : new Date(),	// 현재 날짜와 시간 반환
	bview : 0	// 조회수
	}
	console.log(info)	// 객체 정보 출력시 문자열 연결연산자 금지
	
	// 2. 유효성 검사
		// 1. 입력받은 데이터 길이 
	if(info.bwriter.length <= 0 || info.bpassword.length <= 0
		||info.btitle.length <= 0||info.bcontent.length <= 0)
	{alert('작성이 안된 구역이 있습니다. 작성해주세요.')
	return; } // 함수 종료 

	// 3. 배열에 저장 ** 추후 : 백엔드에게 통신해서 데이터 전달 [ 백엔드 : java, DB]
	contents.push(info)
	alert('글 등록 성공')
	console.log(contents)

	// 4. 초기화
	document.querySelector('.bwriter').value = ''
	document.querySelector('.bpassword').value = ''
	document.querySelector('.btitle').value = ''
	document.querySelector('.bcontent').value = ''
	
	onprint()	
} // f e

// 2. 출력함수
function onprint(){	// 1. js열렸을때 2. 글쓰기 성공했을때 3. 글삭제 4. 글수정
	console.log('onprint 실행')	
	// 1. 기본 html 구성
	let html = `<tr> <th>번호</th> <th>제목</th> <th>작성자</th>
				<th>작성일</th> <th>조회수</th> </tr>`
	
	// 2. 내용 html 구성
	for(let i=0 ; i<contents.length ; i++){
		
		let date = contents[i].bdate.getFullYear() +'-'+
					contents[i].bdate.getMonth()+1 +'-'+
					contents[i].bdate.getDate()+'  '+
					contents[i].bdate.getHours()+':'+
					contents[i].bdate.getMinutes()+':'+
					contents[i].bdate.getSeconds()
		
		html += `<tr onclick="onview(${i})">
					<td>${i+1}</td> 
					<td>${contents[i].btitle}</td> 
					<td>${contents[i].bwriter}</td>
					<td>${date}</td>
					<td>${contents[i].bview}</td>
				</tr>`
	} // for e

	// 3. 마크업에 html 대입	
	document.querySelector('.boardtable').innerHTML = html;
}// f e 

// 3. 글 보기 함수
function onview(i){	// 글 목록에서 해당 행을 클릭했을때
	console.log(i)
	contents[i].bview += 1;onprint()
	
	let html = `<div> 제목 : ${contents[i].btitle}</div>
	 			<div> 내용 : ${contents[i].bcontent}</div>
				<div> 작성자 : ${contents[i].bwriter}</div>
				<div><button onclick="onDelete(${i})"> 삭제 </button></div>`
	
	document.querySelector('.viewbox').innerHTML = html;
} // f e

// 4. 글 삭제 함수
function onDelete(i){
	let 비밀번호 = prompt('.비밀번호를 입력해주세요')
	if(비밀번호 == contents[i].bpassword)
	{contents.splice(i,1);
	alert('삭제 완료하였습니다.')}
	else{alert('비밀번호가 일치하지 않습니다.')}
	document.querySelector('.viewbox').innerHTML = ''
	onprint()
} // f e 






























