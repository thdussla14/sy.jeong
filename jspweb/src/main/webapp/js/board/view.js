console.log('view')
console.log(memberInfo)
// * 비로그인시 댓글 비활성화
if(memberInfo== null){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.rcontent').value = '로그인 후 작성 가능합니다.';
	document.querySelector('.rwritebtn').disabled = true;
}
// * 현재 게시물 번호 
let bno = document.querySelector('.bno').innerHTML;
console.log(bno);
// 1. 게시물 상세 출력 
getBoard() 
function getBoard(){ 
	console.log('getBoard 실행')
	$.ajax({
		url		: "/jspweb/boardinfo",
		method	: "get",
		data	: {"type" : 2 , "bno": bno},
		success : (r)=>{
			console.log('응답')
			console.log(r)
			document.querySelector('.infobox').innerHTML	
			= `${r.bdate} / 
			<span> <i class="far fa-eye"></i>  </span> ${r.bview} / 			
			<span> <i class="far fa-thumbs-up"></i>  </span> ${r.blike} / 			
			<span> <i class="far fa-thumbs-down"></i></span> ${r.bhate} `
			//
			//
			
			document.querySelector('.pimgbox').innerHTML	= 
			`<img src="/jspweb/member/pimg/${r.pimg==null? '사람.png':r.pimg}" width="100px">`;
			document.querySelector('.btitle').innerHTML 	= r.btitle;
			document.querySelector('.bcontent').innerHTML 	= r.bcontent;
			
			if(r.bfile == null){
				document.querySelector('.bfile').innerHTML  = '첨부파일없음';
			}
			else{
				document.querySelector('.bfile').innerHTML  = 
				`${r.bfile} <button onclick="download('${r.bfile}')" class="cbtn" type="button"> 다운로드 </button>`;
			}	
			console.log(memberInfo.mid)
			console.log(r.mid)
			// 로그인 회원과 작성자가 일치하면 게시물 수정/삭제 버튼 생성
			if(memberInfo.mid == r.mid){
			document.querySelector('.btnbox').innerHTML = 
				`	<button class="btn" onclick="bdelete(${bno},${r.cno})" type="button"> 삭제 </button>
					<button class="btn" onclick="bupdate(${bno})" type="button"> 수정 </button>
				`
			}
			// 댓글 출력
			getReplyList();
		}// success e
	})// ajax e
}
// 2. 첨부파일 다운로드
function download(bfile){
	console.log('download 실행')
	console.log(bfile)	
	/*
	$.ajax({
		url		: "/jspweb/filedownload",
		method	: "get",
		data	: {"bfile": bfile},
		success : (r)=>{
			console.log('응답')
			console.log(r)			
		}
	})
	*/
	location.href="/jspweb/filedownload?bfile="+bfile;
}

// 3. 좋아요 싫어요 조회수
bIncrease(1) // 스크립트가 열리는 순간 조회수 증가 
function bIncrease(type){
	// 1. 현재 게시물의 번호  [ 증감의 대상 ]
	$.ajax({
		url 	: "/jspweb/board/view",
		method	: "get",
		data	: {"type": type ,"bno" : bno },
		success	: (r)=>{
			console.log('응답')
			console.log(r)
			getBoard() 
		}
	})
}

// 4. 삭제 
function bdelete(bno,cno){
	console.log(bno)
	$.ajax({
		url 	: "/jspweb/boardinfo",
		method	: "delete",
		data	: {"type":1, "bno" : bno },
		success	: (r)=>{
			console.log('응답')
			if(r=='true'){
				alert('게시물 삭제 성공')
				location.href="/jspweb/board/list.jsp?cno="+cno ;}
			else{alert('게시물 삭제 실패')}			
		}		
	})
}
// 5. 수정 페이지 이동
function bupdate(bno){
	location.href="/jspweb/board/update.jsp?bno="+bno;
}

