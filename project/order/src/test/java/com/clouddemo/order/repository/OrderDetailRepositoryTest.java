package com.clouddemo.order.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clouddemo.order.OrderApplicationTests;
import com.clouddemo.order.dataobject.OrderDetail;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Test
	public void testSave() {
		OrderDetail od = new OrderDetail();
		od.setDetailId("12345678");
		od.setOrderId("12345556");
		od.setProductId("157875196366160022");
		od.setProductName("皮蛋粥");
		od.setProductPrice(new BigDecimal(111345L));
		od.setProductQuantity(22);
		orderDetailRepository.save(od);
		Optional<OrderDetail> op = orderDetailRepository.findById("12345678");
		od = op.get();
		Assert.assertTrue(od.getCreateTime()!=null);
	}
}
