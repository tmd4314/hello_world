package com.yedam.classes;

public class List {
	public String name;
	public String number;
	public int age;
	List() {}
	public List(String un, String nb, int ag){
		name = un;
		number = nb;
		this.age = ag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
