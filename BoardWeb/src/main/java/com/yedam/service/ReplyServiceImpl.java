package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVo;

// ReplyService 인터페이스를 구현하는 클래스.
public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVo> replyList(SearchDTO search) {
		return mapper.selectList(search);
	}

	@Override
	public boolean addReply(ReplyVo rvo) {
		return mapper.insertReply(rvo) == 1;
	}

	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}

	@Override
	public ReplyVo getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}

	@Override
	public int getTotalCnt(int boardNo) {
		return mapper.selectReplyCnt(boardNo);
	}

	@Override
	public List<Map<String, Object>> replyListForDT(int boardNo) {
		return mapper.selectListForDT(boardNo);
	}
	
}
