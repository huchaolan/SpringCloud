package com.clouddemo.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

	NEW(0,"新下单"),
	FINISH(1,"已完成");
	
	private int status;
	
	private String msg;
	
	OrderStatusEnum(int status,String msg){
		this.status = status;
		this.msg = msg;
	}
}
