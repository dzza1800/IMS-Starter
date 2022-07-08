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

import com.qa.ims.controller.OrderController;

import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {


		@Mock
		private Utils utils;

		@Mock
		private OrderDAO dao;

		@InjectMocks
		private OrderController controller;

		@Test
		public void testCreate() {
			final long OrderID = 1L;
			final Order created = new Order(OrderID, 1L, 1L);

			Mockito.when(utils.getLong()).thenReturn(OrderID);
			Mockito.when(utils.getLong()).thenReturn(1L);
			Mockito.when(utils.getLong()).thenReturn(1L);
			Mockito.when(dao.create(created)).thenReturn(created);

			assertEquals(created, controller.create());

			Mockito.verify(utils, Mockito.times(3)).getLong();
		
			Mockito.verify(dao, Mockito.times(1)).create(created);
		}

		@Test
		public void testReadAll() {
			List<Order> order = new ArrayList<>();
			order.add(new Order(1L, 1L, 1L));

			Mockito.when(dao.readAll()).thenReturn(order);

			assertEquals(order, controller.readAll());

			Mockito.verify(dao, Mockito.times(1)).readAll();
		}

		@Test
		public void testUpdate() {
			Order updated = new Order(1L, 1L, 1L, 1L);

			Mockito.when(this.utils.getLong()).thenReturn(updated.getOrder_id());
			Mockito.when(this.utils.getLong()).thenReturn(updated.getCustomer_id());
			Mockito.when(this.utils.getLong()).thenReturn(updated.getItems_id());
			Mockito.when(this.utils.getLong()).thenReturn(updated.getQuantity());
			Mockito.when(this.dao.update(updated)).thenReturn(updated);

			assertEquals(updated, this.controller.update());

			Mockito.verify(this.utils, Mockito.times(4)).getLong();
			Mockito.verify(this.dao, Mockito.times(1)).update(updated);
		}

		@Test
		public void testDeleteItem() {
			

			Mockito.when(utils.getLong()).thenReturn(2L);
			Mockito.when(utils.getLong()).thenReturn(1L);
 
			assertEquals(0, this.controller.deleteItem());

			Mockito.verify(utils, Mockito.times(1)).getLong();
			
	}
		@Test
		public void testDeleteOrder() {
			

			Mockito.when(utils.getLong()).thenReturn(2L);
			Mockito.when(utils.getLong()).thenReturn(1L);
			
			Mockito.when(dao.delete(1L)).thenReturn(1);
 
			assertEquals(1L, this.controller.deleteOrder());

			Mockito.verify(utils, Mockito.times(1)).getLong();
			Mockito.verify(dao, Mockito.times(1)).delete(1L);
	}

}
