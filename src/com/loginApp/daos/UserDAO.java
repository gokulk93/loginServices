package com.loginApp.daos;

import java.sql.SQLException;

import com.loginApp.beans.User;

public interface UserDAO {
	public boolean validateUsers(User user);
	public int addUser(User user);
	public User getUserById(int userId);
}
