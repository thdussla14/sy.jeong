package 과제.과제11;

import java.util.ArrayList;

public class Controller {

	private static Controller cont = new Controller();
	private Controller () { }
	public static Controller getInstance() {return cont;}
	
	ArrayList<DTO>wishlist = new ArrayList<>(); // 장바구니 리스트
	
	public boolean register(String pname, int price, int storage) {		
		DTO dto = new DTO(pname,price,storage);		
		boolean result = DAO.getInsetance().register(dto);		
		return result;
	}
	public ArrayList<DTO> list() {
		ArrayList<DTO> result  = DAO.getInsetance().list();
		return result;
	}
	public boolean update(int pno,String pname,int price) {	
		DTO dto = new DTO(pno, pname, price);
		return DAO.getInsetance().update(dto);
	}
	public boolean storage_update(int pno,int stock) {
		return DAO.getInsetance().storage_update(pno,stock);		
	}
	public boolean delete(int pno) {
		return DAO.getInsetance().delete(pno);
	}
	public boolean sale(int pno,int count) {
		return DAO.getInsetance().sale(pno,count);
	}
	public boolean check(int pno) {
		int count = 0;
		int stock = 0;
		ArrayList<DTO> result  = DAO.getInsetance().list();
		for(DTO dto : result) {
			if(dto.getPno()== pno) {
				for(DTO dto2 : wishlist) {
					if(dto2.getPno()==pno) {count++;}
				}	
				stock = dto.getStorage()-count;
				if(stock>0) {
					wishlist.add(dto);
					return true;}
			}
		}
		return false;
	}
	public boolean slae() {
		int totalprice = 0;
		System.out.println("[구매내역]-------------------------");
		System.out.printf("%3s\t%10s\t%10s\n","번호","제품명","가격");
		for(DTO dto : wishlist) {
			totalprice += dto.getPrice();
			System.out.printf("%3s\t%10s\t%10s\n",dto.getPno(),dto.getPname(),dto.getPrice());
		}
		System.out.println("-------------------------------");
		System.out.println("총가격 : "+totalprice);
		boolean result = DAO.getInsetance().sale2(wishlist);
		return result;
	}
	public void clear() {
		wishlist = null;
	}
}
