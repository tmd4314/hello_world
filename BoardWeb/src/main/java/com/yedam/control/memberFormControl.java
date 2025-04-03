package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVo;

public class memberFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("logId");
		System.out.println(id);
		
		MemberService svc = new MemberServiceImpl();
		MemberVo mvo = svc.member(id);
		req.setAttribute("member", mvo);
		
		req.getRequestDispatcher("member/memberForm.tiles").forward(req, resp);
	}

}
