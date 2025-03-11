package com.yedam.variable;

import java.util.Scanner;

// 추가, 수정, 삭제, 목록 출력.

public class VarExe7 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		//Member 값을 저장.
		Member[] storage = new Member[100]; // {null, null,...., null}
		storage[0] = new Member("홍길동", 83);
		storage[1] = new Member("김민혁", 86);
		storage[2] = new Member("한수아", 90);
		
		while(run) {
			System.out.println("1.등록 2.수정 3.삭제 4.출력 5.평균 6.종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine()); // 1 엔터.
			
			switch(menu) {
			case 1:
				System.out.print("이름입력>> ");
				String name = scn.nextLine();
				System.out.print("점수입력>> ");
				int score = Integer.parseInt(scn.nextLine());
				Member member = new Member(); //인스턴스 생성
//				member.name = name;
//				member.score = score;
				member.setMember(name, score);
				// 빈공간에 값을 할당.
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] == null) {
						storage[i] = member;
						break; // for 반복문 종료.
					}
				}
				break; // case 1의 종료.
			case 2:
				System.out.print("수정할 이름 입력>>");
				String names = scn.nextLine();
				boolean isExist = false;
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(names)) {
						System.out.print("이름을 수정>>");
						String nn = scn.nextLine();
						System.out.print("점수를 수정>> ");
						int sc = Integer.parseInt(scn.nextLine());
						storage[i].setMember(nn, sc);
						System.out.println("수정되었습니다.");
						isExist = true;
						break;
					} 
				}
				if(!isExist) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
			case 3: // 삭제. 이름입력 조호 후 => null 대입.
				System.out.print("삭제할 이름 입력>>");
				name = scn.nextLine();
				boolean isExist2 = false;
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null && storage[i].getName().equals(name)) {
						storage[i] = null;
						System.out.println("삭제되었습니다.");
						isExist = true;
						break;
					}
				}
				if(!isExist2) {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;
			case 4: // 목록 출력.
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						System.out.println(storage[i].getName() + " " +storage[i].getScore());
					}
				}
				break;
			case 5:
				int sum = 0;
				int count = 0;
				double avg = 0.0;
				for(int i = 0; i < storage.length; i++) {
					if(storage[i] != null) {
						sum += storage[i].getScore();
						count++;
					}
				}
				double avq = sum*1.0 /count;
				System.out.println("평균은 " + avq + "입니다.");
				break;
			case 6:
				run = false;
			}
		}
		System.out.println("end of prog.");
	}//end of main().
}
