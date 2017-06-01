package com.test.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.ProductDAO;
import com.test.dao.ProductDAOImpl;
import com.test.dto.ProductVO;

public class ProductServiceImpl implements ProductService {
	ProductDAO proDao = new ProductDAOImpl();
	@Override
	public ArrayList<ProductVO> getProList() throws SQLException {
		ArrayList<ProductVO> proVO = proDao.selectProductList();
		return proVO;
	}

	@Override
	public int insertProduct(ProductVO proVO) throws SQLException {
		int result = 0;
		result = proDao.insertProduct(proVO);
		return result;
	}

	@Override
	public int confirmProdcut(String pNum) throws SQLException {
		int result = -1;
		if(proDao.selectProduct(pNum)!=null){
			result = 1;
		}
		 
		return result;
	}

	@Override
	public ProductVO searchProdcut(String pNum) throws SQLException {
		ProductVO proVo = null;
		proVo = proDao.selectProduct(pNum);
		return proVo;
	}

	@Override
	public int modifyProduct(ProductVO proVO) throws SQLException {
		int result = 0;
		result = proDao.updateProduct(proVO);
		return result;
	}

	@Override
	public int removeProduct(String pNum) throws SQLException {
		int result = 0;
		result = proDao.deleteProduct(pNum);
		return result;
	}

	@Override
	public List<ProductVO> searchIndexProductList(String index, String key)
			throws SQLException {
		List<ProductVO> proVO = proDao.selectProductList(index, key);
		return proVO;
	}

}
