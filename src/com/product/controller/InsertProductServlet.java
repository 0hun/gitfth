package com.product.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dto.ProductVO;
import com.test.service.ProductService;
import com.test.service.ProductServiceImpl;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/product/insertProduct")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService proService = new ProductServiceImpl();
		String num="1";
		try {
			ArrayList<ProductVO> proList = proService.getProList();
			if(proList.size() != 0){
				num = String.valueOf(Integer.parseInt(proList.remove(proList.size()-1).getProNum())+1);
				if(num != null){
					request.setAttribute("num", num);
				}
			}else{
				request.setAttribute("num", num);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url="/product/insertProductForm.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getContextPath()+"/product/productList";
		int result = -1;
		
		ProductVO proVO = new ProductVO();
		proVO.setAccount(request.getParameter("account"));
		proVO.setMaker(request.getParameter("maker"));
		proVO.setPrice(request.getParameter("price"));
		proVO.setProName(request.getParameter("name"));
		proVO.setProNum(request.getParameter("num"));
		
		ProductService proService = new ProductServiceImpl();
		
		try {
			result = proService.insertProduct(proVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(url+"?result="+result);
		
	}

}
