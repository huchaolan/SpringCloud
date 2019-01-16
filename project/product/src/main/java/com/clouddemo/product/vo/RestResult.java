package com.clouddemo.product.vo;

import lombok.Data;

@Data
public class RestResult<T> {

	private int code;
	
	private String msg;
	
	private T data;
}
