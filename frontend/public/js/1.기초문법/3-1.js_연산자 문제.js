
//<문제1>	1. 국어, 영어, 수학 점수를 입력받아 3개의 변수에 저장	2. 총점 출력, 평균 출력						
 
//'국어'라는 이름으로 변수 선언하고 prompt 입력받은 문자 데이터를 저장
 let 국어 = Number(prompt ('국어 점수 입력'))
 let 영어 = Number(prompt ('영어 점수 입력'))
 let 수학 = Number(prompt ('수학 점수 입력'))
 let 총점 = Number(국어+영어+수학)
 
 console.log('국어 점수 : '+국어)
 console.log('영어 점수 : '+영어)
 console.log('수학 점수 : '+수학)
 console.log ('총점 : '+ (국어+영어+수학))
 console.log ('평균 : '+ (총점/3))
 		
// <문제2>	prompt 함수로 반지름 입력받아서 원넓이 [반지름*반지름*3.14] 출력
 		
 let 반지름 = Number (prompt('반지름 입력'))
 console.log('반지름 : '+ 반지름)
 console.log('원넓이 : '+ (반지름*반지름*3.14))
 		
// <문제3>	prompt 함수로 두 실수를 입력받아서 앞실수의 값이 뒤 실수의 값의 몇 %인지 출력	
// 			(ex) 54.5  84.3 	결과 : 64%
 						
 let 실수1 = Number(prompt('실수1 입력'))
 let 실수2 = Number(prompt('실수2 입력'))
 console.log('실수1 : '+ 실수1)
 console.log('실수2 : '+ 실수2)
 console.log('실수2의 실수1 백분율 : '+ ((실수1/실수2)*100)+'%')			
 								
//<문제4>	prompt 함수로 정수를 입력받아 홀수 [true]/ 짝수 [false] 출력
 		
 let 정수1 = Number(prompt('정수1 입력'))
 console.log('홀수 : '+ ((정수1 % 2) == 1)) 		
 				
// <문제5>	prompt 함수로 정수를 입력받아 7배수이면 [true]/아니면 [false] 출력
 		
 let 정수2 = Number(prompt('정수2 입력'))
 console.log('7의 배수 : '+ ((정수2 % 7) == 0))		
 
 			
// <문제6>	prompt 함수로 십만원 단위의 금액을 입력받아 지폐 개수 세기
// 			(ex) 356789  		결과 : 십만원 3장, 만원 5장, 천원 6장 ※ 몫 구하기: parseInt(3.75) -> 3

 let 금액 = Number(prompt('금액 입력'))
 console.log('입력받은 금액 : '+ 금액)
 console.log('십만원권 : '+ parseInt(금액/100000) +'장')
 //! : 금액에서 십만원권 제외
 금액 = 금액 - (parseInt( 금액/100000 )*100000)
 console.log('만원권 : '+ parseInt(금액/10000) +'장')
  //! : 금액에서 만원권 제외
 금액 = 금액 - (parseInt( 금액/10000 )*10000)
 console.log('천원권 : '+ parseInt(금액/1000) +'장')

/*	(ex)금액 = 54326 
		금액 = 금액 - (parseInt( 금액/10000 )*10000)
	연산 순서 
		1. ( 금액/10000 )				= 5.4326
		2. parseInt( 금액/10000 )		= 5	
		3. *10000					= 50000
		4. 금액 - 50000				= 4326					
		5. 금액 = 4326				새로운 값 변경
*/	

 //<문제7>	prompt 함수로 아이디와 비밀번호를 입력받아 아이디가 admin이고 비밀번호가1234와 일치하면 [true]/아니면 [false] 출력	
 
 let 아이디 = prompt ('아이디 입력')
 let 비밀번호 = prompt('비밀번호 입력')
 console.log('로그인상태 : '+ (아이디=='admin' && 비밀번호=='1234'))
 		
 //<문제8>	prompt 함수로 정수를 입력받아 홀수이면서 7배수이면 [true]/아니면 [false] 출력		
 		
 let 정수3 = Number(prompt('정수3 입력'))
 console.log(정수3%2==1 && 정수3%7 == 0)

 //<문제9>	prompt 함수로 정수를 입력받아 '홀수'/'짝수' 출력
 
 let value1 = Number(prompt('정수 입력'))
 
 console.log(value1 +'의 홀짝 판단 : ' + ((value1%2)==1 ? '홀수': '짝수'))
 
 //<문제10>  prompt 함수로 정수 2개를 입력받아 더 큰 수를 출력
 let value2 = Number(prompt('정수2 입력'))

 // 변수 + 문자 + 변수 + 문자 +(삼항연산자 중첩))
 console.log(value1+'와 '+value2+'중 큰 수 : '+ 
 			(value1>value2 ? value1 : value2>value1 ? value2 :'같다'))

 
 //<문제11>  prompt 함수로 정수 3개를 입력받아 가장 큰 수를 출력
 
 let value3 = Number(prompt('정수4 입력'))

 let max = value1				 // 가장 큰 수 변수에 첫번째 값 대입
 max = max<value2 ? value2 : max //만약에 max 보다 크면 max 에 대입
 max = max<value3 ? value3 : max
 console.log('가장 큰 수 : '+ max)
  
 //<문제12>  prompt 함수로 정수 3개를 입력받아 오름차순으로 출력






	