package com.loginApp.daos;

import com.loginApp.beans.User;

public interface UserDAO {
	public int validateUsers(User user);
	public int addUser(User user);
}
