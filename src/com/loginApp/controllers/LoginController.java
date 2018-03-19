package com.loginApp.controllers;

import com.loginApp.beans.User;
import com.loginApp.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	
	
	@RequestMapping("/")
	public String homePage(){
		return "loginPage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("SpringWeb") User user, ModelMap model){
	
		user.setName(model.addAttribute("name",user.getName()).toString());
		user.setPassword(model.addAttribute("password", user.getPassword()).toString());
		System.out.println(user.getName());
		if(loginService.login(user))
			return "home";
		else			
			return "loginPage";
		
	}

}
