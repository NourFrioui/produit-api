package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.exceptions.NotFoundException;
import com.springboot_test.stock_management.model.dto.ShipmentDto;
import com.springboot_test.stock_management.model.entity.Order;
import com.springboot_test.stock_management.model.entity.Shipment;
import com.springboot_test.stock_management.repository.OrderRepository;
import com.springboot_test.stock_management.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    
    @Autowired
    private final ShipmentRepository shipmentRepository;
    private final OrderRepository orderRepository;

    public List<Shipment> getAllShipments() {
        return this.shipmentRepository.findAll();
    }

    public Shipment createShipment(final ShipmentDto request) {
        final Order order = this.orderRepository.findById(request.getOrderId())
                .orElseThrow(() -> new NotFoundException("Order not found with id " + request.getOrderId()));

        final Shipment shipment = Shipment.builder()
                .tracking_number(request.getTrackingNumber())
                .status(request.getStatus())
                .shipped_date(request.getShippedDate())
                .order(order)
                .build();

        return this.shipmentRepository.save(shipment);
    }

    public Shipment getShipmentById(final long id) {
        return this.shipmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Shipment not found with id " + id));
    }

    public String deleteShipment(final long id) {
        final Optional<Shipment> optionalShipment = this.shipmentRepository.findById(id);
        if (optionalShipment.isEmpty()) {
            throw new NotFoundException("Shipment Not Found");
        }
        this.shipmentRepository.delete(optionalShipment.get());
        return "Shipment Deleted Successfully";
    }

    public Shipment updateShipment(final long id, final Shipment shipment) {
        final Optional<Shipment> optionalShipment = this.shipmentRepository.findById(id);
        if (optionalShipment.isEmpty()) {
            throw new NotFoundException("Shipment Not Found");
        }

        final Shipment updatedShipment = optionalShipment.get();

        if (shipment.getTracking_number() != null) {
            updatedShipment.setTracking_number(shipment.getTracking_number());
        }
        if (shipment.getStatus() != null) {
            updatedShipment.setStatus(shipment.getStatus());
        }
        if (shipment.getShipped_date() != null) {
            updatedShipment.setShipped_date(shipment.getShipped_date());
        }
        if (shipment.getOrder() != null) {
            updatedShipment.setOrder(shipment.getOrder());
        }

        return this.shipmentRepository.save(updatedShipment);
    }
}
