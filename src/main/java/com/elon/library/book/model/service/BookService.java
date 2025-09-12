package com.elon.library.book.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elon.library.book.model.dao.BookDAO;
import com.elon.library.book.model.vo.Book;
import com.elon.library.common.TeamH2Template;



public class BookService {
	private TeamH2Template h2Template;
	private BookDAO bDao;
	
	public BookService() {
		h2Template = TeamH2Template.getInstance();
		bDao = new BookDAO();
	}

	public List<Book> bookSearch(String bookSearch, String category) {
		// TODO Auto-generated method stub
		List<Book> booklist = null;
		try {
			Connection conn = h2Template.getConnection();
			booklist = bDao.bookSearch(bookSearch, category, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> bookAllList = null;
		try {
			Connection conn = h2Template.getConnection();
			bookAllList = bDao.getAllBook(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookAllList;
	}

	public int deleteBook(String bookNo) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = h2Template.getConnection();
			result = bDao.deleteBook(bookNo, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int addBook(Book book) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = h2Template.getConnection();
			result = bDao.addBook(book, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
		
	/* user */
	//  한 페이지에 10개
	public static final int PAGE_SIZE = 10;
	
	public int count(String type,String searchKey) {
		try(
			Connection conn = h2Template.getConnection()){
			return bDao.count(type,searchKey ,conn);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Book> selectPage(String type, String searchKey,int page){
		try(
			Connection conn = h2Template.getConnection()){
			return bDao.selectPage(type, searchKey, page, PAGE_SIZE, conn);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int modifyBook(Book book) {
		int result = 0;
		Connection conn = h2Template.getConnection();
		try {
			result = bDao.modifyBook(book, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return result;
	}
}

	
