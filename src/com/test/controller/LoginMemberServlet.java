package com.test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.exception.MemberNotFoundByIdException;
import com.test.exception.PasswordNotMatchException;
import com.test.service.MemberService;
import com.test.service.MemberServiceImpl;

@WebServlet("/login")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/loginForm.jsp";	
		HttpSession session=request.getSession();
		String loginUser=(String)session.getAttribute("loginUser"); 
		if(loginUser!=null){
			url="member/login.jsp";
		}
				
		request.getRequestDispatcher(url).forward(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MemberService memService=new MemberServiceImpl();
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		String url="member/memberList";
		
		HttpSession session=request.getSession();
		
		boolean flag=false;
		String message="로그인 성공했습니다.";
		
		try {
			memService.login(id, pwd);
			
			session.setAttribute("loginUser", id);
			session.setMaxInactiveInterval(60*6);
			
			flag=true;
		} catch (MemberNotFoundByIdException | PasswordNotMatchException e) {
			message="아이디/패스워드가 일치하지 않습니다.";
			url="member/loginForm.jsp";
			request.setAttribute("flag", flag);
			request.setAttribute("message", message);
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		
		response.sendRedirect(url);
		
	}

}
