package com.samuelsilva.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelsilva.something.model.User;
import com.samuelsilva.something.repository.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void save(User user) {
		userDAO.save(user);
	}

	public void delete(Long id) {
		userDAO.delete(id);
	}

}
