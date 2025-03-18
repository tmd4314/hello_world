package com.yedam.classes;
import java.util.ArrayList;
import java.util.List;

public class MethodExe2 {
	private List<Product> store; //필드
	
	//생성자
	MethodExe2() {
		store = new ArrayList<Product>();
		store.add(new Product("A001", "지우개", 500));
		store.add(new Product("B001", "샤프1000", 1000));
		store.add(new Product("C001", "연필500", 800));
		store.add(new Product("D001", "지우개", 1800));
	}
	
	//메소드
	boolean add(Product prod) {
		boolean result = store.add(prod);
		return result;
	} // end of void add(Product prd)
	// 상품이름, ALL
	List<Product> productList(Product prod) {
		List<Product> list = new ArrayList<Product>();
		for(int i = 0; i < store.size(); i++) {
			if(prod.getProductName().equals("ALL")
					|| store.get(i).getProductName().equals(prod.getProductName())) {
				if(store.get(i).getPrice() >= prod.getPrice()) {
					list.add(store.get(i));
				}
			}
			
		}
		return list;
	}// end of productList.
	// 삭제 => boolean remove(String code)
	boolean remove(String code) {
		List<Product> remove = new ArrayList<Product>();
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(code)) {
					store.remove(i);
					return true;
			}
		}
		return false;
	}// end of remove.
	
	// 수정 => boolean modify
	boolean modify(Product prod) {
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getProductCode().equals(prod.getProductCode())) {
					// 상품명수정.
				if(prod.getProductName() != null) {
					store.get(i).setProductName(prod.getProductName());
				}
				//상품가격 수정.
				if(prod.getPrice() != 0) {
					store.get(i).setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}// end of modify.


}
