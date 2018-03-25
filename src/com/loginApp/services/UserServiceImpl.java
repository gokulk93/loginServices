package com.loginApp.services;

import com.loginApp.beans.User;
import com.loginApp.daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDb;
	
	@Override
	public boolean login(User user) {
		int result= userDb.validateUsers(user);
		if(result != 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean addUsers(User user) {
		if(userDb.addUser(user) !=0)
			return true;
		else
			return false;
	}

}
