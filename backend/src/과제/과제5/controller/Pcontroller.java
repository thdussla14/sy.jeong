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
	
	// DB 대용
	private ArrayList<Product> productDB = new ArrayList<>();
	
	// 1. 전 제품 출력
	public ArrayList<Product> print() {
		
		return productDB;
	}
	// 2. 제품 등록
	public boolean register() {
		
		return true;
	}
	// 3. 제품 상세
	public Product view() {
		
		return null;
	}
	// 4. 내가 등록한 제품 목록
	public ArrayList<Product> myproduct() {
		
		return productDB;
	}
	// 5. 제품 수정
	public boolean update() {
		
		return true;
	}
	// 6. 제품 삭제
	public boolean delete() {
		
		return true;
	}
	// 7. 쪽지 보내기
	public boolean sends() {
		
		return true;
	}
	
	
}// class e
