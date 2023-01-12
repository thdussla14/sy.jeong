/*
	- 출력
	콘솔출력 : console.log(	)
	알람메시지 출력 : alert()
	html
		1. document.write(	)
		2. document.querySelctor ( ).innerHTML
		
	- 입력
	1. 알람메시지 입력 : prmopt()
	2. html 입력 : document.querySelctor().value	
	
 */

 // 에시1 ) 입력받은 수 만큼 * 출력
 
 let output = '' // 출력 변수
 
 let s1 = Number( prompt('예시1 별 개수 '))
 
 for ( let i=1 ; i<=s1 ; i++)		// i는 1부터 입력받은 수 (s1) 까지 1씩 증가 반복
	 {output += '*'}					// = 대입[기존데이터 삭제] vs += 누적대입[기존데이터에 추가]
 console.log(output)
 
/*
	만약 5를 입력했을때  s1 = 5

	for( let i=1 ; i<=s1 ; i ++)
	
		i	조건	[ i<=s1]       실행문		    output	       증감식
	=1		1<=5 [T]	  output += "*"		'*'				i++
	=2		2<=5 [T]	  output += "*"		'**'			i++
	=3		3<=5 [T]	  output += "*"		'***'			i++
	=4		4<=5 [T]	  output += "*"		'****'			i++
	=5		5<=5 [T]	  output += "*"		'*****'			i++	
	=6		6<=5 [F]	  실행 X
*/ 
 
 // 예시2 ) 입력받은 수 만큼 * 출력 [ 3줄마다 줄바꿈]
 
 output='' 				// 이전 사용한 output 변수 다시 초기화 !! let 써서 선언하면 X
 let s2 = Number( prompt('예시2 별 개수'))
 for ( let i=1; i<=s2; i++)				
 	{output +='*'; 							//1. 별    출력
	if(i%3==0){output += '\n'}  }			//2. 줄바꿈 출력
 console.log(output)

 /*
	만약 5를 입력했을때  s1 = 5

	for( let i=1 ; i<=s1 ; i ++)
	
		i	조건1	[ i<=s1]       실행1		 	조건2		  	실행2		 output	       증감식
	=1		1<=5 [T]	  output += "*"		1%3==0[F]	실행X		'*'				i++
	=2		2<=5 [T]	  output += "*"		2%3==0[F]	실행X		'**'			i++
	=3		3<=5 [T]	  output += "*"		3%3==0[T]	'\n'	'***\n'			i++
	=4		4<=5 [T]	  output += "*"		4%3==0[F]	실행X		'***\n*'		i++
	=5		5<=5 [T]	  output += "*"		5%3==0[F]	실행X		'***\n**'		i++	
	=6		6<=5 [F]	  실행 X
 */ 

//------문제1---------------------------------------------------

 output='' 			
 let s3 = Number( prompt('문제1 줄수'))
 for (let i=1; i<=s3 ; i++)
	 {for(let j=1; j<=i ;j++){output += '*'};
	  output += '\n'; }
 console.log(output)
 
//------문제2-------------------------------------------------------- 
 output='' 				
 let s4 = Number( prompt('문제2 줄수'))
 for (let i=s4; i>=1;i--)
	 {for(let j=1;j<=i; j++){output += '*'} ;
	 output += '\n';}
 console.log(output)
 
//------문제3--------------------------------------------------------  
  output='' 				
 let s5 = Number( prompt('문제3 줄수'))
 for (let i=s5; i>=1;i--)
	 {for(let k=1 ; k<=s5-i ; k++ ){output += ' '};
	  for(let j=1 ; j<=i ; j++){output += '*'} ;
	  output += '\n';}
 console.log(output)
 
//------문제4--------------------------------------------------------  
  output='' 				
 let s6 = Number( prompt('문제4 줄수'))
 for (let i=s6; i>=1;i--)
	 {for(let j=1 ; j<=i ; j++){output += ' '} ;
	  for(let k=0 ; k<=s6-i ; k++ ){output += '*'};
	 output += '\n';}
 console.log(output)
//------문제5----피라미드---------------------------------------------    
 output='' 				
 let line = Number( prompt('문제5 줄수'))
 for (let i=1; i<=line ; i++)
 	 {for(let j=0 ; j<=line-i ; j++ ){output += ' '};
 	  for(let s=1 ; s<=i*2-1   ; s++ ){output += '*'};
 	 output += '\n';}
 console.log(output)	

//------문제6----엑스 별-------------------------------------------- 
  


//------과제1----다이아몬드------제출 X /확인 : 2인 1조 발표?----------------------- 


 
 
 /* 9         9/2
 9>0[T] i=1   j= 1 2 3 4    s=1 
	 	i=2   j= 1 2 3     	s=3 
	 	i=3   j= 1 2     	s=5 
 		i=4   j= 1 		    s=7
	 	
	 	i=5   j= 0		    s=9
 	
	 	i=6   j= 1          s=7 
	 	i=7   j= 1 2        s=5
	 	i=8   j= 1 2 3      s=3
	 	i=9   j= 1 2 3 4    s=1
 */

