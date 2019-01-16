package com.clouddemo.order.dataobject;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class OrderDetail {

	@Id
	private String detailId;
	
	/**
	 * 订单Id
	 */
	private String orderId;
	
	/**
	 * 产品Id
	 */
	private String productId;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 价格
	 */
	private BigDecimal productPrice;
	
	/**
	 * 数量
	 */
	private int productQuantity;
	
	/**
	 * 小图
	 */
	private String productIcon;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 修改时间
	 */
	private Timestamp updateTime;	
}
