package com.cg.pizzaorder.bean;

import java.time.LocalDate;

public class PizzaOrder {
	private int orderId;
	private double totalPrice;
	private int customerId;
	LocalDate orderDate;

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public PizzaOrder() {
		super();
	}

	public PizzaOrder(double totalPrice, LocalDate orderDate) {
		super();
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}

}
