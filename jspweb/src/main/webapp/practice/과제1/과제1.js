console.log( 'staff 열림');
fieldprint()

// 사진 미리보기
function premimg( object ){
	
	let file = new FileReader();
	
	file.readAsDataURL(object.files[0]);
	
	file.onload = (e)=>{
		document.querySelector('.premimg').src = e.target.result;
	}
}

function insertStaff(){
	console.log( 'insertStaff');
	
	let insertForm = document.querySelectorAll('.insertForm')[0];
	let insertFormData = new FormData(insertForm);
	console.log( insertFormData );
	
	$.ajax({
		url : "/jspweb/staff",	 
		method : "post",	
		data : insertFormData , 			
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('등록성공') 	
				document.querySelector('.sname').value ='';
				getStaff() 
			}else{ alert('등록실패') }
		}
	})
}

let updatesno = 0;
function onpenupdateModal(sno){
	updatesno = sno;
	document.querySelector('.update_modal_wrap').style.display ='flex';
	$.ajax({ // 2. ajax에게 보내서 결과 받기 
		url : "/jspweb/staff" ,
		method : "get" , 
		data : { "type" : 1 , "sno" : sno } ,
		success : (r) => {
			console.log( '통신' ); console.log( r );
			if(r!='null'){
				document.querySelector('.update_sno').innerHTML = r.sno;
				document.querySelector('.update_premimg').src = `/jspweb/practice/과제1/simg/${r.simg == null ? 'default.webp' : r.simg }`;
				document.querySelector('.update_sname').value = r.sname;
				document.querySelector('.update_edate').innerHTML = r.edate;
				document.querySelector('.update_ddate').value = r.ddate
				document.querySelector('.update_dcontent').value = r.dcontent;
				document.querySelector('.update_sclass').value = r.sclass;
				document.querySelector('.update_stype').value = r.stype;
				document.querySelector('.update_field').value = r.field;
			}
		}	
	})	
}
function closeupdateModal(){
	document.querySelector('.update_modal_wrap').style.display ='none';
}

function update_premimg( object ){
	
	let file = new FileReader();
	
	file.readAsDataURL(object.files[0]);
	
	file.onload = (e)=>{
		document.querySelector('.update_premimg').src = e.target.result;
	}
}

function updateStaff(){
	console.log( 'insertStaff');
	
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData(updateForm);
	updateFormData.set( "update_sno" , updatesno );
	console.log( updateFormData );
	
	
	$.ajax({
		url : "/jspweb/staff",	 
		method : "put",	
		data : updateFormData , 			
		contentType : false ,			
		processData : false ,			
		success : (r)=>{
			console.log( 'ajax 응답');
			console.log( r );
			if( r == 'true'){
				alert('수정성공')
				getStaff()
				document.querySelector('.update_modal_wrap').style.display ='none'; 					 
			}else{ alert('수정실패') }
		}
	})
}

function fieldprint(){
	let html = `<tr>
					<th>부서코드</th>
					<th>부서이름</th>
					<th>담당자</th>
				</tr>`
				
	 $.ajax ({
      url    : "/jspweb/staff",
      method   : "get",
      data : { "type" : 3 } ,
      success   : (r)=>{
         console.log('응답')
         console.log(r)
               
         r.forEach((o)=>{
            
         html +=`<tr>
                  <td>${o.fnum}   </td>                  
                  <td>${o.fname}   </td>
                  <td>${o.sno}   </td>
               </tr>`
         })      
         document.querySelector('.fieldtable').innerHTML = html; getStaff()
      }
   });   
				
	
}


