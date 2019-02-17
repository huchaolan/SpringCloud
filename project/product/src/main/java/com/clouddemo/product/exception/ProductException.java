package com.clouddemo.product.exception;

import lombok.Getter;

import com.clouddemo.product.enums.ProductError;

@Getter
public class ProductException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    private String code = null;
    private String msg = null;
    public ProductException(String code,String msg){
    	super(msg);
    	this.code = code;
    	this.msg = msg;
    }
    
    public ProductException(ProductError error){
    	super(error.getMsg());
    	this.code = error.getCode();
    	this.msg = error.getMsg();
    }

}
