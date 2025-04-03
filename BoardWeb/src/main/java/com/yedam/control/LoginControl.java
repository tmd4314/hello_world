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

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터
		String id = req.getParameter("uname");
		String pw = req.getParameter("psw");
		
		MemberService svc = new MemberServiceImpl();
		MemberVo mvo = svc.login(id, pw);
		
		if(mvo == null) {
			req.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/views/member/loginForm.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("logId", id); //세션객체의 attr에 저장.
			session.setAttribute("pwd", pw); //세션객체의 attr에 저장.
			session.setAttribute("userName",mvo.getUserName()); //세션객체의 attr에 저장.
			session.setAttribute("responsibility",mvo.getResponsibility()); //세션객체의 attr에 저장.
			session.setAttribute("img",mvo.getImages()); //세션객체의 attr에 저장.
			
			if(mvo.getResponsibility().equals("User")) {
//				resp.sendRedirect("main.do");
				req.getRequestDispatcher("board/main.tiles").forward(req, resp);
			} else if(mvo.getResponsibility().equals("Admin")) {
				req.getRequestDispatcher("manager/main.tiles").forward(req, resp);
			}
			
		}
	}

}
