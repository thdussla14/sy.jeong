
console.log('js실행')

let categoryList = ['커피','논커피','티','푸드']

let foodList = [{ name:'아메리카노',price:1600,img :'아메리카노.png',category:'커피'},
	{name:'꿀커피',price:1800,img:'꿀커피.png',category:'커피'},
	{name:'카페라떼',price:2600,img:'카페 라떼.png',category:'커피'},
	{name:'바닐라라떼',price:2600,img:'바닐라라떼.png',category:'커피'},
	{name:'카라멜마키아토',price:2600,img:'카라멜 마키아토.png',category:'커피'},
	{name:'카페모카',price:2600,img:'카페모카.png',category:'커피'},
	{name:'그린티라떼',price: 2600,img:'그린티라떼.png',category:'논커피'},
	{name:'딸기크림라떼',price: 2600,img:'딸기 크림 라떼.png',category:'논커피'},
	{name:'옥수수라떼',price: 2600,img:'옥수수 라떼.png',category:'논커피'},
	{name:'페퍼민트라임티',price: 2600,img:'페퍼민트 라임티.png',category:'티'},
	{name:'얼그레이티',price: 2600,img:'얼그레이티.png',category:'티'},
	{name:'캐모마일티',price: 2600,img:'캐모마일티.png',category:'티'},
	{name:'폭탄 카스테라',price: 2600,img:'폭탄 카스테라.png',category:'푸드'},
	{name:'에그타르트',price:2600,img:'에그타르트.png',category:'푸드'},
	{name:'클럽샌드위치세트',price:2600,img:'클럽샌드위치 세트.png',category:'푸드'}	
	]
// 카트 목록
let cartList = []
// 주문 목록
let orderList = []

category_print();
category_select(0);

console.log(foodList)

function category_print()
	{ let html = `<ul>`	
	for( let i = 0 ; i<categoryList.length ; i++ )
		{html += `<li 
					class="categoryli(${i})" 
					onclick="category_select(${i})"
					> ${ categoryList[i] } </li>`} // for e
					
	html+= `</ul>`
	document.querySelector('.categorybox').innerHTML = html	} // fun e
	
function category_select( i )
	{let html = ''
	for( let j = 0 ; j<foodList.length ; j++ )
		{if(categoryList[i]==foodList[j].category)
		{html += `<div class="product" onclick="cartAdd(${j})">
					<img class="p_img" src="img/${foodList[j].img}" width="100%"/>
					<div class="p_info">
						<div class="p_name"> ${foodList[j].name} </div>
						<div class="p_price"> ${foodList[j].price}원 </div>
					</div> 
				</div> `} // if e
					}// for e						
	document.querySelector('.content').innerHTML = html		
	 }// fun e	
	 
// 4. 선택한 제품을 카트에 담기
 function cartAdd(j){
	 // 선택한 i번째 버거의 객체를 cartList에 추가
	 cartList.push(foodList[j])
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
	 document.querySelector('.count').innerHTML = cartList.length
	 // 카트내 버거 총 금액
	 let total = 0;
	 for (let i=0; i<cartList.length ; i++)
	 {total += cartList[i].price }
	 document.querySelector('.total').innerHTML = total.toLocaleString()
	  // 카트내 버거 출력
	  let html = ''
	 for(let i=0 ; i<cartList.length ; i++)
	 { html += `<div class="item">
					<div class="ititle">${cartList[i].name} </div>
					<div class="iprice">${cartList[i].price.toLocaleString()}원</div>
				</div>`}
		document.querySelector('.info_bot').innerHTML = html
 }//fun e 	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
