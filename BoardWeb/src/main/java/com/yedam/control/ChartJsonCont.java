package com.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;

public class ChartJsonCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/json;charset=utf-8");
		
		EventService evc = new EventServiceImpl();
		List<Map<String, Object>> list = evc.cntPerWriter();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		resp.getWriter().print(json);
	}

}
