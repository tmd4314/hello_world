package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

public class BoardListControl implements Control {
	
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//para,eter.
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		SearchDTO search = new SearchDTO();
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		search.setKeyword(kw);
		
		// 글 목록 정보 -> jsp
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardVo> list = mapper.selectBoard(search);
		req.setAttribute("blist", list);
		
		int totalCnt = mapper.selectTotal(search);
		PageDTO pageDTO = new PageDTO(totalCnt, Integer.parseInt(page));
		req.setAttribute("paging", pageDTO);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		// boardList.do -> jsp 출력 : 페이지재지정.
		req.getRequestDispatcher("board/boardList2.tiles").forward(req, resp);
		
	}
}
