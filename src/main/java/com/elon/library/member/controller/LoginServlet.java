package com.elon.library.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.elon.library.member.model.service.MemberService;
import com.elon.library.member.model.vo.Member;





/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		MemberService mService = new MemberService();
		Member member = new Member(memberId,memberPw);
		
		member = mService.checkLogin(member );
		if(member != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", member.getMemberId());
			session.setAttribute("memberName", member.getMemberName());
			session.setAttribute("adminYn", member.getAdmin_YN()); 
			session.setAttribute("memberActive", member.getMember_Active());
			
			
			if("Y".equals(member.getAdmin_YN())) {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-main.jsp");
				view.forward(request, response);
				System.out.println("관리자 성공" + memberId);
			} else if ("N".equals(member.getMember_Active())) {
				request.setAttribute("errorMsg", "비활성 계정입니다 관리자에게 문의 바랍니다.");
				System.out.println("비활성화 계정");
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
				view.forward(request, response);
				
			} else {
				response.sendRedirect("/");
				System.out.println("일반 회원 성공" + memberId);
			}
		} else {
			request.setAttribute("errorMsg", "계정이 옳바르지 않습니다.");
			System.out.println("로그인 실패");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
			view.forward(request, response);
		}
	}

}
