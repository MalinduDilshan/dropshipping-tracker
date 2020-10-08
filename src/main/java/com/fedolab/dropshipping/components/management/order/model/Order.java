package com.fedolab.dropshipping.components.management.order.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fedolab.dropshipping.components.common.repository.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order extends Auditable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<CustomerOrder> customerOrders;

    public Order() {
    }

    public Order(long id) {
        this.id = id;
    }
}
