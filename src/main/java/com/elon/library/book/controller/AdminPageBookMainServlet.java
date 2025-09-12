package com.elon.library.book.controller;

import java.io.IOException;
import java.util.List;

import com.elon.library.book.model.service.BookService;
import com.elon.library.book.model.vo.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageBookMainServlet
 */
@WebServlet("/khlibary/admin/book/main")
public class AdminPageBookMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageBookMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * 
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    	BookService bService = new BookService();
        List<Book> booklist = bService.getAllBooks();  
        request.setAttribute("booklist", booklist); 
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-main.jsp");
        view.forward(request, response);
    }
    
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookSearch = request.getParameter("bookSearch");
		String category = request.getParameter("select");
		BookService bService = new BookService();
		List<Book> booklist = bService.bookSearch(bookSearch, category);
		
		if (booklist == null || booklist.isEmpty()) {
			booklist = bService.getAllBooks();
			request.setAttribute("errorMsg", "검색결과가 없습니다.");
		} else if (bookSearch.isEmpty()) {
			request.setAttribute("errorMsg", "");
		}
		
		request.setAttribute("booklist", booklist);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-main.jsp");
		view.forward(request, response);
		
	}

}

