package com.fedolab.dropshipping.components.management.order.service;

import com.fedolab.dropshipping.components.management.order.repository.OrderRepository;
import com.fedolab.dropshipping.config.SpringRunTime;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.testng.annotations.Test;

@Log4j2
@EnableAutoConfiguration
public class OrderServiceTest extends SpringRunTime {

    private String testClass = this.getClass().getSimpleName();

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void placeOrder() {
        log.info("Start of " + testClass + "_testPlaceOrder");

        log.info("End of " + testClass + "_testPlaceOrder");
    }
}
