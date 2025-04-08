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

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVo board = mapper.infoBoard(Integer.parseInt(bno));
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("board/boardInfo2.tiles").forward(req, resp);
	}
	
}
