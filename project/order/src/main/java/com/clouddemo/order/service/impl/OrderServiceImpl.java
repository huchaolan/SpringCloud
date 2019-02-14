package com.clouddemo.order.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouddemo.order.client.ProductClient;
import com.clouddemo.order.client.bean.ProductInfo;
import com.clouddemo.order.dataobject.OrderDetail;
import com.clouddemo.order.dataobject.OrderMaster;
import com.clouddemo.order.dto.OrderDTO;
import com.clouddemo.order.enums.ErrorEnums;
import com.clouddemo.order.enums.OrderStatusEnum;
import com.clouddemo.order.enums.PayStatusEnum;
import com.clouddemo.order.exception.OrderException;
import com.clouddemo.order.repository.OrderDetailRepository;
import com.clouddemo.order.repository.OrderMasterRepository;
import com.clouddemo.order.service.OrderService;
import com.clouddemo.order.util.IDGenerator;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private ProductClient prodcutClient;
	/**
	 * 创建订单
	 * @param orderDTO
	 * @return
	 */
	public OrderDTO createOrder(OrderDTO orderDTO) {
		addProductInfo(orderDTO);
		//TODO 计算总价
		countTotalPricel(orderDTO);
		//TODO 扣库存
		
		OrderMaster om = new OrderMaster();
		orderDTO.setOrderId(IDGenerator.nextId());
		BeanUtils.copyProperties(orderDTO, om);//复制属性
		om.setOrderStatus(OrderStatusEnum.NEW.getStatus());
		om.setPayStatus(PayStatusEnum.UNPAID.getStatus());
		om = orderMasterRepository.save(om);
		List<OrderDetail> orderList = orderDTO.getOrderDetails();
		for(OrderDetail order:orderList) {
			order.setOrderId(om.getOrderId());
			order.setDetailId(IDGenerator.nextId());
		}
		orderList = orderDetailRepository.saveAll(orderList);
	    return orderDTO;
    }
	
	/**
	 * 计算总价
	 * @param orderDTO
	 */
	private void countTotalPricel(OrderDTO orderDTO) {
		List<OrderDetail> orderList = orderDTO.getOrderDetails();
		BigDecimal total = new BigDecimal(0);
		for(OrderDetail od:orderList) {
			int quan = od.getProductQuantity();
			BigDecimal price = od.getProductPrice();
			BigDecimal pp = price.multiply(new BigDecimal(quan));
			total = total.add(pp);
		}
		orderDTO.setOrderAmount(total);
    }

	/**
	 * 为订单添加产品信息
	 * @param orderDTO
	 */
	private void addProductInfo(OrderDTO orderDTO) {
		List<OrderDetail> orderDetailList = orderDTO.getOrderDetails();
		List<String> productIdList = orderDetailList.stream().map(OrderDetail::getProductId).collect(Collectors.toList());
		List<ProductInfo> productInfos = prodcutClient.getProductInfo(productIdList);
		if(productInfos.isEmpty()) {
			throw new OrderException(ErrorEnums.ERROR_4);
		}
		
		Map<String,ProductInfo> productIdMap = new HashMap<String,ProductInfo>();
	    for(ProductInfo product:productInfos){
	    	productIdMap.put(product.getProductId(), product);
	    }
	    
	    for(OrderDetail orderDetail:orderDetailList) {
	    	String prodcutId=orderDetail.getProductId();
	    	if(productIdMap.containsKey(prodcutId)) {
	    		ProductInfo pinfo = productIdMap.get(prodcutId);
	    		orderDetail.setProductIcon(pinfo.getProductIcon());
	    		orderDetail.setProductName(pinfo.getProductName());
	    		orderDetail.setProductPrice(pinfo.getProductPrice());
	    	}else{
	    		throw new OrderException(ErrorEnums.ERROR_5);
	    	}
	    }
    }

}
