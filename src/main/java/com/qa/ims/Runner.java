package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.LoginController;





public class Runner {

	public static final Logger LOGGER = LogManager.getLogger();
	
	public static void main(String[] args) {
		LoginController loginC = new LoginController();

			IMS ims = new IMS();
			ims.imsSystem();
			LOGGER.info("SO LONG!");	
		
	}

}
