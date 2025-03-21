package com.yedam.java_test;

public class Employee {
	private String no;
	private String name;
	private String phone;
	private String hiredate;
	private int salary;
	
	public Employee() {}
	public Employee(String no ,String name, String phone, String hiredate, int salary) {
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.hiredate = hiredate;
		this.salary = salary;
	}
	//메소드
	public String showListHiredate() {
		String datePart = hiredate.split(" ")[0]; // 날짜 부분만 추출
		return no + " " + name + "  " + datePart;
	}
	public String showList() {
		return no + " " + name + "   " + phone;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
