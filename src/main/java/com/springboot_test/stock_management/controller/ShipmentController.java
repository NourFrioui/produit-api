package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.model.dto.ShipmentDto;
import com.springboot_test.stock_management.model.entity.Shipment;
import com.springboot_test.stock_management.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipments")
@RequiredArgsConstructor
public class ShipmentController {
    
    @Autowired
    private final ShipmentService shipmentService;

    @GetMapping("/hello")
    public static String hello() {
        return "Hello from ShipmentController!";
    }

    @GetMapping("/all")
    public List<Shipment> getAllShipments() {
        return this.shipmentService.getAllShipments();
    }

    @PostMapping
    public Shipment createShipment(@RequestBody final ShipmentDto request) {
        return this.shipmentService.createShipment(request);
    }

    @GetMapping("{id}")
    public Shipment getShipmentById(@PathVariable final long id) {
        return this.shipmentService.getShipmentById(id);
    }

    @DeleteMapping("{id}")
    public String deleteShipment(@PathVariable final long id) {
        return this.shipmentService.deleteShipment(id);
    }

    @PatchMapping("{id}")
    public Shipment updateShipment(@PathVariable final long id, @RequestBody final Shipment shipment) {
        return this.shipmentService.updateShipment(id, shipment);
    }
}
