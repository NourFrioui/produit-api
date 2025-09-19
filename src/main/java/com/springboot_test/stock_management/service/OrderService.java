package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.exceptions.NotFoundException;
import com.springboot_test.stock_management.model.dto.OrderDto;
import com.springboot_test.stock_management.model.entity.Order;
import com.springboot_test.stock_management.model.entity.Person;
import com.springboot_test.stock_management.repository.OrderRepository;
import com.springboot_test.stock_management.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    @Autowired
    private final OrderRepository orderRepository;
    private final PersonRepository personRepository;

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order createOrder(final OrderDto request) {
        final Person person = this.personRepository.findById(request.getPersonId())
                .orElseThrow(() -> new NotFoundException("Person not found with id " + request.getPersonId()));

        final Order order = Order.builder()
                .order_date(request.getOrderDate())
                .person(person)
                .build();

        return this.orderRepository.save(order);
    }

    public Order getOrderById(final long id) {
        return this.orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with id " + id));
    }

    public String deleteOrder(final long id) {
        final Optional<Order> optionalOrder = this.orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new NotFoundException("Order Not Found");
        }
        this.orderRepository.delete(optionalOrder.get());
        return "Order Deleted Successfully";
    }

    public Order updateOrder(final long id, final Order order) {
        final Optional<Order> optionalOrder = this.orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new NotFoundException("Order Not Found");
        }

        final Order updatedOrder = optionalOrder.get();

        if (order.getOrder_date() != null) {
            updatedOrder.setOrder_date(order.getOrder_date());
        }
        if (order.getPerson() != null) {
            updatedOrder.setPerson(order.getPerson());
        }

        return this.orderRepository.save(updatedOrder);
    }
}
