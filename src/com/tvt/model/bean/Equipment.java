package com.tvt.model.bean;

import java.time.LocalDate;

/**
 * @author dat18
 *
 */
public class Equipment {
	private String equipmentId;
	private String equipmentName;
	private String equipmentType;
	private String imageUrl;
	private LocalDate importDate;
	private LocalDate warrantyDate;
	private String status;
	private float cost;
	private String branchId;

	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipment(String equipmentId, String equipmentName, String equipmentType, String imageUrl,
			LocalDate importDate,LocalDate warrantyDate, String status, float cost, String branchId) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.equipmentType = equipmentType;
		this.imageUrl = imageUrl;
		this.importDate = importDate;
		this.warrantyDate = warrantyDate;
		this.status = status;
		this.cost = cost;
		this.branchId = branchId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalDate getImportDate() {
		return importDate;
	}

	public void setImportDate(LocalDate importDate) {
		this.importDate = importDate;
	}

	public LocalDate getWarrantyDate() {
		return warrantyDate;
	}

	public void setWarrantyDate(LocalDate warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
}
