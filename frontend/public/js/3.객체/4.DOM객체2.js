/*
	베열과 반복문
	1. for(let i=0 ; i<배열명.length ; i++) { }
	2. for(let index in 배열명) { }
	3. for(let object of 배열명){ }
	
	4.	배열명.forEach (화살표함수)
		배열명.forEach ((인수)=>{실행문;})
		배열명.forEach ((요소값)=>{실행문;})
		배열명.forEach ((요소값,인덱스)=>{실행문;})
		배열명.forEach ((요소값,인덱스,배열명)=>{실행문;})
	
 */

// script가 열렸을때
 alert('JS 열림')

// 1. 문서가 열렸을때 DOM 객체 이벤트
// document.addEventListener('DOMContentLoaded', ( ) => {실행문;}) 
// 해당 이벤트에서만 사용 재사용 X
 document.addEventListener('DOMContentLoaded', ( ) => {alert('HTML 열림');})



 const h1 = document.querySelector('h1')	// HTML 마크업 1개를 객체 반환

 console.log(h1)
 console.log(typeof(h1)) 					// tyof( ) : 데이더형 확인 가능
 
 h1.innerHTML = '안녕'
 h1.style.color = 'red'
 h1.style.backgroundColor = 'blue'			// 카멜표기법 background|Color
 h1.style.padding = '10px'

// 2. 
//document.addEventListener('DOMContentLoaded', function ( ){실행문;})
 document.addEventListener('DOMContentLoaded', function ( ){alert('HTML 열림2');})

 const h1Array = document.querySelectorAll('h1')
 
 console.log(h1Array)
 console.log(typeof(h1Array))				// tyof( ) : 데이더형 확인 가능

	//* 배열내 데이터 [ 요소 ]들을 하나씩 꺼내는 방법
	//1. 
	for(let i=0 ; i<h1Array.length ; i++)		// i 임시변수를 인덱스처럼 반복문에서 사용
		{h1Array[i].innerHTML='안녕'+i}
	//2.
	for(let index in h1Array)					// 배열내 요소 모든 인덱스를 하나씩 반복변수에 대입
		{h1Array[index].innerHTML = '안녕'+index}h1Array
	//3. 
	for(let object of h1Array)					// 배열내 요소 모든 데이터를 하나씩 반복변수에 대입
		{object.innerHTML='안녕'}
	//4. 
	h1Array.forEach( (object) => { object.innerHTML='안녕~~' })
		// 배열명.forEach (화살표함수)
		// 배열명.forEach ((인수)=>{실행문;})
		// 배열명.forEach ((요소값)=>{실행문;})
	h1Array.forEach((object)=>console.log(object))
		// 배열명.forEach ((요소값,인덱스)=>{실행문;})
	h1Array.forEach((object,index)=>{console.log(object);console.log(index)})
		// 배열명.forEach ((요소값,인덱스,배열명)=>{실행문;})
	h1Array.forEach((object,index,array)=>{
		console.log(object);console.log(index);console.log(array)})




