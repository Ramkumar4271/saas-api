package com.ram.api.service;

import java.util.List;

import javax.validation.Valid;

import com.ram.api.entity.Order;
import com.ram.api.model.APIResponse;

public interface OrderService {

	APIResponse getOrders();

	APIResponse createOrder(@Valid Order order);

	APIResponse deleteOrder(@Valid long id);

	APIResponse placeOrders(List<Order> orders);

}
