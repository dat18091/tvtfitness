package com.tvt.model.bean;

import java.time.LocalDate;

/**
 * @author dat18
 *
 */
public class Member {
	private String memberId;
	private String fullName;
	private LocalDate birthday;
	private String gender;
	private String numberPhone;
	private String branchId;
	private String accountId;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String memberId, String fullName, LocalDate birthday, String gender, String numberPhone,
			String branchId, String accountId) {
		super();
		this.memberId = memberId;
		this.fullName = fullName;
		this.birthday = birthday;
		this.gender = gender;
		this.numberPhone = numberPhone;
		this.branchId = branchId;
		this.accountId = accountId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", fullName=" + fullName + ", birthday=" + birthday + ", gender="
				+ gender + ", numberPhone=" + numberPhone + ", branchId=" + branchId + ", accountId=" + accountId + "]";
	}
	
}
