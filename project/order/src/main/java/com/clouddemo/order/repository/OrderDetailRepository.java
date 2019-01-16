package com.clouddemo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clouddemo.order.dataobject.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
