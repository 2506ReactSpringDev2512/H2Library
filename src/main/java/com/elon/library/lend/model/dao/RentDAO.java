package com.elon.library.lend.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elon.library.lend.model.vo.Rent;




public class RentDAO {
	
	/* 전체 대여/반납조회 */
	public List<Rent> AllBookMemberInfo(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		List<Rent> btList = new ArrayList<Rent>();
		ResultSet rset = null;
		String query = "SELECT M_ID, LENDINFO_TBL.BOOK_NO, BOOK_NAME, LEND_DATE, RETURN_DATE, RETURN_YN "
				+ " FROM LENDINFO_TBL "
				+ " INNER JOIN BOOK_TBL ON (LENDINFO_TBL.BOOK_NO = BOOK_TBL.BOOK_NO) ";
		pstmt = conn.prepareStatement(query);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			Rent book = new Rent();
			book.setMemberId(rset.getString("M_ID"));
			book.setBookNo(rset.getString("BOOK_NO"));
			book.setBookName(rset.getString("BOOK_NAME"));
			book.setLendDate(rset.getDate("LEND_DATE"));
			book.setReturnDate(rset.getDate("RETURN_DATE"));
			book.setLendYn(rset.getString("RETURN_YN"));
			btList.add(book);
		}
		pstmt.close();
		rset.close();
		conn.close();
		return btList;
	}
	/* 아이디로 책 조회 */
	public List<Rent> RentalInfoById(String memberId, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		List<Rent> btList = new ArrayList<Rent>();
		ResultSet rset = null;
		String query = "SELECT M_ID, LENDINFO_TBL.BOOK_NO, BOOK_NAME, LEND_DATE, RETURN_DATE "
				+ " FROM LENDINFO_TBL"
				+ " INNER JOIN BOOK_TBL ON (LENDINFO_TBL.BOOK_NO = BOOK_TBL.BOOK_NO)"
				+ " WHERE M_ID = '"+memberId+"' AND LEND_YN = '대여가능'";
		pstmt = conn.prepareStatement(query);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			Rent book = new Rent();
			book.setMemberId("M_ID");
			book.setBookNo(rset.getString("BOOK_NO"));
			book.setBookName(rset.getString("BOOK_NAME"));
			book.setLendDate(rset.getDate("LEND_DATE"));
			book.setReturnDate(rset.getDate("RETURN_DATE"));
			btList.add(book);
		}
		pstmt.close();
		rset.close();
		conn.close();
		return btList;
	}

//	public int UpdateBookRental(String bookName, String memberId, Connection conn) 
	/* 전체목록에서 반납 */
	public int UpdateBookRental(String bookNo, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
	    String updateQuery = "UPDATE BOOK_TBL SET LEND_YN = '대여가능' WHERE BOOK_NO = ?";
	    pstmt = conn.prepareStatement(updateQuery);
		pstmt.setString(1, bookNo);
		result = pstmt.executeUpdate();
		return result;
	}
	
	/* 대여 관리 아이디로 반납 */
	public int MemberBookRentalReturn(String bookNo, String memberId, Connection conn) throws SQLException {
	    int result = 0;
	    String updateBookQuery = "UPDATE BOOK_TBL SET LEND_YN = '대여가능' WHERE BOOK_NO = ?";
	    String updateLendInfoQuery = "UPDATE LENDINFO_TBL SET RETURN_YN = 'Y' WHERE M_ID = ? AND BOOK_NO = ?";

	    try {
	        // 1. 트랜잭션 시작 (자동 커밋 비활성화)
	        conn.setAutoCommit(false);

	        // 2. try-with-resources 구문으로 자원 자동 해제 보장
	        try (PreparedStatement pstmt1 = conn.prepareStatement(updateBookQuery);
	             PreparedStatement pstmt2 = conn.prepareStatement(updateLendInfoQuery)) {

	            // BOOK_TBL 업데이트
	            pstmt1.setString(1, bookNo);
	            result += pstmt1.executeUpdate();

	            // LENDINFO_TBL 업데이트
	            pstmt2.setString(1, memberId);
	            pstmt2.setString(2, bookNo);
	            result += pstmt2.executeUpdate();
	        }
	        
	        // 3. 모든 작업이 성공하면 트랜잭션 커밋
	        conn.commit();

	    } catch (SQLException e) {
	        // 4. 오류 발생 시 트랜잭션 롤백
	        if (conn != null) {
	            conn.rollback();
	        }
	        // 오류를 호출한 쪽으로 다시 던져서 문제 발생을 알림
	        throw e;
	    } finally {
	        // 5. Connection의 상태를 원래대로 복구
	        if (conn != null) {
	            conn.setAutoCommit(true);
	        }
	    }
	    return result;
	}

	
