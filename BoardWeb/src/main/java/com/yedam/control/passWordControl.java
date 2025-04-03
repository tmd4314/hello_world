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

public class passWordControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currentPw = req.getParameter("userPw");
        String newPw = req.getParameter("newPw");
        // 2. 세션에서 사용자 ID 가져오기
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("logId");

        // 3. MemberService 객체 생성
        MemberService memberService = new MemberServiceImpl();

        // 4. DB에서 사용자 정보 가져오기
        MemberVo member = memberService.member(userId);

        // 5. 현재 비밀번호와 DB 비밀번호 비교
        if (member != null && member.getPassword().equals(currentPw)) {
                // 7. 비밀번호 변경 로직
                member.setPassword(newPw);; // 새 비밀번호 설정
                boolean isUpdated = memberService.chpassword(member); // 회원 정보 업데이트

                if (isUpdated) {
                    // 비밀번호 변경 성공
                	req.getRequestDispatcher("member/loginForm.tiles").forward(req, resp); 
                } else {
                    // 비밀번호 변경 실패
                    req.setAttribute("msg", "현재 비밀번호 변경에 실패했습니다.");
                }
        }else {
        	req.setAttribute("msg", "현재 비밀번호가 틀렸습니다.");
        	req.getRequestDispatcher("member/memberForm.tiles").forward(req, resp);
        }
    }

}
