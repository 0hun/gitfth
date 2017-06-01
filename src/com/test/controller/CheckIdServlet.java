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

@WebServlet("/member/checkID")
public class CheckIdServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/member/joinMember";
		String id=request.getParameter("chkId");
		String chk_msg="";
		if(id.equalsIgnoreCase("null")){
			request.setAttribute("chk_id","");
			chk_msg="<span style='height:15px;font-size:10px;color:red;'>"
					+ "사용불가능한 아이디 입니다."
					+ "</span>";
		}else {
			int result=-1;		
			MemberService memService=new MemberServiceImpl();
			
			try {
				result=memService.confirmMember(id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(result>0){
				request.setAttribute("chk_id","");
				chk_msg="<span style='height:15px;font-size:10px;color:red;'>"
						+ "이미 사용중인 아이디 입니다."
						+ "</span>";					
			}else{
				request.setAttribute("chk_id", id);
				chk_msg="<span style='height:15px;font-size:10px;color:blue;'>"
						+ "사용가능한 아이디 입니다."					
						+ "</span>";
			}
		}
		request.setAttribute("chk_msg",chk_msg);
		request.getRequestDispatcher(url).forward(request,response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
