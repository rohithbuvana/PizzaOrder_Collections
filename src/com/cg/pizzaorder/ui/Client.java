package com.cg.pizzaorder.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.cg.pizzaorder.bean.Customer;
import com.cg.pizzaorder.bean.PizzaOrder;
import com.cg.pizzaorder.exception.PizzaException;
import com.cg.pizzaorder.service.IPizzaOrderService;
import com.cg.pizzaorder.service.PizzaOrderService;

public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IPizzaOrderService service;
		{
			service = new PizzaOrderService();
		}
		int choice;

		char iterator;
		do {
			System.out.println(
				"###*** WELCOME TO JUSTEAT PIZZAS ***###"+	"\n\t ***Menu***" + "\n\t 1.Place Order" + "\n\t 2.Display Order" + "\n\t 3.Exit" + "\nEnter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				//Getting User Input for Placing the Order
				try {
					Customer customer = new Customer();
					PizzaOrder pizzaOrder = new PizzaOrder();
					System.out.println("Enter the name of the customer ");
					customer.setCustName(sc.next());
					System.out.println("Enter customer address ");
					customer.setAddress(sc.next());
					System.out.println("Enter customer phone number ");
					customer.setPhone(sc.next());
					System.out.println("Toppings available are \n\tCapsicum(Extra Rs30)\n\tMushroom(Extra Rs50)\n\tJalapeno(Extra Rs70)\n\tPaneer(Extra Rs85)");
					System.out.println("Type of pizza topping preferred ");

					while (true) {
						String toppingChoice = sc.next().toLowerCase();
						int flag = 1;
						switch (toppingChoice) {
						case "capsicum":
							pizzaOrder.setTotalPrice(380);
							break;
						case "mushroom":
							pizzaOrder.setTotalPrice(400);
							break;
						case "jalapeno":
							pizzaOrder.setTotalPrice(420);
							break;
						case "paneer":
							pizzaOrder.setTotalPrice(435);
							break;
						default:
							System.out.println("Wrong Selection of topping.....Renter...");
							flag = 0;
						}
						if (flag == 1)
							break;
					}
					System.out.println("Price : " +pizzaOrder.getTotalPrice());
					LocalDate orderDate = LocalDate.now();
					System.out.println("Order Date: " + orderDate);
					pizzaOrder.setOrderDate(orderDate);

					System.out.println("Pizza Order Successfully Placed with Order Id:"
							+ service.placeOrder(customer, pizzaOrder));
				} catch (PizzaException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				//Getting Order Id from the user to display the required Order
				System.out.println("Enter the Order Id: ");
				try {
					PizzaOrder pizzaOrder = service.getOrderDetails(sc.nextInt());
					//Displaying Order Details
					System.out.println("###########################################################################################");
					System.out.println("===========================================================================================");
					System.out.println("\t\t ***Order Details***");
					System.out.println("\tOrder Date: " + pizzaOrder.getOrderDate());
					System.out.println("\tCustomer Id: " + pizzaOrder.getCustomerId());
					System.out.println("\tTotal Price: " + pizzaOrder.getTotalPrice());
					System.out.println("###########################################################################################");
					System.out.println("===========================================================================================");
				} catch (PizzaException e) {
					
					System.out.println("Exception thrown: " + e.getMessage());
				}
				break;
			case 3:
				// To exit the Application
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Menu selection....");
				break;
			}
			
			System.out.println("Do you want to continue(y/n): ");
			iterator = sc.next().toLowerCase().charAt(0);

		} while (iterator == 'y');
		sc.close();
	}
}
