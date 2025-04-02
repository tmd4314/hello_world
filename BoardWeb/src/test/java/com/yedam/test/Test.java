package com.yedam.test;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVo;

public class Test {
	public static void main(String[] args) {
		MemberService svc = new MemberServiceImpl();
		
		MemberVo member = svc.login("tmd4314", "dltmdals1@");
		System.out.println(member.toString());
	}
}
