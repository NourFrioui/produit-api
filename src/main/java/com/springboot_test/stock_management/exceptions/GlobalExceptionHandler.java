package com.springboot_test.stock_management.exceptions;

import com.springboot_test.stock_management.model.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public static ResponseEntity<ErrorResponse> handleNotFoundException(final NotFoundException ex) {
		final ErrorResponse response = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage()
		);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public static ResponseEntity<ErrorResponse> handleValidationErrors(final MethodArgumentNotValidException ex) {
		final String errorMessage = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(error -> error.getField() + " : " + error.getDefaultMessage())
				.findFirst()
				.orElse("Invalid input");

		return new ResponseEntity<>(new ErrorResponse(400, errorMessage), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public static ResponseEntity<ErrorResponse> handleGlobalException(final Exception ex) {
		final ErrorResponse response = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Une erreur inattendue est survenue : " + ex.getMessage()
		);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}



