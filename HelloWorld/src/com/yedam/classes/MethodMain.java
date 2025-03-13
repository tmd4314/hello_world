package com.yedam.classes;

public class MethodMain {
	public static void main(String[] args) {
		MethodExe3 m3 = new MethodExe3();
		//System.out.println(m3.gugudan(3, 7));   
		//System.out.println(m3.printStar(6, "*"));
		//m3.printCard();
	}
	void method2() {
		// 상품코드: M001, 상품명: 만년필, 가격: 10000
		MethodExe2 m2 = new MethodExe2();
		// 상품코드, 상품명, 가격 modify(Product prod)
		// A001   지우개   500
		// A001   연필     600
//				Product prod = new Product("A001", "지우개2" , 1423);
//				if(m2.modify(prod)) {
//					System.out.println("수정성공");
//				}
	
//				if(m2.add(new Product("A001", "지우개", 500))) {
//					System.out.println("등록 성공");
//				}
	
//				if(m2.remove("A001")) {
//					System.out.println("삭제성공");
//				};

		Product search = new Product();
		search.setProductName("지우개");// 상품코드 상품명 가격
		search.setPrice(500);
		
		Product[] list = m2.productList(search);
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				System.out.println(list[i].showList());
			}
		}
	}
	void method1() {
		MethodExe1 m1 = new MethodExe1();
//		System.out.println(m1);
		// 메소드 호출
		int n = 5;
		m1.printString(n, "★");
		
		double result = m1.sum(n, 10.522);
		System.out.println(result);
		
		int sum = m1.sum(new int[] {10, 20, 30});
		result = m1.sum(new double[] {10.5, 22.1, 34.5});
		System.out.println(result);
		
	}
}
