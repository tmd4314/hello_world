package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVo;

public interface ReplyService {
	List<ReplyVo> replyList(int boardNo);
	boolean addReply(ReplyVo rvo);
	boolean removeReply(int replyNo);
	ReplyVo getReply(int replyNo);
}
