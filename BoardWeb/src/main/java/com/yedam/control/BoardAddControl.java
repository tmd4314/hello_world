package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

public class BoardAddControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if(req.getMethod().equals("GET")) {
			//요청 재지정. // url에 직접 입력, 링크 => get방식 요청.
			req.getRequestDispatcher("/WEB-INF/views/addForm.jsp").forward(req, resp);
		}else if(req.getMethod().equals("POST")){
			//등록.
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			BoardVo board = new BoardVo();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			
			// mybatis를 활용해서 jdbc 처리.
			SqlSession sqlSession = DataSource.getInstance().openSession(true);
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			int r = mapper.insertBoard(board);
			if(r > 0 ) {
				resp.sendRedirect("boardList.do"); //요청재지정.
			}else {
				System.out.println("게시글 등록 실패");
			}
			
		}
	}
}
