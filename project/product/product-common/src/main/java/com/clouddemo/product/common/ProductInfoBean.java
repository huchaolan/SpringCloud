package com.clouddemo.product.common;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductInfoBean {
	/**
	 * 产品ID
	 */
	private String productId;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品价格
	 */
	private BigDecimal productPrice;
	
	/**
	 * 库存
	 */
	private Integer productStock;
	
	/**
	 * 描述
	 */
	private String productDescription;
	
	/**
	 * 小图
	 */
	private String productIcon;
	
	/**
	 * 产品状态(商品状态,0正常1下架)
	 */
	private Integer productStatus;
	
	/**
	 * 类目编号
	 */
	private Integer categoryType;
}
