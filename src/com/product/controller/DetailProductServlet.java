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
 * Servlet implementation class DetailProductServlet
 */
@WebServlet("/product/detailProduct")
public class DetailProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/product/productDetail.jsp";
		String id = request.getParameter("pNum");
		ProductService proService = new ProductServiceImpl();
		
		ProductVO product =new ProductVO();
		
		try {
			product = proService.searchProdcut(id);
			System.out.println(product.getAccount());
			System.out.println(product.getMaker());
			System.out.println(product.getPrice());
			System.out.println(product.getProName());
			System.out.println(product.getProNum());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("product", product);
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
