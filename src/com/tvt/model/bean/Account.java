package com.tvt.model.bean;

/**
 * @author dat18
 *
 */
public class Account {
	private String accountId;
	private String accountName;
	private String password;
	private String accountType;
	private String accountLevel;

	public Account() {
	}

	public Account(String accountId, String accountName, String password, String accountType, String accountLevel) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.password = password;
		this.accountType = accountType;
		this.accountLevel = accountLevel;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountLevel() {
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
}
