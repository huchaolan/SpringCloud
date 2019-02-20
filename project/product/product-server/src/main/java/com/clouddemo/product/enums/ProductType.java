package com.clouddemo.product.enums;

import lombok.Getter;

@Getter
public enum ProductType {

	DOWN(1,"下架"),
	UP(0,"上架");
	
	private int status;
	private String msg;
	
	ProductType(int status,String msg){
		this.status = status;
		this.msg= msg;
	}
	
}
