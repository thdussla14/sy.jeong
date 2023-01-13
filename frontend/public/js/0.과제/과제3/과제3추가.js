/*
  과제3
  주제 : 방문록 게시판 구현
 
    조건1) 방문록 내용을 여러개 담는 배열 선언 : let  contentArray=[]
    조건2) 내용작성 <input> 입력받기
    조건3) 등록버튼 <button> 클릭시 입력된 데이터가 배열에 저장하는 addContent() 함수 실행
    조건4) 현재 배열에 저장된 모든 방문록을 <table>에 출력 
 
 	<tr>
 		<th> 번호 </th> <th> 방문록 </th>
 	</th>
 
 
 */

 let contentArray = [ ]

  
 function addContent()
	 {   
	 let content = document.querySelector('.content').value 
	 contentArray.push(content)
 	 printContent()
	 }
 
  function onDelete(dno)
 	{contentArray.splice(dno,1)
 	 printContent()
 	} 
 
  function printContent()
 	 {let html = `<tr> 
	 				<th>번호</th> 
	 				<th>방문내용</th>  
	 				<th>비고</th> 
	 			</tr>`	 
	 for(let i = 0; i<contentArray.length; i++)	 
		{html += `<tr> 
	 				<td> ${i+1} </td> 
	 				<td> ${contentArray[i]}</td>  
	 				<td> <button onclick="onDelete(${i}")>삭제</button> </td> 
	 			</tr>`
	 	}
 	document.querySelector('.list').innerHTML = html
  }
 