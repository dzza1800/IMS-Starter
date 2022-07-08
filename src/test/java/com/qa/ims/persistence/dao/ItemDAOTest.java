package com.qa.ims.persistence.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	} 

	@Test
	public void testCreate() {
		long price = 23;
		final Item created = new Item(2L, "Test", price);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		long price = 23;
		expected.add(new Item(1L, "Test", price));
		assertEquals(expected, DAO.readAll());
	}
	@Test
	public void testReadLatest() {
		long price = 23;
		assertEquals(new Item(1L, "Test", price), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		long price = 23;
		assertEquals(new Item(ID, "Test", price), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		long price = 23;
		final Item updated = new Item(1L, "Test", price);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}

}
