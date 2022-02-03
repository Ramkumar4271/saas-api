package com.ram.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.api.entity.Order;
import com.ram.api.model.APIResponse;
import com.ram.api.service.OrderService;

@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping("/")
	public APIResponse getOrders() {
		return this.service.getOrders();
	}
	
	@PostMapping("/new-order")
	public APIResponse createOrder(@Valid @RequestBody Order order) {
		return this.service.createOrder(order);
	}
	
	@DeleteMapping("/{id}")
	public APIResponse deleteOrder(@Valid @PathVariable(required = true) long id) {
		return this.service.deleteOrder(id);
	}
	
	@PostMapping("/place-orders")
	public APIResponse placeOrders(@RequestBody List<Order> orders) {
		return this.service.placeOrders(orders);
	}
}
