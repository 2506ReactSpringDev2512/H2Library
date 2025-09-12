package com.elon.library.book.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.elon.library.book.model.service.BookService;
import com.elon.library.book.model.vo.Book;



/**
 * Servlet implementation class listServlet
 */
@WebServlet("/book/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final BookService bService = new BookService();
//	private static final int PAGE_SIZE = 20;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//    	페이지의 파라미터들 가져오기
    	String type = request.getParameter("type");
    	String searchKey = request.getParameter("searchKey");
    	String pageParam = request.getParameter("page");// 페이지네이션 구현을 위한 파라미터
    	
    	if (type == null ) type = "bookName";
    	if (searchKey == null) searchKey = "";
    	int page = 1;
    	try {page = Integer.parseInt(pageParam);}catch(Exception ignore) {}//getParameter는 항상 String만 가져오니 숫자 변환
    	
//    	총 행의 개수
    	int totalCount = bService.count(type,searchKey);
    	
//    	총 페이지
    	int size = BookService.PAGE_SIZE;
    	int totalPages = (int) Math.ceil(totalCount/(double) size);
    	if(totalPages == 0 ) totalPages = 1; //결과가 없더라도 페이지는 표시되도록 하한선 설정
    	
//    	페이지 보정
    	if(page < 1)page = 1;
    	if(page > totalPages)page = totalPages;
    	
//    	헤당 페이지 데이터
    	List<Book>bList = bService.selectPage(type, searchKey, page);
    	
//    	JSP로 전달
    	request.setAttribute("bList", bList);
    	request.setAttribute("type", type);
    	request.setAttribute("searchKey", searchKey);
    	request.setAttribute("page", page);
    	request.setAttribute("size", size);
    	request.setAttribute("totalCount", totalCount);
    	request.setAttribute("totalPages", totalPages);
    	
    	request.getRequestDispatcher("/WEB-INF/views/book/list.jsp")
    	.forward(request, response);

    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
