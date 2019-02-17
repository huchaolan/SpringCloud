package com.clouddemo.product.enums;

import lombok.Getter;

@Getter
public enum ProductError {

	PRODUCT_NOT_EXIST("9999","产品不存在"),
	INVENTORY_SHORTAGE("8888","库存不足")
	;
	
	private String code = null;
	
	private String msg = null;
	
	private ProductError(String code,String msg) {
		this.code = code;
		this.msg = msg;
	} 
}
