package com.clouddemo.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clouddemo.order.client.ProductClient;
import com.clouddemo.order.conver.Form2DTOConver;
import com.clouddemo.order.dataobject.OrderDetail;
import com.clouddemo.order.dto.OrderDTO;
import com.clouddemo.order.enums.ErrorEnums;
import com.clouddemo.order.exception.OrderException;
import com.clouddemo.order.form.OrderForm;
import com.clouddemo.order.service.OrderService;
import com.clouddemo.order.util.RestResultUtil;
import com.clouddemo.order.vo.RestResult;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductClient productClient;
	
	@PostMapping("/create")
	public RestResult<Map<String,String>> createOrder(@Valid OrderForm orderForm,BindingResult bresult) {
		if(bresult.hasErrors()) {
			log.error("参数错误",orderForm);
			throw new OrderException(ErrorEnums.ERROR_1.getStatus(),bresult.getFieldError().getDefaultMessage());
		}
		
		OrderDTO dto = Form2DTOConver.cover(orderForm);
		List<OrderDetail> details = dto.getOrderDetails();
		if(details.isEmpty()){
			throw new OrderException(ErrorEnums.ERROR_2);
		}
		dto = orderService.createOrder(dto);
		Map<String,String> result = new HashMap<String,String>();
		result.put("orderId",dto.getOrderId());
		return RestResultUtil.success(result);
	}
}
