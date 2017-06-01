package com.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.test.dto.ProductVO;

public interface ProductDAO {
	public ArrayList<ProductVO> selectProductList() throws SQLException;
	public ArrayList<ProductVO> selectProductList(String index,String key) throws SQLException;
	public ProductVO selectProduct(String pNum) throws SQLException;
	public int insertProduct(ProductVO proVO) throws SQLException;
	public int updateProduct(ProductVO proVO) throws SQLException;
	public int deleteProduct(String id) throws SQLException;
}
