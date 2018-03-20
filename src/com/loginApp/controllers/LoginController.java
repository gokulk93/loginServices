package com.loginApp.controllers;

import com.loginApp.beans.User;
import com.loginApp.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	@Autowired
	User user;
	
	
	@RequestMapping("/")
	public String homePage(ModelMap model){
		
		return "loginPage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password, ModelMap model){
		System.out.println(username+" "+password);
		user.setName(username);
		user.setPassword(password);
		if(loginService.login(user)) {
			model.addAttribute("name", username);
			return "home";
		}else {
			
			model.addAttribute("invalidCredentials", "Invalid credentials");
			return "loginPage";
		}
		
	}

}
