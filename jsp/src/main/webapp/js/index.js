
let productList = [
	{img:'p1.gif', title:'퓨어 니트 샤 스커트 세트', size:'[M,L]',price: 56000 , discount: 0.3 , like :55, reviw: 412},
	{img:'p2.gif', title:'로라 오프 숄더 셔츠', size:'[M,L]',price: 52000 , discount: 0.2 , like :25, reviw: 606},
	{img:'p3.gif', title:'라움 리본 포켓 셔츠 원피스', size:'[M,L]',price: 56000 , discount: 0.2 , like :54, reviw: 205},
	{img:'p4.gif', title:'모앤 꽈배기 V넥 루즈핏 가디건', size:'[M,L]',price: 48000 , discount: 0.3 , like :28, reviw: 323},
	{img:'p5.gif', title:'포드 카라 스트라이프 셔츠', size:'[M,L]',price: 54000 , discount: 0.3 , like :54, reviw: 813},
	{img:'p6.gif', title:'블린 랩 버튼 카라 원피스', size:'[M,L]',price: 67000 , discount: 0.3 , like :66, reviw: 111},	
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
	document.querySelector('.itembox').innerHTML = html;
}
















