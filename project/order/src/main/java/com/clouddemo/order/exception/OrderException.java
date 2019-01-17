package com.clouddemo.order.exception;

import com.clouddemo.order.enums.ErrorEnums;

public class OrderException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    private String code = null;
    private String msg = null;
    public OrderException(String code,String msg){
    	super(msg);
    	this.code = code;
    	this.msg = msg;
    }
    
    public OrderException(ErrorEnums error){
    	super(error.getMsg());
    	this.code = error.getStatus();
    	this.msg = error.getMsg();
    }

}
