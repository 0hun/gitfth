package com.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.test.dto.MemberVO;
import com.test.sqlconfig.IBatisDBConnector;

public class MemberDAOImple implements MemberDAO {

	private SqlMapClient client= IBatisDBConnector.getSqlMapInstance();
	
	@Override
	public ArrayList<MemberVO> selectMemberList() throws SQLException {
		ArrayList<MemberVO> memberList
		=(ArrayList<MemberVO>)client.queryForList("memberList", null);
		return memberList;
	}

	@Override
	public ArrayList<MemberVO> selectMemberList(String index, String key)
			throws SQLException {
		
		ArrayList<MemberVO> memberList = null;
		HashMap<String, String> map = new HashMap<>();
		map.put("index", index);
		map.put("key", key);
		memberList = (ArrayList<MemberVO>)client.queryForList("searchMember", map);
		
		
		return memberList;
	}

	@Override
	public MemberVO selectMember(String id) throws SQLException {
		MemberVO memVO =(MemberVO)client.queryForObject("selectMember", id);
		return memVO;
	}

	@Override
	public int insertMember(MemberVO member) throws SQLException {
		int result=client.update("insertMember", member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) throws SQLException {
		int result  = client.update("updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(String id) throws SQLException {
		int result = client.update("deleteMember", id);
		return result;
	}

}
