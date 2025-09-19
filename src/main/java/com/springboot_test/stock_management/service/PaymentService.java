package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.exceptions.NotFoundException;
import com.springboot_test.stock_management.model.dto.PaymentDto;
import com.springboot_test.stock_management.model.entity.Order;
import com.springboot_test.stock_management.model.entity.Payment;
import com.springboot_test.stock_management.repository.OrderRepository;
import com.springboot_test.stock_management.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    
    @Autowired
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public List<Payment> getAllPayments() {
        return this.paymentRepository.findAll();
    }

    public Payment createPayment(final PaymentDto request) {
        final Order order = this.orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new NotFoundException("Order not found with id " + request.getOrderId()));

        final Payment payment = Payment.builder()
                .payment_type(request.getPaymentType())
                .amount(request.getAmount())
                .order(order)
                .build();

        return this.paymentRepository.save(payment);
    }

    public Payment getPaymentById(final long id) {
        return this.paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found with id " + id));
    }

    public String deletePayment(final long id) {
        final Optional<Payment> optionalPayment = this.paymentRepository.findById(id);
        if (optionalPayment.isEmpty()) {
            throw new NotFoundException("Payment Not Found");
        }
        this.paymentRepository.delete(optionalPayment.get());
        return "Payment Deleted Successfully";
    }

    public Payment updatePayment(final long id, final Payment payment) {
        final Optional<Payment> optionalPayment = this.paymentRepository.findById(id);
        if (optionalPayment.isEmpty()) {
            throw new NotFoundException("Payment Not Found");
        }

        final Payment updatedPayment = optionalPayment.get();

        if (payment.getPayment_type() != null) {
            updatedPayment.setPayment_type(payment.getPayment_type());
        }
        if (payment.getAmount() != 0) {
            updatedPayment.setAmount(payment.getAmount());
        }
        if (payment.getOrder() != null) {
            updatedPayment.setOrder(payment.getOrder());
        }

        return this.paymentRepository.save(updatedPayment);
    }
}
