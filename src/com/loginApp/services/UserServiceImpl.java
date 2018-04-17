package com.loginApp.services;

import com.loginApp.beans.User;
import com.loginApp.daos.UserDAO;
import com.loginApp.daos.UserDAOImpl;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
	UserDAO userDb;
	
	@Autowired
	User user;
	
	@Override
	public boolean login(User user) {
	    LOGGER.info("Logining services");
		boolean result= userDb.checkLogin(user);
		
		if(result) { 
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String addUsers(User newUserDetails) throws DataAccessException {
		LOGGER.info("Adddig user service!!!");
		int result = userDb.addUser(newUserDetails);
		if(result ==1) {
			return "successfull";
		}else if(result == -1) {
			return "existing user";
		}else {
			return "failed";
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
