package com.elon.library.lend.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elon.library.common.TeamH2Template;
import com.elon.library.lend.model.dao.RentDAO;
import com.elon.library.lend.model.vo.Rent;






public class RentService {
	private TeamH2Template h2Template;
	private final RentDAO rDAO = new RentDAO();
	public static final int PAGE_SIZE = 10;
	
    public RentService() {
        this.h2Template = TeamH2Template.getInstance();
    }

	
	public int rentBook(String bookNo, String memberId) {
		int result = 0;
		try {
			Connection conn = h2Template.getConnection();
			result = rDAO.rentThisBook(bookNo,memberId,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

//	 유저들의 대여 리스트 
	
	public List<Rent> getRentList(String memberId, String type, String searchKey, int page,int pageNo) {
		List<Rent>rList = null;
		try {
			Connection conn = h2Template.getConnection();
			rList = rDAO.getMemberRentList(memberId,type,searchKey,page,PAGE_SIZE,pageNo,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rList;
	}


	public int returnBook(String bookNo) {
		int result = 0;
			
		try {
			Connection conn = h2Template.getConnection();
			result = rDAO.returnThisBook(bookNo,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/* 전체 대여/반납조회 */
	public List<Rent> AllBookMemberInfo() {
		// TODO Auto-generated method stub
		List<Rent> btList = null;
		Connection conn = h2Template.getConnection();
		try {
			btList = rDAO.AllBookMemberInfo(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return btList;
	}
	/* 아이디로 책 조회 */
	public List<Rent> RentalInfoById(String memberId) {
		// TODO Auto-generated method stub
		List<Rent> btList = null;
		Connection conn = h2Template.getConnection();
		try {
			btList = rDAO.RentalInfoById(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return btList;
	}
	
//	public int UpdateBookRental(String bookName, String memberId) {
	/* 전체목록에서 반납 */
	public int UpdateBookRental(String bookNo) {
		// TODO Auto-generated method stub
		Connection conn = h2Template.getConnection();
		int result = 0;
		try {
//			result = BookRentDao.UpdateBookRental(bookName, memberId, conn);
			result = rDAO.UpdateBookRental(bookNo, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	/* 대여 관리 아이디로 반납 */
	public int MemberBookRentalReturn(String bookNo, String memberId) {
		// TODO Auto-generated method stub
		Connection conn = h2Template.getConnection();
		int result = 0;
		try {
			result = rDAO.MemberBookRentalReturn(bookNo, memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	public int count(String memberId,String type, String searchKey, int pageNo) {
		try(
				Connection conn = h2Template.getConnection()){
				return rDAO.count(memberId,type, searchKey, pageNo, conn);
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
	}
}
