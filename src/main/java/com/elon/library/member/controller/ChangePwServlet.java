package com.elon.library.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.elon.library.member.model.service.MemberService;




/**
 * Servlet implementation class ChangePwServlet
 */
@WebServlet("/member/changePw")
public class ChangePwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mode", "verify");
		request.getRequestDispatcher("/WEB-INF/views/member/changePw.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberService();
		request.setCharacterEncoding("UTF-8");
		String step = request.getParameter("step");
		String memberId = (String) request.getSession().getAttribute("memberId");
//		세션 만료 등 이유로 로그인 정보가 없는 상태면 로그인 페이지로 이동
		if(memberId == null) {
			response.sendRedirect(request.getContextPath()+ "/member/login");
			return;
		}
//		비밀번호 검증
		try{
			if(step.equals("verify")) {
				String inputPassword = request.getParameter("inputPassword");
				boolean ok = mService.checkPassword(memberId, inputPassword);
				
//				확인결과 거짓이면
				if(!ok) {
					request.setAttribute("mode", "verify");
					request.setAttribute("error", "비밀번호가 올바르지 않습니다");
					request.getRequestDispatcher("/WEB-INF/views/member/changePw.jsp")
					.forward(request, response);
					return;
				}
//				 확인 결과 참이면 수정 페이지로
				request.setAttribute("mode", "edit");
				request.getRequestDispatcher("/WEB-INF/views/member/changePw.jsp")
				.forward(request, response);
			}
			
			if(step.equals("update")) {
				String newPw = request.getParameter("newPw");
				String checkPw = request.getParameter("checkPw");
				
//				두 비밀번호가 다르면
				if(!newPw.equals(checkPw)) {
					request.setAttribute("mode", "edit");
					request.setAttribute(newPw, "");
					request.setAttribute(checkPw, "");
					
					request.getRequestDispatcher("/WEB-INF/views/member/changePw.jsp")	
					.forward(request, response);
					
//				두 비밀번호가 같으면
				}else if(newPw.equals(checkPw)) {
					int result = mService.updatePw(memberId,newPw);
					if(result == 1) System.out.println("변경 성공");
					if(result != 1) System.out.println("변경 실패");
					request.getRequestDispatcher("/WEB-INF/views/member/recode.jsp")	
					.forward(request, response);
				}
			}
//		알 수 없는 step 이면 처음 화면으로
		}catch(Exception e) {
            throw new ServletException(e);
		}
	}
}
