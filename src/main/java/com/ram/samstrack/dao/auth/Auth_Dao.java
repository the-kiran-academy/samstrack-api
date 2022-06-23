package com.ram.samstrack.dao.auth;

import javax.servlet.http.HttpSession;

import com.ram.samstrack.model.User;

public interface Auth_Dao {
	public User login(User user);
	public int logout(HttpSession session);
	
	public int forgot_Password(User user);
	
}
