package com.elon.library.lend.controller;

import java.io.IOException;

import com.elon.library.lend.model.service.RentService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageBookReturnMainServlet
 */
@WebServlet("/khlibary/admin/bookrental/main/return")
public class AdminPageBookReturnMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageBookReturnMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* 대여 관리 아이디로 반납 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookNo = request.getParameter("bookNo_return");
		String memberId = request.getParameter("member_ID");
		RentService btService = new RentService();
		int result = btService.MemberBookRentalReturn(bookNo, memberId);
		if(result > 0) {
			System.out.println("반납 성공");
			System.out.println(memberId);
			System.out.println(bookNo);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-bookRental-main.jsp");
			view.forward(request, response);
		} else {
			System.out.println("반납 실패");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-bookRental-main.jsp");
			view.forward(request, response);
		}
		
	}

}
