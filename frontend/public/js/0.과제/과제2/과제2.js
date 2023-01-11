/*
----------------과제2------------------

주제 : 입력된 값으로 구구단 출력

조건1) 단 [input]과 곱[input] 입력 받기
조건2) 확인 [button]클릭하면 결과 실행
조건3) 테이블에 출력 [ 행=단, 열=3]
  
*/
//------------------------------------------------------
	console.log('JS 실행')
	
	
// let 테이블행 = '<tr> <th> 단 </th> <th> * </th> <th> 곱 </th> <th> 결과 </th> </tr>' // 결과 누적 


function onResult()
{	
	let 테이블행 = '<tr> <th> 단 </th> <th> * </th> <th> 곱 </th> <th> 결과 </th> </tr>' // 결과 리셋 
// 각 <input>에 입력된 value을 각 변수에 저장
	let dan  = document.querySelector('.Dan').value
	let gob  = document.querySelector('.Gob').value	

	
// 3. <table>의 행<tr> 반복문으로 만들기 

	for ( let 곱 = 1 ; 곱 <= gob ; 곱++)	// 곱은 1부터 9까지 1씩 증가 반복 처리
	{console.log(곱)	;				 	// 반복 확인
	console.log(dan+"* "+곱+" = "+(dan*곱));

// 4. 마크업과 변수를 이용한 HTML 구성하고 변수에 추가	

	테이블행 += 	//  += 추가	// = 대입 
	'<tr> <th>'+dan+' </th> <th> * </th> <th>'+ 곱 +' </th> <th>'+ (dan*곱) +'</th> </tr>';	
	}	
				
document.querySelector('.gu_table').innerHTML = 테이블행	

}