console.log('실행확인') //연동확인용
 
 let 도서목록 = ['혼자공부하는자바','이것이자바다','열혈 C언어'] // 등록 도서며명 목록
 let 대여목록 = ['혼자공부하는자바'] // 등록된 도서명 목록중에 대여된 도서 목록
 	
 // 도서현황 파악 함수 [1. 스크립트가 열렸을때 	2. 도서등록했을때	3. 도서삭제했을때	4. 도서대여했을때	5. 도서반납했을때]
 function adminPrintContent() 
 	// 테이블틀 선언
  	{let html = `<tr class="title">	
						<th>번호		</th>
						<th>도서		</th>
						<th>도서대여여부</th>	
						<th>비고		</th>
				</tr>`					
	for (let i=0 ; i< 도서목록.length ; i++)					
 		{html +=
	 			 `<tr>
			 			<td> ${i+1}	</td>
			 			<td> ${도서목록[i]}</td>
			 			<td> 
			 				${대여목록.includes(도서목록[i]) ? '대여중' : '대여가능'}
			 			</td>
			 			<td>	
			 				<button onclick="onDelete(${i})" > 삭제 </button>
			 			</td>
			 	 </tr>`	
 		// 전체 도서 현황 html 테이블로 출력       
 	   	document.querySelector('.bookmaster').innerHTML = html}
 	}// function end
 	
 // 기본페이지에 도서현황 출력
 adminPrintContent() 
 
 // 도서등록버튼 클릭시 신규도서 도서목록에 추가  [1. 등록버튼을 클릭했을때]
 function onAdd()
 	{// 입력된 도서명 불러오기
	let newbook = document.querySelector('.newbook').value	
 	console.log(newbook)
 	
 	// 기존 도서목록과 비교하여 중복확인	 	
 	if(도서목록.includes(newbook)){alert('이미 등록된 도서명 입니다.'); return ; } 
 	// 도서명 글자 수 제한 
	if(newbook.length<5||newbook.length>10){alert('5 ~ 10자 이내로 입력해주세요.'); return ; }
	// 새로운 도서를 도서목록에 추가
	도서목록.push(newbook); alert('신규 도서가 등록되었습니다.')
	// input 입력란 초기화		
	document.querySelector('.newbook').value='';
	adminPrintContent()		   //-----------------------관리자페이지 도서 추가시 관리자페이지 현황 갱신
	customerPrintContent()     //-------------------------관리자페이지 도서 추가시 고객페이지 현황 갱신
	console.log(도서목록)

 	}// function end
 	
 // 삭제버튼 클릭시 도서목록에서 해당 도서 제거
 function onDelete(i) 
 	{if(대여목록.includes(도서목록[i])){alert('대여중인 도서는 삭제가 불가능합니다.'); return ;}
	//도서목록 해당 인덱스로부터 1개 제거
	도서목록.splice(i,1)	 	
	alert('해당 도서가 삭제되었습니다.')
	adminPrintContent()			//-----------------------관리자페이지 도서 삭제시 관리자페이지 현황 갱신
	customerPrintContent()		//-------------------------관리자페이지 도서 삭제시 고객페이지 현황 갱신
	console.log(도서목록)
	}// function end

//고객체이지 테이블 안을 채우는 함수
 function customerPrintContent(){
	let html = `<tr class="title">	
						<th>번호		</th>
						<th>도서		</th>
						<th>도서대여여부</th>	
						<th>비고		</th>
				</tr>`					
	for (let i=0 ; i< 도서목록.length ; i++)					
 		{html +=
	 			 `<tr>
			 			<td> ${i+1}	</td>
			 			<td> ${도서목록[i]}</td>
			 			<td> 
			 				${대여목록.includes(도서목록[i]) ? '대여중' : '대여가능'}
			 			</td>
			 			<td>	
			 				<button onclick="rentalClick(${i})" > 대여 </button>
			 				<button onclick="returnClick(${i})" > 반납 </button>
			 			</td>
			 	 </tr>`	
 		// 전체 도서 현황 html 테이블로 출력       
 	   	document.querySelector('.customerTable').innerHTML = html}
 	}// function end

customerPrintContent()

//도서반납버튼  클릭시 처리하는 함수 [해당 인덱스를 인수를 받는다.]
function returnClick(i){
		if(대여목록.includes(도서목록[i]))
		{대여목록.splice(i, 1); //대여목록에 있는 해당 인덱스의 도서를 삭제한다.
		adminPrintContent()			//-------------------------고객페이지 반납시 관리자페이지 갱신
		customerPrintContent(); //화면을 다시 프린트해준다. (갱신 -> 정보가 바뀌었으니)
	}}

// 도서대여버튼 클릭시 처리하는 함수 [해당 인덱스를 인수를 받는다.]
function rentalClick(i){	
		if(대여목록.includes(도서목록[i])){alert('이미 대여중인 도서입니다.'); return ;}
		document.querySelector(".noticeText").innerHTML = "";
		대여목록.push(도서목록[i]);//대여목록에 해당 인덱스에 해당하는 도서를 넣는다
		console.log(대여목록)
		adminPrintContent()			//-------------------------고객페이지 반납시 관리자페이지 갱신
		customerPrintContent(); //화면을 다시 프린트해준다. (갱신 -> 정보가 바뀌었으니)
	}