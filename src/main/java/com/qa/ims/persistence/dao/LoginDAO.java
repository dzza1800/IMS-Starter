package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.IMS;
import com.qa.ims.persistence.domain.Login;
import com.qa.ims.utils.DBUtils;

public class LoginDAO {
	public static final Logger LOGGER = LogManager.getLogger();
	public Login loginCred(Login login) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND UserPassword = ?");) {
			statement.setString(1, login.getUsername());
			statement.setString(2, login.getPassword());
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			return modelFromResultSet(resultSet);
			
		}
			catch(Exception e) {
				System.err.println("Wrong");
				return null;
			}
		
	}
	
	public Login modelFromResultSet(ResultSet resultSet) throws SQLException {
		String username = resultSet.getString("username");
		String password = resultSet.getString("UserPassword");
		
		return new Login(username, password);
	
	}
	
	

}
