package com.loginApp.services;

import com.loginApp.beans.User;
import com.loginApp.daos.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginDAO loginDb;
	
	@Override
	public boolean login(User user) {
		System.out.println(user.getName());
		return loginDb.validateUsers(user);
	}

}
