/*
	//1. 문자열 처리
	//'<button onclick="버튼클릭('+i+')"> '+i+' </button>'
		 
	//2. 백틱 이용한 문자열처리
		//`(백틱-esc아래)
		//1. 전체를 백틱으로 감싼다.
		//2. 변수/수식은 ${변수/수식} 감싼다.
	// 버튼목록 += `<button onclick="버튼클릭(${i})">${i}</button>`

 */


 console.log('js 작동')


//1. 숫자버튼 출력 함수
 function 버튼출력 () 
	 {	 
		 
	 let 버튼목록 = '' ; //for 밖에 만든 이유 -> 45개 만들려구
	 
	 for(let i=1; i<=45; i++)
	 	{	
			 버튼목록 += `<button onclick="버튼클릭(${i})">${i}</button>`
			 // 만약에 i가 5의 배수이면 줄바꿈
			 if(i%5==0){버튼목록 += '<br>'}
		 } 
	 
	 // 해당 div 에 버튼 목록 넣어준다.
	 document.querySelector('.버튼목록상자').innerHTML = 버튼목록
	 
	 // 취소 버튼 보이게 활성화
	 document.querySelector('.취소버튼').style.display = 'inline'
	 
	 }
 
 
//2. 숫자버튼 출력 없애는 함수
 function 버튼출력취소()
	 {
	 document.querySelector('.버튼목록상자').innerHTML = ''
	 
	  // 취소 버튼 안보이게 비활성화
	 document.querySelector('.취소버튼').style.display = 'none'
	 
 	 // 배열내 모든 요소 제거
	 선택번호목록.splice(0); //0번 인덱스부터 (개수) 생략 했을때 모두 제거
	 
	 추첨버튼출력();
	 }


// 선택한 숫자를 6개 저장하는 배열 
let 선택번호목록=[]


//3. 버튼클릭 함수
function 버튼클릭 (번호)
	{
	console.log(번호+'번호를 선택하셨군요.')
	
	// 중복검사 [ 배열명.indeOf(찾을데이터) : 찾을데이터의 인덱스번호 반환, 없으면 -1]
	if(선택번호목록.indexOf(번호)>=0)
		{alert('이미 선택한 번호입니다.[해당 번호를 취소합니다.]');		
		// [ 배열명.splice(인데스,개수) : 해당인덱스부터 개수만큼 삭제]
		선택번호목록.splice (선택번호목록.indexOf(번호),1);
		추첨버튼출력()
		return;}
		
	// 6개까지만 저장 [배열명.length : 배열내 데이터 총 개수]
	if (선택번호목록.length==6)
		{alert('이미 모두[6개]를 선택했습니다.')
		return;}		
		
	// 위 2가지 유효성검사를 충족하지 않았을때 저장			
	선택번호목록.push (번호)		
	추첨버튼출력()
	}

//4. 선택번호목록 출력 및 추첨버튼 활성화
function 추첨버튼출력()
	{if(선택번호목록.length==6)
		 {document.querySelector('.추첨버튼').style.display='inline'}
	else {document.querySelector('.추첨버튼').style.display='none'}
	document.querySelector('.선택번호상자').innerHTML = 선택번호목록
	}

// 추첨 번호 목록 배열 선언
 let 추첨번호목록=[]

//5. 추첨하기 버튼을 클릭했을때 함수
function 구매추첨()
	{//1. 컴퓨터가 난수 발생 [1~45사이 6개]
	for( let i=1; i<=6; i++)
		{	//1. 실수 난수 생성
			let 실수난수 = Math.random()*45+1
			//2. 실수 --> 정수
			let 정수난수 = parseInt(Math.random()*45+1)
			
			// 중복검사
			if(추첨번호목록.indexOf(정수난수)>=0)
				{i--;} //i는 6회를 반복하는데 난수 저장 실패시 1회 차감
			else {추첨번호목록.push(정수난수)}
			//---추첨번호목록.push(parseInt(Math.random()*44+1))
		}
		
	document.querySelector('.추첨번호상자').innerHTML = 추첨번호목록
	
	
	
	// 추첨 결과 출력 [두 배열 간 맞은 개수와 등수 출력] : 6개 1등 5개 2등 4개 3등 3개 4등 그외 꽝
	let 맞은개수 =0;
	for(let i=0 ; i<추첨번호목록.length ; i++)
		{	
		for(let j=0 ; j<선택번호목록.length ; j++)
			{
			console.log(추첨번호목록[i]+':'+선택번호목록[j])
			if(추첨번호목록[i]==선택번호목록[j]);{맞은개수++}		
			}
		}
	//	
	맞은개수 =0;	
	for(let i=0 ; i<추첨번호목록.length ; i++)
		{	
		if(선택번호목록.indexOf(추첨번호목록[i])>=0){맞은개수++}		
		}
		
	//3. 	
	맞은개수 =0;
	for(let value of 추첨번호목록)	
		{
		console.log(value)
		if(선택번호목록.includes(value)==true){맞은개수++}
		}		
	alert(맞은개수)	
	}
		

/*
	난수만들기
		1. Math 클래스 [ 미리 만들어둔 설계도 ]
			-random() 함수 [ Math 클래스가 제공하는 미리 만들어둔 함수]
			ex) 
			Math.random( )		: 0~1 	사이의 난수 발생
			Math.random()+1		: 1~2 	사이의 난수 발생
			Math.random()*45	: 0~45	사이의 난수 발생
			Math.random()*44+1	: 1~45	사이의 난수 발생
			-floor() : 소수점 버림 함수

		2.parseInt() : 정수 변환 함수

	두 배열 비교
		1. 	배열1 : [1,2,3,4]
			배열2 : [1,5,3,7]
		   [i] [j]
			1->1	2->1	3->1	4->1
			1->5	2->5	3->5	4->5
			1->3	2->3	3->3	4->3
			1->7 	2->7	3->7	4->7
	
	배열명.indexOf(찾을데이터)	: 찾을데이터의 인덱스 반환 / 없으면 -1
	배열명.includes(찾을데이터)	: 찾을데이터의 존재 여부 true/ 없으면 false	
		
	
		
		
		
		
 */
































