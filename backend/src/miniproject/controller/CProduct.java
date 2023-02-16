package miniproject.controller;

import java.util.ArrayList;

import miniproject.model.Product;

public class CProduct {

	private static CProduct pc = new CProduct();
	private CProduct () { }
	public static CProduct getInstance() {
		return pc;
	}
	
	private static ArrayList<Product> productDB = new ArrayList<>();
	public static ArrayList<Product> getInstances() {
		return productDB ;
	}
	
			
	// 내가 등록한 제품 출력
	public ArrayList<Product> myProducts(int mno) {
	
		ArrayList<Product> myP = new ArrayList<>();
		
		for(Product p : productDB)
		{if(p.mno==mno)
			{myP.add(p);}// for e
		}
		return myP;
	}

}
