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




































