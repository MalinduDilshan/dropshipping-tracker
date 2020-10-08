package com.fedolab.dropshipping.components.management.order.repository;

import com.fedolab.dropshipping.components.management.order.model.CustomerOrder;
import com.fedolab.dropshipping.components.management.order.model.CustomerOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, CustomerOrderId> {

    List<CustomerOrder> findByCustomerOrderId_CustomerIdAndStatus(long customerId, int status);
}
