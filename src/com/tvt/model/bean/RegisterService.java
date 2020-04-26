package com.tvt.model.bean;

import java.time.LocalDate;

/**
 * @author dat18
 *
 */
public class RegisterService {

	private int registerServiceId;
	private String serviceId;
	private String memberId;
	private LocalDate timeOfPurchase;
	private float amount;

	public RegisterService() {
		// TODO Auto-generated constructor stub
	}

	public RegisterService(int registerServiceId, String serviceId, String memberId, LocalDate timeOfPurchase,
			float amount) {
		super();
		this.registerServiceId = registerServiceId;
		this.serviceId = serviceId;
		this.memberId = memberId;
		this.timeOfPurchase = timeOfPurchase;
		this.amount = amount;
	}

	public int getRegisterServiceId() {
		return registerServiceId;
	}

	public void setRegisterServiceId(int registerServiceId) {
		this.registerServiceId = registerServiceId;
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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
