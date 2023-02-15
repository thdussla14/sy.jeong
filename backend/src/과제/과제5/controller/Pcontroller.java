package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Product;

public class Pcontroller {

	// ** 싱글톤
	private static Pcontroller pc = new Pcontroller();
	private Pcontroller () { }
	public static Pcontroller getInstance() {
		return pc;
	}

	private static ArrayList<Product> productDB = new ArrayList<>();
	public static ArrayList<Product> getInstance1() {
		return productDB ;
	}
	
	// 1. 전 제품 출력
	public ArrayList<Product> print() {
		return productDB;
	}

	// 2. 제품 등록
	public boolean register(String title, String content, String price) {
		
		int mno = Mcontroller.getInsetance().getLogSession();
		int pno = 0;
		if(productDB.size()>0)
			{pno = productDB.get(productDB.size()-1).getPno()+1;}
		String State = "판매중";
		Product product = new Product(mno,pno,title,content,price,State);	
		productDB.add(product);
		return true;
		
	}
	// 3. 제품 상세
	public Product view(int spno) {
		
		Product pro = null;
		
		for(int i=0 ; i<productDB.size() ; i++)
		{if(productDB.get(i).getPno()==spno)
			{ pro = productDB.get(i);}}// for e
	
		return pro;
		
	}
	// 4. 내가 등록한 제품 목록
	public ArrayList<Product> myproduct() {
		
		ArrayList<Product> myproduct = new ArrayList<>();
		
		for(Product p:productDB)
		{if(p.getMno()==Mcontroller.getInsetance().getLogSession())
			{myproduct.add(p); }}// for e
		
		return myproduct;
	}
	// 5. 제품 수정
	public boolean update(int result,String title, String content, String price) {
 
		productDB.get(result).setTitle(title);
		productDB.get(result).setContent(content);
		productDB.get(result).setPrice(price);
		return true;
	}
	// 6. 제품 삭제
	public boolean delete(int result) {
		
		productDB.remove(result);
		return true;
	}
	
	// 7. 판매 완료
	public boolean compelete(int result) {

		productDB.get(result).setState("판매완료");
		return true;

	}
	
	// 8. 유효성검사
	public int check(int pno) {
		
		for(int i=0; i<productDB.size() ; i++)
		{if(productDB.get(i).getPno()==pno)
			{if(productDB.get(i).getMno()==Mcontroller.getInsetance().getLogSession()) 
				{return i;
			}}}// for e
		return -1;
	}
	
}// class e
