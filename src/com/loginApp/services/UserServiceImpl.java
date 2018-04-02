package com.loginApp.services;

import com.loginApp.beans.User;
import com.loginApp.daos.UserDAO;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDb;
	
	@Autowired
	User user;
	
	@Override
	public boolean login(User user) {
		boolean result= userDb.validateUsers(user);
		
		if(result) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String addUsers(User user) throws DataAccessException {
		String checkExistingUser = getUserId(user.getUserId());
		if(checkExistingUser.equals(null)) {
			if(userDb.addUser(user) !=0)
				return "successfull";
			else
				return "failed";
		}else {
			return "existing user";
		}
		
		
	}

	@Override
	public String getUserId(int userId) {
		user = userDb.getUserById(userId);
		if(user!=null) {
			return user.getUserName();
		}else {
			return null;
		}
		
		
	}
	

}
