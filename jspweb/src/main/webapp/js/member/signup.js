console.log('signup js 실행')

/*
	정규표현식 : 문자 특정 규칙, 패턴, 집합 표현할때 사용되는 언어
		-- 문법
		 /^		: 정규표현식 시작
		 $/		: 정규표현식 끝
		 [a-z]	: 소문자	a-z 패턴
		 [A-Z]	: 대문자	A-Z 패턴
		 [0-9]	: 숫자 	0-9 패턴
		 [가-힣]	: 한글 패턴
		  {최소길이,최대길이}: 문자열 길이 패턴
		 
		 [a-zA-Z]		: 영문 입력
		 [a-zA-Z0-9]	: 영문 숫자 입력
		 [a-zA-Z0-9가-힣]	: 영문 숫자 한글 입력
		 
		-- 패턴 검사 함수
			정규표현식.test(데이터)	: 패턴 적합 true / 비적합 false
			ex)
				/^[a-z]$/.test(qwe)	 --> true
				/^[A-Z]$/.test(qwe)	 --> false

*/


// 아이디 유효성 검사 [ 문자길이, 중복검사 ]
function idcheck(){ // onkeyup 
	console.log('idcheck 실행')
	// 입력시마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	console.log(mid)
	// 정규표현식 [ 영문대소문자+숫자 길이 : 5 ~30 글자]
	let midj = /^[a-z0-9]{5,30}$/;
	console.log(midj.test(mid))
	// 중복값 확인

	if(midj.test(mid)){
		$.ajax({ 
	         url 	 : "/jspweb/mconfirm" , 	
	         method  : "get" , 			
	         data	 :  {"mid":mid},				
	         success : (result)=>{
				console.log('응답성공')
				if(result == 'true'){
					document.querySelector('.idconfirm').innerHTML = '사용중인 아이디'
				}else{
					document.querySelector('.idconfirm').innerHTML = '사용가능한 아이디'
				}
			}
	      });			
	}
	else{document.querySelector('.idconfirm').innerHTML = '영문대소문자+숫자 조합으로 5 ~30 글자이내로 입력해주세요'}
	
}

// 1. 회원가입  *** 첨부파일이 있을때 ***
function signup(){
	console.log('signup 실행')

	let signupForm = document.querySelectorAll('.signupForm')[0];// 첫번째 form 가져오기
	
	let signupFormData = new FormData(signupForm);
	console.log(signupFormData);
	$.ajax({ 
         url 	 : "/jspweb/member" , 	// 서블릿 주소
         method  : "post" , 			// 첨부파일은 무조건 "get/post"
         data	 : signupFormData,
         // 첨부파일 있을때 추가되는 속성
         contentType : false,		// true : 매개변수 형식의 문자열타입 [ 기본값 ] 
         								// form-urlencoded 형식으로 전송
         							// false : 해제
         								// multipart/form-data 형식으로 전송
         processData : false,
         success : ( result)=>{
			console.log('응답성공')
			if(result == 'true'){
				alert('회원가입 성공');
				location.href="/jspweb/index.jsp";}
			else{alert('회원가입 실패')}
		}
     });
}