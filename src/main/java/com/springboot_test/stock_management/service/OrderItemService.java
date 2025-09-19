package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.exceptions.NotFoundException;
import com.springboot_test.stock_management.model.dto.OrderItemDto;
import com.springboot_test.stock_management.model.entity.Order;
import com.springboot_test.stock_management.model.entity.OrderItem;
import com.springboot_test.stock_management.model.entity.Product;
import com.springboot_test.stock_management.repository.OrderItemRepository;
import com.springboot_test.stock_management.repository.OrderRepository;
import com.springboot_test.stock_management.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    
    @Autowired
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<OrderItem> getAllOrderItems() {
        return this.orderItemRepository.findAll();
    }

    public OrderItem createOrderItem(final OrderItemDto request) {
        final Order order = this.orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new NotFoundException("Order not found with id " + request.getOrderId()));
        
        final Product product = this.productRepository.findById(request.getProductId())
                .orElseThrow(() -> new NotFoundException("Product not found with id " + request.getProductId()));

        final OrderItem orderItem = OrderItem.builder()
                .quantity(request.getQuantity())
                .order(order)
                .product(product)
                .build();

        return this.orderItemRepository.save(orderItem);
    }

    public OrderItem getOrderItemById(final long id) {
        return this.orderItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("OrderItem not found with id " + id));
    }

    public String deleteOrderItem(final long id) {
        final Optional<OrderItem> optionalOrderItem = this.orderItemRepository.findById(id);
        if (optionalOrderItem.isEmpty()) {
            throw new NotFoundException("OrderItem Not Found");
        }
        this.orderItemRepository.delete(optionalOrderItem.get());
        return "OrderItem Deleted Successfully";
    }

    public OrderItem updateOrderItem(final long id, final OrderItem orderItem) {
        final Optional<OrderItem> optionalOrderItem = this.orderItemRepository.findById(id);
        if (optionalOrderItem.isEmpty()) {
            throw new NotFoundException("OrderItem Not Found");
        }

        final OrderItem updatedOrderItem = optionalOrderItem.get();

        if (orderItem.getQuantity() != null) {
            updatedOrderItem.setQuantity(orderItem.getQuantity());
        }
        if (orderItem.getOrder() != null) {
            updatedOrderItem.setOrder(orderItem.getOrder());
        }
        if (orderItem.getProduct() != null) {
            updatedOrderItem.setProduct(orderItem.getProduct());
        }

        return this.orderItemRepository.save(updatedOrderItem);
    }
}
