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
	 // <input> 마크업을 js변수로 가져오기 [DOM 객체]
	 let snum = document.querySelector ('.snum') 
	 // <input> 마크업에 입력된 데이터 호출
	 let snumValue = snum.value
	 // 길이 알기
	 let length1 = snumValue.length
	 // 찾기 [ 만약에 배열내 입력한 값이 존재하면 !=-1 ]
	 let index = studentArray.indexOf (snumValue)
	 
	 if (snumValue=="")
	 	{document.querySelector('.resultbox').innerHTML = '학번을 입력해주세요.';}
	 	// 입력한 숫자가 8자리가 아니면 8자리 입력하라는 출력
	 else if(length1!=8)
		{document.querySelector('.resultbox').innerHTML = '8자리로 입력해주세요.';}
		// 배열내에 입력한 값이 존재했으면 로그인 성공 
	 else if(index != -1)
		{document.querySelector('.resultbox').innerHTML = '로그인 성공';}			
		//배열내에 입력한 값이 존재하지 않았으면 로그인 실패
	 else 
	 	{document.querySelector('.resultbox').innerHTML ='없는 학번입니다.';}
	 	// input의 데이터 공백으로 초기화
	 snum.value = '';
	 	// 배열 확인용
	 console.log(studentArray)
	 }
		
 //------------------------------------------------------------------------------------
 
 //--과제2--------------------------------------------------------------------
  
 function onAdd (){ 
	 
	 console.log('함수실행') //확인용
	 
	 // <input> 마크업을 js변수로 가져오기 [DOM 객체]
	 let studentNumber = document.querySelector ('.studentNumber')
	 
	 console.log('.studentNumber') //확인용
	 
	 // <input> 마크업에 입력된 value[값] 가져와서 변수에 저장
	 let sNumber = studentNumber.value;
	 
	 console.log(sNumber) //확인용
	 
	 let length2 = sNumber.length
	 
	 console.log(length2) //확인용
	 
	 // 유효성검사 [중복체크] : 입력받은 값[studentNumber]과 기존 값들[studentArray]을 비교
	 
	 let Index = studentArray.indexOf (sNumber);
	 
	 console.log(Index) //확인용
	 
	 if (sNumber=="")
	 	{document.querySelector('.result_box').innerHTML = '학번을 입력해주세요.';}
	 else if(length2!=8)
		{document.querySelector('.result_box').innerHTML = '8자리로 입력해주세요.';}
	 else if(Index != -1) 
		{document.querySelector('.result_box').innerHTML = '이미 등록된 학번입니다.';}
	 else {studentArray.push(sNumber); 
		document.querySelector('.result_box').innerHTML = '등록에 성공하였습니다.';}
	
	studentNumber.value = '';
	
	console.log(studentArray)}
 		