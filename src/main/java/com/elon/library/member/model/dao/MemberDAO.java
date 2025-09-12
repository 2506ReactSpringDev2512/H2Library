package com.elon.library.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elon.library.member.model.vo.Member;




public class MemberDAO {
	public Member checkLogin(Member member, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member KHmember = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,member.getMemberId() );
		pstmt.setString(2, member.getMemberPw());
		rset = pstmt.executeQuery();
		while(rset.next()) {
			KHmember = MemberList(rset);
			System.out.println("가동확인 while ");
		}
		System.out.print("디버깅 DAO "+ KHmember);
		rset.close();
		pstmt.close();
		conn.close();
		return KHmember;
	}
	
	public Member memberSearch(String memberId, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberId);
		rset = pstmt.executeQuery();
		
		while(rset.next()) {
			member = MemberList(rset);
		}
		pstmt.close();
		rset.close();
		conn.close();
		return member;
	}
	
	public int modifyMember(Member member, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER_TBL SET MEMBER_PW = ?, "
				+ "MEMBER_NAME = ?,"
				+ "MEMBER_PHONE = ?,"
				+ "MEMBER_AGE = ?,"
				+ "MEMBER_ACTIVE = ? WHERE MEMBER_ID = ?";
		
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberPw());
		pstmt.setString(2, member.getMemberName());
		pstmt.setString(3, member.getMemberPhone());
		pstmt.setInt(4, member.getAge());
		pstmt.setString(5, String.valueOf(member.getMember_Active()));
		pstmt.setString(6, member.getMemberId());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}
	
	public int memberAdd(Member member, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?, DEFAULT, DEFAULT)";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberPw());
		pstmt.setString(3, member.getMemberName());
		pstmt.setString(4, member.getMemberPhone());
		pstmt.setString(5, member.getGender());
		pstmt.setInt(6, member.getAge());
		result = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return result;
	}
	
	public int memberDelete(String memberId, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		int result = 0;
		String query = "DELETE MEMBER_TBL WHERE MEMBER_ID = '"+memberId+"'";
		stmt = conn.createStatement();
		result = stmt.executeUpdate(query);
		stmt.close();
		conn.close();
		return result;
	}
	
	public Member MemberList(ResultSet rset) throws SQLException {
		String memberId = rset.getString("MEMBER_ID");
		String memberPw = rset.getString("MEMBER_PW");
		String memberName = rset.getString("MEMBER_NAME");
		String phone = rset.getString("MEMBER_PHONE");
		String gender = rset.getString("MEMBER_GENDER");
		int age = rset.getInt("MEMBER_AGE");
		String admin = rset.getString("ADMIN_YN");
		String active = rset.getString("MEMBER_ACTIVE");
		
		Member member = new Member(memberId, memberPw, memberName, phone, gender, age, admin, active);
		System.out.println("디버깅 memeber 생성"+ member);
		return member;
	}
	
	public List<Member> getAllMember(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		List<Member> memberList = new ArrayList<Member>();
		String query = "SELECT * FROM MEMBER_TBL WHERE ADMIN_YN = 'N' ORDER BY MEMBER_NAME";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(query);
		while(rset.next()) {
			Member member = MemberList(rset);
			memberList.add(member);
		}
		stmt.close();
		rset.close();
		conn.close();
		return memberList;
	}
	
	/* 유저 */

	
	public String findPasswordHash(String memberId, Connection conn) throws SQLException {
	    String sql = "SELECT MEMBER_PW FROM MEMBER_TBL WHERE MEMBER_ID = ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    	pstmt.setString(1, memberId);
	        try (ResultSet rset = pstmt.executeQuery()) {
	            return rset.next() ? rset.getString(1) : null;
	        }
	    }
	}
	
	public Member findById(String memberId, Connection conn) throws SQLException {
	    String sql = "SELECT MEMBER_ID, MEMBER_NAME, MEMBER_PHONE, MEMBER_GENDER, MEMBER_AGE FROM MEMBER_TBL WHERE MEMBER_ID = ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    	pstmt.setString(1, memberId);
	        try (ResultSet rset = pstmt.executeQuery()) {
	            if (!rset.next()) return null;
	            Member m = new Member();
	            m.setMemberId(rset.getString("MEMBER_ID"));
	            m.setMemberName(rset.getString("MEMBER_NAME"));
	            m.setMemberPhone(rset.getString("MEMBER_PHONE"));
	            m.setGender(rset.getString("MEMBER_GENDER")); 
	            m.setAge(rset.getInt("MEMBER_AGE"));
	            return m;
	        }
	    }
	}
	
	public int update(String memberId, String name, String phone, String gender, Integer age, Connection conn) throws SQLException {
	    String sql = "UPDATE MEMBER_TBL " +
	                 "   SET MEMBER_NAME = ?, MEMBER_PHONE = ?, MEMBER_GENDER = ?, MEMBER_AGE = ? " +
	                 " WHERE MEMBER_ID = ?";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    	pstmt.setString(1, name);
	    	pstmt.setString(2, phone);
	    	pstmt.setString(3, gender);
	        if (age == null) pstmt.setNull(4, java.sql.Types.INTEGER);
	        else pstmt.setInt(4, age);
	        pstmt.setString(5, memberId);
	        return pstmt.executeUpdate();
	    }
	}
	
	public String FindID(String memberName, String memberPhone, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String memberId = null;
		ResultSet rset = null;
		String query = "SELECT MEMBER_ID FROM MEMBER_TBL WHERE MEMBER_NAME = ? AND MEMBER_PHONE = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, memberName);
		pstmt.setString(2, memberPhone);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			memberId = rset.getString("MEMBER_ID");
		}
		pstmt.close();
		rset.close();
		conn.close();
		return memberId;
	}
	
	public Member findPw(Member member, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		Member memberPw = null;
		ResultSet rset = null;
		String query = "SELECT MEMBER_PW FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_NAME = ? AND MEMBER_AGE = ? AND MEMBER_PHONE = ?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, member.getMemberId());
		pstmt.setString(2, member.getMemberName());
		pstmt.setInt(3, member.getAge());
		pstmt.setString(4, member.getMemberPhone());
		rset = pstmt.executeQuery();
		while(rset.next()) {
			memberPw = new Member();
			memberPw.setMemberPw(rset.getString("MEMBER_PW"));
		}
		pstmt.close();
		rset.close();
		conn.close();
		return memberPw;
	}
	
	public int updatePw(String memberId,String newPw,Connection conn) throws SQLException {
		String sql = "UPDATE MEMBER_TBL SET MEMBER_PW = ? WHERE MEMBER_ID = ? ";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, newPw);
			pstmt.setString(2, memberId);
			return pstmt.executeUpdate();
		}
	}

}
