package com.springboot_test.stock_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "shipment")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shipment_id;

	private String tracking_number;

	private String status;

	private Date shipped_date;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

}
