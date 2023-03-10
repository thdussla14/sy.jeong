console.log('login js 실행')
// 1. 로그인 
function login(){
	console.log('login')
	// 1. 입력값 불러오기
	let mid = document.querySelector('.mid').value;
	let mpw = document.querySelector('.mpw').value;
	
	$.ajax({ 
	         url 	 : "/jspweb/login" , 	
	         method  : "post" , 			
	         data	 :  {"mid":mid,"mpw":mpw},				
	         success : (result)=>{
				console.log('응답성공')
				if(result=='true'){
					alert('로그인 성공');
					location.href = "/jspweb/index.jsp"}
				else{alert('로그인 실패')}
			} // success e
	  }); // ajax e
} // login e

// 2. 아이디 찾기
function findid(){
	console.log('findid')
	let memail = document.querySelector('.memail').value;
	
	$.ajax({ 
	         url 	 : "/jspweb/find" , 	
	         method  : "get" , 			
	         data	 :  {"type":1,"memail":memail},				
	         success : (r)=>{
				if(r=='false'){
					 document.querySelector('.checkconfirm').innerHTML =`동일한 회원정보가 없습니다.`}
				else{document.querySelector('.checkconfirm').innerHTML =`회원님의 아이디는 ${r}입니다.`}
			} // success e
	  }); // ajax e	
}

// 3. 비밀번호 찾기
function findpw(){
	console.log('findpw')	
	let info ={
		"type"	:2,
		"mid"	:document.querySelector('.mid').value,
		"memail":document.querySelector('.memail').value
	}

	$.ajax({ 
	         url 	 : "/jspweb/find" , 	
	         method  : "get" , 			
	         data	 :  info,				
	         success : (r)=>{
				if(r=='false'){
					 document.querySelector('.checkconfirm').innerHTML =`동일한 회원정보가 없습니다.`}
				else{document.querySelector('.checkconfirm').innerHTML =`임시 비밀번호를 이메일로 전송했습니다.`}
			} // success e
	  }); // ajax e
}

























