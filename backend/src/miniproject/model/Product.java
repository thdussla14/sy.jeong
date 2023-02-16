package miniproject.model;

import java.util.ArrayList;

import miniproject.controller.Pcontroller;

public class Product {

	// 1.필드
	// 1-1. 관계 필드 = 참조 필드 [FK]
	public int mno; // 등록 회원 넘버
	// 1-1. 관계 필드 = 식별 필드 [PK]
	public int pno; 	  // 제품 넘버
	public String pCode; // 카테고리 식별 코드
	// 1-2. 일반 필드
	public String title;
	public String content;
	public String price;
	public String state;	// 제품상태 : 판매중, 판매완료

	// 2. 생성자
	
	// 2-1. 빈생성자
	public Product() { }
	// 2-2. 풀생성자

	public Product(int mno, int pno, String pCode, String title, String content, String price, String state) {
		this.mno = mno;
		this.pno = pno;
		this.pCode = pCode;
		this.title = title;
		this.content = content;
		this.price = price;
		this.state = state;
	}

	// 3. 메소드

	// 제품 출력
	public ArrayList<Product> print () {
		
		ArrayList<Product> result = Pcontroller.getInstances();
				
		return result;
	}
	
	// 제품 등록
	public boolean register() {
		
		return true;
	}
	// 제품 상세
	public Product view() {
		
		Product product = new Product();
		
		return product;
	}
	// 제품 수정
	public boolean update() {
		
		return true;
	}
	// 제품 삭제
	public boolean delete() {
		
		return true;
	}
	// 제품 상태 변경
	public boolean compelete() {
		
		return true;
	}

	
}// class e
