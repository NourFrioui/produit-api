package com.springboot_test.stock_management.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;
	private Date order_date;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@OneToMany(mappedBy = "order")
	private Set<OrderItem> orderItems;

	@OneToMany(mappedBy = "order")
	private Set<Shipment> shipments;


}