// 6. 댓글 작성
function rwrite(){
	$.ajax({
		url 	: "/jspweb/boardreply",
		method	: "post",
		data	: {
				"type": 1,
				"bno" : bno , 
				"rcontent" : document.querySelector('.rcontent').value },
		success	: (r)=>{
			console.log('응답'); console.log(r);
			if(r=='true'){
				alert('댓글 작성 성공');
				document.querySelector('.rcontent').value = '';
				// 댓글 박스만 랜더링
				//$('.replylistbox').load(location.href)+' .replylistbox';
				// 전체 랜더링
				location.reload();}
			else{alert('댓글 작성 실패')}		
		}
	})
}
// 7. 댓글 출력
function getReplyList(){
	$.ajax({
		url 	: "/jspweb/boardreply",
		method	: "get",
		data	: {"bno" : bno, "rindex":0},
		success	: (r)=>{
			console.log('응답'); console.log(r);
			let html = '';
			r.forEach((o)=>{				
				html += `<div>
							<span><img src="/jspweb/member/pimg/${o.mimg}" width="23px"></span>				
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
							<button class="btn" onclick="rereplyview(${o.rno})" type="button"> 댓글 작성 </button>
							<div class="rereplybox${o.rno}">
							
							</div>
						</div>`
			})			
			document.querySelector('.replylistbox').innerHTML = html ;
		}
	})
}

// 8. 대댓글 작성란 오픈 
function rereplyview(rno){
	console.log('rereplyview')
	console.log(rno)
	
	let html = '';
	
	$.ajax({
		url 	: "/jspweb/boardreply",
		async	: "false",	// 동기식 통신 
		method	: "get",
		data	: {"bno" : bno, "rindex":rno},
		success	: (r)=>{
			console.log('응답'); console.log(r);		
			r.forEach((o)=>{	
							
				html += `<div class="rereply">
							<span><img src="/jspweb/member/pimg/${o.mimg}" width="23px"></span>				
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
						</div>`
						
			})	// forEach e
			html += `<textarea class="rereply rerecontent" rows="" cols="40"></textarea>
					<button onclick="rerewrite(${rno})" class="btn" type="button">  대댓글 작성 </button>`
			document.querySelector('.rereplybox'+rno).innerHTML = html;			
		} // success e
	}) // ajax e

}
// 9. 하위 댓글 작성
function rerewrite(rno){
	$.ajax({
		url 	: "/jspweb/boardreply",
		method	: "post",
		data	: {
				"type": 2,
				"bno" : bno , 
				"rcontent" : document.querySelector('.rerecontent').value ,
				"rindex": rno},
		success	: (r)=>{
			console.log('응답'); console.log(r);
			if(r=='true'){
				alert('대댓글 작성 성공');
				document.querySelector('.rerecontent').value = '';
				// 댓글 박스만 랜더링
				//$('.replylistbox').load(location.href)+' .replylistbox';
				// 전체 랜더링
				location.reload();}
			else{alert('대댓글 작성 실패')}		
		}
	})
}





// download(${r.bfile}) vs download('${r.bfile}') 인수 전달시 주의 문자 전달을 위하여 '' 필수!!
// '짱구.png' => . 파일 확장자 구분기호 인식
//`<button onclick="download('${r.bfile}')" type="button"> 다운로드 </button>`  	[o]
//`<button onclick="download('짱구.png')" type="button"> 다운로드 </button>`  		[o]
// 짱구.png   => . 접근 연산자로 인식
//`<button onclick="download(${r.bfile})" type="button"> 다운로드 </button>`		[x]
//`<button onclick="download(짱구.png)" type="button"> 다운로드 </button>`  		[x]

/*
	 전송방법
	 	HTML	: <form>
	 	JS 		: location.href=""
	 	JQUERY	: $.ajax({})
	 	Servlet	: 
	 		1. response.getwriter().print
	 		2. response.get 

*/