//----------------------------------------------------------------------------------------------
let deletesno = 0;
// 인사 출력
// 사원 전체 출력
function getStaff(){
   console.log('getStaff실행');
   
   $.ajax ({
      url    : "/jspweb/staff",
      method   : "get",
      data : { "type" : 2 } ,
      success   : (r)=>{
         console.log('응답')
         console.log(r)
         html =`   <tr>
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
                  <td>${o.sno}   </td>                  
                  <td><img src="/jspweb/practice/과제1/simg/${ o.simg == null ? 'default.webp' : o.simg }"  width="50px" height="50px"/></td>
                  <td>${o.sname}   </td>
                  <td>${o.sclass}   </td>
                  <td>${o.stype}   </td>
                  <td>${o.field}   </td>
                  <td>${o.edate}   </td>                  
                  <td>${o.ddate    == null ? '' : o.ddate  }</td>
                  <td>${o.dcontent == null ? '' :o.dcontent}</td>
                  <td>
                     <button type="button" onclick="onpenupdateModal(${o.sno})">수정</button>
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
      url    : "/jspweb/staff",
      method   : "get",
       data : { "type" : 2 } ,
      success   : (r)=>{
         console.log('응답')
         console.log(r)
         html =`   <tr>
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
                        <td>${o.sno}   </td>                  
                        <td><img src="/jspweb/practice/과제1/simg/${ o.simg == null ? 'default.webp' : o.simg }"  width="50px" height="50px"/></td>
                        <td>${o.sname}   </td>
                        <td>${o.sclass}   </td>
                        <td>${o.stype}   </td>
                        <td>${o.field}   </td>
                        <td>${o.edate}   </td>                  
                        <td>
                           <button type="button"  onclick="onpenupdateModal(${o.sno})">수정</button>
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
      url    	: "/jspweb/staff",
      method   	: "get",
      data 		: { "type" : 2 } ,
      success   : (r)=>{
         console.log('응답')
         console.log(r)
         html =`   <tr>
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
            if(o.ddate!=null){
               html +=`<tr>
                        <td>${o.sno}   </td>                  
                        <td><img src="/jspweb/practice/과제1/simg/${ o.simg == null ? 'default.webp' : o.simg }"  width="50px" height="50px"/></td>
                        <td>${o.sname}   </td>
                        <td>${o.sclass}   </td>
                        <td>${o.stype}   </td>
                        <td>${o.field}   </td>
                        <td>${o.edate}   </td>                  
                        <td>${o.ddate}   </td>
                        <td>${o.dcontent}</td>
                        <td>
                           <button type="button"  onclick="onpenupdateModal(${o.sno})">수정</button>
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
   deletesno = 0 ;    console.log(deletesno);
   document.querySelector('.modal_wrap_D').style.display='none';
}


// 인사 삭제
function deleteStaff(){
   console.log('deleteStaff실행');   
   let sno = document.querySelector('.sno').value;
   if(deletesno==sno){
      $.ajax ({
         url    : "/jspweb/staff",
         method   : "delete",
         data    :{"sno": sno}, 
         success   : (r)=>{
            console.log('응답')
            console.log(r)   
            if(r=='true'){
               alert('인사 기록 삭제 성공');
               document.querySelector('.sno').value ='';
               closemodal_D();
               getStaff();}
            else{alert('인사 기록 삭제 실패');
               document.querySelector('.sno').value ='';
               closemodal_D();}
         }
      });
   }
   else{alert('사원번호가 일치하지 않습니다.');
      document.querySelector('.sno').value ="";
      closemodal_D();}
}

// 사원 검색
function search(){
   console.log('search실행'); 
   let search = document.querySelector('.search').value;
       $.ajax ({
      url    : "/jspweb/staff",
      method   : "get",
      data : { "type" : 4 ,"search":search} ,
      success   : (r)=>{
         console.log('응답')
         console.log(r)
         html =`   <tr>
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
                       <td>${o.sno}   </td>                  
                       <td><img src="/jspweb/practice/과제1/simg/${ o.simg == null ? 'default.webp' : o.simg }"  width="50px" height="50px"/></td>
                       <td>${o.sname}   </td>
                       <td>${o.sclass}   </td>
                       <td>${o.stype}   </td>
                       <td>${o.field}   </td>
                       <td>${o.edate}   </td>                                   
                       <td>${ o.ddate  == null ? '-' : o.ddate }    </td>
                       <td>${o.dcontent== null ? '-' :o.dcontent }</td>
                       <td>
                          <button type="button"  onclick="onpenupdateModal(${o.sno})">수정</button>
                          <button type="button"  onclick="openmodal_D(${o.sno})">삭제</button>
                       </td>
                    </tr>`

         })// foreach e      
         document.querySelector('.stafftable').innerHTML = html;      
      }
   });   
}
