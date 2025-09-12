package com.elon.library.lend.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.elon.library.lend.model.service.RentService;
import com.elon.library.lend.model.vo.Rent;


/**
 * Servlet implementation class CurrentServlet
 */
@WebServlet("/member/current")
public class CurrentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RentService rService = new RentService();
		HttpSession session = request.getSession(false);
		String memberId = (String) session.getAttribute("memberId");
    	String type = request.getParameter("recodeSelect");
    	String searchKey = request.getParameter("searchKey");
    	int pageNo = 2;
    	if (type == null ) type = "";
    	if (searchKey == null) searchKey = "";
		List<Rent> rList = rService.getRentList(memberId,type,searchKey,pageNo);
		
		System.out.println(rList);
		request.setAttribute("rList", rList);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/current.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
