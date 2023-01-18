
/* 공통 - DB */
let categoryList = [ '프리미엄', '스페셜' , '와퍼', '올데이킹','치킨버거']
let burgurList = [
	{name : '몬스터X', price : 9200 ,	img : '몬스터X.png', category:'프리미엄'},
	{name : '몬스터와퍼', price : 8200 ,	img : '몬스터와퍼.png', category:'프리미엄'},
	{name : '통새우와퍼', price : 6200 ,	img : '통새우와퍼.png', category:'스폐셜'}]
let cartList = []




category_print();
categoey_select(0);	// 기본값 : 프리미엄
product_print(0)	// 기본값 : 프리미엄

// 1. 카테고리 출력하는 함수 	// [ 1.js열렸을때]
function category_print(){
	// 1.HTML 구성
	let html = `<ul>`
	//*
	for( let i = 0 ; i< categoryList.length ; i++ ){
		html += `<li 
					class="categoryli" 
					onclick="categoey_select( ${i} )"
					> ${ categoryList[i] } </li>`
	} // for end 
	html+= `</ul>`
	// 2 해당 마크업에 HTML 출력 
	document.querySelector('.categorybox').innerHTML = html	
} // f e 

function categoey_select( i ){ // i : 선택된 li의 인덱스
	// 1. 모든 li 가져와서 배열 저장 
	let categoryli = document.querySelectorAll('.categoryli')
	// 2. 모든 li 배열 반복문 
	for( let j = 0 ; j<categoryli.length ; j++ ){
		if( j == i ){ // 만약에 li배열에서 내가 선택횐 li의 인덱스와 같으면
			categoryli[j].classList.add( 'categoryselect' ) ; }	// 해당 마크업의 class 식별자 추가 
		else{ // 선택되지 않은 li
			categoryli[j].classList.remove( 'categoryselect'  );}// 해당 마크업의 class 식별자 제거 		
	}//for e
	category_print(i)
}//fun e

// 제품 출력 함수 [ 1. 스크립트 열렸을때 	2. 카테고리 전환시] 
 function product_print(index){	 
	 //1. html 구성
	 	let html ='';
		for(let i=0 ; i<burgurList.length ; i++)
		// i는 0번째 인덱스부터 마지막인덱스까지 버거 객체 가져온다.
		{ if( burgurList[i].category==categoryList[index])
		// i번째 
		{	html += `<div onclick="onAdd(${i})" class="product"> 
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
 
 // 
 function onAdd(i){
	 cartList.push(burgurList[i])
	 let html = ``
	 for(let i=0 ; i<cartList.length ; i++)
	 { html += `<div class="cart_bottom">
		 			<div class="cproduct">
						<div class="ctitle">${burgurList[i].name} </div>
						<div class="Tprice">${burgurList[i].price.toLocaleString()}원</div>
					</div>
				</div>`}
		document.querySelector('.cartbox').innerHTML = html
 }
 
 
 