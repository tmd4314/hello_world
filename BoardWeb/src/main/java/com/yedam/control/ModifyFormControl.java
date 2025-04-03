package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

public class ModifyFormControl implements Control{
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno = 15 단건조회. modifyBoard.jsp
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVo board = mapper.infoBoard(Integer.parseInt(bno));
		
		// 권한체크. 
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		
		if(logId != null && logId.equals(board.getWriter())) {
			req.getRequestDispatcher("board/modifyBoard.tiles").forward(req, resp);
		} else {
			req.setAttribute("msg", "권한이 없습니다");
			req.getRequestDispatcher("common/boardInfo.tiles").forward(req, resp);
		}
	}
}
