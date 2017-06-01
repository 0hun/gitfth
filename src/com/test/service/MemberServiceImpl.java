package com.test.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.MemberDAO;
import com.test.dao.MemberDAOImple;
import com.test.dto.MemberVO;
import com.test.exception.MemberNotFoundByIdException;
import com.test.exception.PasswordNotMatchException;

public class MemberServiceImpl implements MemberService {

	MemberDAO memDao=new MemberDAOImple();	

	@Override
	public void login(String id, String pwd)
			throws MemberNotFoundByIdException, PasswordNotMatchException {
		MemberVO member = null;
		try {
			member = memDao.selectMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (member != null) {
			if (pwd.equals(member.getPwd())) {
				return;
			} else {
				throw new PasswordNotMatchException();
			}
		} else {
			throw new MemberNotFoundByIdException();
		}

	}

	@Override
	public ArrayList<MemberVO> getMemberList() throws SQLException {

		ArrayList<MemberVO> memVO = memDao.selectMemberList();

		return memVO;
	}

	// 1. 회원등록
	public int joinMember(MemberVO member) throws SQLException{
		int result=0;
		result=memDao.insertMember(member);
		return result;
	};

	// 1.1 중복확인
	public int confirmMember(String id) throws SQLException{
		int result=0;
		if(memDao.selectMember(id)!=null){
			result=1;
		}
		return result;//1:중복		
	}

	// 2. 회원조회(내정보수정/회원상세조회)
	public MemberVO searchMember(String id) throws SQLException{
		MemberVO member=null;
		member=memDao.selectMember(id);
		return member;
	}

	// 3. 회원수정
	public int modifyMember(MemberVO member) throws SQLException{
		int result=0;
		result=memDao.updateMember(member);
		return result;
	}

	// 4. 회원삭제
	public int removeMember(String id) throws SQLException{
		int result=0;
		result=memDao.deleteMember(id);
		return result;
	}

	// 5. 검색(아이디/주소/이메일/전화번호)
	public List<MemberVO> searchIndexMemberList(String index, String key)
			throws SQLException{
		List<MemberVO> memberList=memDao.selectMemberList(index, key);
		return memberList;
	}

}





