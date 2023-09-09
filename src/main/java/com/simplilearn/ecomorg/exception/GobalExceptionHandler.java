package com.simplilearn.ecomorg.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.simplilearn.ecomorg.dto.ExceptionResponseDto;

@ControllerAdvice
public class GobalExceptionHandler {

	ExceptionResponseDto errResponse;

	// Not found exception handler
	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<ExceptionResponseDto> notFoundException(NotFoundException ex) {
		errResponse = new ExceptionResponseDto(ex.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponseDto>(errResponse, HttpStatus.NOT_FOUND);
	}

	// Bad request exception handler
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ExceptionResponseDto> badRequestException(BadRequestException ex) {
		errResponse = new ExceptionResponseDto(ex.getMessage(), new Date(), HttpStatus.BAD_REQUEST.name(),
				ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponseDto>(errResponse, HttpStatus.BAD_REQUEST);
	}

	// Unauthorized request exception handler
	@ExceptionHandler(value = UnauthorizedException.class)
	public ResponseEntity<ExceptionResponseDto> unauthorizedException(UnauthorizedException ex) {
		errResponse = new ExceptionResponseDto(ex.getMessage(), new Date(), HttpStatus.UNAUTHORIZED.name(),
				ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponseDto>(errResponse, HttpStatus.UNAUTHORIZED);
	}

	// Validation request exception handler
	@ExceptionHandler(value = ValidationException.class)
	public ResponseEntity<ExceptionResponseDto> validationException(ValidationException ex) {
		errResponse = new ExceptionResponseDto(ex.getMessage(), new Date(), HttpStatus.BAD_REQUEST.name(),
				ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponseDto>(errResponse, HttpStatus.BAD_REQUEST);
	}
}
