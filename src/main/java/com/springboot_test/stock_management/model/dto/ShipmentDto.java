package com.springboot_test.stock_management.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDto {
    private String trackingNumber;
    private String status;
    private Date shippedDate;
    private Long orderId;
}
