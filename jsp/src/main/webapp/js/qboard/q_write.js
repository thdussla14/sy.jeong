console.log('js 실행')


let 문의사항임시저장소 =[]

function qwrite(){
	let qboard = {				
		qwriter : document.querySelector('.qwriter').vlaue,
		qpassword : document.querySelector('.qpassword').vlaue,
		qtitle : document.querySelector('.qtitle').vlaue,
		qcontent : document.querySelector('.qcontent').vlaue,
		qdate : Date(),
		state : 0,
		compelete : 0
	}	
	
	문의사항임시저장소.push(qboard)
	
	let result = true ; 
	if(result){alert('글쓰기 성공'); location.href="qlist.html"}
	else{alert('글쓰기 실패')}
	console.log(qboard)
	console.log(문의사항임시저장소)
	
}