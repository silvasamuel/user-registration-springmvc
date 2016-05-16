package com.samuelsilva.something.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.samuelsilva.something.enums.UserStatusEnum;
import com.samuelsilva.something.model.User;
import com.samuelsilva.something.repository.Users;

/**
 * @author samuel.silva
 */

@Controller
@RequestMapping("/userregistration")
public class UserCrudController {
	
	@Autowired
	private Users users;
	
	@RequestMapping("/usercrud")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("UserCrud");
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView searchUser() {
		ModelAndView mv = new ModelAndView("UserSearch");
		
		return mv; 
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(User user) {
		user.setRegistrationDate(new Date());
		
		users.save(user);
		
		ModelAndView mv = new ModelAndView("UserCrud");
		mv.addObject("message", "User successfully saved!");
		
		return mv;
	}
	
	@ModelAttribute("userStatusList")
	public List<UserStatusEnum> getUserStatusEnumList() {
		return Arrays.asList(UserStatusEnum.values());
	}
}
