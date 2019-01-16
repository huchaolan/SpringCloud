package com.clouddemo.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

	UNPAID(0,"未支付"),
	PAID(1,"已支付");
	
	private int status;
	
	private String msg;
	
	PayStatusEnum(int status,String msg) {
		this.status = status;
		this.msg = msg;
	}
}
