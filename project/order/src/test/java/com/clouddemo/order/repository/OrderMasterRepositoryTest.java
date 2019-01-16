package com.clouddemo.order.repository;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clouddemo.order.OrderApplicationTests;
import com.clouddemo.order.dataobject.OrderMaster;
import com.clouddemo.order.enums.OrderStatusEnum;
import com.clouddemo.order.enums.PayStatusEnum;


@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests{
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	
	@Test
	public void testSave() {
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("12345556");
		orderMaster.setBuyerName("zhuyunbo");
		orderMaster.setBuyerAddress("dongguan");
		orderMaster.setBuyerOpenid("buyerOpenid_111111");
		orderMaster.setBuyerPhone("13456743224455");
		orderMaster.setOrderAmount(new BigDecimal("11111"));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getStatus());
		orderMaster.setPayStatus(PayStatusEnum.UNPAID.getStatus());
		orderMaster = orderMasterRepository.save(orderMaster);
		Assert.assertTrue(orderMaster.getOrderId()!=null);
	}

}
