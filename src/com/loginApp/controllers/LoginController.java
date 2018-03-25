package com.loginApp.controllers;

import com.loginApp.beans.User;
import com.loginApp.services.UserService;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	User user;
	
	
	@RequestMapping("/")
	public String loginPage(){
		return "loginPage";
	}
	
	@RequestMapping("/register")
	public String registration(){
		return "registrationPage";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password, ModelMap model){
		user.setUserName(username);
		user.setPassword(password);		
		if(userService.login(user)) {
			model.addAttribute("name", username);
			return "home";
		}else {
			model.addAttribute("userStatus", "Invalid credentials");
			return "loginPage";
		}
	}
	
	@RequestMapping(value="/addDetails", method=RequestMethod.POST)
	public String addUsers(@ModelAttribute User userForm, ModelMap model) throws SQLException{
		
		if(userService.addUsers(userForm)) {
			model.addAttribute("userStatus", "New user succesfully added. Continue your login");
			return "loginPage";
		}else {
			model.addAttribute("userStatus", "Registration fails. Try after some time");
			return "registrationPage";
		}
		
	}
	@ExceptionHandler(DataAccessException.class)
	public String errorPage(ModelMap model) {
		model.addAttribute("status", "SQL exception occured.Please contact administrator");
		return "errorPage";
	}
}
