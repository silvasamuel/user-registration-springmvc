package com.samuelsilva.something.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.samuelsilva.something.enums.UserStatusEnum;
import com.samuelsilva.something.model.User;
import com.samuelsilva.something.repository.UserDAO;

/**
 * @author samuel.silva
 */

@Controller
@RequestMapping("/userregistration")
public class UserCrudController {
	
	private static final String USER_CRUD = "UserCrud";
	private static final String USER_SEARCH = "UserSearch";
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/usercrud")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView(USER_CRUD);
		mv.addObject(new User());
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView searchUser() {
		List<User> allUsers = userDAO.findAll();
		
		ModelAndView mv = new ModelAndView(USER_SEARCH);
		mv.addObject("userList", allUsers);
		
		return mv; 
	}
	
	@RequestMapping("{id}")
	public ModelAndView update(@PathVariable("id") User user) {
		ModelAndView mv = new ModelAndView(USER_CRUD);
		mv.addObject(user);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@Validated User user, Errors errors, RedirectAttributes redirectAttributes) {
		user.setRegistrationDate(new Date());
		
		if(errors.hasErrors()) {
			return USER_CRUD;
		}
		
		userDAO.save(user);
		redirectAttributes.addFlashAttribute("message", "User successfully saved!");
		
		return "redirect:/userregistration/usercrud";
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		userDAO.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "User successfully deleted!");
		return "redirect:/userregistration";
	}
	
	@ModelAttribute("userStatusList")
	public List<UserStatusEnum> getUserStatusEnumList() {
		return Arrays.asList(UserStatusEnum.values());
	}
}
