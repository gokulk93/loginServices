package com.loginApp.daos;

import com.loginApp.beans.User;

public interface LoginDAO {
	public boolean validateUsers(User user);
}
