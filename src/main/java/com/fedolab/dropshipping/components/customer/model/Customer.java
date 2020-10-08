package com.fedolab.dropshipping.components.customer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fedolab.dropshipping.components.common.repository.Auditable;
import com.fedolab.dropshipping.components.management.order.model.CustomerOrder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "customers")
public class Customer extends Auditable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "contact1")
    private String contact1;

    @Column(name = "contact2")
    private String contact2;

    @Column(name = "email")
    private String email;

    @Column(name = "fax")
    private String fax;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<CustomerOrder> customerOrders;


    public Customer() {
    }

    public Customer(long id) {
        this.id = id;
    }
}
