package com.elon.library.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.elon.library.member.model.service.MemberService;
import com.elon.library.member.model.vo.Member;




/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/member/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 1단계: 비밀번호 입력 화면
        req.setAttribute("mode", "verify");
        req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	MemberService memberService = new MemberService();
        req.setCharacterEncoding("UTF-8");
        String step = req.getParameter("step");        
        String memberId = (String) req.getSession().getAttribute("memberId");
        if (memberId == null) {
            resp.sendRedirect(req.getContextPath() + "/member/login");
            return;
        }

        try {
            if ("verify".equals(step)) {
                // 비번 검증
                String inputPassword = req.getParameter("inputPassword");
                boolean ok = memberService.checkPassword(memberId, inputPassword); 
                if (!ok) {
                    req.setAttribute("mode", "verify");
                    req.setAttribute("error", "비밀번호가 올바르지 않습니다.");
                    req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
                    return;
                }
                // 성공 -> 회원 정보 조회 후 수정 폼으로
                Member m = memberService.findById(memberId);
                req.setAttribute("mode", "edit");
                req.setAttribute("member", m);
                req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
                return;
            }

            if ("update".equals(step)) {
                // 폼 값 수집
                String name   = req.getParameter("name");
                String phone  = req.getParameter("phone");
                String gender = req.getParameter("gender");  
                String ageStr = req.getParameter("age");
                Integer age = null;
                if (ageStr != null && !ageStr.isBlank()) {
                    age = Integer.parseInt(ageStr);
                }

                // 서버 검증(간단 예시)
                if (name == null || name.isBlank()) {
                    Member m = memberService.findById(memberId);
                    req.setAttribute("mode", "edit");
                    req.setAttribute("member", m);
                    req.setAttribute("error", "이름은 필수입니다.");
                    req.getRequestDispatcher("/WEB-INF/views/member/modify.jsp").forward(req, resp);
                    return;
                }

                // 업데이트
                memberService.updateProfile(memberId, name, phone, gender, age);
                // 완료 -> 대여 이력으로 이동
                resp.sendRedirect(req.getContextPath() + "/member/recode");
                return;
            }

            // 알 수 없는 step이면 처음 화면
            resp.sendRedirect(req.getContextPath() + "/member/modify");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}