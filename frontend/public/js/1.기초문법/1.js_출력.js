/* 크롬 [브라우저] 개발자도구 F12
	console : 입/출력 가능한 구역 
*/

//	JS
//		1. 주석	[범위+ctrl+shift+/]
//			//   : 한줄수석
//			/**/ : 여러줄 주석
/* 
		2. 출력
			1. console.log()	: 콘솔에 출력하는 함수 [ 테스트 용도 ]
				-js코드 ---->브라우저의 개발자도구 console 출력
			2. alert()			: 알람 메시지 출력하는 함수
			3. document.write()
			
		3. 제어문자 [ 이스케이프 문자 ]
				- 엔터 위에 원화기호[백슬래시] : \
			1. \n 	: 줄바꿈
			2. \t	: 들여쓰기
			3. \\	: \		[백슬래시 출력]
			4. \'	:' 출력
			5.\"	:" 출력			
			
			!	키워드 : 명령어
				데이터 
					1. 문자
					2. 숫자
					3. 논리
			

*/
//1. 출력 [console.log(출력할 데이터/값)]
console.log('HELLO WORLD')	// ' ' 안에 있는 데이터는 문자 처리
//console.log(HELLO WORLD)	// 문자처리 생략시 오류 발생
console.log("HELLO WORLD")	// " " 안에 있는 데이터는 문자 처리
console.log(100)			// 숫자는 문자처리 안함
console.log("100")			// 숫자에 문자처리 하면 문자로 출력
console.log(true)	
//2. 출력 [alert(출력할 데이터/값)]
alert('HELLO WORLD2')
alert('HELLO WORLD22')
alert(200+200)
alert(true)
//3. 제어문자 
console.log('안녕하세요\nJS 처음입니다.')
console.log('안녕하세요\tJS 처음입니다.')
console.log('안녕하세요\\JS 처음입니다.')
console.log('안녕하세요\'JS 처음입니다.\'')
console.log('안녕하세요\"JS 처음입니다.\"')