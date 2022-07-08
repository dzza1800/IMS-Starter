package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemsDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Item>{

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;

	public ItemsController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	public List<Item> readAll() {
		List<Item> items = itemsDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */

	public Item create() {
		LOGGER.info("Please Name the ITEM");
		String ItemName = utils.getString();
		LOGGER.info("Please Enter the price of the ITEM");
		long ItemPrice = utils.getLong();
		Item item = itemsDAO.create(new Item(ItemName, ItemPrice));
		LOGGER.info("Item created and Added");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		long id = utils.getLong();
		LOGGER.info("Please Name the ITEM");
		String ItemName = utils.getString();
		LOGGER.info("Please Enter the price of the ITEM");
		long ItemPrice = utils.getLong();
		Item item = itemsDAO.update(new Item(id, ItemName, ItemPrice));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}
