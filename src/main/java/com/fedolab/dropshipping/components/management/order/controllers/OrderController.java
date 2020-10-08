package com.fedolab.dropshipping.components.management.order.controllers;

import com.fedolab.dropshipping.components.customer.model.Customer;
import com.fedolab.dropshipping.components.management.order.model.CustomerOrder;
import com.fedolab.dropshipping.components.management.order.model.Order;
import com.fedolab.dropshipping.components.management.order.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})

    @ApiOperation(value = "Place customer order", response = Customer.class)
    @CrossOrigin
    @PostMapping(produces = "application/json")
    public ResponseEntity<List<CustomerOrder>> saveCustomer(@RequestBody List<CustomerOrder> customerOrders) {
        return new ResponseEntity<>(orderService.placeOrder(customerOrders), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})

    @ApiOperation(value = "Get orders by customer", response = Customer.class)
    @CrossOrigin
    @GetMapping(value = "/{customerId}", produces = "application/json")
    public ResponseEntity<List<CustomerOrder>> getOrdersByCustomer(@PathVariable("customerId") long customerId) {
        return new ResponseEntity<>(orderService.getOrdersByCustomer(customerId), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})

    @ApiOperation(value = "Get orders by customer", response = Customer.class)
    @CrossOrigin
    @GetMapping(value = "/{orderId}", produces = "application/json")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") long orderId) {
        return new ResponseEntity<>(orderService.getOrderById(orderId), HttpStatus.OK);
    }
}
