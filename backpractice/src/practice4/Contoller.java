package practice4;

import java.util.ArrayList;

public class Contoller {

	// 싱글톤
	private static Contoller control = new Contoller();
	private Contoller () { }
	public static Contoller getInsetance() { return control;}
	
	// 장바구니 
	ArrayList<ProductDTO> shoppingList = new ArrayList<>();
	
	// 등록
	public boolean register(String pname,int pprice,int pstock) {
		
		ProductDTO dto = new ProductDTO(0, pname, pprice, pstock, 0);

		return ProductDAO.getInstance().register(dto);
	}
	// 출력
	public void list() {

		ArrayList<ProductDTO> result = ProductDAO.getInstance().list();
		for(ProductDTO dto:result) {
			System.out.printf("%3s\t%10s\t%10s%10s\n",
					dto.getPno(),dto.getPname(),dto.getPprice(),dto.getPstock());
		}
	}
	// 수정
	public boolean update(int pno, String pname,int pprice) {

		ProductDTO dto = new ProductDTO(pno, pname, pprice, 0, 0);
		
		return ProductDAO.getInstance().update(dto);
	}
	// 재고 수정
	public boolean stockUpdate(int pno,int pstock) {
		
		return ProductDAO.getInstance().stockUpdate(pno,pstock);
	}
	// 삭제
	public boolean delete(int pno) {
		
		return ProductDAO.getInstance().delete(pno);
	}
	// 사용자
	public void user() {		
		ArrayList<ProductDTO> result = ProductDAO.getInstance().list();
		for(ProductDTO dto:result) {
			System.out.printf("%3s\t%10s\t%10s%10s\n",
					dto.getPno(),dto.getPname(),dto.getPprice(),
					dto.getPstock()>0?"판매중":"재고부족");
		}

	}
	// 제품선택
	public boolean check(int pno) {		
		ArrayList<ProductDTO> result = ProductDAO.getInstance().list();
		// 해당 제품 재고 확인
		for(ProductDTO dto:result) {
			// 장바구니 재고
			if(shoppingList.size()>0) { 
				// 장바구니 동일 상품 유
				for(ProductDTO dto2: shoppingList) {
					if(dto.getPno()==dto2.getPno()) {
						if(dto2.getPstock()-1>0) {
							dto2.setPstock(dto2.getPstock()-1);
							dto2.setCount(dto2.getCount()+1);
							return true;
						} 
						else if(dto2.getPstock()<1) { return false;}
					}
				}
			}
			if(dto.getPstock()-1>0) {
				// 장바구니 동일 상품 x
				dto.setPstock(dto.getPstock()-1);
				dto.setCount(1);
				shoppingList.add(dto);
				return true;
			}
		}// result for e
		return false;
	}
	// 장바구니 확인
	public void shoppingList() {
		int total = 0;
		for(int i=0 ; i<shoppingList.size();i++) {
			total += (shoppingList.get(i).getPprice()*shoppingList.get(i).getCount());
			System.out.printf("%3s\t%10s\t%10s%3d\n",
					i+1,shoppingList.get(i).getPname(),shoppingList.get(i).getPprice(),shoppingList.get(i).getCount());
		}
		System.out.println("---------------------------------------------");
		System.out.println("총 금액 : "+total);
	}
	// 결제
	public boolean buy( ) {
		boolean result = ProductDAO.getInstance().buy(shoppingList);
		shoppingList.clear();
		return result;
	}
	// 장바구니 제품 삭제
	public boolean MYdelete(int index) {
		shoppingList.remove(index-1);
		return true;
	}
	// 결제 취소 = 장바구니 비우기
	public void reset() {
		shoppingList.clear();
	}
	
}
