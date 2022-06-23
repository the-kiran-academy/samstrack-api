package com.ram.samstrack.service.auth;

import javax.servlet.http.HttpSession;

import com.ram.samstrack.model.User;

public interface Auth_Service {

	public User login(User user);
	public int logout(HttpSession session);
	
	public int forgot_Password(User user);

}
