package com.fedolab.dropshipping.components.management.order.service;

import com.fedolab.dropshipping.components.common.util.Status;
import com.fedolab.dropshipping.components.customer.model.Customer;
import com.fedolab.dropshipping.components.management.order.model.CustomerOrder;
import com.fedolab.dropshipping.components.management.order.model.Order;
import com.fedolab.dropshipping.components.management.order.repository.CustomerOrderRepository;
import com.fedolab.dropshipping.components.management.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    @Override
    public List<CustomerOrder> placeOrder(List<CustomerOrder> customerOrders) {
        Order order = new Order();
        order.fillCompulsory("");
        order.setStatus(Status.ACTIVE.getValue());
        customerOrders.stream().forEach(customerOrder -> {
            customerOrder.setOrder(order);
            customerOrder.setCustomer(new Customer(customerOrder.getCustomerId()));
            customerOrder.fillCompulsory("");
            customerOrder.setStatus(Status.ACTIVE.getValue());
        });
        order.setCustomerOrders(customerOrders);
        return customerOrderRepository.saveAll(customerOrders);
    }

    @Override
    public List<CustomerOrder> getOrdersByCustomer(long customerId) {
        return customerOrderRepository.findByCustomerOrderId_CustomerIdAndStatus(customerId, Status.ACTIVE.getValue());
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderRepository.findByIdAndStatus(orderId, Status.ACTIVE.getValue());
    }
}
