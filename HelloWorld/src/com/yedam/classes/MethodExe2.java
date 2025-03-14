package com.yedam.classes;

public class MethodExe2 {
	private Product[] store; //필드
	
	//생성자
	MethodExe2() {
		store = new Product[10];
		store[0] = new Product("A001", "지우개", 500);
		store[1] = new Product("B001", "샤프1000", 1000);
		store[2] = new Product("C001", "연필500", 800);
	}
	
	//메소드
	boolean add(Product prod) {
		for(int i = 0; i < store.length; i++) {
			if(store[i] == null) {
				store[i] = prod;
				return true;
			}
		}
		return false;
	} // end of void add(Product prd)
	// 상품이름, ALL
	Product[] productList(Product prod) {
		Product[] list = new Product[10];
		int idx = 0;
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null) {				
				if(prod.getProductName().equals("ALL")
						|| store[i].getProductName().equals(prod.getProductName())) {
					if(store[i].getPrice() >= prod.getPrice()) {
						list[idx++] = store[i];
					}
				}
			}
		}
		return list;
	}// end of productList.
	// 삭제 => boolean remove(String code)
	boolean remove(String code) {
		Product[] remove = new Product[10];
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null && store[i].getProductCode().equals(code)) {
					store[i] = null;
					return true;
			}
		}
		return false;
	}// end of remove.
	
	// 수정 => boolean modify
	boolean modify(Product prod) {
		for(int i = 0; i < store.length; i++) {
			if(store[i] != null && store[i].getProductCode().equals(prod.getProductCode())) {
					// 상품명수정.
				if(prod.getProductName() != null) {
					store[i].setProductName(prod.getProductName());
				}
				//상품가격 수정.
				if(prod.getPrice() != 0) {
					store[i].setPrice(prod.getPrice());
				}
				return true;
			}
		}
		return false;
	}// end of modify.


}
