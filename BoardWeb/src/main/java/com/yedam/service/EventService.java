package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVo;

public interface EventService {
	List<Map<String, Object>> eventListForDT();
	boolean addEvent(EventVo evo);
	boolean removeEvent(EventVo evo);
	
	//차트
	List<Map<String, Object>> cntPerWriter();
	//로그 생성.
	void logCreate(Map<String, String>map);
}
