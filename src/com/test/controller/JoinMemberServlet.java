package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.MemberDAO;
import com.test.dao.MemberDAOImple;
import com.test.dto.MemberVO;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;

@WebServlet("/member/joinMember")
public class JoinMemberServlet extends HttpServlet {
	
	MemberService memService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/joinMemberForm.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url=request.getContextPath()+"/member/memberList";
		int result=-1;
		
		MemberVO member=new MemberVO();
		member.setAddress(request.getParameter("address"));
		member.setEmail(request.getParameter("email"));
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPhone(request.getParameter("phone"));
		member.setPwd(request.getParameter("pwd"));
		
		MemberService memService=new MemberServiceImpl();
		
		try {
			result=memService.joinMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(url+"?result="+result);
				
	}

}



