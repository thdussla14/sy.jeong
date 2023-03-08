console.log('js 실행')

getMemberList();

function getMemberList(){
	console.log('geMemberList 실행')

	$.ajax({ 
         url 	 : "/jspweb/member" , 
         method  : "get" , 
         success : ( result)=>{
				html = `<tr>
							<th width="10%"> 회원번호 </th>
							<th width="10%"> 프로필 </th>
							<th width="10%"> 아이디 </th>
							<th width="10%"> 이메일 </th>
							<th width="10%"> 비고 </th>
						</tr>`
				result.forEach((o)=>{
					html += `<tr>
								<td> ${o.mno}	</td>
								<td> <img src="/jspweb/member/pimg/${ o.mimg == null ? 'default.webp' : o.mimg }"  width="100px" height="100px"/> </td>
								<td> ${o.mid} 	</td>
								<td> ${o.memail}</td>
								<td> 
									<button type="button" onclick="updated()"> 수정 </button>
									<button type="button" onclick="deleted()"> 삭제 </button>
								</td>
							</tr>`
				})
				document.querySelector('.box').innerHTML = html ;
		}
      });		
}

function updated(){ }

function deleted(){ }