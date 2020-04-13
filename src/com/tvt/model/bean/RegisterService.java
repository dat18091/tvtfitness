package com.tvt.model.bean;

import java.time.LocalDate;

/**
 * @author dat18
 *
 */
public class RegisterService {
	private String serviceId;
	private String memberId;
	private LocalDate timeOfPurchase;
	private int amount;
	public RegisterService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterService(String serviceId, String memberId, LocalDate timeOfPurchase, int amount) {
		super();
		this.serviceId = serviceId;
		this.memberId = memberId;
		this.timeOfPurchase = timeOfPurchase;
		this.amount = amount;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public LocalDate getTimeOfPurchase() {
		return timeOfPurchase;
	}
	public void setTimeOfPurchase(LocalDate timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
