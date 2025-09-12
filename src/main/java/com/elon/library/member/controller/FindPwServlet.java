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
 * Servlet implementation class FindPwServlet
 */
@WebServlet("/khlibary/member/findpw")
public class FindPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/findPassword.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		int memberAge =  Integer.parseInt(request.getParameter("Age")); 
		String memberPhone = request.getParameter("memberPhone");
		MemberService mService = new MemberService();
		Member member = new Member(memberId, memberName, memberPhone, memberAge);
		member = mService.findPw(member);
		System.out.println(memberId);
		System.out.println(memberName);
		System.out.println(memberAge);
		System.out.println(memberPhone);
		
		// FindIdServlet.doPost
		if(member != null) {
		    HttpSession session = request.getSession();
		    session.setAttribute("resultMsg", "회원님의 비밀번호는 " + member.getMemberPw() + " 입니다");
		    response.sendRedirect(request.getContextPath() +"/khlibary/member/findpw");
//		    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/findPassword.jsp")
		} else {
		    HttpSession session = request.getSession();
		    session.setAttribute("errorMsg", "회원정보가 없습니다.");
		    response.sendRedirect(request.getContextPath() +"/khlibary/member/findpw");
		}

	}

}
