package com.yedam.bookApp;

import java.util.List;
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
	 //Book[] bookStore = new Book[100];
	 User[] users = new User[100]; // User 배열 선언
	 
	 BookJdbc dao = new BookJdbc();
	 
	 
	 
	private void infow() {
		//회원 등록
		users[0] = new User("tmd4314", "이승민", "dltmdals1@");
		users[1] = new User("user2", "홍길동", "1234");
		users[2] = new User("user3", "이민승", "dltmdals12!");
	}
	
	private boolean login(String userId, String password) {
		for(User user : users) {
			if(user != null && user.getUserId().equals(userId) && user.getPassword().equals(password)) {
				System.out.println("로그인 성공: " + user.getUserName());
				return true;
			}
		}
		System.out.println("로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
		return false; // 로그인 실패
	}
	 
	private  int getSequnceNo() {
		int max = 0;
//		for(int i = 0; i < bookStore.length; i++) {
//			if(bookStore[i] != null && bookStore[i].getOrderNo() > max) {
//				max = bookStore[i].getOrderNo();
//			}
//		}
		return max + 1; // 현재 마지막번호 + 1;
	}
	
//	private void init() {
//		//책 등록
//		bookStore[0] = new Book("자바", "이승민", "한빛", 20000, 1);
//		bookStore[1] = new Book("c++", "김동길", "자빛", 25000, 2);
//		bookStore[2] = new Book("파이썬", "김파이", "오빛", 40000, 3);
//		bookStore[3] = new Book("자바2", "송민승", "자빛", 30000, 4);
//		bookStore[4] = new Book("c++2", "김잠길", "오빛", 15000, 5);
//		bookStore[5] = new Book("파이썬2", "오파이", "한빛", 35000, 6);
//	}
	
	//등록 기능 
	// 1. 이미 존재하는 제목은 입력불가.
	private void add() {
		System.out.print("제목 입력>> ");
		String title = scn.nextLine();
//		if(searchBook(title) != null) {
//			System.out.println("이미 등록된 제목입니다.");
//			return;
//		}
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
		if(dao.insert(book)) {
			System.out.println("정상 등록");
		}else {
			System.out.println("등록 실패.");
		}
	}// end of add().
	
	// 수정.
	private  void edit() {
		System.out.print("도서코드 입력>> ");
		String bcode = scn.nextLine();;
		if(bcode.isBlank()) {
			System.out.println("도서코드를 반드시 입력하세요.");
			return;
		}
		System.out.print("저자입력>> ");
		String author = scn.nextLine();
		System.out.print("제목입력>> ");
		String title = scn.nextLine();
		System.out.print("출판사>> ");
		String company = scn.nextLine();
		System.out.print("금액입력>> ");
		String sprice = scn.nextLine();
		
		Book book = new Book();
		book.setBookCode(bcode);
		book.setAuthor(author);
		book.setTitle(title);
		book.setCompany(company);
		book.setPrice( Integer.parseInt(sprice));
		
		if(dao.update(book)) {
			System.out.println("수정성공.");
		}else {
			System.out.println("수정실패.");
		}
	}
	
	private  void delete() {
		System.out.print("삭제할 도서코드를 입력>>");
		String bcode = scn.nextLine();
		if(bcode.isBlank()) {
			System.out.println("반드시 도서코드를 입력하시오. ");
			return;
		}
		
		Book book = new Book();
		book.setBookCode(bcode);
		
		if(dao.delete(book)) {
			System.out.println("삭제 성공.");
		}else {
			System.out.println("삭제 실패.");
		}
	}
	
	private  void list() {
		System.out.println("순번 제목       저자   가격");
		System.out.println("==================");
		List<Book> list = searchList("");
		for(Book bk : list) {
			System.out.println(bk.showList());
		}

	}// end of list().
	
	private List<Book> searchList(String keyword){
		List<Book> list = dao.list(keyword);
		return list;
	}
	
	
	private void companyInfo() {
		String company = "";
		while(true) {
			System.out.print("조회할 출판사 정보>> ");
			company = scn.nextLine();
			if(!company.isBlank()) {
				break;
			}
			System.out.println("출판사를 반드시 입력하세요.");
		}
		System.out.println("순번 제목       저자   가격");
		System.out.println("=========================");
		List<Book> list = searchList(company);
		for(Book bk : list) {
			System.out.println(bk.showList());
		}
		
	}
	
	private  void bookInfo() {
		String title = "";
		while(true) {
			System.out.print("조회할 도서를 입력>> ");
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
	
	private  Book searchBook(String title) {
		return dao.select(title);
	}
	
	
	
	public void runMain() {
		boolean run = true;
		while(run) {
			System.out.println("1.도서등록 2.수정 3.삭제 4.목록 5.상세조회 6.출판사조회 9.종료");
			System.out.print("선택>>");
			//예외 처리.
			int menu = 9;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
					break;
				} catch(NumberFormatException e) {
					System.out.println("숫자를 입력해주세요.");
					continue;
				}
			}
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
		app.infow();
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