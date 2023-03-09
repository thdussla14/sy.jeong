console.log('login js 실행')

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

