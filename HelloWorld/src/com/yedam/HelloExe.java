package com.yedam;

import com.yedam.classes.List;
import com.yedam.classes.MethodMain;
import com.yedam.classes.Product;

public class HelloExe {
	//8. [3]
	// 홍길동, 010-1234-1234, 20
			// 김민식, 010-2224-2224, 22
			// 초민식, 010-3334-3334, 23
	// 기능(함수) => main 메소드.
	public static void main(String[] args) {
		// 1. 32000
		int num = 32000;
		
		// 2. 34, 32, 88, 23
		int [] Arry = {34, 32, 88, 23};
		
		// 3. 문자: 32
		System.out.println("문자: " + Arry[1]);
		
		// 4. 정수변수에 저장.
		
		
		// 5. Hello, Nice, Good
		String str = "Hello, Nice, Good";
		// 6. 정수 5개 저장
		// Math.random() -> 60~ 100
		int[] ars = new int[5];
		for(int i = 0; i < ars.length; i++) {
			ars[i] = (int)(Math.random() *60) + 40;
		}
		
		
		// 7. 이름, 연락처, 나이선언
		// 홍길동, 010-1234-1234, 20
		String name ="홍길동";
		String number = "010-1234-1234";
		int age = 20;
		
		// 8,9번 연결
		List[] list = new List[3];
		list[0] = new List("홍길동", "010-1234-1234", 20);
		list[1] = new List("김민식", "010-2224-2224", 22);
		list[2] = new List("홍길수", "010-3334-3334", 23);
		
		for(int i = 0 ; i < list.length; i++) {
			if(list[i].getAge() > 22) {
				System.out.println(list[i].getName() + "님의 나이가 제일 많습니다." );
			}
		}
	}
}
