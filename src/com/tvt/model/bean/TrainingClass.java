/*
 *
 * Date: Apr 15, 2020
 * Authur: Phuong
 *
 */

package com.tvt.model.bean;

import java.time.LocalDate;

public class TrainingClass {
	private String classId;
	private String className;
	private String packageName;
	private String empName;
	private String schedule;
	private int maxMember;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private String branchId;
	private String status;

	public TrainingClass() {

	}

	public TrainingClass(String classId, String className, String packageName, String empName, String schedule,
			int maxMember, LocalDate dateStart, LocalDate dateEnd, String branchId, String status) {
		super();
		this.classId = classId;
		this.className = className;
		this.packageName = packageName;
		this.empName = empName;
		this.schedule = schedule;
		this.maxMember = maxMember;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.branchId = branchId;
		this.status = status;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPackageId() {
		return packageName;
	}

	public void setPackageId(String packageName) {
		this.packageName = packageName;
	}

	public String getEmpId() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public int getMaxMember() {
		return maxMember;
	}

	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart(LocalDate dateStart) {
		this.dateStart = dateStart;
	}

	public LocalDate getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(LocalDate dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
