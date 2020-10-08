package com.fedolab.dropshipping.components.customer.service;

import com.fedolab.dropshipping.components.common.util.Status;
import com.fedolab.dropshipping.components.customer.model.Customer;
import com.fedolab.dropshipping.components.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setStatus(Status.ACTIVE.getValue());
        customer.fillCompulsory(customer.getUserId());
        return customerRepository.save(customer);
    }
}
