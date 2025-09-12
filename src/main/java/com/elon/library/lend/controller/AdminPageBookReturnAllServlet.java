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
 * Servlet implementation class AdminPageBookReturnServlet
 */
@WebServlet("/khlibary/admin/bookrental/return")
public class AdminPageBookReturnAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageBookReturnAllServlet() {
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
	/* 전체목록에서 반납 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookNo = request.getParameter("bookNo_return");
		RentService btService = new RentService();
		int result = btService.UpdateBookRental(bookNo);
		if(result > 0) {
			System.out.println("책 반납 완료");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-bookRental-Search.jsp");
			view.forward(request, response);
		} else {
			System.out.println("책 반납 실패");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-bookRental-Search.jsp");
			view.forward(request, response);
		}
		doGet(request, response);
	}

}
