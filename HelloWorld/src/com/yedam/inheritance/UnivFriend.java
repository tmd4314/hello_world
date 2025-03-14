package com.yedam.inheritance;
/*
 * 친구2 
 * Friend 상속.
 */
public class UnivFriend extends Friend{
	private String univName;
	private String major;
	public UnivFriend() {
		super();
	}
	public UnivFriend(String name, String tel, String univName, String major) {
		super(name, tel); //부모 생성자
		this.univName = univName;
		this.major = major;
	}
	// 부모의 메소드 -> 자식이 재정의. overriding.
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", 학과는 " + major + ", 학교는 " + univName;
	}
	
//	@Override
//	public void setName(String name) {
//		// 부모 final 메소드는 overriding 안됨.
//	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	public String getUnviName() {
		return univName;
	}
	public void setUnviName(String univName) {
		this.univName = univName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
