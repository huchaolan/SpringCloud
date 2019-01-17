package com.clouddemo.order.service;

import com.clouddemo.order.dto.OrderDTO;


public interface OrderService {
	public OrderDTO createOrder(OrderDTO orderDTO);
}
