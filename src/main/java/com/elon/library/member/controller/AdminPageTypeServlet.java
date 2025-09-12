package com.elon.library.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AdminPageType
 */
@WebServlet("/khlibary/admin/pagetype")
public class AdminPageTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageType = request.getParameter("action");

		if ("수정".equals(pageType)) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-modify.jsp");
			view.forward(request, response);
		} else if ("추가".equals(pageType)) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-add.jsp");
			view.forward(request, response);
		} else if ("도서수정".equals(pageType)) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-modify.jsp");
			view.forward(request, response);
		} else if("도서추가".equals(pageType)) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-add.jsp");
			view.forward(request, response);
		}
	}

}
