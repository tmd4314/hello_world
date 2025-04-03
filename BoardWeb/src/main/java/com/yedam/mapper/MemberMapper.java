package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVo;

public interface MemberMapper {
	//아이디&비밀번호 단건조회.
	MemberVo selectMember(@Param("id") String id, @Param("pw") String pw);
	MemberVo selectId(@Param("id") String id);
	int insertMember(MemberVo member);  // 입력.
	int updateMember(MemberVo member);
}