package com.springboot_test.stock_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long payment_id;
	private String payment_type;
	private double amount;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
}
