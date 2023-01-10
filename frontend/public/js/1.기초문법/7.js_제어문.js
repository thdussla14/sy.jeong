/*
 	삼항연산자 : 조건? 참 : 거짓
 	제어문
 		IF	: 만약에 ~	[경우의 수 판단]
 		1. 형태 
 			1) 	if ( 조건 )	[true]실행문	
 			2) 	if ( 조건 )	{[true]실행문1 ;실행문2	; 실행문3; } !!실행문이 2개 이상!!
 			3) 	if ( 조건 )	{[true]실행문1 ;} 
 				else {[false]실행문;}
 		 	4)	 if ( 조건1 )	{[true]실행문1 ;} 
 		 		else if ( 조건2 ) {[true]실행문2 ;} 
 		 		else if ( 조건3 ) {[true]실행문3 ;} 
 		 		else {[false]실행문;}
 		 	5) 중첩 가능
 		 		if ( 조건1 )	{ if ( 조건2 )	{ if ( 조건3 )	{    }    }    } 
 			
 */
/*
 	; 세미콜론 [명령어 단위 마침표]		: 콜론 
 	실행문
 	실행문; 실행문;
 	if( ) [참]실행문
 	if( ); [참]실행문   [if ( ) 뒤에 ; 하지 말기 ]
 */
 //1. if 형태 1
  if ( 10>3 ) console.log('[참1] 10이 더크다')
  if ( 10>20 ) console.log('[참2] 10이 더크다')
  if ( 10>20 ); console.log('[참3] 10이 더크다') // [X]
  
 //2. if 형태 2
  if( 10>3 ) console.log('참1'); console.log ('1. 10이 더 크다.'); // [X] 2번쨰 console은 if랑 상관없이 실행
  if( 10>20 ) console.log('참2'); console.log ('2. 10이 더 크다.');// [X] 2번쨰 console은 if랑 상관없이 실행
  if( 10>20 ) {console.log('참2'); console.log ('3. 10이 더 크다.');}
  
 //3. if 형태 3
  if( 10>3 ) { console.log('[참1] 10이 더크다'); }
  else {console.log('[거짓1] 10이 더 작다.')}
  // vs 삼항연산자 [ 코드가 길어지면 가독성 떨어짐 ]
  10>3 ? console.log('[참2]') : console.log('[거짓2]')
  
  //4. if 형태 3
  if( 10>20 ) { console.log('[참1] 10이 20보다 크다'); }			//만약에 10>=20 이면
  else if( 10>=15 ) { console.log('[참2] 10이 15보다 이상'); }		//아니면서 만약에 10>=15 이면
  else if( 10>=10 ) { console.log('[참3] 10이 10보다 이상'); }		//아니면서 만약에 10>=10 이면
  else {console.log('[거짓1] 10이 10 미만이다.')}					//그 외
  // vs 삼항연산자 [ 코드가 길어지면 가독성 떨어짐 ]
  10>20 ? console.log('[참1] 10이 20보다 크다') : 
  10>=15 ? console.log('[참2] 10이 15보다 이상') : 
  10>=10 ?  console.log('[참3] 10이 10보다 이상') : 
  console.log('[거짓1] 10이 10 미만이다.');
 /*  
  // 1. prompt 로 정수 1개를 입력받아 90이상이면 '합격' 아니면 '탈락' console 출력
  	 2. prompt 로 성별을 입력받아
  	 	 'M' 또는 'm' 또는 '남' 또는 '남자' 일 경우 '남자 이군요' console 출력
  	 	 'W' 또는 'w' 또는 '여' 또는 '여자' 일 경우 '여자 이군요' console 출력
  	 	 그 외 '남자 :m,M,남,남자  여자 : w,W,여,여자 로 입력해 주세요'라고  console 출력
  	 3. prompt 로 점수 1개를 입력받아
  	 	90점 이상이면 'A등급'	80점 이상이면 'B등급'	70점 이상이면 'c등급' 그외 '탈락'
  	 		 	 	 
 */ 

//  1. 
  let 정수 = Number(prompt ('정수를 입력하세요'))
  if (정수>=90) {console.log('합격')} else {console.log('탈락')}
//	2.  
  let 성별 = prompt('성별을 입력하세요')
  
  if ( 성별 == 'M' || 성별 == 'm'|| 성별 == '남'|| 성별 == '남자' ) {console.log('남자 이군요')} 
  else if( 성별 == 'W' || 성별 == 'w'|| 성별 == '여' || 성별 == '여자' ){console.log('여자 이군요')}
  else {console.log('남자 :m,M,남,남자 \n 여자 : w,W,여,여자 로 입력해 주세요')}
  
 //	3.
  let 점수 = Number(prompt ('점수를 입력하세요'))
  if (점수>=90) {console.log('A등급')} 
  else if (점수>=80) {console.log('B등급')}
  else if (점수>=70) {console.log('C등급')}
  else {console.log('탈락')}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 