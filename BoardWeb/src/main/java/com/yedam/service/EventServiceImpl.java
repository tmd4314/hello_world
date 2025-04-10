package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVo;

// ReplyService 인터페이스를 구현하는 클래스.
public class EventServiceImpl implements EventService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
	@Override
	public boolean addEvent(EventVo evo) {
		return mapper.insertEvent(evo) == 1;
	}

	@Override
	public List<Map<String, Object>> eventListForDT() {
		return mapper.selectListForDT();
	}

	@Override
	public boolean removeEvent(EventVo evo) {
		return mapper.deleteEvent(evo) == 1;
	}

	@Override
	public List<Map<String, Object>> cntPerWriter() {
		return mapper.selectWriter();
	}

	@Override
	public void logCreate(Map<String, String> map) {
		mapper.insertLogging(map);
	}
	
	
}
