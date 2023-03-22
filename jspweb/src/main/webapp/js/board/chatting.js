console.log('chatting js')

/*
	소켓 			: 두 프로그램 간의 양방향 통신 종착점 [도착지]
	서버소켓	  	: [JAVA] 서버가 가지고 있는 소켓
	클라이언트소켓	: [JS]   유저가 가지고 있는 소켓
	
	
	JS webSocket
		1. JS 에서 제공하는 클래스 WebSocket 
		2. 소켓 객체 생성		
		클라이언트소켓	[JS] 	let clientsocket = new WebSocket("ws://ip:포트번호/프로젝트명/서버소켓URL");
											   new WebSocket("ws://ip:포트번호/프로젝트명/서버소켓URL/mid");
		3. 클라이언트소켓이 서버소켓과 연동
			1.WEbSocket 생성자에서 해당 서버소켓의 경로 확인 통신
			
	JAVA ServerSocket	
		1. 임의의 클래스 생성
		2. 클래스 위에 @ServerEndpoint("/서버소켓URL")  	
		
			clientsocket.onopen					@OnOpen
			clientsocket.send(msg);				@OnMessage
			clientsocket.onmessage				session.getBasicRemote().sendText(msg);
*/

let clientsocket = null;

// 0. 회원제 
if(memberInfo == null){
	alert('로그인이 필요한 기능입니다.'); 
	location.href = "/jspweb/member/login.jsp";
}else{
// 1. 클라이언트소켓 객체 생성과 동시에 서버소켓과 연결 [@OnOpen]
	clientsocket = new WebSocket("ws://192.168.17.31:8080/jspweb/chatting/"+memberInfo.mid);
	clientsocket.onopen    = function(e){소켓연결(e);}
	clientsocket.onmessage = function(e){수신(e)}
	clientsocket.onclose   = function(e){연결해제(e)}
	console.log(clientsocket)
}

let contentbox = document.querySelector('.contentbox')

// 2. 클라이언트소켓 접속시 이벤트 정의 
function 소켓연결(e){
	contentbox.innerHTML += `<div class="alarm"> 
								<span> ***** ${memberInfo.mid}님 채팅방 입장 ***** </span> 
							</div>` ;}

// 3. 클라이언트 소켓이 메세지 전송 [@OnMessage]
function 전송(){
	console.log('채팅 전송')
	// 채팅 입력창 내용 불러오기
	let msg = document.querySelector('.msgbox').value;
	console.log(msg)
	// 채팅 전송 
	clientsocket.send(msg);	
	// 전송 성공시 채팅 입력창 초기화
	document.querySelector('.msgbox').value = '';
}

// 4. 클라이언트 소켓이 메세지 받기 
function 수신(e){ // e.data <--- e --- session.getBasicRemote().sendText(msg);
	console.log(e)
	console.log(e.data)
	console.log(JSON.parse(e.data)) 
	
	// json형태의 문자열로 온 데이터를 객체로 강제 형변환
	let data = JSON.parse(e.data);
	
	// 보낸 사람
	if(data.frommid == memberInfo.mid){
		contentbox.innerHTML += `<div class="secontent">
										<div class="date"> 		${data.time}	</div>
										<div class="content"> 	${data.msg}		</div>
								</div>`
	}else{// 받은 사람
		contentbox.innerHTML += `<div class="recontent">
									<span> <img src="/jspweb/member/pimg/${data.frommimg==null? 'default.webp' :data.frommimg}" class="hpimg">	</span>
									<div class="rcontent">
										<div class="name"> ${data.frommid}	</div>	
										<div class="contentdate">		
											<div class="content"> 	${data.msg}		</div>
											<div class="date"> 		${data.time}	</div>
										</div>		
									</div>
								</div>`
	}
	
	// 스크롤 최하단으로 내리기 
	let top = contentbox.scrollTop;		 	// 현재 스크롤의 위치
	console.log(top);
	let height = contentbox.scrollHeight; 	// 현재 스크롤의 전체 높이
	console.log(height);

	contentbox.scrollTop = contentbox.scrollHeight ;
}

// 5. 서버와 연결이 종료되었을때 = 클라이언트 객체 초기화
function 연결해제(e){console.log('연결 해제');}

/*
	clientsocket.onclose = function(e){console.log(e)}
	
	clientsocket.onclose = (e)=>{console.log(e)}
	
	function 연결해제(e){console.log(e)}
	clientsocket.onclose = (e)=>{연결해제(e)}

*/
function enterkey(){
	console.log( window.event.keycode )
	if( window.event.keyCode == 13){전송();}
}










