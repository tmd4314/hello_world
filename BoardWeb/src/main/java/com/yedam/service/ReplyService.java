package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.ReplyVo;

public interface ReplyService {
	List<ReplyVo> replyList(SearchDTO search);
	boolean addReply(ReplyVo rvo);
	boolean removeReply(int replyNo);
	ReplyVo getReply(int replyNo);
	int getTotalCnt(int boardNo);
	List<Map<String, Object>> replyListForDT(int boardNo);
}
