package com.elon.library.lend.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.elon.library.lend.model.service.RentService;



/**
 * Servlet implementation class rentServlet
 */
@WebServlet("/rent/rent")
public class RentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RentService rService = new RentService();
		String bookNo = request.getParameter("bookNo");
		String memberId = request.getParameter("memberId");
		int result = rService.rentBook(bookNo, memberId);
		if (result == 2 ) {
//			request.getSession().setAttribute("flash", "대여 완료!");
		} else {
//		    request.getSession().setAttribute("flash", "대여 실패!");
		}
//		response.sendRedirect(request.getContextPath() + "/book/list");
		response.sendRedirect(request.getContextPath() + "/book/list");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
