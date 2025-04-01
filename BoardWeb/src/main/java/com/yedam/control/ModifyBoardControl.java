package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.common.PageDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno=15&title=바뀐값&content=바뀐값 수정후 목록이동.
		req.setCharacterEncoding("UTF-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		// 매개값.
		BoardVo board = new BoardVo();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		// mybatis를 활용해서 jdbc 처리.
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int r = mapper.updateBoard(board);
		req.setAttribute("page", page);
		if(r > 0 ) {
			resp.sendRedirect("boardList.do?page=" + page); //요청재지정.
		}else {
			System.out.println("게시글 수정 실패");
		}
		
	}

}
