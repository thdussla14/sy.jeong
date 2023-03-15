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
			document.querySelector('.infobox').innerHTML	= r.bdate+" / "+r.bview+" / "+r.blike+" / "+r.bhate;
			document.querySelector('.pimgbox').innerHTML	= 
			`<img src="/jspweb/member/pimg/${r.pimg}" width="100px">`;
			document.querySelector('.btitle').innerHTML 	= r.btitle;
			document.querySelector('.bcontent').innerHTML 	= r.bcontent;
			
			if(r.bfile == null){
				document.querySelector('.bfile').innerHTML  = '첨부파일없음';
			}
			else{
				document.querySelector('.bfile').innerHTML  = 
				`${r.bfile} <button onclick="download('${r.bfile}')" type="button"> 다운로드 </button>`;
			}		 
		}// success e
	})// ajax e
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