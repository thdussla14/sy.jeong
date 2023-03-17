console.log('js 실행')

let mObject = {
	page	: 1,
	listsize: 3,
	key		:'',
	keyword	:''	
}

getMemberList(1);

function getMemberList(page){
	console.log('geMemberList 실행')

	mObject.page = page ;

	$.ajax({ 
         url 	 : "/jspweb/member" , 
         method  : "get" , 
         data	 : mObject,
         success : (r)=>{
			 console.log(r)
				html = `<tr>
							<th width="10%"> 회원번호 </th>
							<th width="10%"> 프로필 </th>
							<th width="10%"> 아이디 </th>
							<th width="10%"> 이메일 </th>
							<th width="10%"> 비고 </th>
						</tr>`
				r.memberList.forEach((o)=>{
					html += `<tr>
								<td> ${o.mno}	</td>
								<td> <img src="/jspweb/member/pimg/${ o.mimg == null ? '사람.png' : o.mimg }"  width="100px" height="100px"/> </td>
								<td> ${o.mid} 	</td>
								<td> ${o.memail}</td>
								<td> 
									<button type="button" class="btn" onclick="updated()"> 수정 </button>
									<button type="button" class="btn" onclick="deleted()"> 삭제 </button>
								</td>
							</tr>`
				})
				document.querySelector('.box').innerHTML = html ;
				
				html  = '';
				
				html  +=  page<=1 ? '' :
				`<button onclick="getMemberList(${page-1})" class="btn btn-outline-secondary" type="button"> 이전 </button>`; 
				
				for(let i=r.startbtn; i<=r.endbtn ; i++){
					html  += 
					`<button onclick="getMemberList(${i})" class="btn btn-outline-secondary" type="button"> ${i} </button>`; 
				}
				
				html  +=  page>=r.totalpage ? '' :
				`<button onclick="getMemberList(${page+1})" class="btn btn-outline-secondary" type="button"> 다음 </button>`; 
				
				document.querySelector('.page').innerHTML = html;
			
				document.querySelector('.searchcount').innerHTML = '총 게시물 수 : '+r.totalsize ;

		}
      });		
}

function searchMlist(){	
	mObject.key     = document.querySelector('.key').value;
	mObject.keyword = document.querySelector('.keyword').value;
	getMemberList(1);
	
}
function reset(){
	mObject.key     = '';
	mObject.keyword = '';
	getMemberList(1);
}
function setsize(){
	mObject.listsize = document.querySelector('.listsize').value;
	getMemberList(1);
}

function updated(){ }

function deleted(){ }