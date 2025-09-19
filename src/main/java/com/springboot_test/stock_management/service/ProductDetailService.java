package com.springboot_test.stock_management.service;

import com.springboot_test.stock_management.repository.ProductDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailService {

	@Autowired
	private final ProductDetailRepository productDetailRepository;
}
