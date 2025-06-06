package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVo;

// 업무(service 구현객체)
public class MemberServiceImpl implements MemberService{

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVo login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
	
	@Override
	public MemberVo member(String id) {
		return mapper.selectId(id);
	}
	
	@Override
	public boolean addMember(MemberVo member) {
		return mapper.insertMember(member) == 1;
	}
	
	@Override
	public boolean chpassword(MemberVo member) {
		return mapper.updateMember(member) == 1;
	}
	
}
