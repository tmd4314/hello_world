package com.yedam.bookApp;

public class Book {
	private String title;
	private String author;
	private String company;
	private int price;
	private int orderNo;
	private String bookCode;
	
	//생성자.
	public Book() {}
	public Book(String title, String author, String company, int price) {
		this.title = title;
		this.author = author;
		this.company = company;
		this.price = price;
	}
	
	public Book(String title, String author, String company, int price, int orderNo) {
//		this.title = title;
//		this.author = author;
//		this.company = company;
//		this.price = price;
		this(title, author, company, price); // this: 생성된 인스턴스.
		this.orderNo = orderNo;
	}
	//메소드
	public String showList() {
		return bookCode + " " + title + " " + author + " " + price;
	}
	public String showListWithNo() {
		return orderNo + " " + title + " " + author + " " + price;
	}
	public String showBookInfo() {
		String msg ="제목은 " + title + "/ 저자는 "+ author + "\n출판사는 " + company + "/ 가격은 " + price;
		return msg;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getCompany() {
		return company;
	}
	public int getPrice() {
		return price;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setTitle(String title) {
		//this는 클래스안에 있는 필드들
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
