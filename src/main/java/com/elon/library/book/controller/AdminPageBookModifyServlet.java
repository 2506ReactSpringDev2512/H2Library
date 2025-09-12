package com.elon.library.book.controller;

import jakarta.servlet.RequestDispatcher;
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
 * Servlet implementation class AdminPageBookModifyServlet
 */
@WebServlet("/khlibary/admin/book/modify")
public class AdminPageBookModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageBookModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-modify.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String originalBookName = request.getParameter("bookName");          
		String newBookName = request.getParameter("modify_bookName");      
		String newAuthor = request.getParameter("modify_bookAuthor");      
		String newPublisher = request.getParameter("modify_bookPublisher");  
		String newLendStatus = request.getParameter("modifyBook_status");  
		
		Book book = new Book();
		book.setBook_Name(newBookName);         
		book.setBook_Author(newAuthor);
		book.setBook_Publisher(newPublisher);
		book.setLend_YN(newLendStatus);
		book.setModify_Book(originalBookName);
 		BookService bService = new BookService();
		int result = bService.modifyBook(book);
	
		if(result > 0) {
			request.setAttribute("errorMsg", "책 수정 완료");
			System.out.println("수정 완료");
			response.sendRedirect(request.getContextPath() + "/khlibary/admin/book/main");
		} else {
			request.setAttribute("errorMsg", "책 수정 실패");
			System.out.println("수정 실패");
			
			List<Book> booklist = bService.getAllBooks();
	        request.setAttribute("booklist", booklist);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-book-modify.jsp");
			view.forward(request, response);
		}
		
	}

}