//	-----동혁
	public int rentThisBook(String bookNo, String memberId, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;
//		책 상태 변경
		String uQuery = "UPDATE BOOK_TBL SET LEND_YN = 'N' WHERE BOOK_NO = ?";
		pstmt = conn.prepareStatement(uQuery);
		pstmt.setString(1, bookNo);
		System.out.println("책 상태 변경 성공");
		result += pstmt.executeUpdate();
		pstmt.close();
			
//		대여 테이블 변경
		String aQuery = "INSERT INTO LENDINFO_TBL VALUES(?,?,DEFAULT,DEFAULT,DEFAULT)";
		pstmt = conn.prepareStatement(aQuery);
		pstmt.setString(1, memberId);
		pstmt.setString(2, bookNo);
		result += pstmt.executeUpdate();
		System.out.println("대여 테이블 변경 성공");
		pstmt.close();
		conn.close();
		return result;
	}

	public List<Rent> getMemberRentList(String memberId, String type, String searchKey, int pageNo, Connection conn) throws SQLException {
//		추후 스위치문으로 where절을 손 볼 예정 
//		검색창을 이용한 경우 검색 조건 필터링 더하기 위함
		ResultSet rset = null;
		List<Rent>rList = new ArrayList<Rent>();
		PreparedStatement pstmt = null;
		String col = null;
		String curr = "";
		if(pageNo == 1) {
			curr = "";
		}else {
			curr = "AND RETURN_YN = 'N' ";
		}	
		switch(type) {
		case "bookName": col = "AND BOOK_NAME LIKE "; break;
		case "author": col = "AND BOOK_AUTHOR LIKE "; break;
		case "publisher": col = "AND BOOK_PUBLISHER LIKE "; break;
		case "" : col = "AND 1 > " ; break;
		default : col= "AND PUBLISHER LIKE ";
		}
		String query = "SELECT L.M_ID,L.BOOK_NO,L.LEND_DATE,L.RETURN_DATE,B.BOOK_NAME, B.BOOK_AUTHOR,B.BOOK_PUBLISHER,B.LEND_YN,L.RETURN_YN "
				+ "FROM LENDINFO_TBL L "
				+ "JOIN BOOK_TBL B ON B.BOOK_NO = L.BOOK_NO "
				+ "WHERE L.M_ID = ? "+col+" ? "+ curr
				+ " ORDER BY L.LEND_DATE DESC ";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		if(col.equals("AND 1 > ")) {
			pstmt.setInt(2, 0);	
		}else {
			pstmt.setString(2,"%" + searchKey + "%");	
		}
		rset = pstmt.executeQuery();
		while(rset.next()) {
			rList.add(cRent(rset));
			System.out.println(rList);
		}
		rset.close();
		pstmt.close();
		conn.close();
		return rList;
	}
	public int returnThisBook(String bookNo, Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		int result = 0;

		String query1 = "UPDATE BOOK_TBL SET LEND_YN = '대여가능' WHERE BOOK_NO = ?";
		String query2 = "UPDATE LENDINFO_TBL SET RETURN_DATE = SYSDATE , RETURN_YN = 'Y' "
				+ "WHERE BOOK_NO = ? AND RETURN_YN = 'N' ";
		pstmt = conn.prepareStatement(query1);
		pstmt.setString(1, bookNo);
		result += pstmt.executeUpdate();
		pstmt.close();
		
		pstmt = conn.prepareStatement(query2);
		pstmt.setString(1, bookNo);
		result += pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
		return result;
	}

	private Rent cRent(ResultSet rset) throws SQLException {
		String memberId = rset.getString("M_ID");
		String bookNo = rset.getString("BOOK_NO");
		Date lendDate = rset.getDate("LEND_DATE");
		Date returnDate = rset.getDate("RETURN_DATE");
		String bookName = rset.getString("BOOK_NAME");
		String author = rset.getString("BOOK_AUTHOR");
		String publisher = rset.getString("BOOK_PUBLISHER");
		String lendYn = rset.getString("LEND_YN");
		String returnYn = rset.getString("RETURN_YN");
		
		Rent rent = new Rent(memberId,bookNo,lendDate,returnDate,bookName,author,publisher ,lendYn,returnYn);
		return rent;
	}


}

