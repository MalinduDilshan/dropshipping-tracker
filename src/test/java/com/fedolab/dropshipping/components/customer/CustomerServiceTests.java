package com.fedolab.dropshipping.components.customer;

import com.fedolab.dropshipping.components.customer.repository.CustomerRepository;
import com.fedolab.dropshipping.config.SpringRunTime;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.testng.annotations.Test;

@Log4j2
@EnableAutoConfiguration
public class CustomerServiceTests extends SpringRunTime {

    private final String testClass = this.getClass().getSimpleName();

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        log.info("Start of " + testClass + "_testSaveCustomer");

        log.info("End of " + testClass + "_testSaveCustomer");
    }

}
