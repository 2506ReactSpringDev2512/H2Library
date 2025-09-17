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
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/member/recode")
public class RecodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RentService rService = new RentService();
    	String pageParam = request.getParameter("page"); //페이지 네이션을 위한 파라미터
    	String type = request.getParameter("recodeSelect");
    	String searchKey = request.getParameter("searchKey");
    	int page = 1;
    	int pageNo = 1;
		HttpSession session = request.getSession(false);//세션 가져오는 역할
		String memberId = (String) session.getAttribute("memberId");
    	if (type == null ) type = "";
    	if (searchKey == null) searchKey = "";
    	try {page = Integer.parseInt(pageParam);
    	}catch(Exception ignore) {}
//    	총 행의 갯수
    	int totalCount = rService.count(memberId,type,searchKey,pageNo);
//    	총 페이지
    	int size = RentService.PAGE_SIZE;//여긴 왜 rService를 쓰면 안됬을까?
    	int totalPages = (int) Math.ceil(totalCount/(double) size);
    	if(totalPages == 0) totalPages = 1;//검색 결과가 없어도 페이지는 구현되게 /안그러면 레코드 페이지 구현이 안됨
//    	페이지 보정
    	if(page <1)page =1;
    	if(page>totalPages)page = totalPages;
//    	해당 페이지 데이터 
		List<Rent> rList = rService.getRentList(memberId,type,searchKey,page,pageNo);
		
//		jsp로 전달
		request.setAttribute("rList", rList);
    	request.setAttribute("type", type);
    	request.setAttribute("searchKey", searchKey);
    	request.setAttribute("page", page);
    	request.setAttribute("size", size);
    	request.setAttribute("totalCount", totalCount);
    	request.setAttribute("totalPages", totalPages);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/recode.jsp");
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
