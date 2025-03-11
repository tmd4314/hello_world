package com.yedam.variable;

public class Member {
	//클래스: 필드(값을 저장)
	private String name;
	private int score;
	// 클래스: 생성자(실체생성)
	//컴파일러 기본 생성자 생성.
	// 생성자 overloading.
	public Member() {
		
	}
	public Member(String name, int score) {
		this.name = name;
		this.score = score;
		
	}
	// 클래스: 메소드(기능) = 반환값 메소드명 (매개값)
	public void showInfo() {
		System.out.println("이름은 " + name + ", 점수는 " + score);
	}
	public void setMember(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score < 0 ||score > 100) {
			System.out.println("적정값을 입력하세요.");
			return; // 메소드의 종료.
		}
		this.score = score;
	}
}
