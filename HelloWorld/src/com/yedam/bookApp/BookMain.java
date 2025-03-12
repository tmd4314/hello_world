package com.yedam.bookApp;

import java.util.Scanner;

import com.yedam.variable.Member;

public class BookMain {

	static Scanner scn = new Scanner(System.in);
	static Book[] bookStore = new Book[100];
	
	public static int getSequnceNo() {
		int max = 0;
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getOrderNo() > max) {
				max = bookStore[i].getOrderNo();
			}
		}
		return max + 1; // 현재 마지막번호 + 1;
	}
	
	//등록 기능 
	// 1. 이미 존재하는 제목은 입력불가.
	public static void add() {
		System.out.print("제목 입력>> ");
		String title = scn.nextLine();
		if(searchBook(title) != null) {
			System.out.println("이미 등록된 제목입니다.");
			return;
		}
		System.out.print("저자 입력>> ");
		String author = scn.nextLine();
		System.out.print("출판사 입력>> ");
		String company = scn.nextLine();
		System.out.print("가격 입력>> ");
		String price = scn.nextLine();
		if(title.isBlank() || author.isBlank() || company.isBlank()|| price.isBlank()) {
			System.out.println("항목을 입력하세요.");
			return; // 메소드의 종료.
		}

		Book book = new Book(title, author, company, Integer.parseInt(price), getSequnceNo());

		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] == null) {
				bookStore[i] = book;
				break;
			}
		}
	}// end of add().
	
	// 수정.
	public static void edit() {
		System.out.print("금액 수정할 도서를 입력>> ");
		String title = scn.nextLine();
		boolean isExist2 = false;
		if(title.isBlank()) {
			System.out.println("책제목을 반드시 입력하세요.");
			return;
		}
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				System.out.print("수정할 금액입력>> ");
				int sprice = Integer.parseInt(scn.nextLine());
				bookStore[i].setPrice(sprice);
				isExist2 = true;
				break;
			}
		}
		if(!isExist2) {
			System.out.println("찾는 도서가 없습니다.");
		}
	}
	
	public static void delete() {
		System.out.print("삭제할 도서를 입력>>");
		String title = scn.nextLine();
		if(title.isBlank()) {
			System.out.println("반드시 도서 제목을 입력하시오. ");
			return;
		}
		boolean isExist = false;
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				bookStore[i] = null;
				System.out.println("삭제되었습니다.");
				isExist = true;
				break;
			}
		}
		if(!isExist) {
			System.out.println("찾는 도서가 없습니다.");
		}
	}
	
	public static void list() {
		System.out.println("순번 제목       저자   가격");
		System.out.println("==================");
//		for(Book book : bookStore) {
//			System.out.println(book.showList());
//		}
		// 순번정렬.
		// 순번 1> 순번2, 제외:순번2(null) 순번1(null)
		Book temp = null;
		for (int i = 0; i < bookStore.length - 1; i++) {
			for(int j = 0; j < bookStore.length - 1; j++) {
				if(bookStore[j + 1] == null) {
					continue;
				}
				if(bookStore[j] == null || bookStore[j].getOrderNo() > bookStore[j + 1].getOrderNo()) {
					temp =  bookStore[j];
					bookStore[j] = bookStore[j + 1];
					bookStore[j + 1] = temp;
				}
			}
		}
		int seqNo = 1;
		for(int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null){
				System.out.println(seqNo++ + " " + bookStore[i].showList());
			}
		}
	}
	
	public static void bookInfo() {
		String title = "";
		while(true) {
			System.out.println("조회할 도서를 입력>> ");
			title = scn.nextLine();
			if(!title.isBlank()) {
				break;
			}
			System.out.println("책제목을 반드시 입력하세요.");
		}
		
		Book result = searchBook(title);
		if(result == null) {
			System.out.println("죄회 결과가 없습니다.");
			return;
		}
		System.out.println(result.showBookInfo());
	}
	public static Book searchBook(String title) {
		for(int i = 0; i< bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				return bookStore[i];
			}
		}
		return null;
	}
	public static void main(String[] args) {
		boolean run = true;
		init();
		while(run) {
			System.out.println("1.도서등록 2.수정 3.삭제 4.목록 5.상세조회 9.종료");
			System.out.print("선택>>");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1: // 등록.
				add();
				break;
			case 2: // 수정.
				edit();
				break;
			case 3: // 삭제.
				delete();
				break;
			case 4: // 목록.
				list();
				break;
			case 5: // 상세조회.
				bookInfo();
				break;
			case 9: // 종료.
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}
		}
		System.out.println("end of prog");
	}// end of main().
	public static void init() {
		bookStore[0] = new Book("자바", "이승민", "한빛", 20000, 1);
		bookStore[1] = new Book("c++", "김동길", "한빛", 25000, 2);
		bookStore[2] = new Book("파이썬", "김파이", "한빛", 30000, 3);
	}
}
