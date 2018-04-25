package com.yash.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yash.userapp.pojo.User;
import com.yash.userapp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value="/users", method=RequestMethod.POST)
	public String prepareAndSaveUser(@ModelAttribute User user) {

		userService.addUser(user);
		return "user saved name : "+user.getName()+" salary : "+user.getSalary();
		
	}

}
