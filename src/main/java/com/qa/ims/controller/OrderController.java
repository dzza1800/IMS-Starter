package com.qa.ims.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;

	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	public List<Order> readAll() {
		List<Order> order = orderDAO.readAll();
		for (Order orders : order) {
			LOGGER.info(orders); 
		}
		return order;
	}

	/**
	 * Creates a customer by taking in user input
	 */

	public Order create() {
		LOGGER.info("Please Put the id of the customer the order is for");
		long id1 = utils.getLong();
		LOGGER.info("Enter the item's id");
		long id2 = utils.getLong();
		LOGGER.info("Enter the item's quantity");
		long id3 = utils.getLong();
		Order order = orderDAO.create(new Order(id1, id2, id3));
		LOGGER.info("order created for user id " + id1 + " with item id " + id2 + " With item quantity of: " + id3);
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	public Order update() {
		LOGGER.info("Please state the id of the order to update an item on");
		long id1 = utils.getLong();
		LOGGER.info("Please state the id of the customer (must be existing within the order_id)");
		long id2 = utils.getLong();
		LOGGER.info("enter id of the item (must be existing within the items table)");
		long id3 = utils.getLong();
		LOGGER.info("enter item quantity");
		long id4 = utils.getLong();
		Order order = orderDAO.update(new Order(id1, id2, id3, id4));
		LOGGER.info("Item " + id3 + " is updated onto order id " + id1);
		return order;
	}


	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	public int delete() {
		LOGGER.info("Press 1 to delete an item from an order, Press 2 to delete an order");
		Long option = utils.getLong();
		if(option == 1) {
			LOGGER.info("Please enter the id of the order where the item is to be deleted");
			Long id = utils.getLong();
			LOGGER.info("item from order " + id + " is Deleted");
			return orderDAO.deleteItem(id);
		}
		
		else if(option == 2)
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("order " + id + " Deleted");
		return orderDAO.delete(id);
	}
	
	public int deleteOrder() {
		

		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		LOGGER.info("order " + id + " Deleted");
		return orderDAO.delete(id);
	}
	public int deleteItem() {
			LOGGER.info("Please enter the id of the order where the item is to be deleted");
			Long id = utils.getLong();
			LOGGER.info("item from order " + id + " is Deleted");
			return orderDAO.deleteItem(id);
	}
	
}
