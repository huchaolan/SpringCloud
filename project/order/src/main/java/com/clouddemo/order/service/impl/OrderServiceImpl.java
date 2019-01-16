package com.clouddemo.order.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.clouddemo.order.dataobject.OrderMaster;
import com.clouddemo.order.dto.OrderDTO;
import com.clouddemo.order.enums.OrderStatusEnum;
import com.clouddemo.order.enums.PayStatusEnum;
import com.clouddemo.order.repository.OrderDetailRepository;
import com.clouddemo.order.repository.OrderMasterRepository;
import com.clouddemo.order.service.OrderService;
import com.clouddemo.order.util.IDGenerator;

public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	/**
	 * 创建订单
	 * @param orderDTO
	 * @return
	 */
	public OrderDTO createOrder(OrderDTO orderDTO) {
	    //TODO 查询商品信息
		//TODO 计算总价
		//TODO 扣库存
		
		
		OrderMaster om = new OrderMaster();
		om.setOrderId(IDGenerator.nextId());
		BeanUtils.copyProperties(orderDTO, om);//dto有些字段是空值
		om.setOrderStatus(OrderStatusEnum.NEW.getStatus());
		om.setPayStatus(PayStatusEnum.UNPAID.getStatus());
		om.setOrderAmount(new BigDecimal(orderDTO.getOrderDetails().size()));
		orderMasterRepository.save(om);
	    return orderDTO;
    }

}
