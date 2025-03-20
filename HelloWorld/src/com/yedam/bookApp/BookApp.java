package com.yedam.bookApp;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * 실행클래스(main 메소드)
 */
public class BookApp {
	public static void main(String[] args) {
		
//		MemberJdbc dao = new MemberJdbc();
//		List<Map<String, String>> list = dao.memberList();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(list);
		//System.out.println(json);
		

		// singleton 객체 호출.
		BookMain mainApp1 = BookMain.getInstance();
		mainApp1.main(args);
		
//		BookMain mainApp2 = BookMain.getInstance();
//		mainApp1.add();
//		mainApp1.list();
//		
//		mainApp2.list();
		
		
		
		
	}
}