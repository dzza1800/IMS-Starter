package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	private static OrderDAO DAO;

	@Before
	public void setup() {
		DAO = new OrderDAO();
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	} 

	@Test
	public void testCreate() {
		
		final Order created = new Order(1L, 1L, 1L, 1L);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		long quan = 2;
		expected.add(new Order(1L, 1L,"jordan", "harrison", 1L, "Test", quan, 46));
		assertEquals(expected, DAO.readAll());
	}
	@Test
	public void testReadLatest() {
		long quan = 2;
		assertEquals(new Order(1L, 1L,"jordan", "harrison", 1L, "Test", quan, 46), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		long quan = 2;
		assertEquals(new Order(1L, 1L,"jordan", "harrison", 1L, "Test", quan, 46), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		long quan = 3;
		final Order updated = new Order(1L, 1L, 1L, quan);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}


}
