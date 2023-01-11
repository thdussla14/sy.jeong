/*
----------------과제2------------------

주제 : 입력된 값으로 구구단 출력

조건1) 단 [input]과 곱[input] 입력 받기
조건2) 확인 [button]클릭하면 결과 실행
조건3) 테이블에 출력 [ 행=단, 열=3]
  
*/
//------------------------------------------------------
	console.log('JS 실행')

function cross()
{	
let left  = document.querySelector('.left')
let right = document.querySelector('.right') 	
	
let 단 = Number(left.value)
	
//------------------------------------------------------	
// let html 변수명 = 'HTML마크업 작성' // ! : 마크업 문자처리	
// 테이블의 첫행[제목] html 대입된 변수
	
let 테이블행 = '<tr> <th> 단 </th> <th> * </th> <th> 곱 </th> <th> 결과 </th> </tr>'; 
	
// 3. <table>의 행<tr> 반복문으로 만들기 

	for ( let 곱 = 1 ; 곱<=Number(right.value) ; 곱++)	// 곱은 1부터 9까지 1씩 증가 반복 처리
	{console.log(곱)	;				// 반복 확인
	console.log(단+"* "+곱+" = "+(단*곱));

// 4. 마크업과 변수를 이용한 HTML 구성하고 변수에 추가	

	테이블행 += 	//  += 추가	// = 대입 
	'<tr> <th>'+ 단+' </th> <th> * </th> <th>'+ 곱 +' </th> <th>'+ (단*곱) +'</th> </tr>';	
	}				
document.querySelector('.gu_table').innerHTML = 테이블행	
}