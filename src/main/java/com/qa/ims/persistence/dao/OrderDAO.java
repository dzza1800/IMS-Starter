package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;


public class OrderDAO implements Dao<Order>{
	public static final Logger LOGGER = LogManager.getLogger();


	
	public OrderDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM FinalOrders");) {
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Order read(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM FinalOrders WHERE order_id = ?");) {
			statement.setLong(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet); 
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	
	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM FinalOrders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO Orders(customer_id, itemsID, itemsQuantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, order.getCustomer_id());
			statement.setLong(2, order.getItems_id());
			statement.setLong(3, order.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE Orders SET itemsID = ?, itemsQuantity = ? WHERE customer_id = ? AND order_id = ?");) {
			statement.setLong(1, order.getItems_id());
			statement.setLong(2, order.getQuantity());
			statement.setLong(3, order.getCustomer_id());
			statement.setLong(4, order.getOrder_id());
			statement.executeUpdate();
			return read(order.getOrder_id());
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM Orders WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0; 
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		long orderID = resultSet.getLong("order_id");
		long id = resultSet.getLong("customer_id");
		long id2 = resultSet.getLong("itemsID");
		String fname = resultSet.getString("first_name");
		String lname = resultSet.getString("surname");
		String iname = resultSet.getString("Item_Name");
		long quantity = resultSet.getLong("itemsQuantity");
		long userTotalPriceForOnePrice = resultSet.getLong("Item_Price");
		return new Order(orderID, id, fname, lname, id2, iname,quantity, userTotalPriceForOnePrice);
	}

	public int deleteItem(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE Orders SET itemsID = 0, itemsQuantity = 0 WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0; 
	}

}
