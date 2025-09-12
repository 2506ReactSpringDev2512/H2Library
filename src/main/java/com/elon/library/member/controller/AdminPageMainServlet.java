package com.elon.library.member.controller;

import java.io.IOException;
import java.util.List;

import com.elon.library.member.model.service.MemberService;
import com.elon.library.member.model.vo.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageMain
 */
@WebServlet("/khlibary/admin/main")
public class AdminPageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberService mService = new MemberService();
		List<Member> mList = mService.getAllMember();
		request.setAttribute("mList", mList);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-main.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberIdSearch");
		MemberService mService = new MemberService();
		Member member = mService.memberSearch(memberId);
		
		if(member != null) {
		    request.setAttribute("member", member);
		    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-main.jsp");
	        view.forward(request, response);
		} else {
		    request.setAttribute("member", null);
		    request.setAttribute("errorMsg", "회원 정보가 없습니다.");
		    List<Member>mList = mService.getAllMember();
		    request.setAttribute("mList", mList);
		    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-main.jsp");
	        view.forward(request, response);
		}
	}
}
