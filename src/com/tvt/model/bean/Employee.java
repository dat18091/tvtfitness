package com.tvt.model.bean;

import java.time.LocalDate;

/**
 * @author dat18
 *
 */
public class Employee {
	private String empId;
	private String empName;
	private String numberPhone;
	private LocalDate birthday;
	private String img;
	private String branchId;
	private String accountId;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empId, String empName, String numberPhone, LocalDate birthday, String img, String branchId,
			String accountId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.numberPhone = numberPhone;
		this.birthday = birthday;
		this.img = img;
		this.branchId = branchId;
		this.accountId = accountId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getNumberPhone() {
		return numberPhone;
	}
	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
}
