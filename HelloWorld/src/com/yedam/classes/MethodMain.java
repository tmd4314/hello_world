package com.yedam.classes;

import java.util.Scanner;

public class MethodMain {
	public static void main(String[] args) {
		Scanner scn;
		officeApp();
		
	} //end of main.
	
	static void officeApp() {
		// 목록, 추가, 수정, 삭제.......
		MethodExe2 m2 = new MethodExe2(); // 기능정의.
		Scanner scn = new Scanner(System.in);
		Product prod = new Product();
		
		boolean run = true;
		while(run) {
			System.out.println("1.목록 2.추가 3.수정 4.삭제 9.종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:
				
				prod.setProductName("ALL");
				Product[] list = m2.productList(prod);
				for(int i = 0; i < list.length; i++) {
					if(list[i] != null) {
						System.out.println(list[i].showList());
					}
				}
				break;
			case 2:
				System.out.print("아이디값 입력>> ");
				String code = scn.nextLine();
				System.out.print("이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("가격 입력>> ");
				String price = scn.nextLine();
				Product store = new Product(code, name, Integer.parseInt(price));
				if(m2.add(store)) {
					System.out.println("등록 성공");
				}
				break;
			case 3:
				System.out.print("수정할 아이디값 입력>> ");
				String mocode = scn.nextLine();
				System.out.print("이름 입력>> ");
				String moname = scn.nextLine();
				System.out.print("가격 입력>> ");
				String moprice = scn.nextLine();
				Product prod2 = new Product(mocode, moname , Integer.parseInt(moprice));
				if(m2.modify(prod2)) {
					System.out.println("수정성공");
				}
				break;
			case 4:
				System.out.print("삭제할 아이디값 입력>> ");
				String delcode = scn.nextLine();
				if(m2.remove(delcode)) {
					System.out.println("삭제성공");
				};

				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}// end of switch
		}
		// 사용자입력 받아서 1.목록, 2.추가, 3.수정, 4.삭제 구현.
		// 입력메세지 정의 구현.
		
	}
	void method4() {
		MethodExe4 m4 = new MethodExe4();
		MethodExe4.main();
	}
	void method3() {
		MethodExe3 m3 = new MethodExe3();
		//System.out.println(m3.gugudan(3, 7));   
		System.out.println(m3.printStar(5, "*"));
		MethodExe3.printCard();
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
//	
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
