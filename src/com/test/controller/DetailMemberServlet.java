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

@WebServlet("/member/detailMember")
public class DetailMemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/memberDetail.jsp";
		String id=request.getParameter("id");
		MemberService memService=new MemberServiceImpl();
		
		MemberVO member=null;
		try {
			member=memService.searchMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("member", member);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
