package com.samuelsilva.something.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samuelsilva.something.model.User;

/**
 * @author samuel.silva
 */

public interface Users extends JpaRepository<User, Long> {

}
