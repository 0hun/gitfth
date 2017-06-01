package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;

@WebServlet("/member/deleteMember")
public class DeleteMemberServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");		
		String url=request.getContextPath()+"/member/memberList";
		MemberService memService=new MemberServiceImpl();
		
		int result=-1;
		try {
			result=memService.removeMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(url+"?result="+result);
	}

}






