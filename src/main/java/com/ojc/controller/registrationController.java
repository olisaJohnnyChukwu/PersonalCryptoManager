package com.ojc.controller;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ojc.Service.IUserService;
import com.ojc.exception.UserAlreadyExistException;
import com.ojc.model.UserEntity;

@Controller
public class registrationController {
	
	@Autowired
	IUserService UserService;
	
	@GetMapping("/registration")
	public String register(Model model) {
		UserEntity user=new UserEntity();
		
		model.addAttribute("user", user);
		
		return "registration";
		
	}
	
	
	@PostMapping("/registration")
	public String postRegister(Model model,@ModelAttribute(value="user")@Valid UserEntity user) {
		
		 //UserEntity  register =UserService.register(user);
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		
		 try {
			 if(!user.getPassword().equals(user.getRepeatPassword())) {
				 model.addAttribute("password","Passwords dont match");
				 return "registration";
			 }else {
				 user.setPassword(encoder.encode(user.getPassword()));
				 UserEntity  register =UserService.register(user); 
				 model.addAttribute("user", user);
				 return "home";
			 }
			
		 }catch(UserAlreadyExistException uaeEx) {
			 model.addAttribute("error", uaeEx.getLocalizedMessage());
			 return "failedRegisteration";
		 }
		 
		

		
	}

}
