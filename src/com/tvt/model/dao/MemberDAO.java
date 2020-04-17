/**
 * 
 */
package com.tvt.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tvt.model.bean.Member;

/**
 * @author Quoc
 *
 */
public class MemberDAO implements IDAOBase<Member> {

	@Override
	public List<Member> getAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();

			String sql = "select memberId, fullName, birthday, gender, numberPhone, branchId, accountId from MEMBER";

			pstm = conn.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();
			List<Member> list = new ArrayList<Member>();
			while (rs.next()) {
				String memberId = rs.getString("memberId");
				String fullName = rs.getString("fullName");
				LocalDate birthday = rs.getDate("birthday").toLocalDate();
				String gender = rs.getString("gender");
				String numberPhone = rs.getString("numberPhone");
				String branchId = rs.getString("branchId");
				String accountId = rs.getString("accountId");

				Member member = new Member();
				member.setMemberId(memberId);
				member.setFullName(fullName);
				member.setBirthday(birthday);
				member.setGender(gender);
				member.setNumberPhone(numberPhone);
				member.setBranchId(branchId);
				member.setAccountId(accountId);
				list.add(member);
			}

			return list;
		} finally {
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public void insert(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "insert into MEMBER(memberId, fullName, birthday, gender, numberPhone, branchId, accountId) values (?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, member.getMemberId());
			pstm.setString(2, member.getFullName());
			pstm.setDate(3, Date.valueOf(member.getBirthday()));
			pstm.setString(4, member.getGender());
			pstm.setString(5, member.getNumberPhone());
			pstm.setString(6, member.getBranchId());
			pstm.setString(7, member.getAccountId());

			pstm.executeUpdate();
		} finally {
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public void update(Member member) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "update MEMBER set fullName = ?, birthday = ?, gender = ?, numberPhone = ?, branchId = ?, accountId = ? where memberId = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, member.getFullName());
			pstm.setDate(2, Date.valueOf(member.getBirthday()));
			pstm.setString(3, member.getGender());
			pstm.setString(4, member.getNumberPhone());
			pstm.setString(5, member.getBranchId());
			pstm.setString(6, member.getAccountId());
			pstm.setString(7, member.getMemberId());
			pstm.executeUpdate();
		} finally {
			// TODO: handle finally clause
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public void delete(String memberId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "delete from MEMBER where memberId = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, memberId);

			pstm.executeUpdate();
		} finally {
			// TODO: handle finally clause
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

	@Override
	public Member find(String memberId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = com.tvt.common.ConnectDB.getConnect();
			String sql = "select memberId, fullName, birthday, gender, numberPhone, branchId, accountId from MEMBER where memberId = ?";

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, memberId);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				String fullName = rs.getString("fullName");
				LocalDate birthday = rs.getDate("birthday").toLocalDate();
				String gender = rs.getString("gender");
				String numberPhone = rs.getString("numberPhone");
				String branchId = rs.getString("branchId");
				String accountId = rs.getString("accountId");
				Member member = new Member(memberId, fullName, birthday, gender, numberPhone, branchId, accountId);
				return member;
			}
			return null;
		} finally {
			// TODO: handle finally clause
			if (pstm == null) {
				pstm.close();
			}
			if (conn == null) {
				conn.close();
			}
		}
	}

}
