package com.tvt.model.bean;

/**
 * @author dat18
 *
 */
public class Account {
	private String accountId;
	private String password;
	private String accountType;
	private String accountLevel;
	public Account() {}
	public Account(String accountId, String password, String accountType, String accountLevel) {
		super();
		this.accountId = accountId;
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
	public String getPassWord() {
		return password;
	}
	public void setPassWord(String password) {
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
