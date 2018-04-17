package com.loginApp.controllers;

import com.loginApp.beans.User;
import com.loginApp.services.UserService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	User user;
	
	private JSONObject jsonObject= new JSONObject();
	
	private Map<String, String> obj =  new HashMap<String, String>();
	
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
	
	@RequestMapping(value="/login",  method=RequestMethod.POST)
	public @ResponseBody JSONObject login(@ModelAttribute User userDetails){
		jsonObject.clear();
		if(userService.login(userDetails)) {
			jsonObject.put("result", "true");
			jsonObject.put("userName", userService.getUserId(userDetails.getUserId()));
			//jsonObject=(JSONObject) obj;
			return jsonObject;
		}else {
			jsonObject.put("result", "false");
			jsonObject.put("userStatus", "Invalid credentials");
			//jsonObject=(JSONObject) obj;
			return jsonObject;
		}
	}
	
	@RequestMapping(value="/addDetails", method=RequestMethod.POST)
	public @ResponseBody JSONObject addUsers(@ModelAttribute User registrationForm, ModelMap model) throws SQLException{
		jsonObject.clear();
		System.out.println(registrationForm.toString());
		String result = userService.addUsers(registrationForm);
		jsonObject.put("result", result);
		return jsonObject;
		/*
		if(result.equalsIgnoreCase("successfull")) {
			//model.addAttribute("userStatus", "New user succesfully added. Continue your login");
			jsonObject.put("result", "New user succesfully added. Continue your login");
			return jsonObject;
		}else if(result.equalsIgnoreCase("existing user")) {
			//model.addAttribute("userStatus", "User already exists");
			jsonObject.put("result", "User already exists");
			return jsonObject;
		}else {
			//model.addAttribute("userStatus", "Registration fails. Try after some time");
			jsonObject.put("result", "User already exists");
			return jsonObject;
		}*/
		
	}
	@ExceptionHandler(DataAccessException.class)
	public String errorPage(ModelMap model) {
		model.addAttribute("status", "SQL exception occured.Please contact administrator");
		return "errorPage";
	}
}
