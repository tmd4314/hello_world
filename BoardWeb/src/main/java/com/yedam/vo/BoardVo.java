package com.yedam.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// lombok 설치 & 라이브러리 다운로드.
@Getter
@Setter
@ToString

public class BoardVo {
	private int boardNo; // board_no -> 오라클, boardNo -> 자바 
	private String title;
	private String content;
	private String writer;
	private Date writeDate; 
}
