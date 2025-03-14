package com.yedam.classes;

public class MethodExe3 {
	
	// 구구단 출력
	String gugudan(int num, int toNum) {
		String str ="";
		for(int i = num; i <= toNum; i++) {
			int dan = i;
			for(int j = 1; j <= 9; j++) {
//				System.out.println(dan + "*" + toNum + "=" + (toNum*9));
				str += dan + "*" + j + "=" + (dan*j) + "\n";
			}
		}
		return str;
	}// end of gugudan.
	
	
	String printStar(int cnt, String str) {
		String sr = "";
		for(int i = 1; i<=cnt; i++) {
			for(int j = 1; j <= i; j++) {
				 sr += str; // str을 출력
			}
			sr += "\n";
		}
		return sr;
	}
	
	static void printCard() {
		int[] intAry = new int[16];
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (int) (Math.random() *16) + 1;
			for(int j = 0; j < i; j++) {
				if(intAry[i] == intAry[j]) {
					i--;
				}
			}
		}
		
		//출력
		for(int i = 0; i < intAry.length; i++) {
			System.out.printf("%3d", intAry[i]);
			if(i%4 ==3) {
				System.out.println();
			}
		}
   }
	
}
