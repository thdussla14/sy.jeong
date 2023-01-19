
/*
	1. 버거객체	[이름, 가격, 이미지, 카테고리]
	let burgur = {name : '몬스터X',   price : 9200 ,	img : '몬스터X.png', 	 category:'프리미엄'}
	2. 주문객체
	let order={ no : no ,				// 주문번호 [ 인덱스 사용 X ; 인덱스 삭제시 소급적용? 고유번호로 사용 불가]
			 	items 	: map배열,		// 카트배열 -> 새로운 배열 
			 	time 	: new Date(),	// new Date() : 현재 날짜 / 시간 호출
			 	state 	: true,			// true : 일단 주문 //false : 주문완료
			 	complete : 0 ,			// 아직 주문완료전
			 	price 	: total			 }	 



 */

/* ----------------공통데이터 : 모든 함수에서 공통으로 사용할 예정 : 전역변수---------------------------- */
// 등록된 카테고리 '문자열' 목록/배열
let categoryList = [ '프리미엄', '스페셜' , '와퍼', '올데이킹','치킨버거']
// 등록된 버거객체 목록/배열
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

/* -----------------공통 - DB       end----------------------------------------------------- */
/* -----------------js 열렸을때 1번 실행되는 함수------------------------------------------------ */
category_print();	// 카테고리 호출 함수 호출
category_select(0);	// 카테고리 선택시 css 변경/카테고리별 제품출력함수  [기본값 : 프리미엄]

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
// 2.카테고리 선택 함수  
function category_select( i ){ // i : 선택된 li의 인덱스
	// 1. 모든 li 가져와서 배열 저장 
	let categoryli = document.querySelectorAll( ".categoryli")
	// 2. 모든 li 배열 반복문 
	for( let j = 0 ; j<categoryli.length ; j++ ){
		if( j == i ){ // 만약에 li배열에서 내가 선택횐 li의 인덱스와 같으면
			categoryli[j].classList.add( 'categoryselect' ) ; // 해당 마크업의 class 식별자 추가 
		}else{ // 선택되지 않은 li
			categoryli[j].classList.remove( 'categoryselect'  );// 해당 마크업의 class 식별자 제거 
		} 
	} // for e
	// 3. 제품목록 렌더링 [ 화면 업데이트 ]
	product_print( i )
} // f e
// 3. 제품출력 함수 // [ 1.js열렸을때[0:프리미엄] 2.카테고리 바뀌었때 ]
function product_print( index ){ 
	// 1. 기본 html 구성
	let html = '';
	// *
	for( let i = 0 ; i<burgurList.length ; i++ ){
		// i는 0번째 인덱스부터 마지막인덱스까지 버거 객체 가져온다.
		if( burgurList[i].category == categoryList[index] ){
			// i번째 버거객체의 카테고리와 선택된 카테고리와 같으면 
			html += `<div onclick="cartAdd( ${i} )" class="product">
						<img src="img/${ burgurList[i].img }" width="100%" />
						<div class="productinfo">
							<div class="ptitle"> ${ burgurList[i].name } </div>
							<div class="pprice"> ${ burgurList[i].price.toLocaleString() } 원 </div>
						</div>
					</div>`
		} // if e
	} // for e 
	// 2. 구성된 html를 마크업 대입
	document.querySelector('.productbox').innerHTML = html;
} // f e
 // 4. 선택한 제품을 카트에 담기
 function cartAdd(i){
	 // 선택한 i번째 버거의 객체를 cartList에 추가
	 cartList.push(burgurList[i])
	 cart_print()	// 카트내 제품 화면 새로 고침
	 console.log(cartList)
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
	 console.log(cartList)
	 
	 // 1. 주문번호 만들기
		// 마지막인덱스 : 배열명.length-1
		let no = 0;
		// 1. 만약에 길이가 0이면 [ 주문이 하나도 없으면 주문번호 1]
		if(orderList.length == 0) {no = 1;}
		// 2. 아니면 마지막인덱스 주문객체의 주문번호 +1을  다음 주문번호 사용
		else{no = orderList[orderList.length-1].no+1}arguments
		
	// 카트배열[전역변수] -> 새로운 배열 [카트배열 초기화시 주문객체내 카트배열 정보도 초기화-> 새로운 배열에 다시 저장]
		 let map배열 = cartList.map((o)=>{'map'+console.log(o);return o})
		 console.log(map배열)
		
	// 2. 총가격 만들기
		let total = 0;
		for(let i=0;  i<map배열.length ; i++){total += map배열[i].price}
		

	 // 1. 주문
	 	// 1. order 객체 만들기
	 	let order={
			 no 	: no ,			// 주문번호 [ 인덱스 사용 X ]
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
	 주문목록현황() 	 
	 console.log(cartList)
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
 제품목록현황()
 주문목록현황()
 매출현황()
 
 // 1. 제품 등록 입력창
 function 등록()
	{ let 제품 =
		{name : document.querySelector('.name').value,
		price:parseInt(document.querySelector('.price').value),
		img	:document.querySelector('.img').value,
		category :document.querySelector('.category').value }
		
	// 1. 카테고리명 유효성 검사
	if(!categoryList.includes(제품.category))
	 {alert('등록된 카테고리 항목이 아닙니다.'); return ; }
	
	//2. 가격 유효성 검사
	if(isNaN(제품.price))
	{alert('가격은 숫자만 입력해주세요.'); return ;}
	
	burgurList.push(제품); console.log(burgurList)
	제품목록현황()
	} // fun e
	
  // 2. 등록된 버거 현황 출력
 function 제품목록현황()
 	{let html = `	<tr class="t_title">
						<th colspan="6"> 제품 리스트 </th>
					</tr>
 					<tr>
						<th> 번호 </th>
						<th> 이미지 </th>
						<th> 버거이름 </th>
						<th> 가격 </th>
						<th> 카테고리 </th>
						<th> 비고 </th>
					</tr>`
	for( i=0 ; i<burgurList.length; i++)
		{ html += `<tr>
						<td> ${i+1} </td>
						<td> <img src="img/${burgurList[i].img}" width="20px"/> </td>
						<td> ${burgurList[i].name} </td>
						<td> ${burgurList[i].price} </td>
						<td> ${burgurList[i].category} </td>
						<td> 
							<button onclick="Delete(${i})"> 삭제 </button>
							<button onclick="Update(${i})"> 수정 </button>						
						</td>
					</tr>`			
		} // for e					
		document.querySelector('.itemtable').innerHTML =html						
	}  // fun e
 // 2-1. 등록된 버거 삭제
 function Delete(i)
 	{burgurList.splice(i,1); 
 	제품목록현황()
 	console.log(burgurList) }// fun e
 // 2-2. 등록된 버거 가격 변경
 function Update(i)
 	{ let 변경가격 = parseInt(prompt('변경할 가격을 입력해주세요.')) 	
 	burgurList[i].price = 변경가격 	
	제품목록현황()
	 console.log(burgurList)} // fun Update e
 
 // 3. 주문된 주문 목록 현황 출력
 function 주문목록현황()
 	{ let html =`<tr class="t_title">
						<th colspan="5"> 주문 현황 </th>
					</tr>				
					<tr>
						<th> 주문번호 </th>
						<th> 버거이름 </th>
						<th> 가격 </th>
						<th> 상태 </th>
						<th> 비고 </th>
					</tr>`
			
		for( i=0 ; i<orderList.length; i++) 
		 { for( j=0 ; j<orderList[i].items.length; j++) 
			{ html +=`<tr>
					<td> ${orderList[i].no} </td>	
					<td> ${orderList[i].items[j].name} </td>
					<td> ${orderList[i].items[j].price} </td>
					<td> ${orderList[i].state?'주문요청':'주문완료'} </td>
					<td> <button class="compelete" onclick="compelete(${i})" > 주문완료 </button>					
					</td>
				</tr>`	}}	

		 document.querySelector('.ordertable').innerHTML =html	
	 }// fun e
	 
 // 3-1. 주문완료 상태 변경
 function compelete(i)
 	{ orderList[i].state = false
	주문목록현황()} // fun e
 
 // 4. 매출 현황 출력
 function 매출현황()
 	{let html =`<tr class="t_title">
					<th colspan="5"> 매출 현황 </th>
				</tr>
 				<tr>
					<th> 제품번호 </th>
					<th> 버거이름 </th>
					<th> 판매수량 </th>
					<th> 매출액 </th>
					<th> 순위 </th>
				</tr>`
		for( i=0 ; i<burgurList.length ; i++)
		{html +=`<tr>
					<td> ${i+1} </td>
					<td> ${burgurList[i].name} </td>
					<td> ${orderList.length} </td>
					<td> ${burgurList[i].price} </td>
					<td> ${i+1} 	</td>
				</tr>
		`}
		  document.querySelector('.totaltable').innerHTML =html	
	 } // fun e

/*
	1. orderList.items 분리

	orderList.length 만큼 반복하여 객체 order 새로운 배열에 담기 => 
	order.items.length 만큼 반복하여 items 새로운 배열에 담기 =>
	주문번호는 order에 속한 속성
	동일 주문번호내에 각 item 분리?
	버거이름은 items내 burgur에 속한 속성? 각 item에 order no 속성 추가?
	각 item 분리후 수량 카운트?	

	let orderburgurList = []
	orderList[i].items[j].name?

	
	주문번호				버거이름				가격					요청/완료일		비고
	order.no			burgur.name			burgur.price		order.state 
	orderList[i].no		burgurList[i].name	burgurList[i].name


*/









 
 