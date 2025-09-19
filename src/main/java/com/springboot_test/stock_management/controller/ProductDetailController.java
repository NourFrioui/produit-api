package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.service.ProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductDetailController {
	private final ProductDetailService productDetailService;
}
