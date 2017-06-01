package com.test.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.MemberVO;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;

@WebServlet("/member/searchMember")
public class SearchMemberServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/memberList.jsp";
		String index=request.getParameter("index");
		String key=request.getParameter("key");
		
		MemberService memberService=new MemberServiceImpl();
		List<MemberVO> memberList=null;
		try {
			memberList=memberService.searchIndexMemberList(index, key);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("memberList", memberList);
		
		request.getRequestDispatcher(url).forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
