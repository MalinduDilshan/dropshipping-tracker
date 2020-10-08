package com.fedolab.dropshipping.components.management.order.service;

import com.fedolab.dropshipping.components.management.order.model.CustomerOrder;
import com.fedolab.dropshipping.components.management.order.model.Order;

import java.util.List;

public interface OrderService {

    List<CustomerOrder> placeOrder(List<CustomerOrder> customerOrders);

    List<CustomerOrder> getOrdersByCustomer(long customerId);

    Order getOrderById(long orderId);
}
