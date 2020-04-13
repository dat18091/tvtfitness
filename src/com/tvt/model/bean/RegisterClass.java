package com.tvt.model.bean;

/**
 * @author dat18
 *
 */
public class RegisterClass {
	private String memberId;
	private String classId;
	private String payStatus;
	public RegisterClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterClass(String memberId, String classId, String payStatus) {
		super();
		this.memberId = memberId;
		this.classId = classId;
		this.payStatus = payStatus;
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
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
}
