package com.elon.library.member.controller;

import java.io.IOException;

import com.elon.library.member.model.service.MemberService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageDeleteServlet
 */
@WebServlet("/khlibary/admin/delete")
public class AdminPageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		MemberService mService = new MemberService();
		int result = mService.memberDelete(memberId);
		if(result > 0) {
			request.setAttribute("errorMsg", "회원 삭제 완료");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-main.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "회원 삭제 실패");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-main.jsp");
			view.forward(request, response);
		}
	}

}
