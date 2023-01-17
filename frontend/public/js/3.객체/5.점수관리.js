// 학생들이ㅡ 점수 객체를 여러개 저장하는 배열
let studentArray = []

// 1. JS 열렸을떄
let addbtn= document.querySelector('.addbtn')
printTable()
// 2. 해당 버튼에 클릭 이벤트
addbtn.addEventListener('click', ( ) => {

	//1. 입력받은 데이터 가져오기
		// * input type=number로 숫자를 입력해도 value는 무조건 문자열로 가져온다.
		//	 형변환 필요!!
	let info = {
		name : document.querySelector('.name').value,
		kor : parseInt(document.querySelector('.kor').value),
		eng : parseInt(document.querySelector('.eng').value),
		mat : parseInt(document.querySelector('.mat').value)
	}
	console.log(info)
	// 유효성 검사 상태 저장하는 변수 [아래 4개중 하나라도 충족하면 저장 실패]
	let check = true;
	
	//2. 유효성검사 [데이터 체크]
		//1-1. 이름 중복체크
		for (let i=0 ; i <studentArray.length;i++)
			{if(studentArray[i].name == info.name)
			{alert('현재 등록된 학생명입니다.'); check = false;}
			//document.querySelector('.namebox').innerHTML='현재 등록된 학생명입니다.'}
			} // for e

		//1-2. 이름 글자수 제한 3-5
		if (info.name.length<3||info.name.length>5)
			{alert('글자수 제한되었습니다.(3~5자리)'); check = false;}		
		
		//2-1. 점수 0~100 사이만 입력
		if( (info.kor<0 || info.kor>100) ||
		 	(info.eng<0 || info.eng>100) || 
		 	(info.mat<0 || info.mat>100) )
			{alert('입력할 수 없는 점수 범위입니다.'); check = false;}
			
		//2-2. 점수 숫자만 입력 가능 [isNaN() : 숫자형식 체크 | 숫자true/ 문자false ]
		 if(isNaN(info.kor)||
			isNaN(info.eng)||
			isNaN(info.mat))
			{alert('숫자형식으로 입력해주세요.'); check = false;}
			
	//3. 유효성검사 4개중 하나라도 충족하면 저장 실패
		if(check){studentArray.push(info);alert('학생 점수를 등록했습니다.') }
		//if(check==true){studentArray.push(info);alert('학생 점수를 등록했습니다.') }// true 생략가능
		console.log(studentArray)
		 printTable()

}) // addEvent e

// 3. 배열내 객체 정보를 테이블에 출력하는 함수 [ 1. html 열렸을때 2. 등록할때마다 3. 삭제할때마다 4. 수정할때마다 ]
 function printTable()
	{// 1. html 구성
	let html = `<tr> 
					<th>번호</th><th>이름</th><th>국어</th>
					<th>영어</th><th>수학</th><th>총점</th>
					<th>평균</th><th>순위</th><th>비고</th>
				</tr>`
	// 2. 배열내 객체 정보를 html 대입
	studentArray.forEach((o,i)=>
		{// 1. 총점
		let total1 = o.kor+o.eng+o.mat;
		// 2. 순위구하기
		let rank = 1;
		studentArray.forEach((o2)=>{
			//1. 비교할 총점
			let total2 = o2.kor + o2.eng + o2.mat ;
			if(total1<total2){rank++;}			
		})		
		
/*	배열 내 순위
	for1 : 70	90	95	80		
	for2 : 70 	90	95	80
	
	1. 70일때 	rank = 1
		70<70	f
		70<90	t	++	
		70<95	t	++	
		70<80	t	++		rank = 4
	2. 90일때 	rank = 1
		90<70	f
		90<90	f		
		90<95	t	++	
		90<80	f			rank = 2	
	3. 95일때 	rank = 1
		95<70	f
		95<90	f		
		95<95	f		
		95<80	f			rank = 1
	4. 80일때 	rank = 1
		80<70	f
		80<90	t	++	
		80<95	t	++	
		80<80	f			rank = 3
 */		
		html += `<tr> 
					<td> ${i+1} 	</td>
					<td> ${o.name}	</td>
					<td> ${o.kor}	</td>
					<td> ${o.eng}	</td>
					<td> ${o.mat}	</td>
					<td> ${total1}	</td>
					<td> ${parseInt((total1)/3)}</td>
					<td> ${rank}	</td>
					<td> <button onclick="onDelete(${i})">삭제</button>
						 <button onclick="onUpdate(${i})">수정</button>
					</td>
		</tr>`})
		
	document.querySelector('.listtable').innerHTML = html				
 
	} // f e

// 4. 배열내 객체 삭제 [ 삭제할 인덱스 ]
 function onDelete(i)
 		 { studentArray.splice(i,1); 	// 선택한 i 번째 인덱스 객체 삭제
 		 printTable()}					// 삭제 후 테이블 업데이트
 
 let upindex = -1 ; // 수정할 인덱스 // 여러 { } 에서 동일한 변수를 사용하기위해 함수 밖에 선언	// !! 전역 변수 	 
 		 
// 5. 수정버튼을 눌렀을때 이벤트 [ 수정할 인덱스 ]		 
 function onUpdate(i) 
		 {
			upindex = i // 내가 선택한 i번째 인덱스 
		 // 1. 수정할 페이지 보여주기 
			document.querySelector('.updatebox').style.display = 'block'
			
		 // 2. 선택한 i번째 객체의 속성 데이터를 대입
			document.querySelector('.upname').value = studentArray[upindex].name
			document.querySelector('.upkor').value = studentArray[upindex].kor
			document.querySelector('.upeng').value = studentArray[upindex].eng
			document.querySelector('.upmat').value = studentArray[upindex].mat	
		} // f e
		
		
// 5-1. 수정완료 버튼을 눌렀을 때 이벤트
 let updatebtn = document.querySelector('.updatebtn')
 updatebtn.addEventListener('click',()=>{
	 
	 	//1. 수정된 데이터 가져오기
	 		studentArray[upindex].kor = parseInt(document.querySelector('.upkor').value )
			studentArray[upindex].eng = parseInt(document.querySelector('.upeng').value ) 
			studentArray[upindex].mat = parseInt(document.querySelector('.upmat').value )
			
		//2. 수정페이지 닫기	   			   
		 document.querySelector('.updatebox').style.display = 'none' 
		 
		//3. 수정 후 테이블 업데이트 
		 printTable()		 
		}) // f e

