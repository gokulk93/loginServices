package com.loginApp.services;

import java.sql.SQLException;

import com.loginApp.beans.User;

public interface UserService {
	public boolean login(User user);
	public boolean addUsers(User user);
}
