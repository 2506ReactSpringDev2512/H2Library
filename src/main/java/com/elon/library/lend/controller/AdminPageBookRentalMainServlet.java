package com.elon.library.lend.controller;

import java.io.IOException;
import java.util.List;

import com.elon.library.lend.model.service.RentService;
import com.elon.library.lend.model.vo.Rent;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageBookRentalMainServlet
 */
@WebServlet("/khlibary/admin/bookrental/main")
public class AdminPageBookRentalMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageBookRentalMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-bookRental-main.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberIdSearch");
		RentService btService = new RentService();
		List<Rent> btList = btService.RentalInfoById(memberId);
		request.setAttribute("bookRentalInfo", btList);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-bookRental-main.jsp");
		view.forward(request, response);
	}

}
