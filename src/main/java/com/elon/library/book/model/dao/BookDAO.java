package com.elon.library.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elon.library.book.model.vo.Book;




public class BookDAO {
		
	public List<Book> bookSearch(String bookSearch, String category, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Book> booklist = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK_TBL WHERE " + category + " LIKE ? ORDER BY BOOK_NAME";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, "%" + bookSearch + "%");
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			Book book = new Book();
			book.setBook_No(rset.getString("BOOK_NO"));
			book.setBook_Author(rset.getString("BOOK_AUTHOR"));
			book.setBook_Publisher(rset.getString("BOOK_PUBLISHER"));
			book.setBook_Name(rset.getString("BOOK_NAME"));
			book.setLend_YN(rset.getString("LEND_YN"));
			booklist.add(book);
		}
		pstmt.close();
		conn.close();
		return booklist;
	}


	public List<Book> getAllBook(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		List<Book> getAllList = new ArrayList<Book>();
		String query = "SELECT * FROM BOOK_TBL ORDER BY BOOK_NAME";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);	
		while(rset.next()) {
			Book book = new Book();
			book.setBook_No(rset.getString("BOOK_NO"));
			book.setBook_Name(rset.getString("BOOK_NAME"));
			book.setBook_Author(rset.getString("BOOK_AUTHOR"));
			book.setBook_Publisher(rset.getString("BOOK_PUBLISHER"));
			book.setLend_YN(rset.getString("LEND_YN"));
			getAllList.add(book);
		}
		stmt.close();
		rset.close();
		return getAllList;
	}
	
	public int deleteBook(String bookNo, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM BOOK_TBL WHERE BOOK_NO = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, bookNo);
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public int modifyBook(Book book, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE BOOK_TBL SET BOOK_NAME = ?,"
				+ "BOOK_AUTHOR = ?,"
				+ "BOOK_PUBLISHER = ?," 
				+ "LEND_YN = ? WHERE BOOK_NAME = ?";
		pstmt = conn.prepareStatement(query);
	    pstmt.setString(1, book.getBook_Name());       
	    pstmt.setString(2, book.getBook_Author());
	    pstmt.setString(3, book.getBook_Publisher());
	    pstmt.setString(4, book.getLend_YN());	
	    pstmt.setString(5, book.getModify_Book());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}

	public int addBook(Book book, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK_TBL VALUES(?,?,?,?,DEFAULT)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, book.getBook_No());
		pstmt.setString(2, book.getBook_Name());
		pstmt.setString(3, book.getBook_Author());
		pstmt.setString(4, book.getBook_Publisher());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}
	
	/* 유저 */		
//	페이지네이션--------------------------------------------------
//	검색 컬럼 맵핑
	private String resolveCol(String type) {
		switch(type) {
		case "bookName": return "BOOK_NAME"; 
		case "author": return "BOOK_AUTHOR"; 
		case "publisher": return "BOOK_PUBLISHER"; 
		default : return "BOOK_NAME";
		}
	}
//		총 갯수
	public int count(String type,String searchKey,Connection conn) throws SQLException{
		String col = resolveCol(type);
		String sql = "SELECT COUNT(*) FROM BOOK_TBL WHERE " + col + " LIKE ?";
		
//			try로 감싸면 try문을 나오면 자동으로 close됨,+닫는 순서 보장된다
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
		pstmt.setString(1, "%" + (searchKey == null ? "" : searchKey.trim()) + "%");
			try(ResultSet rset = pstmt.executeQuery()){
		rset.next();
		return rset.getInt(1);
			}
		}
	}
	
//	해당 페이지의 10개만
	public List<Book> selectPage(String type,String searchKey,int page,int size,Connection conn)throws SQLException {
		String col = resolveCol(type);
		
		String sql = "SELECT BOOK_NO, BOOK_NAME, BOOK_AUTHOR, BOOK_PUBLISHER, LEND_YN "
		+"FROM BOOK_TBL "
		+"WHERE "+col+" LIKE ? "
		+"ORDER BY BOOK_NO ASC  "
		+"OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
//			오프셋을 이용해서 언제 다음페이지로 넘어갈건지 설정
		int offset = (Math.max(page, 1) -1 ) * Math.max(size, 1);
		
		List<Book>list = new ArrayList<>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			int i = 1;
			pstmt.setString(i++, "%"+(searchKey == null ? "" : searchKey.trim())+"%" );//검색어의 공백 고려
			pstmt.setInt(i++, offset);
			pstmt.setInt(i++, size);
			
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					list.add(rsetToBook(rset));
				}
			}
		}
		return list;
	}


	private Book rsetToBook(ResultSet rset) throws SQLException {
		String book_No = rset.getString("BOOK_NO");
		String book_Name = rset.getString("BOOK_NAME");
		String book_Author = rset.getString("BOOK_AUTHOR");
		String book_Publisher = rset.getString("BOOK_PUBLISHER");
		String lend_YN = rset.getString("LEND_YN");
		Book book = new Book(book_No,book_Name,book_Author,book_Publisher,lend_YN);
		
		return book;
	}




}
