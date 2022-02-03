package com.ram.api.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ram.api.entity.Order;
import com.ram.api.model.APIResponse;
import com.ram.api.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repository;

	@Override
	public APIResponse getOrders() {
		return APIResponse.builder().status(HttpStatus.OK).data(this.repository.findAll()).build();
	}

	@Override
	public APIResponse createOrder(@Valid Order order) {
		return APIResponse.builder().status(HttpStatus.CREATED).data(this.repository.save(order)).build();
	}

	@Override
	public APIResponse deleteOrder(@Valid long id) {
		Optional<Order> orderOpt = this.repository.findById(id);

		if (orderOpt.isEmpty()) {
			return APIResponse.builder().status(HttpStatus.NOT_FOUND)
					.error("Order(" + id + ") is not existing!").build();
		}
		
		this.repository.deleteById(id);

		return APIResponse.builder().status(HttpStatus.OK).data("Order(" + id + ") is deleted successfully!").build();
	}

	@Override
	public APIResponse placeOrders(List<Order> orders) {
		this.repository.deleteAll();
		return APIResponse.builder().status(HttpStatus.OK).data("You have placed your orders successfully.").build();
	}

}
