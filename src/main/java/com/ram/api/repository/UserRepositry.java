package com.ram.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.api.entity.User;

@Repository
public interface UserRepositry extends JpaRepository<User, Long>{
	
	User findByFullname(String username);
	
	User findByEmail(String email);
}
