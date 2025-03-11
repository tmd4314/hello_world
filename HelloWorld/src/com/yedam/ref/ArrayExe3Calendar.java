package com.yedam.ref;

public class ArrayExe3Calendar {
	// 2025년 기준으로 월 정보 => 1일의 위치를 반환.
	public static int getFirstDay(int month) {
		switch(month) {
		case 1:
			return 3;
		case 2:
			return 6;
		case 3:
			return 6;
		case 4:
			return 2;
			default :
				return 1;
		}
	}
	// 2025년 기준으로 월의 마지막날 반환.
	public static int getLastDay(int month) {
		switch(month) {
		case 1:
			return 31;
		case 2:
			return 28;
		case 3:
			return 31;
		case 4:
			return 30;
			default :
				return 1;
		}
	}
	public static void main(String[] args) {
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		for (String day : days) {
			System.out.print(" " + day);
		}
		System.out.println(); // 줄바꿈.
		int month = 3;
		int space = getFirstDay(month); //1일의 위치값.
		int lastDate = getLastDay(month); // 마지막날.
		// 공백갯수만큼 빈칸.
		for (int i = 0; i < space; i++) {
			System.out.print("    ");
		}
		for(int d = 1; d <= lastDate; d++) {
			if(String.valueOf(d).length() == 1) {
				System.out.print("   " + d);
			}else if(String.valueOf(d).length() == 2) {
				System.out.print("  " + d);
			}
			// 줄바꿈.
			if((space + d) % 7 == 0) {
				System.out.println();
			}
			if(month == 3 && d == 21) {
				System.out.print("(test)");
			};
		}
	}
}
