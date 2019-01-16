package com.clouddemo.product.dataobject;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ProductCategory {

	@Id
	@GeneratedValue//自增
	private Integer categoryId;
	
	/**
	 * 类目名字
	 */
	private String categoryName;
	
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
