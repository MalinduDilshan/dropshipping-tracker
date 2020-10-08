package com.fedolab.dropshipping.config;

import com.fedolab.dropshipping.components.management.order.service.OrderService;
import com.fedolab.dropshipping.components.management.order.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

@Slf4j
@EnableJpaRepositories({
        "com.fedolab.dropshipping.components.customer.repository",
        "com.fedolab.dropshipping.components.item.repository",
        "com.fedolab.dropshipping.components.user.repository",
        "com.fedolab.dropshipping.components.management.order.repository",
})
@EntityScan({
        "com.fedolab.dropshipping.components.customer.model",
        "com.fedolab.dropshipping.components.item.model",
        "com.fedolab.dropshipping.components.user.model",
        "com.fedolab.dropshipping.components.management.order.model",
})
@PropertySource(value = {"classpath:application-test.properties"})
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:dropshipping-test.sql"})})
@SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)
public class SpringRunTime extends AbstractTransactionalTestNGSpringContextTests {

    @Configuration
    static class ContextConfiguration {

        @Bean
        public OrderService orderService(){
            return new OrderServiceImpl();
        }
    }

}
