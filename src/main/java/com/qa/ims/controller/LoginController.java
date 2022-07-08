package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.LoginDAO;
import com.qa.ims.persistence.domain.Login;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class LoginController {
	public static final Logger LOGGER = LogManager.getLogger();
		DBUtils dbutil;
		Utils utils;
		LoginDAO logindao;
		Login login;
		
		public LoginController() {
			dbutil = new DBUtils();
			utils = new Utils();
			logindao = new LoginDAO(); 
		}

		public void loggingIN() {
			LOGGER.info("Please enter username");
			String username = utils.getString();
			LOGGER.info("Please enter password");
			String password = utils.getString();
			login = new Login(username, password);
			logindao.loginCred(login);
		}
}
