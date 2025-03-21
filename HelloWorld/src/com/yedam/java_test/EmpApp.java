package com.yedam.java_test;

import java.util.List;
import java.util.Scanner;



public class EmpApp {
	// 2. 정적 필드. 할당.
		private static EmpApp instance = new EmpApp();
		// 1. 생성자 private 선언
		private EmpApp() {
		}
		// 3. getInstance() 제공.
		public static EmpApp getInstance() {
			return instance;
		}
		
		Scanner scn = new Scanner(System.in);
		
		EmpDAO dao = new EmpDAO();
	
	private void add() {
		System.out.print("사번입력>> ");
		String no = scn.nextLine();
		System.out.print("이름입력>> ");
		String name = scn.nextLine();
		System.out.print("전화번호입력>> ");
		String phone = scn.nextLine();
		System.out.print("입사일입력>> ");
		String hiredate = scn.nextLine();
		System.out.print("급여입력>> ");
		String salary = scn.nextLine();
		
		if(no.isBlank() || name.isBlank() || phone.isBlank() || hiredate.isBlank() || salary.isBlank()) {
			System.out.println("항목을 입력하세요.");
			return; // 메소드의 종료.
		}
		
		Employee emp = new Employee(no, name, phone, hiredate, Integer.parseInt(salary));
		if(dao.insert(emp)) {
			System.out.println("등록 완료");
		}else {
			System.out.println("등록 실패");
		}

	}// end of add
	
	private void edit() {
		System.out.print("사번>> ");
		String no = scn.nextLine();
		if(no.isBlank()) {
			System.out.println("사번을 반드시 입력하세요.");
			return;
		}
		System.out.print("급여수정>> ");
		String salary = scn.nextLine();;
		
		Employee employee = new Employee();
		employee.setNo(no);
		employee.setSalary(Integer.parseInt(salary));
		
		if(dao.update(employee)) {
			System.out.println("수정 성공");
		}else {
			System.out.println("수정 실패");
		}
	} // end of edit()
	
	private  void delete() {
		System.out.print("삭제사번>>");
		String no = scn.nextLine();
		if(no.isBlank()) {
			System.out.println("반드시 사번을 입력하시오. ");
			return;
		}
		
		Employee employee = new Employee();
		employee.setNo(no);
		
		if(dao.delete(employee)) {
			System.out.println("삭제 성공.");
		}else {
			System.out.println("삭제 실패.");
		}
		
	}// end of delete
	
	private void list() {
		System.out.println("사번    이름    전화번호");
		System.out.println("=======================");
		List<Employee> list = searchList("");
		for(Employee em : list) {
			System.out.println(em.showList());
		}

	}// end of list
	
	private void info() {
		String hiredate ="";
		while(true) {
			System.out.print("입사일자>> ");
			hiredate = scn.nextLine();
			if(!hiredate.isBlank()) {
				break;
			}
			System.out.println("입사일자를 반드시 입력하세요.");
		}
		System.out.println("사번    이름    입사일자");
		System.out.println("=======================");
		List<Employee> list = searchList(hiredate);
		for(Employee em : list) {
			System.out.println(em.showListHiredate());
		}

	}// end of info
	
	private List<Employee> searchList(String keyword){
		if (keyword.isEmpty()) {
	        return dao.list(); // 전체 목록 조회
	    } else {
	        return dao.list(keyword); // 특정 조건으로 조회
	    }
	} // end of searchList
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	    EmpApp app = EmpApp.getInstance(); // 인스턴스 생성
	    boolean run = true;
	    while(run) {
	        System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
	        System.out.print("선택>>");
	        
	        int menu = 6;
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
	        case 1:
	            app.add(); //등록
	            break;
	        case 2:
	            app.list(); // 목록
	            break;
	        case 3:
	            app.edit(); // 수정
	            break;
	        case 4:
	            app.delete(); // 삭제
	            break;
	        case 5:
	            app.info(); // 조회
	            break;
	        case 6:
	            System.out.println("프로그램 종료합니다.");
	            run = false;
	            break;
	        default:
	            System.out.println("메뉴를 다시 선택하세요.");
	        }
	    }
	}

}
