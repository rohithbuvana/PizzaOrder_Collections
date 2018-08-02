package com.cg.pizzaorder.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;

public class PizzaOrderDAO implements IPizzaOrderDAO {

	Map<Integer, Customer> customerEntry;
	Map<Integer, PizzaOrder> pizzaEntry;
	{
		customerEntry = new HashMap<Integer, Customer>();
		pizzaEntry = new HashMap<Integer, PizzaOrder>();

	}

	//Adding Order Details to the map
	@Override
	public int placeOrder(Customer customer, PizzaOrder pizza) throws PizzaException {
		//Exception is thrown if the Customer or PizzaOrder objects are null
		if (customer == null || pizza == null) {
			throw new PizzaException("Something Went Wrong in DAO");
		}
		Random rn = new Random();
		pizza.setOrderId(Integer.parseInt(String.valueOf(Math.abs(rn.nextInt()))));
		customer.setCustomerId(Integer.parseInt(String.valueOf(Math.abs(rn.nextInt()))));
		pizza.setCustomerId(customer.getCustomerId());
		customerEntry.put(customer.getCustomerId(), customer);
		pizzaEntry.put(pizza.getOrderId(), pizza);
		return pizza.getOrderId();
	}

	//Returning the required order details
	@Override
	public PizzaOrder getOrderDetails(int orderid) throws PizzaException {
		Set set = pizzaEntry.entrySet();
		Iterator i = set.iterator();
		int flag = 0;
		PizzaOrder pizzaOrder = new PizzaOrder();
		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			if (me.getKey().equals(orderid)) {
				pizzaOrder = (PizzaOrder) me.getValue();
				flag = 1;
				break;
			}
		}
		//Exception is thrown if the given user input order id does not exist in the pizzaEntry map
		if (flag == 0) {
			throw new PizzaException("Wrong Order Id....");
		}
		return pizzaOrder;
	}

}
