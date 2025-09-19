package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.dto.OrderDto;
import com.springboot_test.stock_management.model.entity.Order;
import com.springboot_test.stock_management.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    
    @Autowired
    private final OrderService orderService;

    @GetMapping("/hello")
    public static String hello() {
        return "Hello from OrderController!";
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @PostMapping
    public Order createOrder(@RequestBody final OrderDto request) {
        return this.orderService.createOrder(request);
    }

    @GetMapping("{id}")
    public Order getOrderById(@PathVariable final long id) {
        return this.orderService.getOrderById(id);
    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable final long id) {
        return this.orderService.deleteOrder(id);
    }

    @PatchMapping("{id}")
    public Order updateOrder(@PathVariable final long id, @RequestBody final Order order) {
        return this.orderService.updateOrder(id, order);
    }
}
