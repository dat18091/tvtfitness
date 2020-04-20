package com.tvt.model.bean;

/**
 * @author dat18
 *
 */
public class Branch {

	private String branchId;
	private String branchName;
	private String address;

	public Branch() {
		
	}

	public Branch(String branchId, String branchName, String address) {
		this.branchId = branchId;
		this.branchName = branchName;
		this.address = address;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
