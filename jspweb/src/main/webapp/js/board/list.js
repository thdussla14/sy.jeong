console.log('blist js')

// * pageObject : 현재페이지, 검색, 전송타입 보관된 객체 
let pageObject = {
	page 	 : 1,
	key 	 : "",
	keyword  : "", 
	type 	 : 1,
	cno		 : document.querySelector('.cno').value,
	listsize : 3 
}

let cnameHTML = '';
if(pageObject.cno == 1){cnameHTML = '공지사항'}
if(pageObject.cno == 2){cnameHTML = '커뮤니티'}
if(pageObject.cno == 3){cnameHTML = 'QnA'}
if(pageObject.cno == 4){cnameHTML = '노하우'}
document.querySelector('.cname').innerHTML = cnameHTML;

getBlist(1);// js 열릴때 페이지 1 기본값

function getBlist(page){
	// 해당 함수로부터 페이징 번호 받기 
	console.log(page)
	pageObject.page = page ; // 인수로 받은 현재 페이지를 객체에 대입
	
	console.log('blist 실행')
	html = ``
	$.ajax({
		url		: "/jspweb/boardinfo",
		method	: "get",
		data	: pageObject,
		success : (r)=>{
			console.log('응답')
			console.log(r) ;console.log(r.boardList.length);
		if(r.boardList.length==0){
			html += `<div class="bcontentbox"><div class="btitle"> 검색된 게시물이 없습니다. </div></div>`
		}else{				
			r.boardList.forEach((o)=>{
				html += `
					<div class="bcontentbox">
						<div>
							<img class="pimg" src="/jspweb/member/pimg/${o.pimg==null? '사람.png' : o.pimg}" > 
							<span  class="mid">  ${o.mid}</span>
							<span  class="bdate">${o.bdate}</span>
						</div>
						<div class="btitle"> <a href="/jspweb/board/view.jsp?bno=${o.bno}" >${o.btitle}</a> </div>
						<div class="etc">
							<span> <i class="far fa-eye"></i>			<span class="bview"> ${o.bview} </span>	</span>
							<span> <i class="far fa-thumbs-up"   ></i> 	<span class="bup">	 ${o.blike} </span>	</span>
							<span> <i class="far fa-thumbs-down" ></i> 	<span class="bdown"> ${o.bhate} </span>	</span>
							<span> <i class="far fa-comment-dots"></i> 	<span class="bcomme">${o.rcount} </span></span>					
						</div>
					</div>`
				})
		}
			document.querySelector('.boardlist').innerHTML = html;
			
			html = '' ;
			html += page <=1 ? ``:
				`<button onclick="getBlist(${page-1})" class="pagebtn" type="button"> < </button>`;
			for(let i=r.startbtn ; i<=r.endbtn ; i++){
				html += 
				`<button onclick="getBlist(${i})"      class="pagebtn" type="button"> ${i} </button>`
			}
			html += page >= r.totalpage ? ``:
				`<button onclick="getBlist(${page+1})" class="pagebtn" type="button"> > </button>`
				
			document.querySelector('.page').innerHTML = html;
			
			document.querySelector('.searchcount').innerHTML = '총 게시물 수 : '+r.totalsize ;

		} // success e
	})	// ajax e
}

/*
	pk[식별자] 이동하는 방법
	
	1. HTTP 이용한 pk 이동
		<a href="/jspweb/board/view.jsp?bno=${o.bno}" >
		<a href="/jspweb/board/view.jsp? 변수명=데이터" >
		<a href="/jspweb/board/view.jsp? 변수명=데이터 & 변수명=데이터 & 변수명=데이터" >
*/

function searchBlist(){
	// 입력받은 데이터를 전역변수 필드에 대입 
	pageObject.key     = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	console.log(pageObject)
	getBlist(1);
}
function reset(){
	pageObject.key     = '';
	pageObject.keyword = '';
	getBlist(1);
}
function setsize(){
	pageObject.listsize = document.querySelector('.listsize').value;
	getBlist(1);
}

