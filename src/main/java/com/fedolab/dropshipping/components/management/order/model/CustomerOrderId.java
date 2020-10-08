package com.fedolab.dropshipping.components.management.order.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CustomerOrderId implements Serializable {

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "order_id")
    private long orderId;

    public CustomerOrderId() {
    }

    public CustomerOrderId(long customerId, long orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }
}
