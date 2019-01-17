package com.clouddemo.order.enums;

import lombok.Getter;

@Getter
public enum ErrorEnums {

	ERROR_1("9999","参数错误"),
	ERROR_2("9999","转换错误"),
	ERROR_3("9999","物件不能为空")
	;
	
	private String status;
	private String msg;
	private ErrorEnums(String status,String msg){
		this.status = status;
		this.msg = msg;
	}
}
