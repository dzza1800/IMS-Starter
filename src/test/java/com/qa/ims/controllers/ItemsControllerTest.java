package com.qa.ims.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.qa.ims.controller.ItemsController;
import com.qa.ims.persistence.dao.ItemsDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemsControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ItemsDAO dao;

	@InjectMocks
	private ItemsController controller;

	@Test
	public void testCreate() {
		final String ItemName = "Car";
		final Item created = new Item(ItemName, 23);

		Mockito.when(utils.getString()).thenReturn(ItemName);
		Mockito.when(utils.getLong()).thenReturn(23L);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1, "Car", 23));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Item updated = new Item(1L ,"Car", 23L);

		Mockito.when(utils.getLong()).thenReturn(1L, 23L);
		Mockito.when(utils.getString()).thenReturn("Car");
		
		
		Mockito.when(dao.update(updated)).thenReturn(updated);

		assertEquals(updated, controller.update());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
