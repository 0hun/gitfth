package com.test.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dto.MemberVO;
import com.test.exception.MemberNotFoundByIdException;
import com.test.exception.PasswordNotMatchException;

public interface MemberService {

	public void login(String id,String pwd) throws MemberNotFoundByIdException,
										PasswordNotMatchException;
	
	public ArrayList<MemberVO> getMemberList() throws SQLException;
	
	//1. 회원등록
	public int joinMember(MemberVO member) throws SQLException;
	
	//1.1 중복확인
	public int confirmMember(String id) throws SQLException;
	
	//2. 회원조회(내정보수정/회원상세조회)
	public MemberVO searchMember(String id) throws SQLException;
	
	//3. 회원수정
	public int modifyMember(MemberVO member) throws SQLException;
	
	//4. 회원삭제
	public int removeMember(String id) throws SQLException;
		
	//5. 검색(아이디/주소/이메일/전화번호)
	public List<MemberVO> searchIndexMemberList(String index, String key)
	throws SQLException;
	
}







