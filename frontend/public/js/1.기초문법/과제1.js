/**
 과제1 ; 입력상자에 학번 [8자리] 입력 후 로그인 버튼 시 배열에 존재하면 로그인 성공 출력 / 로그인 실패
 
 [조건 1] const studentArray = ['20230110', '20230109','20230108']
 [조건 2] 입력 <input> 사용해서 학번 입력 받기
 [조건 3] 로그인 <button> 사용해서 로그인 이벤트 실행
-------------------------------------------------------------------------------

 과제2 ; 입력상자에 학번 [8자리] 입력 후 배열에 저장했으면 '성공' 출력, 아니면 '실패' 출력
 
 [조건 1] studentArray 배열에 push 등록
 [조건 2] 만약에 배열에 존재하는 학번이면 '실패' 출력
 [조건 3] 등록 <button> 사용해서 등록 이벤트 실행
 -------------------------------------------------------------------------------
 	<추가> 
   	1. 만약에 입력상자에 공백이면 '학번을 입력해주세요'
   	2. 등록이나 로그인 성공시에 input의 value 다시 공백으로 초기화
   	3. 입력상자에 입력한 데이터가 8자리가 아니면 '8자리로 입력해주세요' 
   
 */

//	오류메시지 : 1. 정의X 	2. 이름 오타 	3. 저장/새로고침 적용X

 //--배열 선언--------------------------------------------------------------------------
		//함수 안 선언 : 함수 실행 마다 선언 - 누적 X
		//함수 밖 선언 : JS  실행 1번 선언 - 누적 O
	 
 const studentArray = ['20230110', '20230109','20230108']
 
 //--함수 정의----------------------------------------------------------------------------
 
 function onLog (){
	 
	 let snum = document.querySelector ('.snum') 
	 
	 let index = studentArray.indexOf (snum.value)

	 if (index!==-1) {alert('로그인 성공')} else {document.querySelector('.resultbox').innerHTML ='없는 학번입니다.'} }


 //------------------------------------------------------------------------------------
 
 //--과제2--------------------------------------------------------------------
  
 function onAdd (){ 
	 
	 let snumber = document.querySelector ('.snumber')
	 
	 let length = snumber.length
	 
	 if (length=8){document.querySelector('.result_box1').innerHTML = '8자리로 입력해주세요.'}{''}
	 
	 let index   = studentArray.indexOf (snumber.value)

	 if (index !== -1) {document.querySelector('.result_box2').innerHTML = '이미 등록된 학번입니다.'}  
	 else if (index == -1){studentArray. push (snumber.value); document.querySelector('.result_box2').innerHTML = '등록에 성공하였습니다.'}
	 else {document.querySelector('.result_box2').innerHTML = '등록에 실패하였습니다.'}
	 
	 console.log(studentArray)
	 }
 
 
 
 
 
 
 
 
 