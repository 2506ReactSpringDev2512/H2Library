package com.elon.library.member.controller;

import java.io.IOException;

import com.elon.library.member.model.service.MemberService;
import com.elon.library.member.model.vo.Member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminPageModifyServlet
 */
@WebServlet("/khlibary/admin/modify")
public class AdminPageModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPageModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("modifyId");
		String memberPw = request.getParameter("modifyPassword");
		String memberName = request.getParameter("modifyName");
		String memberPhone = request.getParameter("modifyPhone");
		int memberAge =  Integer.parseInt(request.getParameter("modifyAge"));
		String member_status = request.getParameter("modifyMember_status");
		
		if(memberId == null || memberId.trim().isEmpty()) {
			request.setAttribute("Id_errorMsg", "아이디를 입력해주세요.");
		}
		
		if(memberPw == null || memberPw.trim().isEmpty()) {
			request.setAttribute("Pw_errorMsg", "비밀번호를 입력해주세요.");
		}
		
		if(memberName == null || memberName.trim().isEmpty()) {
			request.setAttribute("Name_errorMsg", "이름을 입력해주세요.");
		}
		
		if(memberPhone == null || memberPhone.trim().isEmpty()) {
			request.setAttribute("Phone_errorMsg", "전화번호를 입력해주세요.");
		}

		
		Member member = new Member(memberId, memberPw, memberName, memberPhone, memberAge, member_status);
		MemberService mService = new MemberService();
		int result = mService.modifyMember(member);
		
		if(result > 0) {
			request.setAttribute("errorMsg", "회원 정보수정 완료");
			response.sendRedirect("/khlibary/admin/modify");
		} else {
			request.setAttribute("errorMsg", "회원 정보를 옳바르게 입력해주세요.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/AdminPage-member-modify.jsp");
			view.forward(request, response);	
		}
	}

}
