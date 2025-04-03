package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.vo.MemberVo;

// 업무프로세스(service)
public interface MemberService {
	// 로그인
	MemberVo login(String id, String pw);
	
	MemberVo member(String id);
	
	//회원가입
	boolean addMember(MemberVo member);
	
	boolean chpassword(MemberVo member);
}
