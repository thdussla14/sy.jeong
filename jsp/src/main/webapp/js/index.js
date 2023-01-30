
let productList = [
	{img:'1.jpg', title:'14K 핑크골드 하트 플라이 목걸이', size:'[M,L]',price: 399000 , discount: 0.1 , like :55, reviw: 412},	
	{img:'3.jpg', title:'14K 핑크골드 쁘띠 모던 튤리 목걸이', size:'[M,L]',price: 399000 , discount: 0.1 , like :54, reviw: 205},
	{img:'4.jpg', title:'14K 핑크골드 쁘띠 호스후프 목걸이', size:'[M,L]',price: 399000 , discount: 0.1 , like :28, reviw: 323},
	{img:'5.jpg', title:'14K 핑크골드 쁘띠 티 목걸이', size:'[M,L]',price: 399000 , discount: 0.1 , like :54, reviw: 813},	
	{img:'2.jpg', title:'14K 핑크골드 하트 플라이 귀걸이', size:'[M,L]',price: 329000 , discount: 0.1 , like :25, reviw: 606},
	{img:'귀걸이2.jpg', title:'14K 골드 모던튤리 오벌라인 귀걸이', size:'[M,L]',price: 449000 , discount: 0.1 , like :25, reviw: 606},
	{img:'귀걸이3.jpg', title:'14K 핑크골드 스와 진주 귀걸이', size:'[M,L]',price: 249000 , discount: 0.1 , like :25, reviw: 606},
	{img:'귀걸이4.jpg', title:'14K 까르모 롱 실버 귀걸이', size:'[M,L]',price: 329000 , discount: 0.1 , like :25, reviw: 606},	
	{img:'반지1.jpg', title:'14K 핑크골드 러브라인 여성 커플링', size:'[M,L]',price: 389000 , discount: 0.1 , like :66, reviw: 111},
	{img:'반지2.jpg', title:'14K 핑크골드 러브 인피니티 반지', size:'[M,L]',price: 369000 , discount: 0.1 , like :66, reviw: 111},
	{img:'반지3.jpg', title:'14K 핑크골드 메모리아 플랫 반지', size:'[M,L]',price: 369000 , discount: 0.1 , like :66, reviw: 111},
	{img:'반지4.jpg', title:'14K 핑크골드 메모리아 라운드 반지', size:'[M,L]',price: 269000 , discount: 0.1 , like :66, reviw: 111}
		
]


product_print();

function product_print(){
	let html = ``
	productList.forEach((o)=>{
		html += `<div class="item">
					<img src="/jsp/img/${o.img}">
					<div class="item_info">	
						<div class="item_title"> ${o.title}	</div>
						<div class="item_size">  ${o.size}	</div>
						<div class="item_price"> ${o.price.toLocaleString()}원</div>
						<div>
							<span class="item_sale">	 ${(o.price*(1-o.discount)).toLocaleString()}원</span>
							<span class="item_discount"> ${parseInt(o.discount*100)}% 			</span>
						</div>
					</div>
					<div class="item_bottom">
						<div>
							<span class="badge rounded-pill text-bg-warning">주문폭주</span>
							<span class="badge rounded-pill text-bg-danger">1+1</span>
						</div>
						<div class="item_review"> 찜  ${o.like} · 리뷰수 ${o.reviw} </div> 
					</div>
				</div>`	
	})
	document.querySelector('.itembox').innerHTML = html
}
















