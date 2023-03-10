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

				html += `			
				<div class="dropdown">
				  <button class="hpimgbtn" type="button" data-bs-toggle="dropdown">
				   	<img src="/jspweb/member/pimg/${ r.mimg == null ? 'default.webp' : r.mimg }" class="hpimg"/>
				  </button>
				  <ul class="dropdown-menu">	<!-- 드롭다운시 표기되는 구역 -->
				    <li><a class="dropdown-item" href="#"> 내프로필 	</a></li>
				    <li><a class="dropdown-item" href="#"> 친구목록 	</a></li>
				    <li><a class="dropdown-item" href="#"> 쪽지함		</a></li>
				    <li><a class="dropdown-item" href="#"> 포인트 	</a></li>
				    <li><a class="dropdown-item" href="/jspweb/member/logout.jsp"> 로그아웃 	</a></li>
				  </ul>
				</div>
				${r.mid}님 `
				if(r.mid == 'admin'){
					html += `<a href = "/jspweb/admin/info.jsp"> 관리자 페이지 	</a>`	
				}

			}	
			document.querySelector('.submenu').innerHTML = html;		
		}
	})
}