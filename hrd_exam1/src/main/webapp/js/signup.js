console.log('signup js')

function signup(){
	console.log('signup')

	// 유효성검사
	if(document.signupform.custno.value == ""){
		alert('회원번호를 입력해주세요.');
		document.signupform.custno.focus(); // 커서 이동 함수 
		return false;
	}		
	if(document.signupform.custname.value == ""){
		alert('회원성명을 입력해주세요.');
		document.signupform.custname.focus(); // 커서 이동 함수 
		return false;
	}
	if(document.signupform.phone.value == ""){
		alert('전화번호를 입력해주세요.');
		document.signupform.phone.focus(); // 커서 이동 함수 
		return false;
	}
	if(document.signupform.address.value == ""){
		alert('회원주소를 입력해주세요.');
		document.signupform.address.focus(); // 커서 이동 함수 
		return false;		
	}
	if(document.signupform.joindate.value == ""){
		alert('가입일자를 입력해주세요.');
		document.signupform.joindate.focus(); // 커서 이동 함수 
		return false;
	}
	if(document.signupform.grade.value == ""){
		alert('회원등급을 입력해주세요.');
		document.signupform.grade.focus(); // 커서 이동 함수 
		return false;
	}	
	if(document.signupform.city.value == ""){
		alert('도시코드를 입력해주세요.');
		document.signupform.city.focus(); // 커서 이동 함수 
		return false;
	}	
	
	// 폼 전송
	document.signupform.submit();
	
	// 완료 알림
	alert('회원등록이 완료 되었습니다!') ; 
	// 페이지 전환
	location.href="/hrd_exam1/view.jsp"
}

function update(){
	console.log('update')

	// 유효성검사
	if(document.updateform.custno.value == ""){
		alert('회원번호를 입력해주세요.');
		document.updateform.custno.focus(); // 커서 이동 함수 
		return false;
	}		
	if(document.updateform.custname.value == ""){
		alert('회원성명을 입력해주세요.');
		document.updateform.custname.focus(); // 커서 이동 함수 
		return false;
	}
	if(document.updateform.phone.value == ""){
		alert('전화번호를 입력해주세요.');
		document.updateform.phone.focus(); // 커서 이동 함수 
		return false;
	}
	if(document.updateform.address.value == ""){
		alert('회원주소를 입력해주세요.');
		document.updateform.address.focus(); // 커서 이동 함수 
		return false;		
	}
	if(document.updateform.joindate.value == ""){
		alert('가입일자를 입력해주세요.');
		document.updateform.joindate.focus(); // 커서 이동 함수 
		return false;
	}
	if(document.updateform.grade.value == ""){
		alert('회원등급을 입력해주세요.');
		document.updateform.grade.focus(); // 커서 이동 함수 
		return false;
	}	
	if(document.updateform.city.value == ""){
		alert('도시코드를 입력해주세요.');
		document.updateform.city.focus(); // 커서 이동 함수 
		return false;
	}	
	
	// 폼 전송
	document.updateform.submit();
	
	// 완료 알림
	alert('회원정보 수정이 완료 되었습니다!') ; 
	// 페이지 전환
	location.href="/hrd_exam1/view.jsp"
	
}