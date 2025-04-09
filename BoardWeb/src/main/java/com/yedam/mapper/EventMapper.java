package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVo;
import com.yedam.vo.EventVo;

public interface EventMapper {
	List<Map<String, Object>> selectListForDT();
	int insertEvent(EventVo evo); //이벤트 등록.
	int deleteEvent(EventVo evo); // 이벤트 삭제.
}
