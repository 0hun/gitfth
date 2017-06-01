package com.test.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dto.ProductVO;

public interface ProductService {
	
	public ArrayList<ProductVO> getProList() throws SQLException;
	
	//1.상품등록
	public int insertProduct(ProductVO proVO) throws SQLException;
	
	//1.1 중복확인
	public int confirmProdcut(String pNum) throws SQLException;
	
	//2.상품조회(상품상세조회)
	public ProductVO searchProdcut(String pNum) throws SQLException;
	
	//3.상품수정
	public int modifyProduct(ProductVO proVO) throws SQLException;
	
	//4.상품삭제
	public int removeProduct(String pNum) throws SQLException;
	
	//5.검색(상품번호/상품명/가격/제조회사/수량)
	public List<ProductVO> searchIndexProductList(String index,String key)
	throws SQLException;
}
