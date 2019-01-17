package com.clouddemo.order.conver;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;

import com.clouddemo.order.dataobject.OrderDetail;
import com.clouddemo.order.dto.OrderDTO;
import com.clouddemo.order.enums.ErrorEnums;
import com.clouddemo.order.exception.OrderException;
import com.clouddemo.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Slf4j
public class Form2DTOConver {

	public static OrderDTO cover(OrderForm orderForm) {
		OrderDTO dto = new OrderDTO();
		BeanUtils.copyProperties(orderForm, dto);
		String itemstr = orderForm.getItems();
		try{
			Gson gson = new Gson();
			List<OrderDetail> list = gson.fromJson(itemstr, new TypeToken<List<OrderDetail>>(){}.getType());
			dto.setOrderDetails(list);
		}catch(Exception e){
			log.error("",e);
			throw new OrderException(ErrorEnums.ERROR_2);
		}
	    return dto;
    }

}
