package com.ram.api.service;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ram.api.model.APIResponse;
import com.ram.api.model.SigninRequest;
import com.ram.api.repository.UserRepositry;
import com.ram.api.util.JwtUtil;

@Service
public class UserServiceImpl implements UserDetailsService {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepositry userRepositry;
	
	public APIResponse createUser(com.ram.api.entity.User user) {
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		com.ram.api.entity.User temp = userRepositry.save(user);
		
		final UserDetails userDetails = this.loadUserByUsername(temp.getFullname());		
		final String token = jwtUtil.generateToken(userDetails);
		
		return APIResponse.builder().status(HttpStatus.ACCEPTED).data(token).build();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.ram.api.entity.User user = userRepositry.findByFullname(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + username);
		}
		
		return new User(
				user.getFullname(),
				user.getPassword(),
				new ArrayList<>());
	}

}
