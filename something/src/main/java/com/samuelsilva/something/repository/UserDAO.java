package com.samuelsilva.something.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelsilva.something.model.User;

/**
 * @author samuel.silva
 */

public interface UserDAO extends JpaRepository<User, Long> {

}
