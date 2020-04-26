/*
 *
 * Date: Apr 20, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bean;

import java.time.LocalDate;

public class RegisterClass {

	private int registerClassId;
	private String memberId;
	private String classId;
	private LocalDate registerDate;
	private String payStatus;

	public RegisterClass() {

	}

	public RegisterClass(int registerClassId, String memberId, String classId, LocalDate registerDate,
			String payStatus) {
		super();
		this.registerClassId = registerClassId;
		this.memberId = memberId;
		this.classId = classId;
		this.registerDate = registerDate;
		this.payStatus = payStatus;
	}

	public int getRegisterClassId() {
		return registerClassId;
	}

	public void setRegisterClassId(int registerClassId) {
		this.registerClassId = registerClassId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

}
