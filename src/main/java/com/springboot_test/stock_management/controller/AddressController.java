package com.springboot_test.stock_management.controller;

import com.springboot_test.stock_management.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressController {
	private final AddressService addressService;
}
