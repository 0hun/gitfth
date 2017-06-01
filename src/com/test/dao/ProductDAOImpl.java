package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.test.db.DataSource;
import com.test.db.JDBCUtil;
import com.test.dto.ProductVO;
import com.test.sqlconfig.IBatisDBConnector;

public class ProductDAOImpl implements ProductDAO {
	private SqlMapClient client= IBatisDBConnector.getSqlMapInstance();
	@Override
	public ArrayList<ProductVO> selectProductList() throws SQLException {
		ArrayList<ProductVO> proList
		= (ArrayList<ProductVO>)client.queryForList("productList", null);
		
		return proList;
	}

	@Override
	public ArrayList<ProductVO> selectProductList(String index, String key)
			throws SQLException {
		ArrayList<ProductVO> proList =null;
		HashMap<String, String> paramap = new HashMap<String, String>();
		paramap.put("index", index);
		paramap.put("key", key);
		proList =(ArrayList<ProductVO>)client.queryForList("searchProduct", paramap);
		
		return proList;
	}

	@Override
	public ProductVO selectProduct(String id) throws SQLException {
		ProductVO proVO = (ProductVO)client.queryForObject("selectProduct", id);
		
		return proVO;
	}

	@Override
	public int insertProduct(ProductVO proVO) throws SQLException {
		int result = client.update("insertProduct", proVO);
		
		return result;
	}

	@Override
	public int updateProduct(ProductVO proVO) throws SQLException {
		int result = client.update("updateProduct", proVO);
		
		return result;
	}

	@Override
	public int deleteProduct(String pronum) throws SQLException {
		int result = client.update("deleteProduct", pronum);
		return result;
	}

}
