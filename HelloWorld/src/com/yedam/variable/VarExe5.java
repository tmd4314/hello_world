package com.yedam.variable;

import java.util.Scanner;

// 예금, 출금, 잔고 확인기능.

public class VarExe5 {
	public static void main(String[] args) {
		boolean run = true;
		int balance = 0; // 예금액을 저장하는 변수.
		int amt = 0;

		Scanner scn = new Scanner(System.in);
		while(run) {
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			int menu = scn.nextInt();
			switch(menu) {
			case 1:
				System.out.print("금액을 입력>>");
				amt = scn.nextInt();
				if(balance + amt > 100000) {
					System.out.print("10만원을 초과 했습니다.");
				}
				else {
					balance = balance + amt;
					System.out.print("정상적으로 " + amt + "원이 입금 되었습니다.");
				}
				break; //case 1 종료.
			case 2:
				System.out.print("출금할 금액을 입력>>");
				amt = scn.nextInt();
				if(balance < amt) {
					System.out.print("잔액초과 출금 할 수 없습니다.");
				} else {
					balance = balance - amt;
					System.out.print("정상적으로 " + amt + "원이 출금 되었습니다.");
				}
				break; //case 2 종료.
			case 3:
				System.out.println("현재 남은 잔고는 " + balance + "원 입니다.");
				break; //case 3 종료.
			case 4:
				run = false;
			}
		}
		System.out.println("end of prog.");
	}// end of main().
}
