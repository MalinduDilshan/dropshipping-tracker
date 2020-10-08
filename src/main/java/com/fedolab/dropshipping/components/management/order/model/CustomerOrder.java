package com.fedolab.dropshipping.components.management.order.model;

import com.fedolab.dropshipping.components.common.repository.Auditable;
import com.fedolab.dropshipping.components.customer.model.Customer;
import com.fedolab.dropshipping.components.item.model.Item;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customerorders")
public class CustomerOrder extends Auditable {

    @EmbeddedId
    private CustomerOrderId customerOrderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "qty")
    private int qty;

    @Transient
    private long customerId;

    @Transient
    private long orderId;

    public CustomerOrder() {
    }

    public CustomerOrder(Customer customer, Order order) {
        this.setCustomerOrderId(new CustomerOrderId(customer.getId(), order.getId()));
        this.setCustomer(customer);
        this.setOrder(order);
    }

    public CustomerOrder(long customerId, long orderId) {
        setCustomerAndOrderId(customerId, orderId);
    }

    public void setCustomerAndOrderId(long customerId, long orderId) {
        this.setCustomerOrderId(new CustomerOrderId(customerId, orderId));
        this.setCustomer(new Customer(customerId));
        this.setOrder(new Order(orderId));
    }
}
