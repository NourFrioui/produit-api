package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.dto.OrderItemDto;
import com.springboot_test.stock_management.model.entity.OrderItem;
import com.springboot_test.stock_management.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-items")
@RequiredArgsConstructor
public class OrderItemController {
    
    @Autowired
    private final OrderItemService orderItemService;

    @GetMapping("/hello")
    public static String hello() {
        return "Hello from OrderItemController!";
    }

    @GetMapping("/all")
    public List<OrderItem> getAllOrderItems() {
        return this.orderItemService.getAllOrderItems();
    }

    @PostMapping
    public OrderItem createOrderItem(@RequestBody final OrderItemDto request) {
        return this.orderItemService.createOrderItem(request);
    }

    @GetMapping("{id}")
    public OrderItem getOrderItemById(@PathVariable final long id) {
        return this.orderItemService.getOrderItemById(id);
    }

    @DeleteMapping("{id}")
    public String deleteOrderItem(@PathVariable final long id) {
        return this.orderItemService.deleteOrderItem(id);
    }

    @PatchMapping("{id}")
    public OrderItem updateOrderItem(@PathVariable final long id, @RequestBody final OrderItem orderItem) {
        return this.orderItemService.updateOrderItem(id, orderItem);
    }
}
