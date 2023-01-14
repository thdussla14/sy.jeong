/**
  과제4	
  주제: 도서관리 시스템
  파일: 과제 4 (html,css,js)
  제출: 화요일까지 [이메일]
  
  * 작성자 기록
  ex) //20230113: 정소연
  		function(){}
  	
  	  //20230113: 권가영
  		#div{}
  
  * 배열 2개
  		let 도서목록 = ['혼자공부하는자바', '이것이자바다','열혈 C언어']
  		let 대여목록 = []  
  		
  * input 은 관리자입장 1개만 (도서등록)
  * table 은 관리자와 고객 각각1개 		
--------------------------------------------------------------------------------  
  	1. 관리자입장 -정소연
  		- 기능
  		1. 도서등록 [ 도서명 ]
  				1. 중복검사 (indexOf)
  				2. 도서명 5~10 사이만 입력 가능 (length)
  		2. 도서현황출력
  		  		1. 번호	2. 도서명		3. 도서대여여부		4. 삭제[대여중에는 불가능]
    
  		  	ex)		번호		도서명			도서대여여부	비고
  		  			1		혼자공부하는자바		대여중		[삭제 버튼]
  		  			2		이것이자바다		대여가능		[삭제 버튼]  	
  		  			3		열혈 C언어			대여가능		[삭제 버튼] 	  	
---------------------------------------------------------------------------------  		  		
  	2. 고객입장 - 권가영
  		- 기능
  		1. 도서목록
  				1. 번호	2. 도서명		3. 도서대여버튼		4. 반납버튼
  				2. 도서대여 
  					1. 없는 도서명 불가능
  					2. 대여중인 도서 불가능
  		  		3. 도서반납
  		  			1. 없는 도서명 불가능
  		  			2. 대여 도서가 아니면 불가능 	
  	
  		  	ex)		번호		도서명			도서대여여부	비고
  		  			1		혼자공부하는자바		대여중		[대여버튼]/[반납 버튼]
  		  			2		이것이자바다		대여가능		[대여버튼]/[반납 버튼] 	
 					3		열혈 C언어			대여가능		[대여버튼]/[반납 버튼] 
 */

 console.log('실행확인') //연동확인용
 
 let 도서목록 = ['혼자공부하는자바','이것이자바다','열혈 C언어']
 let 대여목록 = ['혼자공부하는자바']
 
 //-------------------230114 정소연 작성----------------------------//

 // 도서현황 출력
 function printcontent() 
 	// 테이블틀 선언
  	{let html = `<tr class="title">	
						<th>번호		</th>
						<th>도서		</th>
						<th>도서대여여부</th>
						<th>비고		</th>
				</tr>`					
	for (let i=0 ; i< 도서목록.length ; i++)
	// 대여여부 확인
 		{if(check(도서목록[i])==0)
			{html +=
	 			 `<tr>
	 			<td> ${i+1}	</td>
	 			<td> ${도서목록[i]}</td>
	 			<td> 
	 				<button> 대여중 </button>
	 			</td>
	 			<td></td>
	 			</tr>`}
 		else{html +=
	 			 `<tr>
	 			<td> ${i+1}	</td>
	 			<td> ${도서목록[i]}</td>
	 			<td> 
	 				<button> 대여가능 </button>
	 			</td>
	 			<td><button onclick="onDelete()" > 삭제 </button></td>
	 			</tr>`}
 			
 	   	document.querySelector('.bookmaster').innerHTML = html}
 	}// function end

// 대여여부 확인

function check(x)
	// 대여목록에 포함되어있는가?
   { if(대여목록.indexOf(x)>=0)
		// 포함되어있음  	= 대여중
   		{return 0;}					
		// 포함되어있지 않음 = 대여가능
   	else{return 1;}
   	}// function end				

 // 도서등록버튼 클릭시 신규도서 도서목록에 추가
 function onAdd()
 	{// 입력된 도서명 불러오기
	let newbook = document.querySelector('.newbook').value	
 	console.log(newbook)
 	// 기존 도서목록과 비교하여 중복확인	 	
 	if(도서목록.indexOf(newbook)>=0)
 		{alert('이미 등록된 도서입니다.')}
 	// 도서명 글자 수 제한 
	else if(newbook.length<5||newbook.length>10)
		{alert('5 ~ 10자 이내로 입력해주세요.')}
	// 새로운 도서를 도서목록에 추가
	else{도서목록.push(newbook);}
	printcontent() 
	console.log(도서목록)
 	}// function end
 	
 // 삭제버튼 클릭시 도서목록에서 해당 도서 제거	 //수정 필요함
 function onDelete(dno) 
 	{도서목록.splice(dno,1)
 	console.log(도서목록)	 	
	printcontent()
	}// function end

 
 