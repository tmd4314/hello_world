package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ReplyVo;

// 댓글목록, 등록, 삭제, 단건조회.
public interface ReplyMapper {
	List<ReplyVo> selectList(SearchDTO search); //댓글목록.
	int insertReply(ReplyVo rvo); //댓글등록.
	int deleteReply(int replyNo); //댓글삭제.
	ReplyVo selectReply(int replyNo); //단건조회.
	int selectReplyCnt(int boardNo);
	List<Map<String, Object>> selectListForDT(int boardNo);
}
