package com.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.test.dto.MemberVO;

public interface MemberDAO {

	public ArrayList<MemberVO> selectMemberList() throws SQLException;
	public ArrayList<MemberVO> selectMemberList(String index,String key) throws SQLException;
	public MemberVO selectMember(String id) throws SQLException;;
	public int insertMember(MemberVO member) throws SQLException;;
	public int updateMember(MemberVO member) throws SQLException;;
	public int deleteMember(String id) throws SQLException;;
}





