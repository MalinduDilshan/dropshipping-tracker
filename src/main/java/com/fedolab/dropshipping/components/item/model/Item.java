package com.fedolab.dropshipping.components.item.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fedolab.dropshipping.components.management.order.model.CustomerOrder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    private List<CustomerOrder> customerOrders;
}
