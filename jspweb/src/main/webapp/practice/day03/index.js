console.log('JS 연결');

function doPOST(){
	alert('http POST 메소드 실행합니다.')
	$.ajax({ 
         url 	 : "/jspweb/Ex3" , 
         method  : "post" , 
         success : ( result )=>{ }
      });

}

function doGET(){
	alert('http GET 메소드 실행합니다.')
	$.ajax({ 
         url 	 : "/jspweb/Ex3" , 
         method  : "get" , 
         success : ( result )=>{ }
      });
}

function doPUT(){
	alert('http PUT 메소드 실행합니다.')
	$.ajax({ 
         url 	 : "/jspweb/Ex3" , 
         method  : "put" , 
         success : ( result )=>{ }
      });
}

function doDELETE(){
	alert('http DELETE 메소드 실행합니다.')
	$.ajax({ 
         url 	 : "/jspweb/Ex3" , 
         method  : "delete" , 
         success : ( result )=>{ }
      });
}
//----------------------------------------------
// 1. 등록
function onWrite(){
	console.log('onWrite 메소드 실행합니다.')
	let info = {
		content : document.querySelector('.content').value ,
		writer	: document.querySelector('.writer').value
	}
	console.log(info)
	$.ajax({ 
         url 	 : "/jspweb/Ex3Board" , 
         method  : "post" , 
         data	 :info,
         success : ( result )=>{
			console.log('응답성공')
			if(result == 'true'){
				alert('등록성공');
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
				onlist();}
			else{alert('등록실패')}
		}
      });
}
onlist();
// 2. 출력
function onlist(){
	console.log('onlist 메소드 실행합니다.')
	$.ajax({ 
         url 	 : "/jspweb/Ex3Board" , 
         method  : "get" , 
         success : ( result )=>{
			console.log('응답성공')
			html = `<tr> <th> 번호 </th> <th> 내용 </th> <th> 작성자 </th> <th> 작성일 </th> <th> 비고 </th> </tr>`
			result.forEach((o)=>{
					html += `<tr> 
						<td> ${o.bno} </td> 
						<td> ${o.bcontent} </td> 
						<td> ${o.bwriter} </td> 
						<td> ${o.bdate} </td> 
						<td> <button onclick="onDelete(${o.bno})" type="button"> 삭제 </button>
							 <button onclick="onUpdate(${o.bno})" type="button"> 수정 </button> 
						</td> 
					</tr>`
				})
			document.querySelector('.boardtable').innerHTML = html;
			}
	});
}
// 3. 특정 게시물 삭제
function onDelete(bno){
	console.log('onDelete 메소드 실행합니다.')
	console.log(bno)
		$.ajax({ 
         url 	 : "/jspweb/Ex3Board" , 
         method  : "delete" , 
         data	 : {"bno":bno},
         success : ( result )=>{
			console.log('응답성공')
			if(result==='true'){
				alert('삭제성공')
				onlist();}
			else{alert('삭제실패')}
		}
      });	
}
// 4. 특정 게시물 수정
function onUpdate(bno){
	console.log('onUpdate 메소드 실행합니다.')
	console.log(bno)
	let newContent = prompt('수정할 내용 입력');	
		$.ajax({ 
         url 	 : "/jspweb/Ex3Board" , 
         method  : "put" , 
         data	 : {"bno":bno,"newContent":newContent},
         success : ( result )=>{
			console.log('응답성공')
			if(result==='true'){
				alert('수정성공')
				onlist();}
			else{alert('수정실패')}
		}
      });
}
//----------------------------------------------
// 1. 제품등록
function onRegister(){
	console.log('onRegister 메소드 실행합니다.')

	let info ={
		pname : document.querySelector('.pname').value,
		price : document.querySelector('.price').value
	}
		$.ajax({ 
         url 	 : "/jspweb/Product" , 
         method  : "post" , 
         data	 : info,
         success : ( result )=>{
			console.log('응답성공')
			if(result==='true'){
				document.querySelector('.pname').value='';
				document.querySelector('.price').value='';
				alert('등록성공');
				onprint();
			}
			else{alert('등록실패')}
		}
      });
}
onprint();
// 2. 제품 출력
function onprint(){
	console.log('onprint 실행')

	$.ajax({ 
         url 	 : "/jspweb/Product" , 
         method  : "get" , 
         success : ( result )=>{
			console.log('응답성공')
			html = `<tr> <th> 번호 </th> <th> 제품명 </th> <th> 가격 </th> <th> 비고 </th> </tr>`
			result.forEach((o)=>{
				html += `<tr> 
				<td> ${o.pno}   </td> 
				<td> ${o.pname} </td> 
				<td> ${o.price} </td> 
				<td>
					<button onclick="onPdelete(${o.pno})" type="button"> 삭제 </button>
					<button onclick="onPupdate(${o.pno})" type="button"> 수정 </button>  
				</td> 
			</tr>`
			})
			document.querySelector('.producttable').innerHTML = html;
		}
      });
}
// 3. 제품 삭제
function onPdelete(pno){
	console.log('onPdelete 실행')
	$.ajax({ 
         url 	 : "/jspweb/Product" , 
         method  : "delete" , 
         data	 : {"pno" : pno},
         success : ( result )=>{
			console.log('응답성공')
			if(result==='true'){
				alert('삭제성공');
				onprint();
			}
			else{alert('삭제실패')}
		}
      });
}
// 4. 제품 수정
function onPupdate(pno){
	console.log('onPupdate 실행')
	let newName  = prompt('수정할 제품명을 입력해주세요.');
	let newPrice = prompt('수정할 가격을 입력해주세요.');
	let info = {
		pno   : pno ,
		pname : newName,
		price : newPrice
	}
	
	$.ajax({ 
         url 	 : "/jspweb/Product" , 
         method  : "put" , 
         data	 : info,
         success : ( result )=>{
			console.log('응답성공')
			if(result==='true'){
				alert('수정성공');
				onprint();
			}
			else{alert('수정실패')}
		}
      });
}