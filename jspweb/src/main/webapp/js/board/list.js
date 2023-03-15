console.log('blist js')
getBlist();
function getBlist(){
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
		data	: {"type" : 1},
		success : (r)=>{
			console.log('응답')
			console.log(r)
		r.forEach((o)=>{
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
		}
	})	
}

/*
	pk[식별자] 이동하는 방법
	
	1. HTTP 이용한 pk 이동
		<a href="/jspweb/board/view.jsp?bno=${o.bno}" >
		<a href="/jspweb/board/view.jsp? 변수명=데이터" >
		<a href="/jspweb/board/view.jsp? 변수명=데이터 & 변수명=데이터 & 변수명=데이터" >
*/

function getBlist_c(){
	console.log('blist 실행')
	let cno = document.querySelector('.cno').value;
	if(cno==0){getBlist();return ;}
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
		data	: {"type" : 1},
		success : (r)=>{
			console.log('응답')
			console.log(r)
		r.forEach((o)=>{
			if(o.cno==cno){
				html += `<tr>
							<td> ${o.cname}		</td>
							<td> ${o.bno}		</td>
							<td> ${o.btitle} 	</td>
							<td> ${o.mid} 		</td>
							<td> ${o.bdate} 	</td>
							<td> ${o.bview} 	</td>
							<td> ${o.blike} 	</td>
							<td> ${o.bhate} 	</td>		
						</tr>`
				}
			})
			document.querySelector('.boardlist').innerHTML = html;
		}
	})	
}
function searchBlist(){
	let search      = document.querySelector('.search').value;
	let searchinput = document.querySelector('.searchinput').value;
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
		data	: {"type" : 3 , "search" : search , "searchinput":searchinput },
		success : (r)=>{
			console.log('응답')
			console.log(r)
		r.forEach((o)=>{
				html += `<tr>
							<td> ${o.cname}		</td>
							<td> ${o.bno}		</td>
							<td> ${o.btitle} 	</td>
							<td> ${o.mid} 		</td>
							<td> ${o.bdate} 	</td>
							<td> ${o.bview} 	</td>
							<td> ${o.blike} 	</td>
							<td> ${o.bhate} 	</td>		
						</tr>`
			})
			document.querySelector('.boardlist').innerHTML = html;
		}
	})
}