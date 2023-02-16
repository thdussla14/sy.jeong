package miniproject.controller;

import java.util.ArrayList;

import miniproject.model.Product;

public class Pcontroller {

	private static Pcontroller pc = new Pcontroller();
	private Pcontroller () { }
	public static Pcontroller getInstance() {
		return pc;
	}
	
	private static ArrayList<Product> productDB = new ArrayList<>();
	public static ArrayList<Product> getInstances() {
		return productDB ;
	}
	
	// ?
			
	// 제품 출력
	public ArrayList<Product> print () {
		
		
		return productDB;
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
	
	
}
