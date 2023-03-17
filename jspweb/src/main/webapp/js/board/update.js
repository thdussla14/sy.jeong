console.log('write js')

// 회원정보.js : 만약에 로그인이 안되어 있으면 불가능 [ 제어 ]
if(memberInfo == null){
	alert('회원제 기능입니다. 로그인 후 작성해주세요.')
	location.href = '/jspweb/member/login.jsp';
}

let bno = document.querySelector('.bno').value;
console.log(bno);	
// 수정할 게시물 출력 
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
			
			document.querySelector('.cno').value          = r.cno;
			document.querySelector('.btitle').value       = r.btitle;
			document.querySelector('.bcontent').innerHTML = r.bcontent;
			
			let html  = '';
			// 기존 첨부파일 유/무
			if(r.bfile == null){
				html = '기존 첨부파일 없음';
			}else{
				html = `<span class="oldbfile">${r.bfile}</span> <button onclick="bfiledelete(${bno})" type="button"> 삭제 </button>`;
			}
			document.querySelector('.oldbfilebox').innerHTML = html;
					
		}// success e
	})// ajax e
}
/*
		let conselect = document.querySelector('.cno');
			console.log(cnoselect)
		for(let i=0; i<cnoselect.options.length ; i++){
			if(conselect.options[i].value == r.cno){
			conselect.options[i].selected = true ;
		}
	}		
*/

function bfiledelete(bno){
	$.ajax({
		url		: "/jspweb/boardinfo",
		method	: "delete",
		data	: {"type":2,"bno":bno},
		success : (r)=>{
			console.log('응답')
			console.log(r)
			if(r=='true'){
				alert('파일 삭제 성공');
			// 특정 div만 reload [랜더링] 방법 => Jquery 함수  
			// load( location.href+' .oldbfilebox'); 
			// href 뒤 띄어쓰기 중요!! = > 띄어쓰기 없으면 전체 랜더링
			   $(".oldbfilebox").load( location.href+' .oldbfilebox');
			 }
			else{alert('파일 삭제 실패 [관리자에게 문의]')}
		}
	})
}

// 수정 DB 저장 
function bupdate(){
	console.log('update')
	// 폼 문자열로 가져오기 => type="file" 직접적 접근 불가능
	// let writeForm = document.querySelector('.writefrom');
	// 폼 객체로 가져오기
	let updateForm = document.querySelectorAll('.updateform')[0];
	console.log(updateForm);
	// 폼 객체 -> new FormData 클래스
	let updateFormData = new FormData(updateForm);
	console.log(updateFormData);
	// form 밖에 있거나 js 데이터 추가 => bno를 form 안에 넣으면 코드 단축
	// updateFormData.set('변수명',데이터)
	updateFormData.set('bno',bno);
	
	$.ajax({
		url		: "/jspweb/boardinfo",
		method	: "put",
		data	: updateFormData,
		contentType : false,
        processData : false,
		success : (r)=>{
			console.log('응답')
			console.log(r)
			if(r=='true'){alert('게시물 수정 성공');location.href = '/jspweb/board/view.jsp?bno='+bno; }
			else{alert('게시물 수정 실패 [관리자에게 문의]')}
		}
	})

}