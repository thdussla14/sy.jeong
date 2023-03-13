console.log('update')
console.log(memberInfo)

// 회원정보.js : 만약에 로그인이 안되어 있으면 불가능 [ 제어 ]
if(memberInfo == null){
	alert('로그인이 필요한 페이지입니다.')
	location.href = '/jspweb/member/login.jsp';
}
// 회원정보 출력
document.querySelector('.mimg').src = `/jspweb/member/pimg/${ memberInfo.mimg == null ? '사람.png' : memberInfo.mimg }`;
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').value  = memberInfo.memail;

// 2. 회원정보수정 
function setUpdate(){
	console.log('setDelete함수')

	// 2-2 . 첨부파일 포함 수정
	let updateform = document.querySelectorAll('.updateform')[0];
	let updateformData = new FormData (updateform);
	// form 데이터 추가 
	let defaultimg = document.querySelector('.defaultimg').checked;
	updateformData.set("defaultimg",defaultimg);
	
	$.ajax({
		url 	: "/jspweb/member",
		method 	: "put",
		data	: updateformData,
		contentType : false,
        processData : false,
		success	: (r)=>{
			console.log('응답')
			if(r == 'true'){
				alert('회원정보 수정 성공');
				location.href = '/jspweb/member/logout.jsp';
			}else{
				alert('회원정보 수정 실패 [관리자에게 문의]')
			}	
		} 
	})
	
}

/*	// 2-1 . 첨부파일 제외 수정
	let info = {
		"mpwd" 	 : document.querySelector('.mpw').value,
		"newmpwd": document.querySelector('.newmpw').value,
		"memail" : document.querySelector('.memail').value 
	}
	console.log(info);
	$.ajax({
		url 	: "/jspweb/member",
		method 	: "put",
		data	: info,
		success	: (r)=>{
			console.log('응답')
			if(r == 'true'){
				alert('회원정보 수정 성공')
			}else{
				alert('회원정보 수정 실패 [관리자에게 문의]')
			}	
		} 
	})*/
	