/**
 * 
 */
package com.tvt.model.bo;

import java.sql.SQLException;
import java.util.List;

import com.tvt.model.bean.Member;
import com.tvt.model.dao.MemberDAO;

/**
 * @author PC
 *
 */
public class MemberBO {
	MemberDAO memberDAO = new MemberDAO();

	public void insertMember(Member member) throws SQLException {
		memberDAO.insert(member);
	}

	public List<Member> getAll() throws SQLException {
		return memberDAO.getAll();
	}

	public void deleteMember(String memberId) throws SQLException {
		memberDAO.delete(memberId);
	}

	public Member find(String memberId) throws SQLException {
		return memberDAO.find(memberId);
	}

	public void edit(Member member) throws SQLException {
		memberDAO.update(member);
	}
}
