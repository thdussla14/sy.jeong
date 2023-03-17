console.log('write js')

// 회원정보.js : 만약에 로그인이 안되어 있으면 불가능 [ 제어 ]
if(memberInfo == null){
	alert('회원제 기능입니다. 로그인 후 작성해주세요.')
	location.href = '/jspweb/member/login.jsp';
}


function bwrite(){
	console.log('write')
	// 폼 문자열로 가져오기 => type="file" 직접적 접근 불가능
	// let writeForm = document.querySelector('.writefrom');
	// 폼 객체로 가져오기
	let writeForm = document.querySelectorAll('.writeform')[0];
	console.log(writeForm);
	// 폼 객체 -> new FormData 클래스
	let writeFormData = new FormData(writeForm);
	console.log(writeFormData);

	$.ajax({
		url		: "/jspweb/boardinfo",
		method	: "post",
		data	: writeFormData,
		contentType : false,
        processData : false,
		success : (r)=>{
			console.log('응답')
			console.log(r)
			if(r=='true'){alert('게시물 작성 성공');
			location.href = '/jspweb/board/list.jsp?cno='+writeFormData.get('cno'); }
			else{alert('게시물 작성 실패 [관리자에게 문의]')}
		}
	})

}