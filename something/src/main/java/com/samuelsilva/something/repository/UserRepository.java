package com.samuelsilva.something.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelsilva.something.model.User;

/**
 * @author samuel.silva
 */

public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByNameContaining(String name);

}
