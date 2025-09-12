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
 * Servlet implementation class AdminPageBookDeleteServlet
 */
@WebServlet("/khlibary/admin/book/delete")
public class AdminPageBookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageBookDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookNo = request.getParameter("book_delete");
		BookService bService = new BookService();
		int result = bService.deleteBook(bookNo);
		if(result > 0) {
			
			request.setAttribute("errorMsg", "책 삭제 완료");
			System.out.println("삭제 완료");
			response.sendRedirect(request.getContextPath() + "/khlibary/admin/book/main");
		} else {
			request.setAttribute("errorMsg", "삭제 실패");
			System.out.println("삭제 실패");
			
			List<Book> booklist = bService.getAllBooks();
	        request.setAttribute("booklist", booklist);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-main.jsp");
			view.forward(request, response);
		}
		
	}

}
