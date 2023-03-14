console.log('js실행');
let deletesno = 0;
// 인사 출력
// 사원 전체 출력
function getStaff(){
	console.log('getStaff실행');
	
	$.ajax ({
		url 	: "/jspweb/staff",
		method	: "get",
		success	: (r)=>{
			console.log('응답')
			console.log(r)
			html =`	<tr>
						<th width="10%">사원번호</th>
						<th width="10%">사원사진</th>
						<th width="10%">사원명</th>
						<th width="10%">직급</th>
						<th width="10%">고용형태</th>
						<th width="10%">부서</th>
						<th width="10%">입사일</th>
						<th width="10%">퇴사일</th>
						<th width="10%">퇴사사유</th>
						<th width="10%">비고</th>
					</tr>`
					
			r.forEach((o)=>{
				
			html +=`<tr>
						<td>${o.sno}	</td>						
						<td><img src="/jspweb/member/pimg/${ o.simg == null ? 'default.webp' : o.simg }"  width="50px" height="50px"/></td>
						<td>${o.sname}	</td>
						<td>${o.sclass}	</td>
						<td>${o.stype}	</td>
						<td>${o.field}	</td>
						<td>${o.edate}	</td>						
						<td>${o.ddate    == null ? '' : o.ddate  }</td>
						<td>${o.dcontent == null ? '' :o.dcontent}</td>
						<td>
							<button type="button" onclick="openmodal_U()">수정</button>
							<button type="button" onclick="openmodal_D(${o.sno})">삭제</button>
						</td>
					</tr>`
			})		
			document.querySelector('.stafftable').innerHTML = html;		
		}
	});	
}
// 직무 사원 출력
function getStaff_e(){
	console.log('getStaff_e실행');
	
		$.ajax ({
		url 	: "/jspweb/staff",
		method	: "get",
		success	: (r)=>{
			console.log('응답')
			console.log(r)
			html =`	<tr>
						<th width="10%">사원번호</th>
						<th width="10%">사원사진</th>
						<th width="10%">사원명</th>
						<th width="10%">직급</th>
						<th width="10%">고용형태</th>
						<th width="10%">부서</th>
						<th width="10%">입사일</th>
						<th width="10%">비고</th>
					</tr>`
					
			r.forEach((o)=>{
				if(o.dcontent==null){
					html +=`<tr>
								<td>${o.sno}	</td>						
								<td><img src="/jspweb/member/pimg/${ o.simg == null ? 'default.webp' : o.simg }"  width="50px" height="50px"/></td>
								<td>${o.sname}	</td>
								<td>${o.sclass}	</td>
								<td>${o.stype}	</td>
								<td>${o.field}	</td>
								<td>${o.edate}	</td>						
								<td>
									<button type="button"  onclick="openmodal_U()">수정</button>
									<button type="button"  onclick="openmodal_D(${o.sno})">삭제</button>
								</td>
							</tr>`
				}// if e
			})// foreach e		
			document.querySelector('.stafftable').innerHTML = html;		
		}
	});	
}
// 퇴사 사원 출력
function getStaff_d(){
	console.log('getStaff_d실행');	
	
	$.ajax ({
		url 	: "/jspweb/staff",
		method	: "get",
		success	: (r)=>{
			console.log('응답')
			console.log(r)
			html =`	<tr>
						<th width="10%">사원번호</th>
						<th width="10%">사원사진</th>
						<th width="10%">사원명</th>
						<th width="10%">직급</th>
						<th width="10%">고용형태</th>
						<th width="10%">부서</th>
						<th width="10%">입사일</th>
						<th width="10%">퇴사일</th>
						<th width="10%">퇴사사유</th>
						<th width="10%">비고</th>
					</tr>`
					
			r.forEach((o)=>{
				if(o.dcontent!=null){
					html +=`<tr>
								<td>${o.sno}	</td>						
								<td><img src="/jspweb/member/pimg/${ o.simg == null ? 'default.webp' : o.simg }"  width="50px" height="50px"/></td>
								<td>${o.sname}	</td>
								<td>${o.sclass}	</td>
								<td>${o.stype}	</td>
								<td>${o.field}	</td>
								<td>${o.edate}	</td>						
								<td>${o.ddate}	</td>
								<td>${o.dcontent}</td>
								<td>
									<button type="button"  onclick="openmodal_U()">수정</button>
									<button type="button"  onclick="openmodal_D(${o.sno})">삭제</button>
								</td>
							</tr>`
				}// if e
			})// foreach e		
			document.querySelector('.stafftable').innerHTML = html;		
		}
	});	
}

// 삭제 모달 열기
function openmodal_D(sno){
	console.log('modal')
	deletesno = sno ; console.log(deletesno);
	document.querySelector('.modal_wrap_D').style.display='flex';
}

// 삭제 모달 닫기
function closemodal_D(){
	deletesno = 0 ; 	console.log(deletesno);
	document.querySelector('.modal_wrap_D').style.display='none';
}


// 인사 삭제
function deleteStaff(){
	console.log('deleteStaff실행');	
	let sno = document.querySelector('.sno').value;
	if(deletesno==sno){
		$.ajax ({
			url 	: "/jspweb/staff",
			method	: "delete",
			data 	:{"sno": sno}, 
			success	: (r)=>{
				console.log('응답')
				console.log(r)	
				if(r=='true'){
					alert('인사 기록 삭제 성공');
					document.querySelector('.sno').innerHTML ="";
					closemodal_D();
					getStaff();}
				else{alert('인사 기록 삭제 실패');
					document.querySelector('.sno').innerHTML ="";
					closemodal_D();}
			}
		});
	}
	else{alert('사원번호가 일치하지 않습니다.');
		document.querySelector('.sno').innerHTML ="";
		closemodal_D();}
}
