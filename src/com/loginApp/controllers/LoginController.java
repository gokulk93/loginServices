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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	User user;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String indexPage(){
		return "index";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registrationPage(){
		return "registrationPage";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(){
		return "loginPage";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homePage(){
		return "home";
	}
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody String login( @RequestParam int userId,@RequestParam String password, ModelMap model){
		user.setUserId(userId);
		user.setPassword(password);		
		System.out.println("In Conroller");
		if(userService.login(user)) {
			
			//model.addAttribute("name", userService.getUserId(userId));
			return "true";
		}else {
			//model.addAttribute("userStatus", "Invalid credentials");
			return "false";
		}
	}
	
	@RequestMapping(value="/addDetails", method=RequestMethod.POST)
	public String addUsers(@ModelAttribute User registrationForm, ModelMap model) throws SQLException{
		String result = userService.addUsers(registrationForm);
		if(result.equalsIgnoreCase("successfull")) {
			model.addAttribute("userStatus", "New user succesfully added. Continue your login");
			return "loginPage";
		}else if(result.equalsIgnoreCase("existing user")) {
			model.addAttribute("userStatus", "User already exists");
			return "registrationPage";
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
