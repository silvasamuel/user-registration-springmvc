package com.samuelsilva.something.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelsilva.something.enums.UserStatusEnum;
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

	public String changeStatus(Long id) {
		User user = userDAO.findOne(id);
		
		if(UserStatusEnum.ACTIVE.equals(user.getStatus())) {
			user.setStatus(UserStatusEnum.INACTIVE);
		} else {
			user.setStatus(UserStatusEnum.ACTIVE);
		}
		
		userDAO.save(user);
		
		return user.getStatus().getDescription();
	}

}
