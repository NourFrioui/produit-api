package com.springboot_test.stock_management.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;
	private String street;
	private String city;
	private String state;
	private String zipCode;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;
}
