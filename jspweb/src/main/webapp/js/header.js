console.log('헤더 js 실행')
let memberInfo = null;
getLogin();
// 로그인한 회원 정보 호출
function getLogin(){
	$.ajax({
		url:"/jspweb/login",
		async : false,			// <-- 동기화 변경 
		method:"get",
		success : (r)=>{
			memberInfo = r;		// <-- 지역변수에 옮기기 [이유? 다른 함수에서 사용하기 위해서]
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
				   	<img src="/jspweb/member/pimg/${ r.mimg == null ? '사람.png' : r.mimg }" class="hpimg"/>
				  </button>
				  <ul class="dropdown-menu">	<!-- 드롭다운시 표기되는 구역 -->
				    <li><a class="dropdown-item" href="/jspweb/member/info.jsp"> 내프로필 	</a></li>
				    <li><a class="dropdown-item" href="#"> 친구목록 	</a></li>
				    <li><a class="dropdown-item" href="#"> 쪽지함		</a></li>
				    <li><a class="dropdown-item" href="#"> ${r.mpoint} 포인트 </a></li>
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

// 
let 알림용소켓 = null;
if(memberInfo == null ){
	
}else{
	// JS 실행주체 = 클라이언트 // JAVA = 서버
	// 1. JS 클라이언트 소켓 생성
	알림용소켓 = new WebSocket('ws://localhost:8080/jspweb/alarm/'+memberInfo.mid)
	// 2. 클라이언트 소켓 이벤트 메소드 정의 
	알림용소켓.onopen 		= (e)=>{console.log('알림용 서버소켓 IN')}
	알림용소켓.onclose 		= (e)=>{console.log('알림용 서버소켓 OUT')}
	알림용소켓.onerror 		= (e)=>{console.log('알림용 서버소켓 ERROR')}
	알림용소켓.onmessage 	= (e)=>{onalarm(e)}
}

function onalarm(e){
	let msgbox = document.querySelector('.msgbox');
	
	msgbox.style.bottom = "100px";
	
	// * 4초 후에 자동 내려가기
	// n초 후에 이벤트 실행 setTimeout
	// n초 마다 이벤트 실행 setInterver
	setTimeout(()=>{msgbox.style.bottom = "-200px";},4000)
	
	// 여러명이 요청하면 Dao 충돌 발생
		// Dao synchronized
		// 스레드1 해당메소드 리턴 전까지 다른 요청 대기  
	getcontent()
	
	
}

