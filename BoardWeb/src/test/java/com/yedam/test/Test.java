package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVo;

public class Test {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		ReplyVo rvo = new ReplyVo();
		rvo.setBoardNo(602);
		rvo.setReply("댓글테스트");
		rvo.setReplyer("yyh4310");
		
		int cnt = mapper.deleteReply(2222);
		if(cnt > 0) {
			System.out.println("등록 성공");
		}
		
		List<ReplyVo> list = mapper.selectList(603);
		for(ReplyVo reply : list) {
			System.out.println(reply.toString());
		}
	}
}
