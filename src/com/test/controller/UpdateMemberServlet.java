package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.MemberVO;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;


@WebServlet("/member/modifyMember")
public class UpdateMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String url=request.getContextPath()+"/member/memberList";
		
		MemberVO member=new MemberVO();
		
		member.setAddress(request.getParameter("address"));
		member.setEmail(request.getParameter("email"));
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPhone(request.getParameter("phone"));
		member.setPwd(request.getParameter("pwd"));
		
		MemberService memService=new MemberServiceImpl();
		int result=-1;
		try {
			result=memService.modifyMember(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		response.sendRedirect(url+"?result="+result);		
	}

}







