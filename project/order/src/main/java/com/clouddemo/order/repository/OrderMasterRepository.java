package com.clouddemo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clouddemo.order.dataobject.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}
