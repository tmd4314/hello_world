package com.yedam.mapper;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVo;

/*
 * 인터페이스(메소드 정의) - 구현클래스(메소드 구현)
 */
public interface BoardMapper {
	//목록.
	List<BoardVo> selectBoard(SearchDTO search);
	//등록.
	int insertBoard(BoardVo board);
	//수정.
	int updateBoard(BoardVo board);
	//삭제.
	int deleteBoard(int BoardNo);
	//상세 조회.
	BoardVo infoBoard(int BoardNo);
	//전체건수.
	int selectTotal(SearchDTO search);
}
