console.log('글쓰기 js 실행')

$(document).ready(function() {
  $('#summernote').summernote({height:300, lang:'ko-KR'});
});

let 게시물임시저장소 = []

function board_wirte(){
	// 1. 입력받은 데이터를 개체화한다.
	let board={
		writer :document.querySelector('.bwriter').value,
		password:document.querySelector('.bpassword').value,
		title : document.querySelector('.btitle').value,
		content :document.querySelector('.bcontent').value		
	}
	console.log(board)
	
	// 첨부파일 있을 경우
	// 1. form을 한번에 가져와서 객체화
	let writeform = document.querySelector('.writeform'); console.log(writeform)
	let formdata = new FormData(writeform) ; console.log(formdata)	

	// 유효성 검사 생략
	
	// 2. JAVA에게 데이터를 전송 후 전송된 결과를 받는다. [통신 - AJAX 등]
	게시물임시저장소.push(board)
	
	// 3. 결과에 따른 이벤트	
	let result = true ; // JAVA로부터 전송결과
	if(result){alert('글쓰기 성공'); location.href = 'list.html'}
	else {alert('글쓰기 실패');}
}
// 페이지전환 js 함수 => location.href = 'list.hml'













