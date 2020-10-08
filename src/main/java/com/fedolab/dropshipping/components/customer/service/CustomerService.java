package com.fedolab.dropshipping.components.customer.service;

import com.fedolab.dropshipping.components.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);
}
