package com.samuelsilva.something.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelsilva.something.enums.UserStatusEnum;
import com.samuelsilva.something.model.User;
import com.samuelsilva.something.repository.UserRepository;
import com.samuelsilva.something.repository.filter.UserFilter;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		user.setRegistrationDate(new Date());
		
		userRepository.save(user);
	}

	public void delete(Long id) {
		userRepository.delete(id);
	}

	public String changeStatus(Long id) {
		User user = userRepository.findOne(id);
		
		if(UserStatusEnum.ACTIVE.equals(user.getStatus())) {
			user.setStatus(UserStatusEnum.INACTIVE);
		} else {
			user.setStatus(UserStatusEnum.ACTIVE);
		}
		
		userRepository.save(user);
		
		return user.getStatus().getDescription();
	}
	
	public List<User> search(UserFilter filter) {
		// Name cannot be null
		String name = filter.getName() == null ? "%" : filter.getName();
				
		return userRepository.findByNameContaining(name);
	}

}
