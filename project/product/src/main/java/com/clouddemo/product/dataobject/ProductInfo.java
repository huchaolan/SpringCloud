package com.clouddemo.product.dataobject;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductInfo {
	/**
	 * 产品ID
	 */
	@Id//主键
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
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 修改时间
	 */
	private Timestamp updateTime;
}
