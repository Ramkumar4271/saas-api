package com.ram.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.model.APIResponse;
import com.ram.api.service.PricingService;

@RestController
@RequestMapping("/pricing")
public class PricingController {

	@Autowired
	private PricingService service;

	@GetMapping("/")
	public APIResponse getServices() {
		return this.service.getPricings();
	}
}
