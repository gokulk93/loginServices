package com.loginApp.daos;

import com.loginApp.beans.User;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Override
	public boolean validateUsers(User user){
		if(user.getName().equalsIgnoreCase("gokul") && user.getPassword().equals("Welcome"))
			return true;
		else
			return false;
	}
}
