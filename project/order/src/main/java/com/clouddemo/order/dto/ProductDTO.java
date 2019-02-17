package com.clouddemo.order.dto;

import lombok.Data;

@Data
public class ProductDTO {

	public ProductDTO(){}
	public ProductDTO(String productId, int productQuantity) {
		this.productId = productId;
		this.productQuantity = productQuantity;
    }

	private String productId;
	
	private int productQuantity;
}
