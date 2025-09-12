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



/**
 * Servlet implementation class FindIdServlet
 */
@WebServlet("/khlibary/member/findid")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/findid.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		MemberService mService = new MemberService();
		String memberId = mService.FindID(memberName, memberPhone);
		System.out.println(memberName);
		System.out.println(memberPhone);
		System.out.println(memberId);
		
		if(memberId != null) {
			HttpSession session = request.getSession();
			session.setAttribute("resultMsg", "회원님의 아이디는 " + memberId + " 입니다");
			response.sendRedirect(request.getContextPath() +"/khlibary/member/findid");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "없는 회원 정보입니다.");
			response.sendRedirect(request.getContextPath() +"/khlibary/member/findid");
		}
	}
}
