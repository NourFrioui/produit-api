package com.springboot_test.stock_management.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
	private String name;
	private double price;
	private List<Long> categoryIds;
}
