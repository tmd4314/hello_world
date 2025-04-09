package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardAddControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.ELDatatable;
import com.yedam.control.EventAddControl;
import com.yedam.control.EventFormControl;
import com.yedam.control.JsControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RLDatatable;
import com.yedam.control.RemoveEvent;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.memberFormControl;
import com.yedam.control.passWordControl;

// *.do의 요청에 실행.
public class FrontController extends HttpServlet {
	// 요청url <=> 실행컨트롤.
	Map<String, Control> map;
	
	// 생성자.
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/board.do", new BoardControl()); // 상세화면.
		map.put("/boardList.do", new BoardListControl()); // 목록.
		map.put("/addBoard.do", new BoardAddControl());// 글등록.
		map.put("/modifyForm.do", new ModifyFormControl()); //수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); //수정처리
		map.put("/deleteForm.do", new DeleteFormControl());
		map.put("/deleteBoard.do", new DeleteBoardControl());
		//로그인 관련.
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/main.do", new MainControl());
		map.put("/signForm.do", new SignUpControl());
		map.put("/signUp.do", new SignUpControl());	;
		//회원 수정.
		map.put("/memberForm.do", new memberFormControl()); //회원 화면
		map.put("/passwordForm.do", new passWordControl());
		//자바스크립트
		map.put("/javascript.do", new JsControl());
		//댓글관련.
		map.put("/replyList.do", new ReplyListControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/replyCount.do", new ReplyCountControl());
		map.put("/replyListDatatable.do", new RLDatatable());
		// fullcalendar 관련.
		map.put("/eventForm.do", new EventFormControl());
		map.put("/addEvent.do", new EventAddControl());
		map.put("/eventListDatatable.do", new ELDatatable());
		map.put("/removeEvent.do", new RemoveEvent());
	}
	//service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url vs uri
		// http://localhost:8080/BoardWeb/board.do
		String uri = req.getRequestURI();
		//System.out.println("요청 URI: " + uri); // /BoardWeb/board.do
		String context = req.getContextPath();
		String page = uri.substring(context.length()); // "/board.do"
		System.out.println(page);
		
		Control sub = map.get(page);// 키(url) => control 반환.
		sub.exec(req, resp);
	}
}
