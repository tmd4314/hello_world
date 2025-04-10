package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;
import com.yedam.vo.EventVo;

public class RemoveEvent implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("application/json; charset=UTF-8"); // ContentType 설정
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		EventVo event = new EventVo();
		event.setTitle(title);
		event.setStart(start);
		event.setEnd(end);
		
		Gson gson = new GsonBuilder().create();
		Map<String, Object> map = new HashMap<>();
		
		EventService evc = new EventServiceImpl();
		if(evc.removeEvent(event)) {
			map.put("retCode", "OK");
			map.put("retVal", event);
		}else {
			map.put("retCode", "NG");
		}
		String json = gson.toJson(map);
		resp.getWriter().print(json);
	}
}
