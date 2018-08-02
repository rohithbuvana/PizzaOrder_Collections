package com.cg.pizzaorder.junittest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.dao.IPizzaOrderDAO;
import com.cg.pizzaorder.dao.PizzaOrderDAO;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderJunit {
	public static IPizzaOrderDAO pizzaOrderDAO;

	@BeforeClass
	public static void init() {

		pizzaOrderDAO = new PizzaOrderDAO();
	}

	@Test(expected = PizzaException.class)
	public void testplaceOrderException() throws PizzaException {
		Customer customer = null;
		PizzaOrder pizzaOrder = null;
		pizzaOrderDAO.placeOrder(customer, pizzaOrder);

	}

	@Test
	public void testplaceOrder() throws PizzaException {
		Customer customer = new Customer("RAM", "Pune", "1234567890");
		PizzaOrder pizzaOrder = new PizzaOrder(400, LocalDate.now());
		int orderId = pizzaOrderDAO.placeOrder(customer, pizzaOrder);
		assertEquals(pizzaOrder.getOrderId(), orderId);
	}

	@Test(expected = PizzaException.class)
	public void getOrderDetailsException() throws PizzaException {
		Customer customer = new Customer("RAM", "Pune", "1234567890");
		PizzaOrder pizzaOrder = new PizzaOrder(400, LocalDate.now());
		int orderId = (pizzaOrderDAO.placeOrder(customer, pizzaOrder) - 1);
		pizzaOrderDAO.getOrderDetails(orderId);
	}

	@Test
	public void getOrderDetails() throws PizzaException {
		Customer customer = new Customer("RAM", "Pune", "1234567890");
		PizzaOrder pizzaOrder = new PizzaOrder(400, LocalDate.now());
		int orderId = pizzaOrderDAO.placeOrder(customer, pizzaOrder);
		assertEquals(pizzaOrder, pizzaOrderDAO.getOrderDetails(orderId));
	}

	@AfterClass
	public static void clear() {

		pizzaOrderDAO = null;
	}
}
