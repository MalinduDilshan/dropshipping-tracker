package com.fedolab.dropshipping.components.customer.repository;

import com.fedolab.dropshipping.components.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
