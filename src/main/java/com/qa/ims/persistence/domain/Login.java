package com.qa.ims.persistence.domain;




public class Login {
	String username;
	String password;
	public Login(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
