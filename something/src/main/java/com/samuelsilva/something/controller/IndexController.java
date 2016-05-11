package com.samuelsilva.something.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.samuelsilva.something.model.User;

/**
 * @author samuel.silva
 */

@Controller
@RequestMapping("/userregistration")
public class IndexController {
	
	@RequestMapping("/new")
	public String init() {
		return "SomethingIndex";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(User user) {
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getStatus());
		System.out.println(user.getId());
		System.out.println(user.getRegistrationDate());
		
		return "SomethingIndex";
	}
}
