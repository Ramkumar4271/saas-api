package com.ram.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.entity.User;
import com.ram.api.model.APIResponse;
import com.ram.api.model.SigninRequest;
import com.ram.api.repository.UserRepositry;
import com.ram.api.service.UserServiceImpl;
import com.ram.api.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping(value = "/signup")
	public APIResponse signup(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping(value = "/signin")
	public APIResponse autheticate(@RequestBody SigninRequest signin) {

		com.ram.api.entity.User user = userRepositry.findByEmail(signin.getEmail());

		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + signin.getEmail());
		}

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getFullname(), signin.getPassword()));

		final UserDetails userDetails = userService.loadUserByUsername(user.getFullname());

		final String token = jwtUtil.generateToken(userDetails);
		
		Map<String, String> response = new HashMap();
		response.put("token", token);
		response.put("fullname", user.getFullname());

		return APIResponse.builder().status(HttpStatus.ACCEPTED).data(response).build();
	}

}
