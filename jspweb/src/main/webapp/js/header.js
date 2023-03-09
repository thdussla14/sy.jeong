console.log('헤더 js 실행')
getLogin();
// 로그인한 회원 정보 호출
function getLogin(){
	$.ajax({
		url:"/jspweb/login",
		method:"get",
		success : (r)=>{
			console.log('응답')
			console.log(r)
			let html = '';
			if(r == null){
				html += `<a href = "/jspweb/member/signup.jsp"> 회원가입 	</a>
						 <a href = "/jspweb/member/login.jsp"> 	 로그인 	</a>`
			} else {
								
				if(r.mid == 'admin'){
					html += `<a href = "/jspweb/admin/info.jsp"> 관리자 페이지 	</a>`	
				}

				html += `<img src="/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" class="hpimg"/> `
				html += `${r.mid}님 안녕하세요~`
				html += `<a href = "/jspweb/member/logout.jsp"> 로그아웃 	</a>`	
			}	
			document.querySelector('.header').innerHTML = html;		
		}
	})
}