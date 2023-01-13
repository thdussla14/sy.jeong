

// 1. 인수 X 반환 X 함수 정의
function 함수1() { alert('함수1 실행') }
	// function : 함수 선언시 사용되는 키워드
	// 함수 1		: 함수이름 [식별자] 동일한 파일내에서는 중복이름 불가능
	// ( )		: 인수 정의하는 곳
	// { }		: 함수가 호출되면 실행되는 구역
	
// 1-1. 함수 호출
함수1()

// 2. 인수 O 반환 O 함수 정의
function 함수2(x,y)
	{alert('함수2 실행');
	return x+y ;}
	// (x,y) : 해당 함수를 호출시 인수 [x,y] 2개를 받는 함수
	
let result = 함수2 (3,5)
alert ('함수2 실행 보내준 값 : '+result)

// 3. 인수 O 반환 X 함수 정의
function 함수3(x,y,z)
	{let result = x+y+z 
	alert('함수3 실행 :'+result)}

// 4. 인수 X 반환 O 함수 정의
function 함수4()
	{let result = 3+5+8
	return result;}
let result2= 함수4()
alert('함수4 실행 보내준 값 : '+result2) 