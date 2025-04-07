package com.yedam.vo;

import java.util.Date;

import lombok.Data;


@Data
public class ReplyVo {
	private int replyNo;
	private String reply;
	private String replyer;
	private Date replyDate;
	private int boardNo;
}
