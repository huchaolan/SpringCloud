package com.clouddemo.order.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrderForm {

	/**
	 * 买家名字
	 */
	@NotNull(message="买家名字不能为空")
	private String buyerName;
	
	/**
	 * 买家电话
	 */
	@NotNull(message="买家电话不能为空")
	private String buyerPhone;
	
	/**
	 * 买家地址
	 */
	@NotNull(message="买家地址不能为空")
	private String buyerAddress;
	
	/**
	 * 买家微信openid
	 */
	@NotNull(message="买家微信号不能为空")
	private String buyerOpenid;
	
	/**
	 * 购买物件
	 */
	@NotNull(message="购买物件不能为空")
	private String items;
}
