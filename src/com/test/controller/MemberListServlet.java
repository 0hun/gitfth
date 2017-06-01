package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.MemberVO;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;

@WebServlet("/member/memberList")
public class MemberListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberVO> memberList=null;
		
		MemberService memService=new MemberServiceImpl();
		
		try {
			memberList=memService.getMemberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("memberList", memberList);
		
		request.getRequestDispatcher("memberList.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
