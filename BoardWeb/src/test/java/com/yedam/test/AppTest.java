package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

public class AppTest {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		
		BoardVo board = new BoardVo();
		board.setTitle("메퍼테스토44");
		board.setContent("메퍼를 활용한 입력테스트");
		board.setWriter("newbie");
		board.setBoardNo(4);
		
		try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			
			int r = mapper.insertBoard(board);
			//sqlSession.update("com.yedam.mapper.BoardMapper.deleteBoard", board);
			if(r==1) {
				System.out.println("등록성공.");
				sqlSession.commit();
			}else{
				System.out.println("등록실패.");
			}
			List<BoardVo> list = mapper.selectBoard();
			//sqlSession.selectList("com.yedam.mapper.BoardMapper.selectBoard");
			for(BoardVo brd: list) {
				System.out.println(brd.toString());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
