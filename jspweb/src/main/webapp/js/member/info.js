console.log('info')
console.log(memberInfo)

// 회원정보.js : 만약에 로그인이 안되어 있으면 불가능 [ 제어 ]
if(memberInfo == null){
	alert('로그인이 필요한 페이지입니다.')
	location.href = '/jspweb/member/login.jsp';
}

// 1. header js 에서 ajax 동기식으로 회원정보 가져온 상태 [memberInfo]
document.querySelector('.mimg').src = `/jspweb/member/pimg/${ memberInfo.mimg == null ? '사람.png' : memberInfo.mimg }`;
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;

// 2. 회원탈퇴 
function setDelete(){
	console.log('setDelete함수')
	$.ajax({
		url 	: "/jspweb/member",
		method 	: "delete",
		data	: {"mpwd" : document.querySelector('.mpw').value },
		success	: (r)=>{
			console.log('응답')
			if(r == 'true'){
				alert('회원탈퇴 성공')
				location.href = '/jspweb/member/logout.jsp';
			}else{
				alert('회원탈퇴 실패 [관리자에게 문의]')
			}	
		} 
	})
}
