package com.elon.library.member.controller;

import java.io.IOException;

import com.elon.library.member.model.service.MemberService;
import com.elon.library.member.model.vo.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageAddServlet
 */
@WebServlet("/khlibary/admin/add")
public class AdminPageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-add.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("newId");
		String memberPw = request.getParameter("newPassword");
		String memberName = request.getParameter("newName");
		String memberPhone = request.getParameter("newPhone");
		String gender = request.getParameter("newGender");
		int age = Integer.parseInt(request.getParameter("newAge"));
		
		Member member = new Member(memberId, memberPw, memberName, memberPhone, gender, age);
		MemberService mService = new MemberService();
		int result = mService.memberAdd(member);
		if (result > 0) {
			request.setAttribute("errorMsg", "추가 성공");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-main.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "추가 실패 \n 정보를 옳바르게 입력해주세요.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-add.jsp");
			view.forward(request, response);
		}
	}
}
