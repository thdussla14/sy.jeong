console.log('view')

getBoard() 
function getBoard(){ 
	console.log('getBoard 실행')
	let bno = document.querySelector('.bno').innerHTML;
	console.log(bno);
	
	$.ajax({
		url		: "/jspweb/boardinfo",
		method	: "get",
		data	: {"type" : 2 , "bno": bno},
		success : (r)=>{
			console.log('응답')
			console.log(r)
			document.querySelector('.infobox').innerHTML	
			= `${r.bdate} / ${r.bview} / <button onclick="bIncrease(2)" > ${r.blike} </button> / <button onclick="bIncrease(3)" > ${r.bhate} </button>`
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
	let bno = document.querySelector('.bno').innerHTML;
	console.log(bno);
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