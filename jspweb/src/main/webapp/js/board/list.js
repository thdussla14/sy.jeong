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
	html = `<tr>
				<th width="10%"> 카테고리	</th>		
				<th width="5%">  번호		</th>
				<th width="25%"> 제목 	</th>
				<th width="10%"> 작성자 	</th>
				<th width="25%"> 작성일 	</th>
				<th width="10%"> 조회수 	</th>
				<th width="10%"> 좋아요 	</th>
				<th width="10%"> 싫어요 	</th>
			
			</tr>`
	$.ajax({
		url		: "/jspweb/boardinfo",
		method	: "get",
		data	: pageObject,
		success : (r)=>{
			console.log('응답')
			console.log(r)
		r.boardList.forEach((o)=>{
			html += `<tr>
						<td> ${o.cname}		</td>
						<td> ${o.bno}		</td>
						<td> <a href="/jspweb/board/view.jsp?bno=${o.bno}" >${o.btitle}</a> </td>
						<td> ${o.mid} 		</td>
						<td> ${o.bdate} 	</td>
						<td> ${o.bview} 	</td>
						<td> ${o.blike} 	</td>
						<td> ${o.bhate} 	</td>		
					</tr>`
			})
			document.querySelector('.boardlist').innerHTML = html;
			
			html = '' ;
			html += page <=1 ? ``:
				`<button onclick="getBlist(${page-1})" class="btn btn-outline-secondary" type="button"> 이전 </button>`;
			for(let i=r.startbtn ; i<=r.endbtn ; i++){
				html += 
				`<button onclick="getBlist(${i})"      class="btn btn-outline-secondary" type="button"> ${i} </button>`
			}
			html += page >= r.totalpage ? ``:
				`<button onclick="getBlist(${page+1})" class="btn btn-outline-secondary" type="button"> 다음 </button>`
				
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

