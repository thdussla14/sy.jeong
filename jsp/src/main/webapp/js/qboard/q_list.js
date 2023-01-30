
let qboardlist = [
   { no : 5 , title : '문의드립니다.A' , writer : '유재석' , date : '2023-01-30' , view:3 , state : 1 , complete : ''  } , 
   { no : 4 , title : '문의드립니다.B' , writer : '강호동' , date : '2023-01-27' , view:12, state : 1 , complete : ''   } , 
   { no : 3 , title : '문의드립니다.C' , writer : '신동엽' , date : '2023-01-25' , view:7 , state : 1 , complete : ''  } , 
   { no : 2 , title : '문의드립니다.D' , writer : '서장훈' , date : '2023-01-24' , view:5 , state : 0 , complete : '2023-01-30' } , 
   { no : 1 , title : '문의드립니다.E' , writer : '김희철' , date : '2023-01-23' , view:9 , state : 0 , complete : '2023-01-30'  } 
	]
	
qlist_print()	
	
function qlist_print(){
	
	let html =``
	
	qboardlist.forEach((o)=>{
		html += 
			`<tr>
				<th>${o.no}</th>
				<th><a href="q_view.html">${o.title}</a></th>
				<th>${o.writer}</th>
				<th>${o.date}</th>
				<th>${o.view}</th>
				<th>${o.state==1?'문의접수':'답변완료'}</th>
				<th>${o.complete}</th>
			</tr>`
	})
	
	document.querySelector('.qlisttable').innerHTML=html
}
