console.log('signup js 실행')

/*
	정규표현식 : 문자 특정 규칙, 패턴, 집합 표현할때 사용되는 언어
		-- 문법
		 /^		: 정규표현식 시작
		 $/		: 정규표현식 끝
		 [a-z]	: 소문자	a-z 패턴
		 [A-Z]	: 대문자	A-Z 패턴
		 [0-9]	: 숫자 	0-9 패턴--------------------->\d
		 [가-힣]	: 한글 패턴
		  {최소길이,최대길이}: 문자열 길이 패턴
		 
		 [a-zA-Z]		: 영문 입력
		 [a-zA-Z0-9]	: 영문 숫자 입력
		 [a-zA-Z0-9가-힣]	: 영문 숫자 한글 입력
		 
		 1개 이상 문자가 포함되어야하는 경우
		 (?=.*[a-z]) 		: 소문자 1개 이상
		 (?=.*[A-Z]) 		: 대문자 1개 이상
		 (?=.*[0-9]) 		: 숫자 1개 이상
		 (?=.*\d)
		 (?=.*[!@#$%^&*]) 	: 해당 특수문자 중 1개 이상
		 
		  /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d) (?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{5,20}$/
		  -> 영대문자 1개, 영소문자 1개, 숫자 1개, 특정 특수문자 1개 필수로 5~20글자 이내
		  
		-- 패턴 검사 함수
			정규표현식.test(데이터)	: 패턴 적합 true / 비적합 false
			ex)
				/^[a-z]$/.test(qwe)	 --> true
				/^[A-Z]$/.test(qwe)	 --> false

*/
// * 첨부파일 이미지 미리보기 [ 업로드와 상관없음 ]
// document.addEventListener('change',(e)=>{})
function premimg(object){	// object : 해당 함수를 실행시킨 태그 객체
	console.log('첨부파일 변경'+object)
	console.log(object.files[0])									// 현재 이벤트를 실행한 input에 등록한 파일명 호출
	console.log(document.querySelector('.mimg').files[0])	// 현재 class input에 등록한 파일명 호출
	// 1. JS 파일 클래스 선언
	let file = new FileReader();			// 파일 읽기 클래스
	// 2. 첨부된 파일 읽어오기 
	file.readAsDataURL(object.files[0])		// 해당 파일 읽어오기 /	files[0] : 1개
	// 3. 읽어온 파일 꺼내기 (바이트)
	file.onload = (e)=>{
		// e.target -> file.onload	 : 읽어온 파일 
		// e.target.result			 : 읽어온 파일의 바이트 결과	
		// 4. 이미지 태그의 src 이미지 바이트 대입
		document.querySelector('.premimg').src=e.target.result;
		};

}// premimg e

// * "checkconfirm" span 모두 가져오기
let checkconfirm = document.querySelectorAll('.checkconfirm')

// 2. 아이디 유효성 검사 [ 문자길이, 중복검사 ]
function idcheck(){ // onkeyup 
	// 입력시마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	// 정규표현식 [ 영문대소문자+숫자 길이 : 5 ~30 글자]
	let midj = /^[a-z0-9]{5,30}$/;
	// 중복값 확인
	if(midj.test(mid)){
		$.ajax({ 
	         url 	 : "/jspweb/mconfirm" , 	
	         method  : "get" , 			
	         data	 :  {"mid":mid},				
	         success : (result)=>{
				console.log('응답성공')
				if(result == 'true'){
					checkconfirm[0].innerHTML = '사용중인 아이디'
				}else{
					checkconfirm[0].innerHTML = 'O'
				}
			}
	      });			
	}
	else{checkconfirm[0].innerHTML = '영문대소문자+숫자 조합으로 5 ~30 글자이내로 입력해주세요'}	
}// idcheck e

// 3. 비밀번호 유효성 검사 
function pwcheck(){
	let mpw = document.querySelector('.mpw').value;
	let midj = /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{5,20}$/;
	if(midj.test(mpw)){checkconfirm[1].innerHTML = 'O';pwconfirmcheck();}
	else {checkconfirm[1].innerHTML = '영문대소문자+숫자 조합으로 5 ~20 글자이내로 입력해주세요'}
} // pwcheck e

// 4. 비밀번호 확인 유효성 검사 
function pwconfirmcheck(){
	let mpw = document.querySelector('.mpw').value;
	let mpwconfirm = document.querySelector('.mpwconfirm').value;
	let midj = /^(?=.*[A-Za-z])(?=.*[\d])[A-Za-z\d]{5,20}$/;
	// 정규표현식 확인
	if(midj.test(mpwconfirm)){		
		// 두 비밀번호가 일치 여부 확인
		if(mpw==mpwconfirm){checkconfirm[1].innerHTML = 'O'}	
		else {checkconfirm[1].innerHTML = '비밀번호가 불일치합니다.'}
	}
	else {checkconfirm[1].innerHTML = '영문대소문자+숫자 조합으로 5 ~20 글자이내로 입력해주세요'}
} // pwconfirmcheck e

// 5. 이메일 유효성 검사 
function mailcheck(){
	let memail = document.querySelector('.memail').value;
	let midj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/;
	
	// 아이디 구역
	// [0-9a-zA-Z]	: 영문+숫자
	// [0-9a-zA-Z_-]: 영문+숫자+ _ + -
	// +@			: 아이디와 도메인 사이 @ 
	// 도메인 구역
	// [0-9a-zA-Z-] : 영문+숫자+ -
	// +\.			: 도메인과 최상위 도메인 사이 .
	//  [0-9a-zA-Z-]: 영문+숫자+ -
	// +
	if(midj.test(memail)){checkconfirm[2].innerHTML = 'O';}
	else {checkconfirm[2].innerHTML = '양식에 맞춰 입력해주세요'}
} // mailcheck e

// 1. 회원가입  *** 첨부파일이 있을때 ***
function signup(){
	let count = 0;
	for(let i=0 ; i<checkconfirm.length ; i++){
		if(checkconfirm[i].innerHTML=='O'){count++}
	}
	if(count!= checkconfirm.length ){alert('정상적으로 입력되지 않은 데이터가 있습니다.'); return;}
	let signupForm = document.querySelectorAll('.signupForm')[0];// 첫번째 form 가져오기
	
	let signupFormData = new FormData(signupForm);
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
