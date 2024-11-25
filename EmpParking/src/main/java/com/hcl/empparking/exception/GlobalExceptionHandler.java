package com.hcl.empparking.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.empparking.dtos.ApiResponse;
import com.hcl.empparking.dtos.ValidationErrorResponse;
import com.hcl.empparking.utils.Responses;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		ValidationErrorResponse vdErrorResponse = new ValidationErrorResponse();
		vdErrorResponse.setErrors(errors);
		vdErrorResponse.setStatusCode(Responses.VALIDATION_ERROR_CODE);
		return new ResponseEntity<>(vdErrorResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(GlobalException.class)
	protected ResponseEntity<ErrorResponse> handleGlobalException(GlobalException bookMyMovieGlobalException) {
		return ResponseEntity.status(HttpStatus.valueOf(Integer.valueOf(bookMyMovieGlobalException.getCode())))
				.body(ErrorResponse.builder().code(bookMyMovieGlobalException.getCode())
						.message(bookMyMovieGlobalException.getMessage()).build());
	}

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ApiResponse> empNotFoundException(EmployeeNotFoundException ex) {
		return new ResponseEntity<>(new ApiResponse(Responses.EMP_NOT_FOUND_CODE, ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeAlreadyHaveParkingSpotException.class)
	public ResponseEntity<ApiResponse> employeeAlreadyHaveParkingSpotException(
			EmployeeAlreadyHaveParkingSpotException ex) {
		return new ResponseEntity<>(new ApiResponse(Responses.EMP_ALREADY_HAVE_PARKING_CODE, ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeAlreadyRequestedException.class)
	public ResponseEntity<ApiResponse> employeeAlreadyRequestedException(EmployeeAlreadyRequestedException ex) {
		return new ResponseEntity<>(new ApiResponse(Responses.EMP_ALREADY_REQUESTED_CODE, ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

}
