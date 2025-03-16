package com.yedam.bookApp;

import java.util.Scanner;

import com.yedam.variable.Member;

public class BookMain { 
	// 2. 정적 필드. 할당.
	private static BookMain instance = new BookMain();
	// 1. 생성자 private 선언
	private BookMain() {
	}
	// 3. getInstance() 제공.
	public static BookMain getInstance() {
		return instance;
	}
	
	 Scanner scn = new Scanner(System.in);
	 Book[] bookStore = new Book[100];
	 User[] users = new User[3]; // User 배열 선언
	 
	
	public  int getSequnceNo() {
		int max = 0;
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getOrderNo() > max) {
				max = bookStore[i].getOrderNo();
			}
		}
		return max + 1; // 현재 마지막번호 + 1;
	}
	
	public  void init() {
		//책 등록
		bookStore[0] = new Book("자바", "이승민", "한빛", 20000, 1);
		bookStore[1] = new Book("c++", "김동길", "자빛", 25000, 2);
		bookStore[2] = new Book("파이썬", "김파이", "오빛", 40000, 3);
		bookStore[3] = new Book("자바2", "송민승", "자빛", 30000, 4);
		bookStore[4] = new Book("c++2", "김잠길", "오빛", 15000, 5);
		bookStore[5] = new Book("파이썬2", "오파이", "한빛", 35000, 6);
		
		//회원 등록
		users[0] = new User("user1", "이승민", "1234");
		users[1] = new User("user2", "홍길동", "dltmdals1@");
		users[2] = new User("user3", "이민승", "dltmdals12!");
	}
	
	//등록 기능 
	// 1. 이미 존재하는 제목은 입력불가.
	public  void add() {
		System.out.print("제목 입력>> ");
		String title = scn.nextLine();
		if(search(title) != null) {
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
	public  void edit() {
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
	
	public  void delete() {
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
	
	public  void list() {
		System.out.println("순번 제목       저자   가격");
		System.out.println("==================");
//		// 순번정렬.
//		// 순번 1> 순번2, 제외:순번2(null) 순번1(null)
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
		Book[] list = searchList(null);
		for(int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null){
				System.out.println(seqNo++ + " " + bookStore[i].showList());
			}
		}
	}// end of list().
	
	public  Book[] searchList(String keyword) {
		Book[] list = new Book[100];
		int idx = 0;
		for(int i = 0; i < bookStore.length; i++) {
			if(bookStore[i] != null) {
				if(keyword == null || bookStore[i].getCompany().equals(keyword)) {
					list[idx++] = bookStore[i];
				}	
			}
		}
		return list;
	}// end of searchlist;
	
	public  void searchCompnay(String keyword) {
		Book[] list = new Book[100];
		for(int i = 0; i < bookStore.length; i++) {
			
		}
	}
	
	public  void companyInfo() {
		System.out.println("조회할 출판사 정보>> ");
		String company = scn.nextLine();
		
		int seqNo = 1;
		System.out.println("순번 제목       저자   가격");
		System.out.println("==================");
		Book[] list = searchList(company);
		for(int i = 0; i < bookStore.length; i++) {
			if (bookStore[i] != null){
				if(bookStore[i].getCompany().equals(company)) {
					System.out.println(seqNo++ + " " + bookStore[i].showListWithNo());
				}
			}
		}
	}
	
	public  void bookInfo() {
		String title = "";
		while(true) {
			System.out.print("조회할 도서를 입력>> ");
			title = scn.nextLine();
			if(!title.isBlank()) {
				break;
			}
			System.out.println("책제목을 반드시 입력하세요.");
		}
		
		Book result = search(title);
		if(result == null) {
			System.out.println("죄회 결과가 없습니다.");
			return;
		}
		System.out.println(result.showBookInfo());
	}
	
	public  Book search(String title) {
		for(int i = 0; i< bookStore.length; i++) {
			if(bookStore[i] != null && bookStore[i].getTitle().equals(title)) {
				return bookStore[i];
			}
		}
		return null;
	}
	public boolean login(String userId, String password) {
		for(User user : users) {
			if(user != null && user.getUserId().equals(userId) && user.getPassword().equals(password)) {
				System.out.println("로그인 성공: " + user.getUserName());
				return true;
			}
		}
		System.out.println("로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
		return false; // 로그인 실패
	}
	
	public void runMain() {
		boolean run = true;
		
		while(run) {
			System.out.println("1.도서등록 2.수정 3.삭제 4.목록 5.상세조회 6.출판사조회 9.종료");
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
			case 6: // 상세조회.
				companyInfo();
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
	}

	public static void main(String[] args) {
		BookMain app = new BookMain();
		app.init();
		while(true) {
			System.out.print("아이디 입력>> ");
			String userId = app.scn.nextLine();
			System.out.print("비밀번호 입력>> ");
			String password = app.scn.nextLine();
			if(app.login(userId, password)) {
				app.runMain();
				break;
			}
		}
	}// end of main().
	
	
}
