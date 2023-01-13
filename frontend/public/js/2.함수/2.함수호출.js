/**
 	1. 인수 X 반환 X 함수
 	
 	- 정의 								- 호출
 	function 함수명( ) { } 				함수명 ()
 	
 	2. 인수 O 반환 X 함수
 	
 	- 정의 								- 호출
 	function 함수명( x ) { } 				함수명 (x)
 	
 	3. 인수 X 반환 O 함수
 	
 	- 정의 								- 호출
 	function 함수명( ) {return 3 } 		let result = 함수명 ()
 	
 	4. 인수 O 반환 O 함수
 	
 	- 정의 								- 호출
 	function 함수명( x ) {return3 } 		let result = 함수명 (3)
 	
 	ex) prompt () 함수 예시
 	
 	1. pormpt (인수)					: 인수 = 메시지창에 출력할 텍스트
 	2. let 반환  = prompt (인수) 		: 메시지창에 입력된 인수를 반환이라는 곳에 저장
 	
 	ex) 		복권 : 1000
 		유재석 ----인수 : 1000------> 로또 판매점
 									[로직 : 추첨]
 			<---반환값: 추첨 결과---- 

 */

 
 // 1. 인수가 없는 함수 선언
 function 함수1(){console.log('함수1 실행')}
 
 // 1-1. js 함수 호출 [ 함수호출 : 함수명 ( ) ]
 함수1()
 
 // 2. 인수가 1개인 함수 선언
 function 함수2 (x){console.log('함수2 실행 : '+x)}
 
 // 2-1. 인수가 1개인 함수 호출
 함수2(7)
 
 // 3. 인수가 2개인 함수 선언
 function 함수3 (x,y){console.log('함수3 실행 : '+(x+y))}
 
 // 3-1. 인수가 2개인 함수 호출
 함수3(5,7)
 
 // 4. 반환이 있는 함수 선언
 function 함수4 (x,y,z){let result = x+y+z ; return result;}
 
 // 4-1. 
 함수4(1,2,3)
 let result = 함수4 (1,2,3)
 console.log('함수4 반환 : '+함수4(1,2,3))
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 