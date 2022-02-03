package com.ram.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ram.api.model.APIResponse;
import com.ram.api.repository.ServiceRepository;

@Service
public class ServiceServiceImpl implements ServiceService {
	
	@Autowired
	private ServiceRepository repository;

	@Override
	public APIResponse getServices() {
		return APIResponse.builder().status(HttpStatus.OK).data(this.repository.findAll()).build();
	}

}
