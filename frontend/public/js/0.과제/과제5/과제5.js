
/* 공통 - DB */
// 등록된 카테고리 목록
let categoryList = [ '프리미엄', '스페셜' , '와퍼', '올데이킹','치킨버거']
// 등록된 버거 목록
let burgurList = [
	{name : '몬스터X',   price : 9200 ,	img : '몬스터X.png', 	 category:'프리미엄'},
	{name : '몬스터와퍼', price : 8200 ,	img : '몬스터와퍼.png', category:'프리미엄'},
	{name : '기네스와퍼', price : 8200 ,	img : '기네스와퍼.png', category:'프리미엄'},
	{name : '통새우와퍼', price : 6200 ,	img : '통새우와퍼.png', category:'스페셜'},
	{name : '블랙어니언와퍼', price : 6200 ,	img : '블랙어니언와퍼.png', category:'스페셜'},
	{name : '통새우와퍼', price : 6200 ,	img : '통새우와퍼.png', category:'스페셜'},
	{name : '치킨킹', price : 6200 ,	img : '치킨킹.png', category:'올데이킹'},
	{name : 'BLT오믈렛킹모닝', price : 6200 ,	img : 'BLT오믈렛킹모닝.png', category:'올데이킹'},
	{name : '바비큐킹치킨버거', price : 6200 ,	img : '바비큐킹치킨버거.png', category:'올데이킹'},
	]
// 카트 목록
let cartList = []
// 주문 목록
let orderList = []

category_print();
category_select(0);	// 기본값 : 프리미엄
product_print(0)	// 기본값 : 프리미엄
//---------------------------------------------------------------------------------------------
// 1. 카테고리 출력하는 함수 	// [ 1.js열렸을때]
function category_print(){
	// 1.HTML 구성
	let html = `<ul>`
	//*
	for( let i = 0 ; i< categoryList.length ; i++ ){
		html += `<li 
					class="categoryli" 
					onclick="category_select( ${i} )"
					> ${ categoryList[i] } </li>`
	} // for end 
	html+= `</ul>`
	// 2 해당 마크업에 HTML 출력 
	document.querySelector('.categorybox').innerHTML = html	
} // f e 
// 2. 
function category_select( i ){ // i : 선택된 li의 인덱스

	for( let j = 0 ; j<burgurList.length ; j++ ){
		if(categoryList[i]==burgurList[j].category)
		{burgurList[j].classList.add( 'categoryselect' ) ; 	// 해당 마크업의 class 식별자 추가 
		html += `<div onclick="cartAdd(${i})" class="product"> 
						<img src="img/${burgurList[i].img}" width="100%"/> 
	 				    <div class="productinfo" >
							<div class="ptitle"> ${burgurList[i].name} </div>
							<div class="pprice"> ${burgurList[i].price.toLocaleString()}원</div>
						</div>
					</div>` 
			}//if e 
		}// for e	 
	 //2. 구성된 html에 마크업 대입
	 document.querySelector('.productbox').innerHTML =html
	 
 } //fun e
 // 4. 선택한 제품을 카트에 담기
 function cartAdd(i){
	 // 선택한 i번째 버거의 객체를 cartList에 추가
	 cartList.push(burgurList[i])
	 cart_print()	// 카트내 제품 화면 새로 고침
 }//fun e 
 // 5. 주문 취소
 function cancel(){
	 alert('주문 취소합니다.')
	 cartList.splice(0); // 개수 생략시 모두 삭제
	 cart_print()
 }//fun e 
 // 6. 주문 하기
 function order(){
	 alert('주문 되었습니다.')
	 
	 // 1. 주문번호 만들기
		// 마지막인덱스 : 배열명.length-1
		let no = 0;
		// 1. 만약에 길이가 0이면 [ 주문이 하나도 없으면 주문번호 1]
		if(orderList.length == 0) {no = 1;}
		// 2. 아니면 마지막인덱스 주문객체의 주문번호 +1을  다음 주문번호 사용
		else{no = orderList[orderList.length-1].no+1}arguments
		
	// 카트배열 -> 새로운 배열 [카트배열 초기화시 주문객체내 카트배열 정보도 초기화-> 새로운 배열에 다시 저장]
		 let for배열 = cartList.forEach((o)=>{'for'+console.log(o)})
		 console.log(for배열)
		 console.log("--------------------------------------")
		 let map배열 = cartList.map((o)=>{'map'+console.log(o);return o})
		 console.log(map배열)
		
	// 2. 총가격 만들기
		let total = 0;
		for(let i=0;  i<map배열.length ; i++){total += map배열[i].price}
		

	 // 1. 주문
	 	// 1. order 객체 만들기
	 	let order={
			 no : no ,
			 items 	: map배열,
			 time 	: new Date(),	// new Date() : 현재 날짜 / 시간 호출
			 state 	: true,			// true : 일단 주문 //false : 주문완료
			 complete : 0 ,
			 price 	: total			 
		 }	 
	 
	 	//2. order 객체 배열에 저장
	 	orderList.push(order)
	 	console.log(orderList)
	 // 2. 주문완료 후 
	 cartList.splice(0); // 개수 생략시 모두 삭제
	 cart_print() 	 
 }//fun e
 // 7. 카트내 버거 출력 [ 1. 제품 클릭시 2. 취소/ 주문시]
 function cart_print(){
	 // 카트내 버거 개수 카운트
	 document.querySelector('.pcount').innerHTML = cartList.length
	 // 카트내 버거 총 금액
	 let total = 0;
	 for (let j=0; j<cartList.length ; j++)
	 {total += cartList[j].price }
	 document.querySelector('.ptotal').innerHTML = total.toLocaleString()
	  // 카트내 버거 출력
	  let html = ''
	 for(let j=0 ; j<cartList.length ; j++)
	 { html += `<div class="item">
					<div class="ititle">${cartList[j].name} </div>
					<div class="iprice">${cartList[j].price.toLocaleString()}원</div>
				</div>`}
		document.querySelector('.cartbottom').innerHTML = html
 }//fun e 
 //---------------------------------------------------------------------------------------------
 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 