package com.clouddemo.product.vo;

import java.math.BigDecimal;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class ProductInfoVO {

	@JsonProperty("id")
	private String productId;
	
	@JsonProperty("name")
	private String productName;
	
	@JsonProperty("price")
	private BigDecimal productPrice;
	
	@JsonProperty("description")
	private String productDescription;
	
	@JsonProperty("icon")
	private String productIcon;
	
}
