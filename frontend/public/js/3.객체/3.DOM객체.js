/*
	객체
	1.미리 만들어진 객체
		1.console객체
			console.log( )
		2.Math 클래스
			Math.random ( )
		3.document 객체 : DOM객체
			document.querySelector( )

	2. 사용자 정의 객체
-------------------------------------------------------------------
	- 함수
		1. 일반 함수		function 함수명 ( ) { }
		2. 익명 함수		funciton ( ) { }			재호출 X But 변수나 객체[속성] 대입 O
		3. 화살표 함수		( ) = > { }					재호출 X But 변수나 객체[속성] 대입 O
		
	- window 객체
		1. window.onload = 함수 						: HTML에서 모든 자료[css,js]를 불러왔을때 실행
		2. window.addEventListener('load',함수)
	
	- DOM 객체
		1. document.body.innerHTML					: body마크업에 html 형식 문자를 대입
		2. document.addEventListener('이벤트명',함수)	: 문서에서 이벤트가 발생하면 함수 발생
				1.DOMContentLoaded					: HTML이 열렸을때 [다른 자료 상관 X]

 */

// 1. DOM 객체 : HTML을 객체화 
let h1 =`<h1> ${ '안녕하세요' } </h1>`

document.body.innerHTML = h1

// 2. DOM 객체의 이벤트
	// 1. 기존 함수 적용
function 함수1(){console.log('문서열림')}
document.onload = 함수1
document.addEventListener('DOMContentLoaded', 함수1())

	// 2. 익명 [이름없는] 함수 적용
document.onload = function(){console.log('문서열림2')}	
document.addEventListener('DOMContentLoaded', function(){console.log('문서열림2')})

	// 3. 화살표 [ (인수) => { 실행문 } ] 함수 적용
document.onload = () => {console.log('문서열림3')}
document.addEventListener('DOMContentLoaded', () => {console.log('문서열림3')})

let 익명함수 = function ( ) {console.log('문서열림4') }
let 화살표함수 = () => {console.log('문서열림5')}
let 객체 = {행동 : ()=>{console.log('문서열림6')}}





