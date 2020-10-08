package com.fedolab.dropshipping.components.management.order.repository;

import com.fedolab.dropshipping.components.management.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByIdAndStatus(long orderId, int status);
}
