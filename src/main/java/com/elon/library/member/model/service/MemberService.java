package com.elon.library.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.elon.library.common.TeamH2Template;
import com.elon.library.member.model.dao.MemberDAO;
import com.elon.library.member.model.vo.Member;




public class MemberService {
	private TeamH2Template h2Template;
	private MemberDAO mDao;
	
	public MemberService() {
		h2Template = TeamH2Template.getInstance();
		mDao = new MemberDAO();
	}
	
	public Member checkLogin(Member member) {
		// TODO Auto-generated method stub
		Member KHmember = null;
		try {
			Connection conn = h2Template.getConnection();
			KHmember = mDao.checkLogin(member,conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return KHmember;
	}

	public Member memberSearch(String memberName) {
		// TODO Auto-generated method stub
		Member member = null;
		try {
			Connection conn = h2Template.getConnection();
			member = mDao.memberSearch(memberName, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = h2Template.getConnection();
			result = mDao.modifyMember(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int memberAdd(Member member) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = h2Template.getConnection();
			result = mDao.memberAdd(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int memberDelete(String memberId) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			Connection conn = h2Template.getConnection();
			result = mDao.memberDelete(memberId, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/* 유저 */	
	public int updatePw(String memberId,String newPw) throws SQLException {
		int result = 0;
		try (Connection conn = h2Template.getConnection()){
			result = mDao.updatePw(memberId,newPw,conn);
		}
		return result;
	}
	
    public boolean checkPassword(String memberId, String raw) throws SQLException {
        try (Connection conn = h2Template.getConnection()) {
            String hash = mDao.findPasswordHash(memberId, conn);
            return hash != null && hash.equals(raw);
        }
    }
    public Member findById(String memberId) throws SQLException {
        try (Connection conn = h2Template.getConnection()) {
            return mDao.findById(memberId, conn);
        }
    }

    public void updateProfile(String memberId, String name, String phone, String gender, Integer age) throws SQLException {
        try (Connection conn = h2Template.getConnection()) {
        	mDao.update(memberId, name, phone, gender, age, conn);
        }
    }
    
	public String FindID(String memberName, String memberPhone) {
		// TODO Auto-generated method stub
		String memberId = null;
		try {
			Connection conn = h2Template.getConnection();
			memberId = mDao.FindID(memberName, memberPhone, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberId;
	}


	public Member findPw(Member member) {
		// TODO Auto-generated method stub
		Member memberPw = null;
		try {
			Connection conn = h2Template.getConnection();
			memberPw = mDao.findPw(member, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberPw;
	}

	public List<Member> getAllMember() {
		// TODO Auto-generated method stub
		List<Member> memberList = null;
		try {
			Connection conn = h2Template.getConnection();
			memberList = mDao.getAllMember(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberList;
	}
}
