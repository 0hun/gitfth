package com.product.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.ProductVO;
import com.test.service.ProductService;
import com.test.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/product/modifyProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String url =request.getContextPath()+"/product/productList";
		
		ProductVO proVO = new ProductVO();
		
		proVO.setAccount(request.getParameter("account"));
		proVO.setMaker(request.getParameter("maker"));
		proVO.setPrice(request.getParameter("price"));
		proVO.setProName(request.getParameter("name"));
		proVO.setProNum(request.getParameter("num"));
		
		ProductService proService = new ProductServiceImpl();
		
		int result = -1;
		try {
			result = proService.modifyProduct(proVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.sendRedirect(url+"?result="+result);
	
	}

}
