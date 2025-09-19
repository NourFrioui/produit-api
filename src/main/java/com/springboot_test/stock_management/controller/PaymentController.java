package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.dto.PaymentDto;
import com.springboot_test.stock_management.model.entity.Payment;
import com.springboot_test.stock_management.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    
    @Autowired
    private final PaymentService paymentService;

    @GetMapping("/hello")
    public static String hello() {
        return "Hello from PaymentController!";
    }

    @GetMapping("/all")
    public List<Payment> getAllPayments() {
        return this.paymentService.getAllPayments();
    }

    @PostMapping
    public Payment createPayment(@RequestBody final PaymentDto request) {
        return this.paymentService.createPayment(request);
    }

    @GetMapping("{id}")
    public Payment getPaymentById(@PathVariable final long id) {
        return this.paymentService.getPaymentById(id);
    }

    @DeleteMapping("{id}")
    public String deletePayment(@PathVariable final long id) {
        return this.paymentService.deletePayment(id);
    }

    @PatchMapping("{id}")
    public Payment updatePayment(@PathVariable final long id, @RequestBody final Payment payment) {
        return this.paymentService.updatePayment(id, payment);
    }
}
