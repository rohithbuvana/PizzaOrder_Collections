package com.cg.pizzaorder.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.dao.IPizzaOrderDAO;
import com.cg.pizzaorder.dao.PizzaOrderDAO;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderService implements IPizzaOrderService {
	IPizzaOrderDAO pizzaOrderDAO;
	{
		pizzaOrderDAO = new PizzaOrderDAO();
	}
	Scanner sc = new Scanner(System.in);

	//To Add the order details to the DAO layer
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		while (true) {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher matcher = pattern.matcher(customer.getPhone());
			//Pattern validation for phone number to be of length 10 and should contain only numbers.
			if (customer.getPhone().length() == 10 && matcher.matches()) {
				break;
			} else {
				System.out.println("Invalid Phone Number!!! Should contain only numbers and should of length 10 \n\nRenter the phone number... ");
				customer.setPhone(sc.next());
			}
		}
		return pizzaOrderDAO.placeOrder(customer, pizza);
	}

	//To retrieve the order details from the DAO layer
	@Override
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException {
		return pizzaOrderDAO.getOrderDetails(orderid);

	}
}
