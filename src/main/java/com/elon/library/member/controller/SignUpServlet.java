package com.elon.library.member.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.elon.library.member.model.service.MemberService;
import com.elon.library.member.model.vo.Member;

/**
 * Servlet implementation class UserSignUpPage
 */
@WebServlet("/khlibary/member/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/User-Signup.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("Id");
		String userPw = request.getParameter("Password");
		String userName = request.getParameter("Name");
		String userPhone = request.getParameter("Phone");
		String gender = request.getParameter("Gender");
		int age = Integer.parseInt(request.getParameter("Age"));
		
		Member member = new Member(userId, userPw, userName, userPhone, gender, age);
		MemberService mService = new MemberService();
		int result = mService.memberAdd(member);
		if (result > 0) {
			request.setAttribute("successMsg", "회원가입 성공");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/login.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "회원가입 실패 \n 정보를 옳바르게 입력해주세요.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/User-Signup.jsp");
			view.forward(request, response);
		}
	}
}
