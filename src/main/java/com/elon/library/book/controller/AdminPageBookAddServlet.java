package com.elon.library.book.controller;

import java.io.IOException;

import com.elon.library.book.model.service.BookService;
import com.elon.library.book.model.vo.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageBookAddServlet
 */
@WebServlet("/khlibary/admin/book/add")
public class AdminPageBookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageBookAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-add.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookNo = request.getParameter("add_bookNo");
		String bookName = request.getParameter("add_bookName");
		String bookAuthor = request.getParameter("add_bookAuthor");
		String bookPublisher = request.getParameter("add_bookPublisher");
		BookService bService = new BookService();
		Book book = new Book(bookNo, bookName, bookAuthor, bookPublisher);
		int result = bService.addBook(book);
		if(result > 0) {
			request.setAttribute("errorMsg", "도서 추가 완료");
			System.out.println("도서 추가 성공");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-main.jsp");
			view.forward(request, response);
		} else {
			System.out.println("도서 추가 실패");
			request.setAttribute("errorMsg", "도서 추가 실패");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-add.jsp");
			view.forward(request, response);
		}

	}

}
