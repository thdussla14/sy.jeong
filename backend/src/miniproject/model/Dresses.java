package miniproject.model;

import java.util.ArrayList;

import miniproject.controller.CProduct;

public class Dresses extends Product{
	
	// 1. 필드
	private final String pCode = "01";
	
	
	// 2. 생성자
	// 빈생성자
	public Dresses() {	}
	//
	public Dresses(int mno, int pno, String title, String content, String price, String state) {
		super();
	}
			
	// 3. 메소드
			
	// 제품 출력
	@Override
	public ArrayList<Product> print (String pCode) {

		ArrayList<Product> result = null;

		for(Product p : CProduct.getInstances())
			{if(p.pCode.equals(pCode))
					{System.out.println(p.pCode+"\t"+p.pno+"\t"+p.title+"\t"+p.price+"\t"+p.state);}
			}// for e 
				
		return result;
	}
	@Override
	// 제품 등록
	public boolean register(int mno, String title, String content, String price) {
				
		// 객체 생성
		Product product = new Product();
				
		// 입력받은 내용 저장
		product.mno = mno;
		product.title = title;
		product.content = content;
		product.price = price;
				
		// 자동 생성 내용 저장
		product.pCode = pCode;
		product.mno = mno;
				
		// pno (마지막 pno +1)
		int pno = 0;
		if(CProduct.getInstances().size()>0)
			{pno = CProduct.getInstances().get(CProduct.getInstances().size()-1).pno+1;}
					
		product.pno = pno;	
		product.state = "판매중";
			
		// 제품DB에 저장
		CProduct.getInstances().add(product);
				
				
		return true;
	}
	@Override
	// 제품 상세
	public int view(int mno,int pno) {

		// 제품DB에서 제품번호 일치 확인
		for(Product p:CProduct.getInstances())
			{if(p.pno==pno) 
				{// 일치한 제품 정보 출력
					System.out.println("제품 이름 : "+p.title); 
					System.out.println("제품 내용 : "+p.content);
					System.out.println("제품 가격 : "+p.price);
					System.out.println("제품 상태 : "+p.state);
				}// if e 
			}// for e
				
			return pno;
	}
	@Override
	// 제품 수정
	public boolean update(int mno,int pno,String title, String content, String price) {
				
		int check = 0;
				
		// 제품 DB에서 제품번호 일치 제품 확인
		for( int i=0 ; i<CProduct.getInstances().size() ; i++)
			{if( CProduct.getInstances().get(i).pno==pno)
				{ check = i ;}}// for e
				
		// 해당 제품 새로운 내용 대입
		CProduct.getInstances().get(check).title 	= title ;
		CProduct.getInstances().get(check).content 	= content ;
		CProduct.getInstances().get(check).price 	= price ;
				
		return true;
	}
	@Override
	// 제품 삭제
	public boolean delete(int mno,int pno) {

		int check = 0;
				
		// 제품 DB에서 제품번호 일치 제품 확인
		for( int i=0 ; i<CProduct.getInstances().size() ; i++)
			{if( CProduct.getInstances().get(i).pno==pno)
				{ check = i ;}}// for e

		// 제품 DB에서 해당 제품번호 인덱스 삭제
		CProduct.getInstances().remove(check);
			
		return true;
	}
	@Override
	// 제품 상태 변경
	public boolean compelete(int mno,int pno) {
				
		int check = 0;
				
		// 제품 DB에서 제품번호 일치 제품 확인
		for( int i=0 ; i<CProduct.getInstances().size() ; i++)
			{if( CProduct.getInstances().get(i).pno==pno)
				{ check = i ;}}// for e
				
		// 제품 DB에서 해당 제품번호 상태 변경
		CProduct.getInstances().get(check).state = "판매완료";
				
		return true;
	}
			
}// class e