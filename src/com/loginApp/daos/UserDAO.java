package com.loginApp.daos;

import java.sql.SQLException;
import java.util.List;

import com.loginApp.beans.User;

public interface UserDAO {
	public boolean checkLogin(User user);
	public int addUser(User user);
	public User getUserById(int userId);
	public boolean validateUser(int userId);
}
