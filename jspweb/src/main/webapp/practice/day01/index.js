function Ex1(){
	let data = document.querySelector('.inputdata').value;
	console.log(data);
	
	$.ajax({
		url : "/jspweb/Ex1" , 
		method : "post" , 
		data : {"data":data} , 
		success : function(result){ 
			console.log(result);
		}
	 });
	 Ex2();
}
Ex2()
function Ex2(){

	$.ajax({
		url : "/jspweb/Ex1" , 
		method : "get" , 
		// data : {} , 
		success : function(result){
			console.log(result);
			document.querySelector('.ex2box').innerHTML = result;
			}
	 });	
}

function 과제1C(){
	let data = document.querySelector('.data').value;
	$.ajax({
		url		: "/jspweb/Q1",
		method	: "post",
		data	:{"data":data },
		success	:function(result){
			console.log(result);
			과제1R();
		}
	});
}
과제1R();
function 과제1R(){
	$.ajax({
		url		: "/jspweb/Q1",
		method	: "get",
		success	:function(result){
			console.log(result);
			document.querySelector('.box').innerHTML = result;
		}
	});			
}









	// JS --> 서블릿 이동
	// 0. $ :jqeury 표현식 [jqeury라이브러리 필요]
	// 1. ajax 메소드 사용 : $.ajax();
	// 2. ajax 매개변수 [속성:객체형태] : { } -->  $.ajax({})
	// 3. 속성
		// 1. url		: 통신할 경로 [서블릿(클래스)주소] 
			// http://localhost:8080/jspweb/Ex1
			// http://192.168.17.31:8080/jspweb/Ex1
			// /jspweb/indextest => 프로젝트명/서블렛명
		// 2. method	: http메소드 형식
			// get
			// post
		// 3. data		: 통신시 데이터 보내기
			// js 객체 형태 : {매개변수1:데이터1, 매개변수2:데이터2}
		// 4. success	: 통신시 데이터 받기
			// success  : function(매개변수){ }
			// success  : (매개변수) => { }
	//
	/*
		 $.ajax({
			 url : "http://localhost:8080/jspweb/Ex1" , 
			 method : "" , 
			 data : {매개변수:데이터} , 
			 success : function(result){ }
			 });
	 */