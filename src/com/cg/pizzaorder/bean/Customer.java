package com.cg.pizzaorder.bean;

public class Customer {
	private int customerId;
	private String custName;
	private String address;
	private String Phone;

	public int getCustomerId() {
		return customerId;
	}

	public Customer(String custName, String address, String phone) {
		super();
		this.custName = custName;
		this.address = address;
		Phone = phone;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public Customer(int customerId, String custName, String address, String phone) {
		super();
		this.customerId = customerId;
		this.custName = custName;
		this.address = address;
		Phone = phone;
	}

	public Customer() {
		super();
	}

}
