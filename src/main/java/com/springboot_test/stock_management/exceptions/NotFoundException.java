package com.springboot_test.stock_management.exceptions;

public class NotFoundException extends RuntimeException {
	public NotFoundException(final String message) {
		super(message);
	}
}
