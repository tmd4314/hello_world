package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVo;

public interface MemberMapper {
	MemberVo selectMember(@Param("id") String id, @Param("pw") String pw);
}
