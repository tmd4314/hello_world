package com.yedam.inheritance;

public class CompanyFriend extends Friend{
	private String company;
	private String dept;
	public CompanyFriend() {
		super();
	}
	
	public CompanyFriend(String name, String tel, String company, String dept) {
		super(name, tel);
		this.company = company;
		this.dept = dept;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", 회사는 " + company + ", 부서는 " + dept;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
