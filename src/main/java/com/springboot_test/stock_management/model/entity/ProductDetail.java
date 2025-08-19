package com.springboot_test.stock_management.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "productDetail")
public class ProductDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long detail_id;

	private String specifications;

	private String manufacturer;

	private String warrantyInformation;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
}
