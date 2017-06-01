package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dto.MemberVO;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;

@WebServlet("/member/myPage")
public class MyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		
		String url="/member/memberDetail.jsp";
		MemberService memService=new MemberServiceImpl();
		
		MemberVO loginMember=null;
		try {
			loginMember=memService.searchMember(loginUser);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		request.setAttribute("member", loginMember);
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
