 console.log('point js') 
   
   let pay=0;
   
   function setPay(n){
	  pay += n; 
   }
  //------------------------------------------------------------------------------------------- 회원 식별 번호   
  const IMP = window.IMP;  // 생략 가능
  IMP.init("imp47415848"); // 예: imp00000000a
  //-------------------------------------------------------------------------------------------  
  function requestPay() {
	  
	if(pay == 0){
		alert('충전할 금액을 선택해주세요.'); return;
	}
	  
    IMP.request_pay({
      pg: "kcp.INIBillTst",
      pay_method: "card",
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "이젠 포인트 결제",
      amount: pay,                          // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      if (rsp.success) {// 결제 성공 시 로직
       
      } else {// 결제 실패 시 로직
        
        let info = {
			mpcomment 	: '포인트 충전',
			mpamount	: pay,
			mno			: memberInfo.mno
		}
        
        $.ajax({
			url		: "/jspweb/point",
			method 	: "post",
			data	: info ,
			success	:(r)=>{
				if(r=='true'){alert('포인트 충전 완료')}
			}		
		})
        
        
      }
    });
  }
