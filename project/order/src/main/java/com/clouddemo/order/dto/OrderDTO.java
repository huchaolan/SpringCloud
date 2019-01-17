package com.clouddemo.order.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

import com.clouddemo.order.dataobject.OrderDetail;

@Data
public class OrderDTO {

	private String orderId;
	
	/**
	 * 买家名字
	 */
	private String buyerName;
	
	/**
	 * 买家电话
	 */
	private String buyerPhone;
	
	/**
	 * 买家地址
	 */
	private String buyerAddress;
	
	/**
	 * 买家微信openid
	 */
	private String buyerOpenid;
	
	/**
	 * 订单总金额
	 */
	private BigDecimal orderAmount;
	
	/**
	 * 订单状态, 默认为新下单
	 */
	private int orderStatus;
	
	/**
	 * 支付状态, 默认未支付
	 */
	private int payStatus;
	
	private List<OrderDetail> orderDetails;
}
